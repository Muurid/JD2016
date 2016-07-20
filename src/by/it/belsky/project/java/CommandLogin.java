package by.it.belsky.project.java;

import by.it.belsky.project.java.Beans.User;
import by.it.belsky.project.java.custom_dao.DAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public class CommandLogin implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        String page = Action.LOGIN.inPage;

        //проверим отправлены ли данные из формы, если нет, то покажем форму
        if (request.getParameter("Password") == null) {
            return page;
        }
        String password=request.getParameter("Password");   //пароль
        String login=request.getParameter("Login");   //логин

        if (FormHelper.valid(password) && FormHelper.valid(login)) {
            DAO dao = DAO.getDAO();
            List<User> users=dao.user.getAll(
                    String.format("where Login='%s' and Password='%s'",login,password));
            User user=null;
            if (users.size()>0) {
                user=users.get(0);
            }
            if (user==null) {
                request.setAttribute(
                        Action.msgMessage,
                        "Неверные данные повторите ввод!");
                page = Action.LOGIN.inPage;
            } else {
                request.setAttribute(
                        Action.msgMessage,
                        "Добро пожаловать! "+user.getLogin());
                HttpSession session=request.getSession(true);
                session.setAttribute("user",user);
                page = Action.LOGIN.okPage;
            }
        }else  {
            request.setAttribute(
                    Action.msgMessage,
                    "Введите не менее трех и не более пятнадцати любых символов");
        }
        return page;
    }

}