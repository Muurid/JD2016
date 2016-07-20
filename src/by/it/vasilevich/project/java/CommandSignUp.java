package by.it.vasilevich.project.java;

import by.it.vasilevich.project.java.beans.User;
import by.it.vasilevich.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class CommandSignUp implements ActionCommand {


    @Override
    public String execute(HttpServletRequest request) {
        FormHelper frm = new FormHelper(request);
        //проверим отправлены ли данные из формы, если нет, то покажем форму регистрации
        User user = new User();
        if (frm.isPost())
            try {
                user.setId(0);

                user.setEmail(frm.getString("Email"));   //почта
                user.setLogin(frm.getString("Login"));   //логин
                //пароль. тут проблема безопасности.
                // нужно "солить" и хешировать.
                user.setPassword(frm.getString("Password"));
//                данный способ позволяет регистрироваться под любой ролью
//                user.setFK_Role(frm.getInt("FK_Role"));
                DAO dao = DAO.getDAO();

                //немного сложно для понимания. но это почти что user.setFK_Role(2);
                //только пользователь сможет зарегистрироваться в качестве роли User;
                user.setFK_Role((dao.role.getAll("WHERE Role='User' LIMIT 0,2").get(0)).getId());

                //проверим нет ли такого же пользователя уже в базе
                boolean found =
                        dao.user.getAll(String.format("WHERE Login='%s' or Email='%s' LIMIT 0,2",
                                user.getLogin(), user.getEmail()
                                )
                        ).size() > 0;

                if (!found) {
                    dao.user.create(user);
                    frm.setMessage("Пользователь создан. Введите данные для авторизации.");
                    HttpSession session = request.getSession(true);
                    session.setAttribute("user", user);
                    return Action.PROFILE.inPage;


                    //кстати, тут еще можно добавить пользователя в сессию
                    // и тогда его не нужно будет авторизовывать
                } else {
                    frm.setErrorMessage("Пользователь с такими данными уже существует.");
                }
            } catch (Exception e) {
                frm.setErrorMessage("Пользователя создать не удалось! Введите данные повторно. ");
            }
        return Action.SIGNUP.inPage;
    }
}