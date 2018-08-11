package cn.ovea.controller.web.servlet;

import cn.ovea.controller.service.TeacherCenterService;
import cn.ovea.model.Teacher_information;
import cn.ovea.tool.servlet.BaseServlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/TeacherCenter")
public class TeacherCenterServlet extends BaseServlet {
    TeacherCenterService TCS = new TeacherCenterService();

    public String baseInfoChange(HttpServletRequest req, HttpServletResponse resp){
        Teacher_information userInfo = (Teacher_information) req.getSession().getAttribute("userInfo");
        String sid = req.getParameter("sid");
        String name = req.getParameter("name");
        String phoneNumber = req.getParameter("phoneNumber");
        String qq = req.getParameter("qq");
        String sex = req.getParameter("sex");

        if(sid.equals("") || sid.length() != 4){
            req.setAttribute("form", "职工号不满足规则（必须为4位）");
            return "f:/Center";
        }
        userInfo.setStaff_id(sid);

        if(!name.equals("")){
            userInfo.setName(name);
        }

        if(!phoneNumber.equals("")){
            userInfo.setPhone_number(phoneNumber);
        }

        if(!qq.equals("")){
            userInfo.setQq(qq);
        }

        if(!sex.equals("true")){
            userInfo.setSex(true);
        }else {
            userInfo.setSex(false);
        }
        TCS.baseSet(userInfo);

        return "f:/Center";
    }
}
