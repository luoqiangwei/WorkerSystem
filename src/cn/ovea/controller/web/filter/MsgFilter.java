package cn.ovea.controller.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter("/jsp/msg.jsp")
public class MsgFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        if(servletRequest.getAttribute("msg") != null)
            filterChain.doFilter(servletRequest, servletResponse);
        else
            servletRequest.getRequestDispatcher("/index.jsp").forward(servletRequest, servletResponse);
    }
}
