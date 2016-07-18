package by.it.sinkevich.project.java.filter;

import by.it.sinkevich.project.java.dao.DAO;
import by.it.sinkevich.project.java.dao.RaceDAO;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import java.io.IOException;

@WebFilter(urlPatterns = {"/*"}, initParams = {
        @WebInitParam(name = "encoding", value = "UTF-8", description = "Required encoding")})
public class EncodingFilter implements Filter {

    private String requiredEncoding;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        requiredEncoding = filterConfig.getInitParameter("encoding");
        ServletContext context = filterConfig.getServletContext();
        RaceDAO raceDAO = DAO.getDao().getRaceDAO();
        context.setAttribute("races", raceDAO.readAll(""));
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String requestEncoding = servletRequest.getCharacterEncoding();
        if (requiredEncoding != null && !requiredEncoding.equals(requestEncoding)) {
            servletRequest.setCharacterEncoding(requiredEncoding);
        }

        String responseEncoding = servletResponse.getCharacterEncoding();
        if (requiredEncoding != null && !requiredEncoding.equals(responseEncoding)) {
            servletResponse.setCharacterEncoding(requiredEncoding);
        }

        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        requiredEncoding = null;
    }
}
