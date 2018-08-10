package cn.ovea.controller.web.servlet;

import cn.ovea.tool.servlet.BaseServlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/PersonCenter")
public class PersonCenterServlet extends BaseServlet {
    public String baseInfoChange(HttpServletRequest req, HttpServletResponse resp){
        String sid = req.getParameter("sid");
        String name = req.getParameter("name");
        String phoneNumber = req.getParameter("phoneNumber");
        String qq = req.getParameter("qq");
        String sex = req.getParameter("sex");

        return "f:/jsp/common/person/center.jsp";
    }
}
