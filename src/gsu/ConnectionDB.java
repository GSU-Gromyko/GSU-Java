package gsu;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionDB {

    private static final String url = "jdbc:mysql://localhost:3306/javaProject";
    private static final String user = "java";
    private static final String password = "p4$$vv0rd";

    public Connection get_connection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, user, password);
        } catch (Exception exception) {
            System.err.println(exception);
        }
        return connection;
    }

}
