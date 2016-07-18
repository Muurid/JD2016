package by.it.sinkevich.project.java;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class CommandLogout implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        HttpSession session = request.getSession(true);
        session.invalidate();
        return Action.LOGOUT.viewPage;
    }
}
