package by.it.kust.jd03_04.my_project.java.custom_dao;

import by.it.kust.jd03_04.my_project.java.beans.Tour;
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
public class TourDao extends AbstractDao implements InterfaceDao<Tour> {
    @Override
    public Tour read(int id) {
        List<Tour> tours = getAll("WHERE id=" + id + "LIMIT 0,1");
        if (tours.size() > 0) {
            return tours.get(0);
        } else {
            return null;
        }
    }

    @Override
    public boolean create(Tour tour) {
        String createTourSQL = String.format("INSERT INTO tours (id, country, city, hotel, url, " +
                        "days, price, type, option1, option2, fk_Users) " +
                        "VALUES('%d','%s','%s','%s','%s','%d','%d','%s','%s','%s','%d')",
                tour.getId(),tour.getCountry(),tour.getCity(),tour.getHotel(),tour.getUrl(),
                tour.getDays(),tour.getPrice(),tour.getType(),tour.getOption1(),
                tour.getOption2(),tour.getFk_Users());
        return (0 < executeUpdate(createTourSQL));
    }

    @Override
    public boolean update(Tour tour) {
        String updateTourSQL = String.format("UPDATE tours SET country='%s', city='%s', hotel='%s', url='%s'," +
                        "days='%d', price='%d', type='%s', option1='%s', option2='%s'," +
                        "fk_Users='%d' WHERE tours.id='%d'",
                tour.getCountry(),tour.getCity(),tour.getHotel(),tour.getUrl(),
                tour.getDays(),tour.getPrice(),tour.getType(),tour.getOption1(),tour.getOption2(),
                tour.getFk_Users());
        return (0 < executeUpdate(updateTourSQL));
    }

    @Override
    public boolean delete(Tour tour) {
        String deleteTourSQL = String.format("DELETE FROM tours WHERE tours.id='%d'", tour.getId());
        return (0 < executeUpdate(deleteTourSQL));
    }

    @Override
    public List<Tour> getAll(String where) {
        List<Tour> tours = new ArrayList<>();
        String getUsersSQL = "SELECT * FROM tours " + where + " ;";
        try (Connection connection = ConnectionCreator.getConnection(); // соединение с базой
             Statement statement = connection.createStatement()  // объект для обращения к базе
        ) {
            ResultSet resultSet = statement.executeQuery(getUsersSQL);
            while (resultSet.next()) {
                Tour tour = new Tour();
                tour.setId(resultSet.getInt("id"));
                tour.setCountry(resultSet.getString("country"));
                tour.setCity(resultSet.getString("city"));
                tour.setHotel(resultSet.getString("hotel"));
                tour.setUrl(resultSet.getString("url"));
                tour.setDays(resultSet.getInt("days"));
                tour.setPrice(resultSet.getInt("price"));
                tour.setType(resultSet.getString("type"));
                tour.setOption1(resultSet.getString("option1"));
                tour.setOption2(resultSet.getString("option2"));
                tour.setFk_Users(resultSet.getInt("fk_Users"));
                tours.add(tour);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tours;
    }
}
