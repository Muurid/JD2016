package by.it.belsky.project.java;

import by.it.belsky.project.java.Beans.Form;
import by.it.belsky.project.java.Beans.User;
import by.it.belsky.project.java.custom_dao.DAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public class CommandLogout implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        HttpSession session = request.getSession(true);
        FormHelper formHelper = new FormHelper(request);
        try {
            User user = (User) session.getAttribute("user");
            if (session.getAttribute("user") == null)
                return Action.ERROR.fPage;
            request.setAttribute("LoginAndEmail", user.getLogin() + "( " + user.getEmail() + " )");
            //      DAO dao=DAO.getDAO();
//        List<Form> forms=dao.form.getAll("WHERE FK_Users="+user.getId());
//        request.setAttribute("Forms",forms);
            if (request.getParameter("LogoutButton") != null) {
                session.invalidate();
                return Action.LOGOUT.okPage;
            }
            formHelper.setMessage("test");
            if (user != null) {
                request.setAttribute("user", user);
                List<Form> forms = DAO.getDAO().form.getAll("WHERE FK_Users='" + user.getId() + "'");
                request.setAttribute("forms", forms);
                Form form=null;
                if (forms.size()==0) {
                    return Action.ERROR.kPage;
                }
            } else {
                return Action.LOGIN.inPage;
            }

        } catch (Exception e) {
            formHelper.setErrorMessage(e.toString());

        }
        return Action.LOGOUT.inPage;
    }
}