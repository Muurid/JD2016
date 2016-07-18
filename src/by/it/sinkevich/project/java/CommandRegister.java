package by.it.sinkevich.project.java;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class CommandRegister implements ActionCommand {

    @Override
    public String execute(HttpServletRequest request) {
        HttpSession session = request.getSession(true);

        if (session.getAttribute("user") != null) {
            return Action.LOGIN_SEND_FORM.viewPage;
        }
        return Action.REGISTER.viewPage;
    }
}
