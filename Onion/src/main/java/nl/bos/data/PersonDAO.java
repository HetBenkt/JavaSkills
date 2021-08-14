package nl.bos.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

public class PersonDAO implements IPersonDAO {
    ConnectionFactory connectionFactory = ConnectionFactory.INSTANCE;

    @Override
    public boolean create(PersonDTO person) throws SQLException {
        Connection connection = connectionFactory.connect();

        PreparedStatement create = connection.prepareStatement("INSERT INTO person VALUES(NULL, ?, ?, ?)");
        create.setString(1, person.getName());
        create.setInt(2, person.getAge());
        create.setObject(3, person.getInterests());

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
    public List<PersonDTO> getAll() {
        return Collections.emptyList();
    }
}
