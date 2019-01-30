package nl.bos.trading;

import lombok.AllArgsConstructor;
import lombok.extern.java.Log;

import javax.sql.DataSource;
import java.text.MessageFormat;

@AllArgsConstructor
@Log
public class UserDao {

    private final DataSource dataSource;

    public void save(User user) {
        String msg = MessageFormat.format("Saving user {0} to the DB via datasource {1}", user.getName(), this.dataSource);
        log.info(msg);
    }
}
