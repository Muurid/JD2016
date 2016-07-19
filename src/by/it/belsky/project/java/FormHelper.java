package by.it.belsky.project.java;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

/**
 * Created by misha on 14.07.2016.
 */
class FormHelper {

    private HttpServletRequest request;
    public FormHelper(HttpServletRequest request) {
        this.request = request; //запомним ссылку на запрос.
    }
    //этот класс для чтения и валидации данных в форме
    //этот метод для отладки. Он покажет в виде текста, что пришло из формы
//    static String strDebugForm(HttpServletRequest request) {
//        String formText = "";
//        Enumeration<String> parameterNames = request.getParameterNames();
//        while (parameterNames.hasMoreElements()) {
//            String field = parameterNames.nextElement();
//            String value = request.getParameter(field);
//            formText = formText.concat(field + "=" + value + "; ");
//        }
//        return formText;
//    }
    //валидация данных из формы с шаблоном по умолчанию
    static boolean valid(String value){
        String defaultPattern="[0-9a-zA-Zа-яА-ЯёЁ@\\.]{3,15}";
        return valid(value,defaultPattern);
    }

    //валидация данных из формы с заданным шаблоном
    private static boolean valid(String value,String pattern){
        //проверка на внимательность (для определения, вы просто копируете код или читаете)
        //тут же явно не все, нужно проврить не просто вхождение паттерна в строку
        //а полное соответствие всей строки шаблону. Доделайте.
        return (value!=null) && value.matches(pattern);
    }
    public void setMessage(String message) {
        request.setAttribute(Action.msgMessage, message);
    }
    public void setErrorMessage(String message){
        request.setAttribute(Action.msgMessage, message);
    }
    public boolean isPost(){
        return request.getMethod().equalsIgnoreCase("post");
    }
    public Integer getInt(String nameFieldForm) throws Exception {
        String value = request.getParameter(nameFieldForm);
        boolean res = (value != null && valid(value, "[.,0-9-]+"));
        if (res) {
            return Integer.parseInt(value);
        } else
            throw new Exception("Not valid data");
    }
    public String getString(String nameFieldForm) throws Exception {
        String value = request.getParameter(nameFieldForm);
        boolean res = (value != null && valid(value, ".*"));
        if (res) {
            return value;
        } else
            throw new Exception("Not valid data");
    }
}