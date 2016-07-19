package by.it.sinkevich.project.java;

import by.it.sinkevich.project.java.bean.User;
import by.it.sinkevich.project.java.dao.DAO;
import by.it.sinkevich.project.java.dao.UserDAO;
import by.it.sinkevich.project.java.util.Pattern;
import by.it.sinkevich.project.java.util.Utility;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;
import java.util.List;

public class CommandRegisterSendForm implements ActionCommand {

    @Override
    public String execute(HttpServletRequest request) {
        String viewPage = Action.REGISTER_SEND_FORM.viewPage;

        String name = request.getParameter("name");
        String dateOfBirth = request.getParameter("dateOfBirth");
        String email = request.getParameter("email");
        String login = request.getParameter("login");
        String password = request.getParameter("password");

        if (Utility.isValid(name, Pattern.userNameRegex) && Utility.isValid(dateOfBirth, Pattern.dateRegex) &&
                Utility.isValid(email, Pattern.emailRegex) && Utility.isValid(login, Pattern.loginRegex) &&
                Utility.isValid(password, Pattern.passwordRegex)) {

            User user = new User();
            user.setId(0);
            user.setName(name);
            user.setDateOfBirth(Date.valueOf(dateOfBirth));
            user.setEmail(email);
            user.setFk_role(2);
            user.setLogin(login);
            //password = DigestUtils.md5Hex(password);
            user.setPassword(password);

            UserDAO userDAO = DAO.getDao().getUserDAO();
            List<User> users = userDAO.readAll("WHERE login = '" + user.getLogin() + "'");
            if (users.size() > 0) {
                request.setAttribute(Action.errorMessage, "Пользователь с таким логином уже существует! Пожалуйста введите данные заново!");
                return Action.REGISTER.viewPage;
            }
            if (userDAO.create(user)) {
                request.setAttribute(Action.message, "Пользователь создан! Можете авторизироваться на сайте!");
            } else {
                request.setAttribute(Action.errorMessage, "Пользователь не создан! Пожалуйста введите данные заново!");
                viewPage = Action.REGISTER.viewPage;
            }
        } else {
            request.setAttribute(Action.errorMessage, "Переданы невалидные данные! Пожалуйста введите данные заново!");
            viewPage = Action.REGISTER.viewPage;
        }
        return viewPage;
    }
}
