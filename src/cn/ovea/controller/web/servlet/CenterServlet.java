package cn.ovea.controller.web.servlet;

import cn.ovea.model.Teacher_information;
import cn.ovea.tool.servlet.BaseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Center")
public class CenterServlet extends BaseServlet {
    @Override
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getSession().getAttribute("userInfo") instanceof Teacher_information){
            request.getRequestDispatcher("/jsp/common/person/Tcenter.jsp").forward(request, response);
        }else{
            request.getRequestDispatcher("/jsp/common/person/Mcenter.jsp").forward(request, response);
        }
    }
}
