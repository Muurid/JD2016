package by.it.akhmelev.project.java;

import by.it.akhmelev.project.java.dao.ConnectionCreator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ResourceBundle;

@WebServlet("/do")
public class Controller extends HttpServlet {
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        //Добавка по то, где лучше хранить соединения, локализацию, конфиги и прочее.
        //на примере коннекта к DB

        //Вариант 1. Проще. читаем параметры из web.xml и пишем в ConnectionCreator
        ConnectionCreator.setURL_DB      (  config.getInitParameter("URL_DB")       );
        ConnectionCreator.setUSER_DB     (  config.getInitParameter("USER_DB")      );
        ConnectionCreator.setPASSWORD_DB (  config.getInitParameter("PASSWORD_DB")  );

        //Вариант 2. Немного сложнее. Читаем параметры из файла ресурсов и пишем в ConnectionCreator
        //файл ресурсов трактуется как класс и ищется JVM томката в WEB-INF/classes,

        //НО ant не копирует его в build до сборки WAR-а (это просто не настроено)
        //поэтому нужно или изменить ant или самостоятельно положить ресурсы в WEB-INF/classes

        //я прямо создал папку classes в WEB-INF и добавил туда ресурсы db.properties
        //В итоге так вот к примеру обращаемся к ресурсу db в пакете config
        //(обратите внимание что тут он имеет собственный путь от корня и с классами сервлета не связан)
        ResourceBundle rb = ResourceBundle.getBundle("config.db");
        ConnectionCreator.setURL_DB      (  rb.getString("URL_DB")       );
        ConnectionCreator.setUSER_DB     (  rb.getString("USER_DB")      );
        ConnectionCreator.setPASSWORD_DB (  rb.getString("PASSWORD_DB")  );
        //правильнее конечно сделать папку resourсes и в ANT настоить копирование
        //ее содержимого в build/WEB-INF/classes на шаге 04copy
        //это несложно, но без применения ant понятнее происходящее.

        //и наконец дополнительно еще можно изменить classpath в tomcat но это нежелательный сценарий
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request,
                                HttpServletResponse response)
            throws ServletException, IOException {
        //выставим в сообщение данные из формы (для отладки)
        request.setAttribute(Action.msgMessage, FormHelper.strDebugForm(request));

        ActionFactory client = new ActionFactory(); // определение команды, пришедшей из JSP
        ActionCommand command = client.defineCommand(request);

        //вызов реализованного метода execute() и передача параметров
        //классу-обработчику конкретной команды. Обработчик должен вернуть адрес view
        String viewPage = command.execute(request);

        response.setHeader("Cache-Control", "no-store");

        //метод отправляет пользователю страницу ответа
        if (viewPage != null) {
            ServletContext servletContext=getServletContext();
            RequestDispatcher dispatcher = servletContext.getRequestDispatcher(viewPage);
            // вызов страницы ответа на запрос
            dispatcher.forward(request, response);
            //можно короче:
            //getServletContext().getRequestDispatcher(viewPage).forward(request,response);
        } else {
            // установка страницы c cообщением об ошибке
            viewPage = Action.ERROR.inPage;
            response.sendRedirect(request.getContextPath() + viewPage);
        }
    }
}