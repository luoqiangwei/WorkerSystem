package cn.ovea.controller.web.servlet;

import cn.ovea.controller.service.PunchManageService;
import cn.ovea.tool.servlet.BaseServlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/PunchManage")
public class PunchManageServlet extends BaseServlet {
    PunchManageService PMS = new PunchManageService();
    public String pre(HttpServletRequest req, HttpServletResponse resp) {
        PMS.pre(req);
        return "/jsp/admin/PunchManage.jsp";
    }

    public String delete(HttpServletRequest req, HttpServletResponse resp) {
        PMS.delete(req.getParameter("id"));
        return "/PunchManage?method=pre";
    }
}
