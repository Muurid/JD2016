package by.it.sereda.jd03_02;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectorDemo {

    private static final String URL_DB =
            "jdbc:mysql://127.0.0.1:2016/seredajd0302test"
                    + "?useUnicode=true&characterEncoding=UTF-8";
    private static final String USER_DB = "root";
    private static final String PASSWORD_DB = "";

    private static volatile Connection connection;

    static {
        try {
            Driver driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            synchronized (URL_DB) {
                if (connection == null || connection.isClosed()) {
                    connection = DriverManager.getConnection(URL_DB, USER_DB, PASSWORD_DB);
                }
            }
        }
        return connection;
    }

}
