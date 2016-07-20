package by.it.drachyova.project.java.custom_dao;

import by.it.drachyova.project.java.beans.Reservation;
import by.it.drachyova.project.java.connection.ConnectionCreator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ReservationDAO extends AbstractDAO implements InterfaceDAO<Reservation> {
    @Override
    public List<Reservation> getAll(String WHERE) {
        List<Reservation> reservations = new ArrayList<>();
        String sql = "SELECT * FROM reservations " + WHERE + " ;";
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()
        ) {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Reservation reservation = new Reservation();
                reservation.setId(resultSet.getInt("id"));
                reservation.setFk_type(resultSet.getInt("fk_type"));
                reservation.setFk_user(resultSet.getInt("fk_user"));
                reservations.add(reservation);
            }
        } catch (SQLException e) {
            String message = e.getMessage();
            logger.WriteToLog(message);
        }
        return reservations;
    }

    @Override
    public Reservation read(int id) {
        List<Reservation> reservations = getAll("WHERE ID=" + id + " LIMIT 0,1");
        if (reservations.size() > 0) {
            return reservations.get(0);
        } else
            return null;
    }

    @Override
    public boolean create(Reservation reservation) {
        String sql = String.format("insert INTO reservations(fk_type,fk_role) " +
                        "values('%d',%d);",
                reservation.getFk_type(),
                reservation.getFk_user());
        reservation.setId(executeUpdate(sql));
        return (reservation.getId() > 0);
    }

    @Override
    public boolean update(Reservation reservation) {
        String sql = String.format(
                "UPDATE reservations SET  fk_type = '%d', fk_role = '%d' " +
                        "WHERE reservations.id = %d",
                reservation.getFk_type(), reservation.getFk_user(),
                reservation.getId()
        );
        return (0 < executeUpdate(sql));
    }

    @Override
    public boolean delete(Reservation reservation) {
        String sql = String.format(
                "DELETE FROM reservations WHERE reservations.id = %d;", reservation.getId()
        );
        return (0 < executeUpdate(sql));
    }

}
