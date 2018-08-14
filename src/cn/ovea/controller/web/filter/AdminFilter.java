package cn.ovea.controller.web.filter;

import cn.ovea.model.Teacher_information;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(urlPatterns = {"/jsp/admin/*", "/TeacherManage"})
public class AdminFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        if(request.getSession().getAttribute("isAdmin") != null){
            filterChain.doFilter(servletRequest, servletResponse);
        }else{
            response.sendError(404, "No authority");
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }
}
