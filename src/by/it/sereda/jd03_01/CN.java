package by.it.sereda.jd03_01;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

public class CN {
    public static final String URL_DB = "jdbc:mysql://127.0.0.1:2016/seredajd0301test" +
            "?useUnicode=true&amp;characterEncoding=UTF-8";
    public static final String USER_DB = "root";
    public static final String PASSWORD_DB = "";
    private static volatile Connection connection = null;

    public static Connection getConnection() throws SQLException {
        try {
            Driver driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (connection == null || connection.isClosed()) {
            synchronized (URL_DB) {
                if (connection == null || connection.isClosed())
                    connection = DriverManager.getConnection(URL_DB, USER_DB, PASSWORD_DB);
                System.out.println("Соединение с базой данных установлено");
            }
        }
        return connection;
    }
}

