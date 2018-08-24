package cn.ovea.controller.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("/jsp/teacher/*")
public class TeacherFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        if(request.getSession().getAttribute("isTea") != null){
            filterChain.doFilter(servletRequest, servletResponse);
        }else{
            response.sendError(404, "No authority");
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }
}
