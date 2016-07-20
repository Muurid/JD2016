package by.it.kust.jd03_04.my_project.java;

import by.it.kust.jd03_04.my_project.java.beans.Tour;
import by.it.kust.jd03_04.my_project.java.beans.User;
import by.it.kust.jd03_04.my_project.java.custom_dao.Dao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by Tanya Kust.
 */
public class CommandProfile implements ActionCommand {

    @Override
    public String execute(HttpServletRequest request) {
        HttpSession httpSession = request.getSession(true);
        FormHelper formHelper = new FormHelper(request);
        try {
            //если был POST и нажали кнопку выйти из аккаунта, то сессия сбрасывается.
            if (formHelper.isPost()) {
                if (request.getParameter("LogoutButton") != null &&
                        formHelper.getInt("LogoutButton") == 1) {
                    httpSession.invalidate();
                    return Action.PROFILE.okPage;
                }
            }

            //получим пользователя, его данные и его добавленные туры
            User user = (User) request.getSession(true).getAttribute("user");
            formHelper.setMessage("Профиль " + user);
            if (user != null) {
                request.setAttribute("user", user);
                List<Tour> tours = Dao.getDao().tour.getAll("where fk_Users='" +
                        user.getId() + "'");
                request.setAttribute("tours", tours);
            } else {
                return Action.LOGIN.inPage;
            }
        } catch (Exception e) {
            formHelper.setErrorMessage(e.toString());
        }
        return Action.PROFILE.inPage;
    }
}
