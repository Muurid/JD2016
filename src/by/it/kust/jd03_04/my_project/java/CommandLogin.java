package by.it.kust.jd03_04.my_project.java;

import by.it.kust.jd03_04.my_project.java.beans.User;
import by.it.kust.jd03_04.my_project.java.custom_dao.Dao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class CommandLogin implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        //проверим отправлены ли данные из формы, если нет, то покажем форму
        FormHelper formHelper = new FormHelper(request);
        //если была форма, то ее нужно обработать
        if (formHelper.isPost()){
            try {
                // получим логин и пароль
                String password = formHelper.getString("password");
                String login = formHelper.getString("login");
                //если нет исключения, то читаем пользователя из DAO
                User user = Dao.getDao().user.getAll(
                        String.format("where login='%s' and password='%s'",login,password)
                ).get(0);
                //теперь сохраним данные о пользователе в сессию
                HttpSession session = request.getSession(true);
                session.setAttribute("user", user);
                //получим данные профиля вызывая метод другой команды
                return Action.PROFILE.command.execute(request);
            } catch (Exception e) {
                formHelper.setMessage("Неверные данные, повторите ввод!");
            }
        }
        //если дошли сюда, значит ввода не было, или были ошибки. Покажем форму
        return Action.LOGIN.inPage;
    }
}