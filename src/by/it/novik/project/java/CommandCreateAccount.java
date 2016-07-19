package by.it.novik.project.java;

import by.it.novik.project.java.beans.Account;
import by.it.novik.project.java.beans.User;
import by.it.novik.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Kate Novik.
 */
public class CommandCreateAccount implements ActionCommand{

    @Override
    public String execute(HttpServletRequest request) {
        String page = Action.ACCOUNTS.inPage;
        //Получаем из сессии объект user
        User user= (User) request.getSession(true).getAttribute("user");
        if (user==null) {
            return Action.LOGIN.inPage;
        }
        //Получаем объект DAO
        DAO dao = DAO.getDAO();
        Account account = new Account(0,0,"Working",2);
        if (dao.getAccountDAO().create(account)) {
            request.setAttribute(Action.msgMessage, "Account № " + account.getIdAccount() +" was created.");
        }
        else {
            request.setAttribute(Action.msgMessage, "Account wasn't created.");
        }
        return page;
    }
}
