package by.it.kust.jd03_04.my_project.java;

import by.it.kust.jd03_04.my_project.java.beans.Role;
import by.it.kust.jd03_04.my_project.java.beans.User;
import by.it.kust.jd03_04.my_project.java.custom_dao.Dao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by Tanya Kust.
 */
public class CommandAllUsers implements ActionCommand{

    @Override
    public String execute(HttpServletRequest request) {
        HttpSession httpSession = request.getSession(true);
        FormHelper formHelper = new FormHelper(request);
        Dao dao = Dao.getDao();
        //получим список ролей (лучше бы это сделать при инциализации сервлета)
        List<Role> roles = dao.role.getAll("");
        request.setAttribute("roles",roles);
        //получим пользователя из сессии и его роль
        User sessionUser = (User)httpSession.getAttribute("user");
        if (sessionUser==null){
            formHelper.setErrorMessage("Операция невозможна. Выполните вход!");
            return Action.ALLUSERS.inPage;
        }else if (formHelper.isPost()){
            Role sessionUserRole = null;
            for (Role r: roles){
                if (r.getId()==sessionUser.getFk_Role())
                    sessionUserRole = r;
            }
            //проверим имеет ли пользователь права на операцию
            if (sessionUserRole!=null && !sessionUserRole.getRole().equals("admin")){
                formHelper.setErrorMessage("Операция невозможна. Недостаточно прав");
            }else {
                User user = new User();
                try {
                    user.setId(formHelper.getInt("id"));
                    user.setName(formHelper.getString("name"));
                    user.setLogin(formHelper.getString("login"));
                    //пароль. тут проблема безопасности.
                    // нужно "солить" и хешировать.
                    user.setPassword(formHelper.getString("password"));
                    user.setAddress(formHelper.getString("address"));
                    user.setEmail(formHelper.getString("email"));
                    user.setDiscount(formHelper.getInt("discount"));
                    user.setFk_Role(formHelper.getInt("role"));
                    //Определим, это обновление или удаление.
                    if (user.getId()>0){
                        dao.user.update(user);
                    }else if (user.getId()<0){
                        user.setId(-1*user.getId());
                        dao.user.delete(user);
                    }
                } catch (Exception e) {
                    formHelper.setErrorMessage(e.toString());
                }
            }
        }
        //покажем всех пользователей, вне зависимости от проверки прав
        List<User> users = dao.user.getAll("");
        request.setAttribute("users",users);
        return Action.ALLUSERS.inPage;
    }
}
