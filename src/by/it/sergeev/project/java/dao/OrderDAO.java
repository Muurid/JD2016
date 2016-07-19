package by.it.sergeev.project.java.dao;

import by.it.sergeev.project.java.beans.Order;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderDAO extends AbstractDAO implements InterfaceDAO<Order> {
    @Override
    public List<Order> getAll(String Where){
        List<Order> orders=new ArrayList<>();
        String sql="SELECT * FROM orders "+Where+" ;";

        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet rs=statement.executeQuery(sql);
            while (rs.next()){
                Order order = new Order();
                order.setID(rs.getInt("id"));
                order.setFK_Users(rs.getInt("FK_Users"));
                order.setFK_Ad(rs.getInt("FK_Ad"));
                order.setPrice(rs.getDouble("Price"));
                orders.add(order);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return orders;
    }

    @Override
    public Order read(int id) {
        List<Order> orders = getAll("WHERE idOrder=" + id + " LIMIT 0,1");
        if (orders.size() > 0) {
            return orders.get(0);
        } else
            return null;
    }

    @Override
    public boolean create(Order orders){
        String sql = String.format(
                "insert INTO orders(FK_Users,FK_Ad,Price)" +
                        " values(%d, %d, %.3f);",
                orders.getFK_Users(), orders.getFK_Ad(), orders.getPrice()
        );
        return (0 < executeUpdate(sql));
    }

    @Override
    public boolean update(Order orders){
        String sql=String.format(
                "UPDATE orders SET FK_Users = %d, FK_Ad= %d, Price = %.3f , idOrder= %d",
                orders.getFK_Users(), orders.getFK_Ad(), orders.getPrice(), orders.getID()
        );
        return (0 < executeUpdate(sql));
    }

    @Override
    public boolean delete(Order orders) {
        String sql = String.format(
                "DELETE FROM orders WHERE orders.idOrder = %d;", orders.getID()
        );
        return (0 < executeUpdate(sql));
    }
}
