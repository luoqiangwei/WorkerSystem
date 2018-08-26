package cn.ovea.controller.web.servlet;

import cn.ovea.controller.service.AdminManageService;
import cn.ovea.tool.servlet.BaseServlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AdminManage")
public class AdminManageServlet extends BaseServlet {
    AdminManageService AMS = new AdminManageService();
    public String pre(HttpServletRequest req, HttpServletResponse resp){
        AMS.pre(req);
        return "/jsp/admin/AdminManage.jsp";
    }

    public String delete(HttpServletRequest req, HttpServletResponse resp){
        String id = req.getParameter("id");
        AMS.delete(id);
        return "/AdminManage?method=pre";
    }

    public String perAdd(HttpServletRequest req, HttpServletResponse resp){
        AMS.preAdd(req);
        return "/jsp/admin/AdminManageAdd.jsp";
    }

    public String add(HttpServletRequest req, HttpServletResponse resp){
        String id = req.getParameter("id");
        AMS.add(id);
        return "/AdminManage?method=pre";
    }
}
