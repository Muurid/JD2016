package by.it.drachyova.project.java;

import by.it.drachyova.project.java.beans.Reservation;
import by.it.drachyova.project.java.beans.User;
import by.it.drachyova.project.java.custom_dao.DAO;

import javax.servlet.http.HttpServletRequest;

public class CommandCreateReservation implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        String page = Action.CREATERESERVATION.inPage;
        FormHelper frm = new FormHelper(request);
        frm.setMessage(frm.strDebugForm());
        User user = (User) request.getSession(true).getAttribute("user");
        if (user == null) {
            return Action.LOGIN.inPage;
        }
        //если данные из формы получены то пробуем создать объявление.
        if (frm.isPost())
            try {
                Reservation reservation = new Reservation();
                reservation.setId(0);
                reservation.setFk_user(user.getId());
                DAO dao = DAO.getDAO();
                dao.reservation.create(reservation);
                frm.setMessage(reservation.toString());
                return Action.LOGIN.okPage;
            } catch (Exception e) {
                frm.setErrorMessage(e.toString());
            }
        return page;
    }
}
