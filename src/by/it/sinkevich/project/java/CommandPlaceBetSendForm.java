package by.it.sinkevich.project.java;

import by.it.sinkevich.project.java.bean.Bet;
import by.it.sinkevich.project.java.bean.User;
import by.it.sinkevich.project.java.dao.BetDAO;
import by.it.sinkevich.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.Timestamp;

public class CommandPlaceBetSendForm implements ActionCommand {

    @Override
    public String execute(HttpServletRequest request) {
        HttpSession session = request.getSession(true);
        if (session.getAttribute("sessionUser") == null) {
            return Action.INDEX.viewPage;
        }
        User sessionUser = (User) session.getAttribute("sessionUser");

        Timestamp time = new Timestamp(System.currentTimeMillis());
        String fk_raceStr = request.getParameter("fk_race");
        String horse = request.getParameter("horse");
        String betSumStr = request.getParameter("betSum");
        int fk_user = sessionUser.getId();

        Bet bet = new Bet();
        bet.setId(0);
        bet.setTime(time);
        bet.setFk_race(Integer.parseInt(fk_raceStr));
        bet.setHorse(horse);
        bet.setBetSum(Double.parseDouble(betSumStr));
        bet.setFk_user(fk_user);

        BetDAO betDAO = DAO.getDao().getBetDAO();
        if (betDAO.create(bet)) {
            request.setAttribute(Action.message, "Ставка принята! Желаем вам удачи!");
        } else {
            request.setAttribute(Action.errorMessage, "Ставка не принята! Попробуйте заново!");
            return Action.PLACE_BET.viewPage;
        }
        return Action.MAIN.command.execute(request);
    }
}
