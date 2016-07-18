package by.it.sinkevich.project.java.dao;

import by.it.sinkevich.project.java.bean.Race;
import by.it.sinkevich.project.java.connection.Connector;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Class for entity Race, contains all CRUD operations with DB
 *
 * @author Sinkevich Denis
 */
public class RaceDAO implements InterfaceDAO<Race> {

    @Override
    public Race read(int id) {
        List<Race> races = readAll("WHERE id = " + id);
        if (races.size() > 0) {
            return races.get(0);
        }
        return null;
    }

    @Override
    public boolean create(Race entity) {
        boolean isCreateOk = false;
        try (Connection connection = Connector.getConnection();
             Statement statement = connection.createStatement()) {
            String query = String.format("INSERT INTO races (time, horse1, horse2, horse3, horse4, horse5, horse6, horse7, horse8, winner) " +
                            "values('%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s');",
                    entity.getTime(), entity.getHorse1(), entity.getHorse2(), entity.getHorse3(), entity.getHorse4(),
                    entity.getHorse5(), entity.getHorse6(), entity.getHorse7(), entity.getHorse8(), entity.getWinner());
            isCreateOk = statement.executeUpdate(query) == 1;
        } catch (SQLException e) {
            System.err.println("Ошибка работы с БД в RaceDAO!");
            e.printStackTrace();
        }
        return isCreateOk;
    }

    @Override
    public boolean update(Race entity) {
        boolean isUpdateOk = false;
        try (Connection connection = Connector.getConnection();
             Statement statement = connection.createStatement()) {
            String query = String.format("UPDATE races SET time = '%s', horse1 = '%s', horse2 = '%s', horse3 = '%s', horse4 = '%s', " +
                            "horse5 = '%s', horse6 = '%s', horse7 = '%s', horse8 = '%s', winner = '%s' WHERE id = %d;", entity.getTime(),
                    entity.getHorse1(), entity.getHorse2(), entity.getHorse3(), entity.getHorse4(), entity.getHorse5(),
                    entity.getHorse6(), entity.getHorse7(), entity.getHorse8(), entity.getWinner(), entity.getId());
            isUpdateOk = statement.executeUpdate(query) == 1;
        } catch (SQLException e) {
            System.err.println("Ошибка работы с БД в RaceDAO!");
            e.printStackTrace();
        }
        return isUpdateOk;
    }

    @Override
    public boolean delete(Race entity) {
        boolean isDeleteOk = false;
        String query = "DELETE FROM races WHERE races.ID = " + entity.getId();
        try (Connection connection = Connector.getConnection();
             Statement statement = connection.createStatement()) {
            isDeleteOk = statement.executeUpdate(query) == 1;
        } catch (SQLException e) {
            System.err.println("Ошибка работы с БД в RaceDAO!");
            e.printStackTrace();
        }
        return isDeleteOk;
    }

    @Override
    public List<Race> readAll(String WhereAndOrder) {
        List<Race> races = new ArrayList<>();
        try (Connection connection = Connector.getConnection();
             Statement statement = connection.createStatement()) {
            String query = "SELECT * FROM races " + WhereAndOrder + " ;";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                races.add(new Race(
                        resultSet.getInt("id"),
                        resultSet.getTimestamp("time"),
                        resultSet.getString("horse1"),
                        resultSet.getString("horse2"),
                        resultSet.getString("horse3"),
                        resultSet.getString("horse4"),
                        resultSet.getString("horse5"),
                        resultSet.getString("horse6"),
                        resultSet.getString("horse7"),
                        resultSet.getString("horse8"),
                        resultSet.getString("winner")));
            }
        } catch (SQLException e) {
            System.err.println("Ошибка работы с БД в RaceDAO!");
            e.printStackTrace();
        }
        return races;
    }
}
