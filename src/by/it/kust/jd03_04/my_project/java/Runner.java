package by.it.kust.jd03_04.my_project.java;

import by.it.kust.jd03_04.my_project.java.beans.Role;
import by.it.kust.jd03_04.my_project.java.beans.Tour;
import by.it.kust.jd03_04.my_project.java.beans.User;
import by.it.kust.jd03_04.my_project.java.custom_dao.Dao;
import by.it.kust.jd03_04.my_project.java.custom_dao.RoleDao;
import by.it.kust.jd03_04.my_project.java.custom_dao.TourDao;
import by.it.kust.jd03_04.my_project.java.custom_dao.UserDao;

import java.util.List;

/**
 * Created by Tanya Kust.
 */
public class Runner {
    static void showUsers(){
        // покажем все, что есть в таблице пользователей
        System.out.println("\nTable of users:");
        List<User> users = new UserDao().getAll("");
        for (User each: users) System.out.println(each);
    }
    static void showTours(){
        // покажем все, что есть в таблице туров
        System.out.println("\nTable of tours:");
        List<Tour> tours = new TourDao().getAll("");
        for (Tour each: tours) System.out.println(each);
    }
    static void showRoles(){
        // покажем все, что есть в таблице ролей
        System.out.println("\nTable of roles:");
        List<Role> roles = new RoleDao().getAll("");
        for (Role each: roles) System.out.println(each);
    }

    public static void main(String[] args) {
        // инициализация работы с базой
        Dao dao = Dao.getDao();
        System.out.println("Роли пользователей:");
        for (Role role: dao.role.getAll("")){
            System.out.println(role);
        }
        //showRoles();

        showUsers();
        User user = new User(0,"Юзер через Дао","login159","pass7","user@mail.com", "Belarus, Minsk",0,2);
        // добавим пользователя в БД
        if (dao.user.create(user)) System.out.println("User added to DB: " + user);
        showUsers();

        // извлечем и обновим пользоватедя с email user@mail.com
        user = dao.user.getAll("WHERE email='user@mail.com'").get(0);
        user.setEmail("user@newmail.com");
        if (dao.user.update(user)) System.out.println("User's email updated: " + user);
        showUsers();

        // удалим пользователя
        if (dao.user.delete(user)) System.out.println("User deleted from DB: " + user);
        showUsers();
    }
}
