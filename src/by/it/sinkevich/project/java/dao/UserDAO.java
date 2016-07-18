package by.it.sinkevich.project.java.dao;

import by.it.sinkevich.project.java.bean.User;
import by.it.sinkevich.project.java.connection.Connector;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Class for entity User, contains all CRUD operations with DB
 *
 * @author Sinkevich Denis
 */
public class UserDAO implements InterfaceDAO<User> {

    @Override
    public User read(int id) {
        List<User> users = readAll("WHERE id = " + id);
        if (users.size() > 0) {
            return users.get(0);
        }
        return null;
    }

    @Override
    public boolean create(User entity) {
        boolean isCreateOk = false;
        try (Connection connection = Connector.getConnection();
             Statement statement = connection.createStatement()) {
            String query = String.format("insert into users (name, dateOfBirth, email, fk_role, login, password) " +
                            "values('%s', '%s', '%s', %d, '%s', '%s');", entity.getName(), entity.getDateOfBirth(),
                    entity.getEmail(), entity.getFk_role(), entity.getLogin(), entity.getPassword());
            isCreateOk = statement.executeUpdate(query) == 1;
        } catch (SQLException e) {
            System.err.println("Ошибка работы с БД в UserDAO!");
            e.printStackTrace();
        }
        return isCreateOk;
    }

    @Override
    public boolean update(User entity) {
        boolean isUpdateOk = false;
        try (Connection connection = Connector.getConnection();
             Statement statement = connection.createStatement()) {
            String query = String.format("UPDATE users SET name = '%s', dateOfBirth = '%s', email = '%s', " +
                            "fk_role = %d, login = '%s', password = '%s' WHERE id = %d;",
                    entity.getName(), entity.getDateOfBirth(), entity.getEmail(),
                    entity.getFk_role(), entity.getLogin(), entity.getPassword(), entity.getId());
            isUpdateOk = statement.executeUpdate(query) == 1;
        } catch (SQLException e) {
            System.err.println("Ошибка работы с БД в UserDAO!");
            e.printStackTrace();
        }
        return isUpdateOk;
    }

    @Override
    public boolean delete(User entity) {
        boolean isDeleteOk = false;
        String query = "DELETE FROM users WHERE users.ID = " + entity.getId();
        try (Connection connection = Connector.getConnection();
             Statement statement = connection.createStatement()) {
            isDeleteOk = statement.executeUpdate(query) == 1;
        } catch (SQLException e) {
            System.err.println("Ошибка работы с БД в UserDAO!");
            e.printStackTrace();
        }
        return isDeleteOk;
    }

    @Override
    public List<User> readAll(String WhereAndOrder) {
        List<User> users = new ArrayList<>();
        try (Connection connection = Connector.getConnection();
             Statement statement = connection.createStatement()) {
            String query = "SELECT * FROM users " + WhereAndOrder + " ;";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                users.add(new User(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getDate("dateOfBirth"),
                        resultSet.getString("email"),
                        resultSet.getInt("fk_role"),
                        resultSet.getString("login"),
                        resultSet.getString("password")));
            }
        } catch (SQLException e) {
            System.err.println("Ошибка работы с БД в UserDAO!");
            e.printStackTrace();
        }
        return users;
    }
}
