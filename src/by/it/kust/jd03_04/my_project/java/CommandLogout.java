package by.it.kust.jd03_04.my_project.java;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class CommandLogout implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        // если нажата кнопка Logout
        if (request.getParameter("LogoutButton") != null){
            HttpSession httpSession = request.getSession(false);
            if (httpSession != null){
                httpSession.invalidate();
                return Action.LOGOUT.okPage;
            }
        }
        return Action.LOGOUT.inPage;
    }
}
