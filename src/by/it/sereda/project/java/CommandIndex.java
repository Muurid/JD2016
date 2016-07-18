package by.it.sereda.project.java;

import by.it.sereda.project.java.beans.Rent;
import by.it.sereda.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class CommandIndex implements by.it.sereda.project.java.ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        List<Rent> rents = DAO.getDAO().rent.getAll("");
        request.setAttribute("rents", rents);
        return Action.INDEX.inPage;
    }
}