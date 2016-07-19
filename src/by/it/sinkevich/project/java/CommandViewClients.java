package by.it.sinkevich.project.java;

import by.it.sinkevich.project.java.bean.Role;
import by.it.sinkevich.project.java.bean.User;
import by.it.sinkevich.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.Date;
import java.util.List;

public class CommandViewClients implements ActionCommand {

    @Override
    public String execute(HttpServletRequest request) {
        HttpSession session = request.getSession(true);

        if (session.getAttribute("sessionUser") == null) {
            return Action.INDEX.viewPage;
        }

        if (!session.getAttribute("sessionUserRole").equals("Bookmaker")) {
            request.setAttribute(Action.errorMessage, "Операция невозможна! Недостаточно прав!");
        }

        if (request.getMethod().equalsIgnoreCase("post")) {
            String idStr = request.getParameter("id");
            String name = request.getParameter("name");
            String dateOfBirthStr = request.getParameter("dateOfBirth");
            String email = request.getParameter("email");
            String fk_roleStr = request.getParameter("fk_role");
            String login = request.getParameter("login");
            String password = request.getParameter("password");

            User user = new User();
            user.setId(Integer.parseInt(idStr));
            user.setName(name);
            user.setDateOfBirth(Date.valueOf(dateOfBirthStr));
            user.setEmail(email);
            user.setFk_role(Integer.parseInt(fk_roleStr));
            user.setLogin(login);
            user.setPassword(password);

            if (request.getParameter("operation").equals("update")) {
                DAO.getDao().getUserDAO().update(user);
            } else {
                DAO.getDao().getUserDAO().delete(user);
            }
        }

        List<User> users = DAO.getDao().getUserDAO().readAll("");
        request.setAttribute("users", users);
        List<Role> roles = DAO.getDao().getRoleDAO().readAll("");
        request.setAttribute("roles", roles);
        return Action.VIEW_CLIENTS.viewPage;
    }
}
