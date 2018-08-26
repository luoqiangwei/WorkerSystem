package cn.ovea.controller.web.servlet;

import cn.ovea.controller.service.BulletinManageService;
import cn.ovea.tool.servlet.BaseServlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BulletinManage")
public class BulletinManageServlet extends BaseServlet {
    BulletinManageService BMS = new BulletinManageService();
    public String pre(HttpServletRequest req, HttpServletResponse resp) {
        BMS.pre(req);
        return "/jsp/admin/BulletinManage.jsp";
    }

    public String delete(HttpServletRequest req, HttpServletResponse resp) {
        BMS.delete(req.getParameter("id"));
        return "/BulletinManage?method=pre";
    }
}
