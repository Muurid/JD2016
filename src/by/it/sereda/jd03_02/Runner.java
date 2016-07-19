package by.it.sereda.jd03_02;

import by.it.sereda.jd03_02.crud.UserCRUD;

import java.sql.SQLException;

public class Runner {
    public static void main (String[] args) {
        User user=new User(0, "logintest", "emailtest", "passtest", 1);
        UserCRUD userCRUD= new UserCRUD();
        try {
            user=userCRUD.create(user);
            //System.out.println(user);
            System.out.println(userCRUD.read(user.getId()));
            if (userCRUD.delete(user)) {
                System.out.println("Delete ok");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
