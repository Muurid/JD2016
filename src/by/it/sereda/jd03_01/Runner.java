package by.it.sereda.jd03_01;

import java.sql.*;

public class Runner {
    public static void main(String[] args) {
        try (Connection connection = CN.getConnection(); Statement statement = connection.createStatement()) {

            statement.executeUpdate("DROP TABLE IF EXISTS users ");
            statement.executeUpdate("DROP TABLE IF EXISTS role ");
            statement.executeUpdate("DROP TABLE IF EXISTS rent ");

            statement.executeUpdate("CREATE TABLE `seredatest`.`role` ( `ID` INT(10) NOT NULL , `Role` VARCHAR(100) NOT NULL , PRIMARY KEY (`ID`)) ENGINE = InnoDB;");
            statement.executeUpdate("CREATE TABLE `seredatest`.`users` ( `ID` INT(10) NOT NULL AUTO_INCREMENT , `Login` VARCHAR(100) NOT NULL , `Password` VARCHAR(100) NOT NULL , `Email` VARCHAR(100) NOT NULL , `FK_Role` INT(10) NOT NULL , PRIMARY KEY (`ID`)) ENGINE = InnoDB;");
            statement.executeUpdate("CREATE TABLE `seredatest`.`rent` ( `ID` INT(10) NOT NULL AUTO_INCREMENT , `Adress` VARCHAR(100) NOT NULL , `Floor` INT(10) NOT NULL , `Guests` INT(10) NOT NULL , `Hotels` VARCHAR(100) NOT NULL , `Price` INT(10) NOT NULL , `Rating` INT(10) NOT NULL , `RoomCount` INT(10) NOT NULL , `FK_Users` INT NOT NULL , PRIMARY KEY (`ID`)) ENGINE = InnoDB;");

            statement.executeUpdate("INSERT INTO `role` (`ID`, `Role`) VALUES ('1', 'administrator'), ('2', 'user');");
            statement.executeUpdate("INSERT INTO `users` (`ID`, `Login`, `Password`, `Email`, `FK_Role`) VALUES (NULL, 'admin', 'admin', 'admin@mail.com', '1');");
            statement.executeUpdate("INSERT INTO `users` (`ID`, `Login`, `Password`, `Email`, `FK_Role`) VALUES (NULL, 'user', 'userpassword', 'user@mail.com', '2');");
            statement.executeUpdate("INSERT INTO `rent` (`ID`, `Adress`, `Floor`, `Guests`, `Hotels`, `Price`, `Rating`, `RoomCount`, `FK_Users`) VALUES (NULL, '19 Malevska ul. Warsaw Poland', '0', '2', 'Hilton', '100', '9', '1', '1');");

            ResultSet resultSet = statement.executeQuery("SELECT * FROM Users INNER JOIN Role ON Users.FK_Role=Role.ID");
            System.out.println("Cписок пользователей:");


            while (resultSet.next()) {
                ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
                int countColumn = resultSetMetaData.getColumnCount();
                System.out.println("Пользователь:");
                for (int i = 1; i < countColumn + 1; i++) {
                                        System.out.print(
                            resultSetMetaData.getColumnLabel(i) + " = " + resultSet.getString(i) + "\t");
                }
                System.out.println();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}