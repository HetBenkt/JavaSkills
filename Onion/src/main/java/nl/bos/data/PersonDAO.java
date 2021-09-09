package nl.bos.data;

import java.sql.*;
import java.util.*;
import java.util.stream.Collectors;

public class PersonDAO implements IPersonDAO {
    private final ConnectionFactory connectionFactory = ConnectionFactory.INSTANCE;

    @Override
    public boolean create(PersonDTO person) throws SQLException {
        PreparedStatement create = connectionFactory.connect().prepareStatement("INSERT INTO person (name, age, interests) VALUES(?, ?, ?)");
        create.setString(1, person.getName());
        create.setInt(2, person.getAge());
        create.setString(3, String.join(", ", person.getInterests()));

        return create.executeUpdate() == 1;
    }

    @Override
    public PersonDTO read(Long id) throws SQLException {
        PreparedStatement statement = connectionFactory.connect().prepareStatement("SELECT * FROM person WHERE id = ?");
        statement.setLong(1, id);
        ResultSet resultSet = statement.executeQuery();
        resultSet.next(); //we only have 1 unique ID

        return new PersonDTO(
                resultSet.getLong("id"),
                resultSet.getString("name"),
                resultSet.getInt("age"),
                buildInterests(resultSet.getArray("interests"))
        );
    }

    @Override
    public boolean update(PersonDTO person) throws SQLException {
        return false;
    }

    @Override
    public boolean delete(PersonDTO person) throws SQLException {
        return false;
    }

    @Override
    public List<PersonDTO> getAll() throws SQLException {
        List<PersonDTO> result = new ArrayList<>();

        Statement select = connectionFactory.connect().createStatement();
        ResultSet resultSet = select.executeQuery("SELECT * FROM person ORDER BY id DESC");
        while (resultSet.next()) {
            PersonDTO person = new PersonDTO(
                    resultSet.getLong("id"),
                    resultSet.getString("name"),
                    resultSet.getInt("age"),
                    buildInterests(resultSet.getArray("interests"))
            );
            result.add(person);
        }

        return result;
    }

    private Set<String> buildInterests(Array interests) {
        Set<String> result;

        if (interests.toString().equals("")) {
            result = Collections.emptySet();
        } else {
            result = Arrays.stream(interests.toString().split(",")).map(String::trim).collect(Collectors.toSet());
        }

        return result;
    }
}