package by.it.kust.jd03_04.my_project.java.connection;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Tanya Kust.
 */
public class ConnectionCreator {
    // Правильно держать настройки соединения вне кода!
    private static final String URL_DB = "jdbc:mysql://localhost:2016/kust"+
            "?useUnicode=true&characterEncoding=UTF-8";
    private static final String USER_DB = "root";
    private static final String PASSWORD_DB = "";

    private static volatile Connection connection = null;

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Driver driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);
        } catch (SQLException | ClassNotFoundException e) {
            System.err.println("Ошибка регистрации драйвера");
        }
    }

    public static Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()){
            synchronized (URL_DB){
                if (connection == null || connection.isClosed()){
                    connection = DriverManager.getConnection(URL_DB, USER_DB, PASSWORD_DB);
                }
            }
        }
        return connection;
    }
}
