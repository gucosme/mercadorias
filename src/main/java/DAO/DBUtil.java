package DAO;

import com.heroku.sdk.jdbc.DatabaseUrl;

import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by gusta on 08/09/2016.
 */
public class DBUtil {
    private static Connection connection;

    public Connection getConnection() throws SQLException, URISyntaxException {
        return DatabaseUrl.extract().getConnection();
    }
}
