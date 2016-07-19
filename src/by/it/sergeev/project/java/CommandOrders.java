package by.it.sergeev.project.java;

import by.it.sergeev.project.java.beans.Ad;
import by.it.sergeev.project.java.beans.User;
import by.it.sergeev.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;

public class CommandOrders implements ActionCommand {
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
                ad.setElectronics(frm.getString("Electronics"));
                ad.setManufacturer(frm.getString("Manufacturer"));
                ad.setName(frm.getString("Name"));
                ad.setModel(frm.getString("Model"));
                ad.setPrice(frm.getDouble("Price"));
                ad.setDescription(frm.getString("Description"));
                ad.setFK_Users(user.getId());
                DAO dao= DAO.getDAO();
                dao.ad.create(ad);
                frm.setMessage(ad.toString());
                return Action.LOGIN.okPage;
            } catch (Exception e) {
                frm.setErrorMessage(e.toString());
            }
        return page;
    }
}
