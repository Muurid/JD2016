package by.it.sinkevich.project.java;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class CommandPlaceBet implements ActionCommand {

    @Override
    public String execute(HttpServletRequest request) {
        HttpSession session = request.getSession(true);
        if (session.getAttribute("sessionUser") == null) {
            return Action.INDEX.viewPage;
        }
        return Action.PLACE_BET.viewPage;
    }
}
