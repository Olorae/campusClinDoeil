package uqac.dim.campusclindoeil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnection {
    public static Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/CampusClinDoeil";
        String user = "Olorae";
        String password = "Coral909";
        return DriverManager.getConnection(url, user, password);
    }
}
