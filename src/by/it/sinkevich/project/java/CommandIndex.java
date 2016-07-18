package by.it.sinkevich.project.java;

import by.it.sinkevich.project.java.bean.Race;
import by.it.sinkevich.project.java.bean.User;
import by.it.sinkevich.project.java.dao.DAO;
import by.it.sinkevich.project.java.dao.RaceDAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public class CommandIndex implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        HttpSession session = request.getSession(true);
        User sessionUser = (User) session.getAttribute("user");

        if (sessionUser!= null) {
            return Action.LOGIN_SEND_FORM.viewPage;
        }

        RaceDAO raceDAO = DAO.getDao().getRaceDAO();
        List<Race> races = raceDAO.readAll("");
        session.setAttribute("races", races);
        return Action.INDEX.viewPage;
    }
}
