package by.it.drachyova.project.java.custom_dao;

import by.it.drachyova.project.java.beans.Room;
import by.it.drachyova.project.java.connection.ConnectionCreator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class RoomDAO extends AbstractDAO implements InterfaceDAO<Room> {
    @Override
    public List<Room> getAll(String WHERE) {
        List<Room> rooms = new ArrayList<>();
        String sql = "SELECT * FROM rooms " + WHERE + " ;";
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()
        ) {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Room room = new Room();
                room.setId(resultSet.getInt("id"));
                room.setType(resultSet.getString("type"));
                room.setPrice(resultSet.getInt("price"));
                room.setAvailable(resultSet.getBoolean("isAvailable"));
                rooms.add(room);
            }
        } catch (SQLException e) {
            String message = e.getMessage();
            logger.WriteToLog(message);
        }
        return rooms;
    }

    @Override
    public Room read(int id) {
        List<Room> rooms = getAll("WHERE ID=" + id + " LIMIT 0,1");
        if (rooms.size() > 0) {
            return rooms.get(0);
        } else
            return null;
    }

    @Override
    public boolean create(Room room) {
        String sql = String.format("insert INTO rooms(type, price, isAvailable) " +
                        "values('%s','%d','%d');",
                room.getType(), room.getPrice(), room.isAvailable());
        room.setId(executeUpdate(sql));
        return (room.getId() > 0);
    }

    @Override
    public boolean update(Room room) {
        String sql = String.format(
                "UPDATE rooms SET type = '%s', price = '%d', isAvailable = '%d'" +
                        "WHERE rooms.id = %d",
                room.getType(), room.getPrice(), room.isAvailable(), room.getId());
        return (0 < executeUpdate(sql));
    }

    @Override
    public boolean delete(Room room) {
        String sql = String.format(
                "DELETE FROM rooms WHERE rooms.id = %d;", room.getId()
        );
        return (0 < executeUpdate(sql));
    }

}
