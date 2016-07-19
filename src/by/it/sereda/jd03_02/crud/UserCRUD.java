package by.it.sereda.jd03_02.crud;

import by.it.sereda.jd03_02.ConnectorDemo;
import by.it.sereda.jd03_02.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserCRUD {
    public User create(User user) throws SQLException {
        boolean okCreate=false;
        user.setId(0);
        //формирование строки sql по данным bean user
        try (
                Connection connection = ConnectorDemo.getConnection(); //создаем соединение с базой
                Statement statement = connection.createStatement();// создаем объект для обращения к базе
        ) {


            String sql = String.format("insert into users(Login,Password,Email,FK_Role)\n" +
                            "values('%s','%s','%s',%d);",
                    user.getLogin(), user.getPassword(), user.getEmail(), user.getFk_role());
            //выполняем добавление в базу, должна быть добавлена одна запись, проверим это
            if (statement.executeUpdate(sql) == 1) {
                //если всё добавлено то узнаемм  последний ID
                ResultSet resultSet = statement.executeQuery("SELECT LAST_INSERT_ID();");
                if (resultSet.next()) {
                    user.setId(resultSet.getInt(1));
                    okCreate=true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
        if (okCreate) {
            return user;
        }
        else {
            return null;
        }
    }

    public boolean delete (User user) throws SQLException {
        boolean okDelete=false;
        try (
                Connection connection = ConnectorDemo.getConnection();
                Statement statement = connection.createStatement();
        ) {
            String sql = "Delete from users where ID="+user.getId();
            return (statement.executeUpdate(sql) ==1);
        } catch (SQLException e) {
            throw e;
        }
    }

    public User read (int id) throws SQLException {
        User user=null;
        try (
                Connection connection = ConnectorDemo.getConnection();
                Statement statement = connection.createStatement();
        ) {
            String sql = "Select * from users where ID="+ id;
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                user=new User (
                        resultSet.getInt("ID"),
                        resultSet.getString("Login"),
                        resultSet.getString("Email"),
                        resultSet.getString("Password"),
                        resultSet.getInt("FK_Role"));
            }
        } catch (SQLException e) {
            throw e;
        }
        return user;
    }
}
