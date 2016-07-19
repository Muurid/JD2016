package by.it.sereda.project.java;

import by.it.sereda.project.java.beans.Rent;
import by.it.sereda.project.java.beans.User;
import by.it.sereda.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;

public class CommandCreateRent implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        String page= Action.CREATERENT.inPage;
        FormHelper frm=new FormHelper(request);
        frm.setMessage(frm.strDebugForm());
        User user= (User) request.getSession(true).getAttribute("user");
        if (user==null) {
            return Action.LOGIN.inPage;
        }
        //если данные из формы получены то пробуем создать объявление.
        if (frm.isPost())
        try {
            Rent rent =new Rent();
            rent.setID(0);
            rent.setAddress(frm.getString("Address"));
            rent.setHotels(frm.getString("Hotels"));
            rent.setRating(frm.getDouble("Rating"));
            rent.setPrice(frm.getDouble("Price"));
            rent.setFloor(frm.getInt("Floor"));
            rent.setGuests(frm.getInt("Guests"));
            rent.setRoomCount(frm.getInt("RoomCount"));
            rent.setFK_Users(user.getId());
            DAO dao= DAO.getDAO();
            dao.rent.create(rent);
            frm.setMessage(rent.toString());
            return Action.LOGIN.okPage;
        } catch (Exception e) {
            frm.setErrorMessage(e.toString());
        }
        return page;
    }
}
