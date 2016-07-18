package by.it.sinkevich.project.java.filter;

import by.it.sinkevich.project.java.dao.DAO;
import by.it.sinkevich.project.java.dao.RaceDAO;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(urlPatterns = {"/*"})
public class IndexFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        ServletContext context = filterConfig.getServletContext();
        RaceDAO raceDAO = DAO.getDao().getRaceDAO();
        context.setAttribute("races", raceDAO.readAll(""));
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
