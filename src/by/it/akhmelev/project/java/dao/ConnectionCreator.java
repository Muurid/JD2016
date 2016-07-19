package by.it.akhmelev.project.java.dao;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionCreator {
    //Памятка. Корректно держать настройки соединения вне кода (!)
    public static String URL_DB;
    public static String USER_DB;
    public static String PASSWORD_DB;

    public static void setURL_DB(String urlDb) {
        URL_DB = urlDb;
    }

    public static void setUSER_DB(String userDb) {
        USER_DB = userDb;
    }

    public static void setPASSWORD_DB(String passwordDb) {
        PASSWORD_DB = passwordDb;
    }

    static {
        try{
            Class.forName("com.mysql.jdbc.Driver");     //регистрация jdbc (для tomcat)
            Driver driver = new FabricMySQLDriver();    //
            DriverManager.registerDriver(driver);       //регистрация драйвера
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //аналог синглтона на случай множественного обращения
    private static volatile Connection connection = null;

    public static Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
                synchronized (URL_DB) {
                    if (connection == null || connection.isClosed())
                        connection = DriverManager.getConnection(URL_DB, USER_DB, PASSWORD_DB);
                }
        }
        return connection;
    }
    //(так конечно проще, но будет правильнее сделать пул соединений)
    //и получать тут свободные соединения. Синхронно.

}
