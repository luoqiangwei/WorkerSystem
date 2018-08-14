package cn.ovea.controller.web.servlet;

import cn.ovea.controller.service.MemberCenterService;
import cn.ovea.model.Member_information;
import cn.ovea.model.exception.User_informationException;
import cn.ovea.tool.servlet.BaseServlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/MemberCenter")
public class MemberCenterServlet extends BaseServlet {
    MemberCenterService MCS = new MemberCenterService();
    public String baseInfoChange(HttpServletRequest req, HttpServletResponse resp){
        if(req.getAttribute("MCType") != null){
            req.removeAttribute("MCType");
        }
        Member_information userInfo = (Member_information) req.getSession().getAttribute("userInfo");
        String sid = req.getParameter("sid");
        String name = req.getParameter("name");
        String phoneNumber = req.getParameter("phoneNumber");
        String qq = req.getParameter("qq");
        String sex = req.getParameter("sex");

        if(sid.trim().equals("") || sid.length() != 8){
            req.setAttribute("sid", "学号不满足规则（必须为8位）");
            return "f:/Center";
        }
        userInfo.setStudent_id(sid);
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
        MCS.baseSet(userInfo);

        req.setAttribute("msg", "修改成功。");
        req.setAttribute("toUrl", "/Center");
        return "f:/jsp/msg.jsp";
    }

    public String passwdChange(HttpServletRequest req, HttpServletResponse resp){
        Member_information userInfo = (Member_information) req.getSession().getAttribute("userInfo");
        String opwd = req.getParameter("opwd");
        String pwd = req.getParameter("pwd");
        String rpwd = req.getParameter("rpwd");

        if(opwd.trim().equals("") || pwd.trim().equals("") || rpwd.trim().equals("")){
            req.setAttribute("pform", "有未填写的值。");
            req.setAttribute("MCType", "1");
            return "f:/Center";
        }

        try {
            MCS.checkOPwd(userInfo, opwd);
        } catch (User_informationException e) {
            req.setAttribute("MCType", "1");
            req.setAttribute("opwd", e.getMessage());
            return "f:/Center";
        }

        if(pwd.length() < 8){
            req.setAttribute("pwd", "密码长度不足8位。");
            req.setAttribute("MCType", "1");
            return "f:/Center";
        }

        if(pwd.length() > 20){
            req.setAttribute("pwd", "密码过长（超过20位）。");
            req.setAttribute("MCType", "1");
            return "f:/Center";
        }


        if(!pwd.equals(rpwd)){
            req.setAttribute("rpwd", "两次密码不一致。");
            req.setAttribute("MCType", "1");
            return "f:/Center";
        }

        MCS.pwdSet(userInfo, pwd);

        if(req.getAttribute("MCType") != null){
            req.removeAttribute("MCType");
        }
        req.setAttribute("msg", "修改成功。");
        req.setAttribute("toUrl", "/Center");
        return "f:/jsp/msg.jsp";
    }
}
