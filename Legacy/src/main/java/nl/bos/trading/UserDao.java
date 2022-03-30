package nl.bos.trading;

import javax.sql.DataSource;
import java.text.MessageFormat;

public class UserDao {

    private final DataSource dataSource;

    public UserDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void save(User user) {
        String msg = MessageFormat.format("Saving user {0} to the DB via datasource {1}", user.getName(), this.dataSource);
        System.out.println(msg);
    }
}
