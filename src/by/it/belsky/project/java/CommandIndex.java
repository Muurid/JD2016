package by.it.belsky.project.java;


import by.it.belsky.project.java.Beans.Form;
import by.it.belsky.project.java.custom_dao.DAO;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by misha on 19.07.2016.
 */
public class CommandIndex implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        List<Form> forms = DAO.getDAO().form.getAll("");
        request.setAttribute("forms", forms);
        return Action.INDEX.inPage;
    }
}
