package by.it.belsky.project.java;

import by.it.belsky.project.java.Beans.Role;
import by.it.belsky.project.java.Beans.User;
import by.it.belsky.project.java.custom_dao.DAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by misha on 19.07.2016.
 */
public class CommandAllUsers implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        HttpSession httpSession = request.getSession(true);
        FormHelper forms = new FormHelper(request);
        DAO dao = DAO.getDAO();
        //получим список ролей (лучше бы это сделать при инциализации сервлета)
        List<Role> roles = dao.role.getAll("");
        request.setAttribute("roles", roles);

        //получим пользователя из сессии и его роль
        User sessionUser = (User) httpSession.getAttribute("user");

        if (sessionUser == null) {
            forms.setErrorMessage("Операции невозможны. Нужно выполнить вход. ");
//            request.setAttribute(
//                    Action.msgMessage,
//                    "Операция невозможна  ТАК РАБОТАЕТ!!! ");
            return Action.ALLUSERS.inPage;
        } else if (forms.isPost()) {
            Role sessionUserRole = null;
            for (Role r : roles) {
                if (r.getId() == sessionUser.getFk_Role())
                    sessionUserRole = r;
            }
            //проверим имеет ли пользователь права на операцию
            if (sessionUserRole != null && !sessionUserRole.getRole().equals("administrator")) {
                forms.setErrorMessage("Операция невозможна. Недостаточно прав.");
            } else //иначе операция возможна.
            {
                User user = new User();
                try {
                    user.setId(forms.getInt("ID"));
                    user.setEmail(forms.getString("Email"));   //почта
                    user.setLogin(forms.getString("Login"));   //логин
                    user.setPassword(forms.getString("Password"));
                    user.setFk_Role(forms.getInt("fk_Role"));
                    forms.setMessage(user.toString());
                    //Определим, это обновление или удаление.
                    if (0 < user.getId()) {
                        dao.user.update(user);
                    } else if (0 > user.getId()) {
                        user.setId(-1 * user.getId());
                        dao.user.delete(user);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        //покажем всех пользователей, вне зависимости от проверки прав
        List<User> users = dao.user.getAll("");
        request.setAttribute("users", users);
        return Action.ALLUSERS.okPage;
    }
}

