package by.it.kust.jd03_04.my_project.java;

import by.it.kust.jd03_04.my_project.java.beans.User;
import by.it.kust.jd03_04.my_project.java.custom_dao.Dao;

import javax.servlet.http.HttpServletRequest;

public class CommandSignUp implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        FormHelper formHelper = new FormHelper(request);
        //проверим отправлены ли данные из формы, если нет, то покажем форму регистрации
        User user = new User();
        if (formHelper.isPost()){

                user.setId(0);
                //проверим поля (добавьте паттерны самостоятельно)
            try {
                user.setName(formHelper.getString("name"));
            } catch (Exception e) {
                formHelper.setErrorMessage("Ошибка ФИО");
            }
            try {
                user.setLogin(formHelper.getString("login"));
            } catch (Exception e) {
                formHelper.setErrorMessage("Ошибка логина");
            }
            //пароль. тут проблема безопасности.
                // нужно "солить" и хешировать.
            try {
                user.setPassword(formHelper.getString("password"));
            } catch (Exception e) {
                formHelper.setErrorMessage("Ошибка пароля");
            }
            try {
                user.setAddress(formHelper.getString("address"));
            } catch (Exception e) {
                formHelper.setErrorMessage("Ошибка адреса");
            }
            try {
                user.setEmail(formHelper.getString("email"));
            } catch (Exception e) {
                formHelper.setErrorMessage("Ошибка имэйла");
            }
            user.setDiscount(0);
                user.setFk_Role(2);

                Dao dao = Dao.getDao();
                // это почти что user.setFk_Role(2)
                //user.setFk_Role((dao.role.getAll("WHERE role='user' LIMIT 0,1").get(0)).getId());
                //проверим нет ли такого же пользователя уже в базе
                boolean found =
                        dao.user.getAll(String.format("WHERE login='%s' or email='%s' LIMIT 0,1",
                                user.getLogin(), user.getEmail())).size() > 0;
                if (!found){
                    if (dao.user.create(user))
                        formHelper.setMessage("Пользователь добавлен. Введите данные для авторизации.");
                    return Action.SIGNUP.okPage;
                    //кстати, тут еще можно добавить пользователя в сессию
                    // и тогда его не нужно будет авторизовывать
                }else {
                    formHelper.setMessage("Пользователь с такими данными уже существует.");
                }
            } /*catch (Exception e) {
                formHelper.setErrorMessage("Пользователь НЕ создан. Введите данные повторно.");
            }*/

        return Action.SIGNUP.inPage;
    }
}