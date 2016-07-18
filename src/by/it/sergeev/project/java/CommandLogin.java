package by.it.sergeev.project.java;

import by.it.sergeev.project.java.beans.User;
import by.it.sergeev.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class CommandLogin implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        //проверим отправлены ли данные из формы, если нет, то покажем форму
        FormHelper frm = new FormHelper(request);
        //если была форма, то ее нужно обработать
        if (frm.isPost())
            try {
                //получили логин и пароль
                String password = frm.getString("Password");
                String login = frm.getString("Login");

                //если нет исключения, то читаем пользователя из DAO
                User user = DAO.getDAO().user.getAll(
                        String.format("where Login='%s' and Password='%s'", login, password)
                ).get(0);

                //теперь сохраним данные о пользователе в сессию
                HttpSession session = request.getSession(true);
                session.setAttribute("user", user);

                //получим данные профиля вызывая метод другой команды
                return Action.PROFILE.command.execute(request);

            } catch (Exception e) {
                frm.setErrorMessage("Неверные данные повторите ввод.");
            }
        //если дошли сюда, значит ввода не было, или были ошибки. Покажем форму
        return Action.LOGIN.inPage;
    }
}