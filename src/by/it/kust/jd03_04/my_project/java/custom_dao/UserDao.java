package by.it.kust.jd03_04.my_project.java.custom_dao;

import by.it.kust.jd03_04.my_project.java.beans.User;
import by.it.kust.jd03_04.my_project.java.connection.ConnectionCreator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tanya Kust.
 */
public class UserDao extends AbstractDao implements InterfaceDao<User> {
    @Override
    public User read(int id) {
        List<User> users = getAll("WHERE id=" + id + "LIMIT 0,1");
        if (users.size() > 0) {
            return users.get(0);
        } else {
            return null;
        }
    }

    @Override
    public boolean create(User user) {
        String createUserSQL = String.format("INSERT INTO users (id, name, login, password, email, " +
                        "address, discount, fk_Role) VALUES('%d','%s','%s','%s','%s','%s','%d','%d')",
                user.getId(), user.getName(), user.getLogin(), user.getPassword(), user.getEmail(),
                user.getAddress(), user.getDiscount(), user.getFk_Role());
        return (0 < executeUpdate(createUserSQL));
    }

    @Override
    public boolean update(User user) {
        String updateUserSQL = String.format("UPDATE users SET name='%s', login='%s', password='%s', email='%s'," +
                        "address='%s', discount='%d', fk_Role='%d' WHERE users.id='%d'",
                user.getName(), user.getLogin(), user.getPassword(), user.getEmail(),
                user.getAddress(), user.getDiscount(), user.getFk_Role(), user.getId());
        return (0 < executeUpdate(updateUserSQL));
    }

    @Override
    public boolean delete(User user) {
        String deleteUserSQL = String.format("DELETE FROM users WHERE users.id='%d'", user.getId());
        return (0 < executeUpdate(deleteUserSQL));
    }

    @Override
    public List<User> getAll(String where) {
        List<User> users = new ArrayList<>();
        String getUsersSQL = "SELECT * FROM users " + where + " ;";
        try (Connection connection = ConnectionCreator.getConnection(); // соединение с базой
             Statement statement = connection.createStatement()  // объект для обращения к базе
        ) {
            ResultSet resultSet = statement.executeQuery(getUsersSQL);
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                user.setLogin(resultSet.getString("login"));
                user.setPassword(resultSet.getString("password"));
                user.setEmail(resultSet.getString("email"));
                user.setAddress(resultSet.getString("address"));
                user.setDiscount(resultSet.getInt("discount"));
                user.setFk_Role(resultSet.getInt("fk_Role"));
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }
}
