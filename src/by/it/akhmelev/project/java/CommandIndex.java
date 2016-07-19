package by.it.akhmelev.project.java;

import by.it.akhmelev.project.java.beans.Ad;
import by.it.akhmelev.project.java.dao.DAO;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.List;

public class CommandIndex implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        List<Ad> ads = DAO.getDAO().ad.getAll("");
        request.setAttribute("ads", ads);
        return Action.INDEX.inPage;
    }
}