package by.it.kust.jd03_04.my_project.java;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;
import java.util.Enumeration;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Tanya Kust.
 */
public class FormHelper {
    // класс для чтения и валидации данных в форме
    private HttpServletRequest request;
    public FormHelper(HttpServletRequest request){
        this.request = request;   // запоминаем ссылку на запрос
    }

    //валидация данных из формы с заданным шаблоном
    private boolean valid(String value, String regexp){
        if (value==null) return false;
        Pattern pattern = Pattern.compile(regexp);
        Matcher matcher = pattern.matcher(value);
        if (matcher.find())
            return true;
        else return false;
    }

    public boolean isPost(){
        return request.getMethod().equalsIgnoreCase("post");
    }

    public String getString(String nameFieldForm) throws Exception {
        String value = request.getParameter(nameFieldForm);
        boolean res = (value != null && valid(value,".*"));
        if (res){
            return value;
        }else {
            throw new Exception("Введены некорректные данные - не текст!");
        }
    }

    public Double getDouble(String nameFieldForm) throws Exception {
        String value = request.getParameter(nameFieldForm);
        boolean res = (value != null && valid(value,".*"));
        if (res){
            return Double.parseDouble(value);
        }else {
            throw new Exception("Введены некорректные данные - не число double!");
        }
    }

    public Integer getInt(String nameFieldForm) throws Exception {
        String value = request.getParameter(nameFieldForm);
        boolean res = (value != null && valid(value,".*"));
        if (res){
            return Integer.parseInt(value);
        }else {
            throw new Exception("Введены некорректные данные - не число Integer!");
        }
    }

    public Date getDate(String nameFieldForm) throws Exception {
        String value = request.getParameter(nameFieldForm);
        boolean res = (value != null && valid(value,".*"));
        if (res){
            return Date.valueOf(value);
        }else {
            throw new Exception("Введены некорректные данные - не дата Date!");
        }
    }

    //это экземплярный метод для отладки. Он покажет в виде текста, что пришло из формы
    //пока приватный, но вполне может быть и публичным
    public String strDebugForm(){
        String formText = "";
        Enumeration<String> parameterNames = request.getParameterNames();
        while (parameterNames.hasMoreElements()){
            String field = parameterNames.nextElement();
            String value = request.getParameter(field);
            formText = formText.concat(field + "=" + value + "; ");
        }
        return formText;
    }

    //это статический метод для отладки. Он покажет в виде текста, что пришло из формы
    static String strDebugForm(HttpServletRequest request){
        return new FormHelper(request).strDebugForm();
    }

    public void setErrorMessage(String message){
        request.setAttribute(Action.msgError, message);
    }

    public void setMessage(String message){
        request.setAttribute(Action.msgMessage, message);
    }
}
