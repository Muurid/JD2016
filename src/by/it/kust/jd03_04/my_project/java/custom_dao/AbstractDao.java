package by.it.kust.jd03_04.my_project.java.custom_dao;

import by.it.kust.jd03_04.my_project.java.connection.ConnectionCreator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Tanya Kust.
 */
public abstract class AbstractDao {
    // общая команда для create, update, delete
    protected int executeUpdate(String sql){
        int result = -1;
        try(Connection connection = ConnectionCreator.getConnection();
            Statement statement = connection.createStatement()) {
            result = statement.executeUpdate(sql);
            System.out.println(result + ":" + sql);  // проверить SQL
            if (sql.trim().toUpperCase().startsWith("INSERT")){
                ResultSet resultSet = statement.executeQuery("SELECT LAST_INSERT_ID();");
                if (resultSet.next()) result = resultSet.getInt(1);
            }

        } catch (SQLException e) {
            //тут нужно логгирование SQLException(e);
            System.out.println("Ошибка соединения или sql запроса: " + e);
        }
        return result;
    }
}
