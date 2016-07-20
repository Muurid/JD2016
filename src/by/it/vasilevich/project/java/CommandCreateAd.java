package by.it.vasilevich.project.java;


import by.it.vasilevich.project.java.beans.Ad;
import by.it.vasilevich.project.java.beans.User;
import by.it.vasilevich.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;

public class CommandCreateAd implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        String page=Action.CREATEAD.inPage;
        FormHelper frm=new FormHelper(request);
        frm.setMessage(frm.strDebugForm());
        User user= (User) request.getSession(true).getAttribute("user");
        if (user==null) {
            return Action.LOGIN.inPage;
        }
        //если данные из формы получены то пробуем создать объявление.
        if (frm.isPost())
        try {
            Ad ad=new Ad();
            ad.setID(0);
            ad.setPrice(frm.getInt("Price"));
            ad.setBrand(frm.getString("Brand"));
            ad.setModel(frm.getString("Model"));
            ad.setType(frm.getString("Type"));
            ad.setYear(frm.getInt("Year"));
            ad.setEngine(frm.getString("Engine"));
            ad.setTransmission(frm.getString("Transmission"));
            ad.setDrive_unit(frm.getString("Drive_unit"));
            ad.setMileage(frm.getInt("Mileage"));
            ad.setColor(frm.getString("Color"));
            ad.setFK_Users(user.getId());
            DAO dao=DAO.getDAO();
            dao.ad.create(ad);
            frm.setMessage(ad.toString());
            return Action.LOGIN.okPage;
        } catch (Exception e) {
            frm.setErrorMessage(e.toString());
        }
        return page;
    }
}
