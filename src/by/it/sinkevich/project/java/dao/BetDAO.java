package by.it.sinkevich.project.java.dao;

import by.it.sinkevich.project.java.bean.Bet;
import by.it.sinkevich.project.java.connection.Connector;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Class for entity Bet, contains all CRUD operations with DB
 *
 * @author Sinkevich Denis
 */
public class BetDAO implements InterfaceDAO<Bet> {

    @Override
    public Bet read(int id) {
        List<Bet> bets = readAll("WHERE id = " + id);
        if (bets.size() > 0) {
            return bets.get(0);
        }
        return null;
    }

    @Override
    public boolean create(Bet entity) {
        boolean isCreateOk = false;
        try (Connection connection = Connector.getConnection();
             Statement statement = connection.createStatement()) {
            String query = String.format("INSERT INTO bets (time, fk_race, horse, betSum, fk_user) values('%s', %d, '%s', '%s', %d);",
                    entity.getTime(), entity.getFk_race(), entity.getHorse(), entity.getBetSum(), entity.getFk_user());
            isCreateOk = statement.executeUpdate(query) == 1;
        } catch (SQLException e) {
            System.err.println("Ошибка работы с БД в BetDAO!");
            e.printStackTrace();
        }
        return isCreateOk;
    }

    @Override
    public boolean update(Bet entity) {
        boolean isUpdateOk = false;
        try (Connection connection = Connector.getConnection();
             Statement statement = connection.createStatement()) {
            String query = String.format("UPDATE bets SET time = '%s', fk_race = %d, horse = '%s', betSum = '%s', fk_user = %d WHERE id = %d;",
                    entity.getTime(), entity.getFk_race(), entity.getHorse(), entity.getBetSum(), entity.getFk_user(), entity.getId());
            isUpdateOk = statement.executeUpdate(query) == 1;
        } catch (SQLException e) {
            System.err.println("Ошибка работы с БД в BetDAO!");
            e.printStackTrace();
        }
        return isUpdateOk;
    }

    @Override
    public boolean delete(Bet entity) {
        boolean isDeleteOk = false;
        String query = "DELETE FROM bets WHERE bets.ID = " + entity.getId();
        try (Connection connection = Connector.getConnection();
             Statement statement = connection.createStatement()) {
            isDeleteOk = statement.executeUpdate(query) == 1;
        } catch (SQLException e) {
            System.err.println("Ошибка работы с БД в BetDAO!");
            e.printStackTrace();
        }
        return isDeleteOk;
    }

    @Override
    public List<Bet> readAll(String WhereAndOrder) {
        List<Bet> bets = new ArrayList<>();
        try (Connection connection = Connector.getConnection();
             Statement statement = connection.createStatement()) {
            String query = "SELECT * FROM bets " + WhereAndOrder + " ;";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                bets.add(new Bet(
                        resultSet.getInt("id"),
                        resultSet.getTimestamp("time"),
                        resultSet.getInt("fk_race"),
                        resultSet.getString("horse"),
                        resultSet.getDouble("betSum"),
                        resultSet.getInt("fk_user")));
            }
        } catch (SQLException e) {
            System.err.println("Ошибка работы с БД в BetDAO!");
            e.printStackTrace();
        }
        return bets;
    }
}
