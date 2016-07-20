package by.it.kust.jd03_04.my_project.java;

import by.it.kust.jd03_04.my_project.java.beans.Tour;
import by.it.kust.jd03_04.my_project.java.beans.User;
import by.it.kust.jd03_04.my_project.java.custom_dao.Dao;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Tanya Kust.
 */
public class CommandAddTour implements ActionCommand{

    @Override
    public String execute(HttpServletRequest request) {
        FormHelper formHelper = new FormHelper(request);
        formHelper.setMessage(formHelper.strDebugForm());
        User user = (User)request.getSession(true).getAttribute("user");

        //покажем все туры
        Dao dao = Dao.getDao();
        List<Tour> tours = dao.tour.getAll("");
        request.setAttribute("tours",tours);
        String page = Action.ORDERTOUR.inPage;

        if (user==null){
            return Action.LOGIN.inPage;
        }
        //если данные из формы получены то пробуем добавить тур.
        if (formHelper.isPost()){
            try {
                Tour tour = new Tour();
                tour.setId(0);
                tour.setCountry(formHelper.getString("country"));
                tour.setCity(formHelper.getString("city"));
                tour.setHotel(formHelper.getString("hotel"));
                tour.setUrl(formHelper.getString("url"));
                tour.setDays(formHelper.getInt("days"));
                tour.setPrice(formHelper.getInt("price"));
                tour.setType(formHelper.getString("type"));
                tour.setOption1(formHelper.getString("option1"));
                tour.setOption2(formHelper.getString("option2"));
                tour.setFk_Users(user.getId());
                if (dao.tour.create(tour)) {
                    formHelper.setMessage("Тур заказан: " + tour.toString());
                    List<Tour> updatedTours = Dao.getDao().tour.getAll("where fk_Users='" +
                            user.getId() + "'");
                    request.setAttribute("tours", updatedTours);
                }
                return Action.ORDERTOUR.okPage;
            } catch (Exception e) {
                formHelper.setErrorMessage(e.toString());
            }
        }
        return page;
    }
}
