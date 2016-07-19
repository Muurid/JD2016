package by.it.sinkevich.project.java;

import by.it.sinkevich.project.java.bean.User;
import by.it.sinkevich.project.java.util.Utility;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/do")
public class Controller extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute(Action.message, Utility.getParametersFromRequest(req));

        ActionFactory actionFactory = new ActionFactory();
        ActionCommand command = actionFactory.getCommandFromRequest(req);

        String viewPage = command.execute(req);

        HttpSession session = req.getSession(true);
        if (session.getAttribute("sessionUser") != null) {
            User sessionUser = (User) session.getAttribute("sessionUser");
            Cookie cookie1 = new Cookie("login", sessionUser.getLogin());
            Cookie cookie2 = new Cookie("password", sessionUser.getPassword());
            cookie1.setMaxAge(30);
            cookie2.setMaxAge(30);
            resp.addCookie(cookie1);
            resp.addCookie(cookie2);
        }

        resp.setHeader("Cache-Control", "no-store");

        if (viewPage != null) {
            ServletContext servletContext = getServletContext();
            RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher(viewPage);
            requestDispatcher.forward(req, resp);
        } else {
            viewPage = Action.ERROR.viewPage;
            resp.sendRedirect(req.getContextPath() + viewPage);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
