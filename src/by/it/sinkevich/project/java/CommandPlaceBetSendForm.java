package by.it.sinkevich.project.java;

import javax.servlet.http.HttpServletRequest;

public class CommandPlaceBetSendForm implements ActionCommand {

    @Override
    public String execute(HttpServletRequest request) {
        return Action.PLACE_BET_SEND_FORM.viewPage;
    }
}
