package cn.ovea.controller.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter("/jsp/common/punch/*")
public class PunchFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        if(req.getSession().getAttribute("userInfo") != null) {
            filterChain.doFilter(servletRequest, servletResponse);
        }else
            servletRequest.getRequestDispatcher("/jsp/login.jsp").forward(servletRequest, servletResponse);
    }
}
