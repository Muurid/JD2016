package by.it.drachyova.project.java;

import javax.servlet.http.HttpServletRequest;

public class CommandIndex implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        return Action.INDEX.inPage;
    }
}