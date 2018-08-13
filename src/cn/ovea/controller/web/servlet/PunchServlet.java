package cn.ovea.controller.web.servlet;

import cn.ovea.tool.servlet.BaseServlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Punch")
public class PunchServlet extends BaseServlet {
    public String punch(HttpServletRequest req, HttpServletResponse resp){
        String location = req.getParameter("location");
        System.out.println(location);
        return "/jsp/common/punch/punch.jsp";
    }
}
