package cn.ovea.controller.web.servlet;

import cn.ovea.controller.service.TeacherManageService;
import cn.ovea.model.Teacher_information;
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

    public String updateItem(HttpServletRequest req, HttpServletResponse resp){
//        System.out.println(req.getParameter("sid"));
        String id = req.getParameter("id");
        String sid = req.getParameter("sid");
        String email = req.getParameter("email");
        String passwd = req.getParameter("passwd");
        String isEff = req.getParameter("isEff");
//        System.out.println(id + " " + sid + " " + email + " " + passwd + " " + isEff);
        if (sid.trim().equals("") || email.trim().equals("")){
            req.setAttribute("msg", "必须填写职工号或邮箱。");
            return "f:/TeacherManage?method=findAll";
        }

        if(sid.trim().length() != 4){
            req.setAttribute("msg", "职工号必须为4位。");
            return "f:/TeacherManage?method=findAll";
        }

        if(passwd.trim().length() != 0 && passwd.length() < 8){
            req.setAttribute("msg", "密码过短。");
            return "f:/TeacherManage?method=findAll";
        }

        Teacher_information ti = new Teacher_information();
        ti.setUser_id(id);
        ti.setStaff_id(sid);
        ti.setEmail(email);
        ti.setPassword(passwd);
        ti.setIs_effective(Boolean.parseBoolean(isEff));

        TMS.updateItem(ti);

        return "f:/TeacherManage?method=findAll";
    }
}
