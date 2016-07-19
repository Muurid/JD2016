package by.it.sinkevich.project.java;

import by.it.sinkevich.project.java.bean.Role;
import by.it.sinkevich.project.java.bean.User;
import by.it.sinkevich.project.java.dao.DAO;
import by.it.sinkevich.project.java.dao.UserDAO;
import by.it.sinkevich.project.java.util.Pattern;
import by.it.sinkevich.project.java.util.Utility;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public class CommandLoginSendForm implements ActionCommand {

    @Override
    public String execute(HttpServletRequest request) {
        String viewPage = Action.LOGIN_SEND_FORM.viewPage;
        String login = request.getParameter("login");
        String password = request.getParameter("password");

        if (Utility.isValid(login, Pattern.loginRegex) && Utility.isValid(password, Pattern.passwordRegex)) {
            //password = DigestUtils.md5Hex(password);
            UserDAO userDAO = DAO.getDao().getUserDAO();
            List<User> users = userDAO.readAll(String.format("WHERE login = '%s' AND password = '%s'", login, password));
            User user = null;
            if (users.size() > 0) {
                user = users.get(0);
            }
            String message = request.getAttribute("message").toString();
            if (user != null) {
                HttpSession session = request.getSession(true);
                session.setAttribute("sessionUser", user);
                Role sessionUserRole = DAO.getDao().getRoleDAO().read(user.getId());
                session.setAttribute("sessionUserRole", sessionUserRole);
                request.setAttribute(Action.message, message.concat("Добро пожаловать, ").concat(user.getLogin()));
                return Action.MAIN.command.execute(request);
            } else {
                request.setAttribute(Action.errorMessage, "Введены неверные данные!");
                viewPage = Action.LOGIN.viewPage;
            }
        }
        return viewPage;
    }
}
