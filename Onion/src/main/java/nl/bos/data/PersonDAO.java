package nl.bos.data;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PersonDAO implements IPersonDAO {
    ConnectionFactory connectionFactory = ConnectionFactory.INSTANCE;

    @Override
    public boolean create(PersonDTO person) throws SQLException {
        Connection connection = connectionFactory.connect();

        PreparedStatement create = connection.prepareStatement("INSERT INTO person (name, age, interests) VALUES(?, ?, ?)");
        create.setString(1, person.getName());
        create.setInt(2, person.getAge());
        create.setString(3, String.join(", ", person.getInterests()));

        return create.executeUpdate() == 1;
    }

    @Override
    public PersonDTO read(Long id) {
        return null;
    }

    @Override
    public boolean update(PersonDTO person) {
        return false;
    }

    @Override
    public boolean delete(PersonDTO person) {
        return false;
    }

    @Override
    public List<PersonDTO> getAll() throws SQLException {
        List<PersonDTO> result = new ArrayList<>();
        Connection connection = connectionFactory.connect();

        Statement select = connection.createStatement();
        ResultSet resultSet = select.executeQuery("SELECT * FROM person");
        while (resultSet.next()) {
            PersonDTO person = new PersonDTO(
                    resultSet.getLong("id"),
                    resultSet.getString("name"),
                    resultSet.getInt("age"),
                    Collections.emptySet() //todo interests
            );
            result.add(person);
        }

        return result;
    }
}
