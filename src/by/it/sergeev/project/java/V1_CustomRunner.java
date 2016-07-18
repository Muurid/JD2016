package by.it.sergeev.project.java;

import by.it.sergeev.project.java.beans.Role;
import by.it.sergeev.project.java.beans.User;
import by.it.sergeev.project.java.dao.DAO;
import by.it.sergeev.project.java.dao.UserDAO;

import java.sql.SQLException;
import java.util.List;

public class V1_CustomRunner {

    static void showUsers(){
        //покажем все, что есть в таблице пользователей
        System.out.println("\nТаблица пользователей:");
        List<User> users=new UserDAO().getAll("");
        for (User each:users) System.out.println(each);
    }

    public static void main(String[] args) throws SQLException {
        //инициализация работы с базой
        DAO dao = DAO.getDAO();
        System.out.println("Роли пользователей");
        for (Role role: dao.role.getAll("")) {
            System.out.println(role);
        }
        showUsers();

        User user = new User(0,"Сергей Иванович", "siivanov", "dfdfd","dfdfdf","dfd","siivanov@mail.ru",2);
        //добавим пользователя
        if (dao.user.create(user)) System.out.println("\nДобавлен:" + user);
        showUsers();

        //извлечем и обновим пользователя с email siivanov@mail.ru
        user = dao.user.getAll("WHERE ID>2").get(0);
        user.setLogin("up_siivanov");
        if (dao.user.update(user)) System.out.println("\nИзменен:" + user);
        showUsers();

        //удалим пользователя
        if (dao.user.delete(user)) System.out.println("\nУдален:" + user);
        showUsers();
    }
}
