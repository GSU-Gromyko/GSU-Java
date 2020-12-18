package gsu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBConnection {

    private static String url = "jdbc:mysql://localhost:3306/javaLab";
    private static String user = "java";
    private static String password = "p4$$vv0rd";

    private static Connection con;
    private static Statement stmt;
    private static ResultSet rs;

    public Connection get_connection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            System.err.println(e);
        }
        return connection;
    }
}
