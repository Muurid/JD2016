package by.it.sergeev.project.java;

import by.it.sergeev.project.java.beans.Ad;
import by.it.sergeev.project.java.beans.User;
import by.it.sergeev.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public class CommandProfile implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        HttpSession httpSession = request.getSession(true);
        FormHelper frm = new FormHelper((request));
        try {
            //если был POST и нажали кнопку выйти из аккаунта, то сессия сбрасывается.
            if (frm.isPost()) {
                if (request.getParameter("LogoutButton") != null &&
                        frm.getInt("LogoutButton") == 1) {
                    httpSession.invalidate();
                    return Action.PROFILE.okPage;
                }
            }

            frm.setMessage("test");
            //получим пользователя, его данные и его объявления

            User user = (User) request.getSession(true).getAttribute("user");
            if (user != null) {
                request.setAttribute("user", user);
                List<Ad> ads = DAO.getDAO().ad.getAll("WHERE FK_Users='" + user.getId() + "'");
                request.setAttribute("ads", ads);
            } else {
                return Action.LOGIN.inPage;
            }
        } catch (Exception e) {
            frm.setErrorMessage(e.toString());
        }
        return Action.PROFILE.inPage;
    }
}
