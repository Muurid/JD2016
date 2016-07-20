package by.it.kust.jd03_04.my_project.java;

import by.it.kust.jd03_04.my_project.java.beans.Tour;
import by.it.kust.jd03_04.my_project.java.custom_dao.Dao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by Tanya Kust.
 */
public class CommandIndex implements ActionCommand{
    @Override
    public String execute(HttpServletRequest request) {
        //HttpSession httpSession = request.getSession(true);
        //FormHelper formHelper = new FormHelper(request);
        Dao dao = Dao.getDao();
        //получим список туров
        List<Tour> proposedTours = dao.tour.getAll("");
        request.setAttribute("tours",proposedTours);
        return Action.INDEX.okPage;
    }
}
