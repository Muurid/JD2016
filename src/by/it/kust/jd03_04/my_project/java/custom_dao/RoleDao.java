package by.it.kust.jd03_04.my_project.java.custom_dao;

import by.it.kust.jd03_04.my_project.java.beans.Role;
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
public class RoleDao extends AbstractDao implements InterfaceDao<Role> {

    @Override
    public Role read(int id) {
        List<Role> roles = getAll("WHERE id=" + id + "LIMIT 0,1");
        if (roles.size() > 0) {
            return roles.get(0);
        } else {
            return null;
        }
    }

    @Override
    public boolean create(Role role) {
        String createRoleSQL = String.format("INSERT INTO roles (id, role) VALUES('%d','%s')",
                role.getId(),role.getRole());
        return (0 < executeUpdate(createRoleSQL));
    }

    @Override
    public boolean update(Role role) {
        String updateRoleSQL = String.format("UPDATE roles SET role='%s' WHERE roles.id='%d'",
                role.getRole(),role.getId());
        return (0 < executeUpdate(updateRoleSQL));
    }

    @Override
    public boolean delete(Role role) {
        String deleteRoleSQL = String.format("DELETE FROM roles WHERE roles.id='%d'", role.getId());
        return (0 < executeUpdate(deleteRoleSQL));
    }

    @Override
    public List<Role> getAll(String where) {
        List<Role> roles = new ArrayList<>();
        String getRolesSQL = "SELECT * FROM roles " + where + " ;";
        try (Connection connection = ConnectionCreator.getConnection(); // соединение с базой
             Statement statement = connection.createStatement()  // объект для обращения к базе
        ) {
            ResultSet resultSet = statement.executeQuery(getRolesSQL);
            while (resultSet.next()) {
                Role role = new Role();
                role.setId(resultSet.getInt("id"));
                role.setRole(resultSet.getString("role"));
                roles.add(role);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return roles;
    }
}
