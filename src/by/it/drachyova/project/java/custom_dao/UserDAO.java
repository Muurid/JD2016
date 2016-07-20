package by.it.drachyova.project.java.custom_dao;

import by.it.drachyova.project.java.beans.User;
import by.it.drachyova.project.java.connection.ConnectionCreator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDAO extends AbstractDAO implements InterfaceDAO<User> {

    @Override
    public List<User> getAll(String WHERE) {
        List<User> users = new ArrayList<>();
        String sql = "SELECT * FROM users " + WHERE + " ;";
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()
        ) {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setLogin(resultSet.getString("login"));
                user.setEmail(resultSet.getString("email"));
                user.setPassword(resultSet.getString("password"));
                user.setFk_role(resultSet.getInt("fk_role"));
                users.add(user);
            }
        } catch (SQLException e) {
            String message = e.getMessage();
            logger.WriteToLog(message);
        }
        return users;
    }

    @Override
    public User read(int id) {
        List<User> users = getAll("WHERE ID=" + id + " LIMIT 0,1");
        if (users.size() > 0) {
            return users.get(0);
        } else
            return null;
    }

    @Override
    public boolean create(User user) {
        String sql = String.format(
                "insert INTO users(Login,Password,Email,FK_Role)" +
                        " values('%s','%s','%s',%d);",
                user.getLogin(), user.getPassword(), user.getEmail(), user.getFk_role()
        );
        user.setId(executeUpdate(sql));
        return (user.getId() > 0);
    }

    @Override
    public boolean update(User user) {
        String sql = String.format(
                "UPDATE users SET Login = '%s', Password = '%s', Email = '%s', FK_Role = '%d' WHERE users.ID = '%d';",
                user.getLogin(), user.getPassword(), user.getEmail(), user.getFk_role(), user.getId());

        return (0 < executeUpdate(sql));
    }

    @Override
    public boolean delete(User user) {
        String sql = String.format(
                "DELETE FROM users WHERE users.id = %d;", user.getId()
        );
        return (0 < executeUpdate(sql));
    }


}
