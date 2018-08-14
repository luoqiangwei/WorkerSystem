package cn.ovea.controller.web.servlet;

import cn.ovea.controller.service.TeacherManageService;
import cn.ovea.tool.servlet.BaseServlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/TeacherManage")
public class TeacherManageServlet extends BaseServlet {
    TeacherManageService TMS = new TeacherManageService();
    public String findAll(HttpServletRequest req, HttpServletResponse resp){
        TMS.findAll(req);
        return "f:/jsp/admin/TeacherManage.jsp";
    }
}
