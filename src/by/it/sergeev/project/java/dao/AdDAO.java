package by.it.sergeev.project.java.dao;

import by.it.sergeev.project.java.beans.Ad;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class AdDAO extends AbstractDAO implements InterfaceDAO<Ad> {
    @Override
    public Ad read(int id) {
        List<Ad> roles = getAll("WHERE ID=" + id + " LIMIT 0,1");
        if (roles.size() > 0) {
            return roles.get(0);
        } else
            return null;
    }

    @Override
    public boolean create(Ad ad) {
        //локаль нужна,т.к. есть дробные числа. Их нужно указывать через точку
        String sql = String.format(Locale.ENGLISH,
                "insert INTO ad(Electronics,Manufacturer,Name,Model,Price,Description,FK_Users)" +
                        "\n values('%s', '%s', '%s', '%s', '%.3f', '%s' ,'%d');",
                ad.getElectronics(),
                ad.getManufacturer(),
                ad.getName(),
                ad.getModel(),
                ad.getPrice(),
                ad.getDescription(),
                ad.getFK_Users()
        );
        ad.setID(executeUpdate(sql));
        return (ad.getID() > 0);
    }

    @Override
    public boolean update(Ad ad) {
        //локаль нужна,т.к. есть дробные числа. Их нужно указывать через точку
        String sql = String.format(Locale.ENGLISH,
                "UPDATE `ad` SET " +
                        "`Electronics`='%s'" +
                        ",`Manufacturer`='%s'" +
                        ",`Name`='%s'" +
                        ",`Model`='%s'"+
                        ",`Price`='%.3f'" +
                        ",`Description`='%s'" +
                        ",`FK_Users`= %d" +
                        " WHERE `ad`.`ID` = %d",
                ad.getElectronics(),
                ad.getManufacturer(),
                ad.getName(),
                ad.getModel(),
                ad.getPrice(),
                ad.getDescription(),
                ad.getFK_Users(),
                ad.getID()
        );

        return (0 < executeUpdate(sql));
    }

    @Override
    public boolean delete(Ad ad) {
        String sql = String.format(
                "DELETE FROM `ad` WHERE `ad`.`ID`=%d;", ad.getID()
        );
        return (0 < executeUpdate(sql));
    }

    @Override
    public List<Ad> getAll(String WHERE) {
        List<Ad> ads = new ArrayList<>();
        String sql = "SELECT * FROM ad " + WHERE + " ;";
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()
        ) {
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                Ad ad = new Ad();
                ad.setID(rs.getInt("ID"));
                ad.setElectronics(rs.getString("Electronics"));
                ad.setManufacturer(rs.getString("Manufacturer"));
                ad.setName(rs.getString("Name"));
                ad.setModel(rs.getString("Model"));
                ad.setPrice(rs.getDouble("Price"));
                ad.setDescription(rs.getString("Description"));
                ad.setFK_Users(rs.getInt("FK_Users"));
                ads.add(ad);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ads;
    }
}
