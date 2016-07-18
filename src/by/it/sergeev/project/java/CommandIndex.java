package by.it.sergeev.project.java;

import by.it.sergeev.project.java.beans.Ad;
import by.it.sergeev.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class CommandIndex implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        List<Ad> ads = DAO.getDAO().ad.getAll("");
        request.setAttribute("ads", ads);
        return Action.INDEX.inPage;
    }
}