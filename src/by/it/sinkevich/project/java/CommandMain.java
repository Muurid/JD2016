package by.it.sinkevich.project.java;

import by.it.sinkevich.project.java.bean.Bet;
import by.it.sinkevich.project.java.bean.User;
import by.it.sinkevich.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public class CommandMain implements ActionCommand {

    @Override
    public String execute(HttpServletRequest request) {
        HttpSession session = request.getSession(true);
        User sessionUser = (User) session.getAttribute("sessionUser");
        List<Bet> sessionUserBets = DAO.getDao().getBetDAO().readAll("WHERE fk_user = " + sessionUser.getId());
        request.setAttribute("sessionUserBets", sessionUserBets);
        return Action.MAIN.viewPage;
    }
}
