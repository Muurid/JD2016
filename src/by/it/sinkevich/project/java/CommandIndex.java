package by.it.sinkevich.project.java;

import javax.servlet.http.HttpServletRequest;

public class CommandIndex implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        return Action.INDEX.viewPage;
    }
}
