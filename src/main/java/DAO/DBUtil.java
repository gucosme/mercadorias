package DAO;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by gusta on 08/09/2016.
 */
public class DBUtil {
    private static Connection connection;

    public Connection getConnection() throws URISyntaxException, SQLException{
        URI dbURI = new URI(System.getenv("CLEARDB_DATABASE_URL"));

        String username = dbURI.getUserInfo().split(":")[0];
        String password = dbURI.getUserInfo().split(":")[1];
        String dbUrl = "jdbc:mysql://" + dbURI.getHost() + dbURI.getPath();

        return DriverManager.getConnection(dbUrl, username, password);
    }
}
