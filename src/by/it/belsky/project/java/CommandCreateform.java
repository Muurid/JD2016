package by.it.belsky.project.java;

import by.it.belsky.project.java.Beans.Form;
import by.it.belsky.project.java.Beans.User;
import by.it.belsky.project.java.custom_dao.DAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class CommandCreateform implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        String page = Action.CREATEFORM.inPage;

        //проверим отправлены ли данные из формы, если нет, то покажем форму
        HttpSession session = request.getSession(true);
        if (session.getAttribute("user") == null) {
            request.setAttribute(
                Action.msgMessage,
                    "Авторизируйтесь либо пройдите регистрацию! ");
            return Action.ERROR.okPage;
        }

        try {
            if (request.getParameter("CarModel") == null) {
                request.setAttribute(
                  Action.msgMessage,
                   "Заполните форму ");
                return Action.CREATEFORM.inPage;
            }

            Form form = new Form();
            form.setID(0);
            User user = (User) session.getAttribute("user");
            form.setFK_Users(user.getId());

            form.setCarModel(request.getParameter("CarModel"));
            form.setYearOfIssue(Integer.parseInt(request.getParameter("YearOfIssue")));
            form.setMileage(Integer.parseInt(request.getParameter("MileAge")));
            form.setDescriptionOfBreakage(request.getParameter("DescriptionOfBreakage"));

            DAO dao = DAO.getDAO();
            if (dao.form.create(form)) {
                request.setAttribute(
                        Action.msgMessage, "Форма зарегистрирована");
                page = Action.CREATEFORM.okPage;
            } else {
                request.setAttribute(
                        Action.msgMessage, "Форма не зарегистрирована. Введите данные заново. " + dao.user.lastSQL);
                page = Action.CREATEFORM.inPage;
            }

        } catch (Exception e) {
            request.setAttribute(Action.msgMessage, e.toString());
        }

        return page;
    }
}
//    public static void main(String[] args) {
//        Form form = new Form(0, "lada", 1988, 132000, "none", 1);
//        DAO dao = DAO.getDAO();
//
//        dao.form.create(form);
//    }
//
//}