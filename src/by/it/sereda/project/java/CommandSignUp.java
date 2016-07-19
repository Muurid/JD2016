package by.it.sereda.project.java;

import by.it.sereda.project.java.beans.User;
import by.it.sereda.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;

public class CommandSignUp implements ActionCommand {


    @Override
    public String execute(HttpServletRequest request) {
        FormHelper frm = new FormHelper(request);
        //проверим отправлены ли данные из формы, если нет, то покажем форму регистрации
        User user = new User();
        if (frm.isPost())
        try {
            user.setId(0);
            //проверим поля (добавьте паттерны самостоятельно)
            user.setEmail(frm.getString("Email"));   //почта
            user.setLogin(frm.getString("Login"));   //логин
            //пароль. тут проблема безопасности.
            // нужно "солить" и хешировать.
            user.setPassword(frm.getString("Password"));
            DAO dao = DAO.getDAO();

            //немного сложно для понимания. но это почти что user.setFk_Role(2);
            user.setFk_Role((dao.role.getAll("WHERE Role='User' LIMIT 0,1").get(0)).getId());

            //проверим нет ли такого же пользователя уже в базе
            boolean found =
                    dao.user.getAll(String.format("WHERE Login='%s' or Email='%s' LIMIT 0,1",
                            user.getLogin(), user.getEmail()
                            )
                    ).size() > 0;

            if (!found) {
                dao.user.create(user);
                frm.setMessage("Пользователь успешно создан. Введите данные для авторизации.");
                return Action.SIGNUP.okPage;
                //кстати, тут еще можно добавить пользователя в сессию
                // и тогда его не нужно будет авторизовывать
            } else {
                frm.setErrorMessage("Пользователь с такими данными уже существует.");
            }
        } catch (Exception e) {
            frm.setErrorMessage("Ошибка создания пользователя. Введите данные повторно. ");
        }
        return Action.SIGNUP.inPage;
    }
}