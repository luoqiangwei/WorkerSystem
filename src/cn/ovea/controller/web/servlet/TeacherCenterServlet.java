package cn.ovea.controller.web.servlet;

import cn.ovea.controller.service.TeacherCenterService;
import cn.ovea.model.Teacher_information;
import cn.ovea.model.exception.User_informationException;
import cn.ovea.tool.servlet.BaseServlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/TeacherCenter")
public class TeacherCenterServlet extends BaseServlet {
    TeacherCenterService TCS = new TeacherCenterService();

    public String baseInfoChange(HttpServletRequest req, HttpServletResponse resp){
        if(req.getAttribute("TCType") != null){
            req.removeAttribute("TCType");
        }
        Teacher_information userInfo = (Teacher_information) req.getSession().getAttribute("userInfo");
        String sid = req.getParameter("sid");
        String name = req.getParameter("name");
        String phoneNumber = req.getParameter("phoneNumber");
        String qq = req.getParameter("qq");
        String sex = req.getParameter("sex");

        if(sid.trim().equals("") || sid.length() != 4){
            req.setAttribute("sid", "职工号不满足规则（必须为4位）");
            return "f:/Center";
        }
        userInfo.setStaff_id(sid);

        if(!name.trim().equals("")){
            userInfo.setName(name);
        }

        if(!phoneNumber.trim().equals("")){
            userInfo.setPhone_number(phoneNumber);
        }

        if(!qq.trim().equals("")){
            userInfo.setQq(qq);
        }

        if(sex.equals("true")){
            userInfo.setSex(true);
        }else {
            userInfo.setSex(false);
        }
        TCS.baseSet(userInfo);

        req.setAttribute("msg", "修改成功。");
        req.setAttribute("toUrl", "/Center");
        return "f:/jsp/msg.jsp";
    }

    public String passwdChange(HttpServletRequest req, HttpServletResponse resp){
        Teacher_information userInfo = (Teacher_information) req.getSession().getAttribute("userInfo");
        String opwd = req.getParameter("opwd");
        String pwd = req.getParameter("pwd");
        String rpwd = req.getParameter("rpwd");

        if(opwd.trim().equals("") || pwd.trim().equals("") || rpwd.trim().equals("")){
            req.setAttribute("pform", "有未填写的值。");
            req.setAttribute("TCType", "1");
            return "f:/Center";
        }

        try {
            TCS.checkOPwd(userInfo, opwd);
        } catch (User_informationException e) {
            req.setAttribute("TCType", "1");
            req.setAttribute("opwd", e.getMessage());
            return "f:/Center";
        }

        if(pwd.length() < 8){
            req.setAttribute("pwd", "密码长度不足8位。");
            req.setAttribute("TCType", "1");
            return "f:/Center";
        }

        if(pwd.length() > 20){
            req.setAttribute("pwd", "密码过长（超过20位）。");
            req.setAttribute("TCType", "1");
            return "f:/Center";
        }


        if(!pwd.equals(rpwd)){
            req.setAttribute("rpwd", "两次密码不一致。");
            req.setAttribute("TCType", "1");
            return "f:/Center";
        }

        TCS.pwdSet(userInfo, pwd);

        if(req.getAttribute("TCType") != null){
            req.removeAttribute("TCType");
        }

        req.setAttribute("msg", "修改成功。");
        req.setAttribute("toUrl", "/Center");
        return "f:/jsp/msg.jsp";
    }
}
