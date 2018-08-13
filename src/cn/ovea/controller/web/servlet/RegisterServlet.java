package cn.ovea.controller.web.servlet;

import cn.ovea.controller.service.RegisterService;
import cn.ovea.model.Member_information;
import cn.ovea.model.exception.User_informationException;
import cn.ovea.tool.commons.exception.NanoflakeException;
import cn.ovea.tool.commons.exception.RSAException;
import cn.ovea.tool.servlet.BaseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Register")
public class RegisterServlet extends BaseServlet {

    RegisterService RS;

    {
        try {
            RS = new RegisterService();
        } catch (NanoflakeException e) {
            e.printStackTrace();
        } catch (RSAException e) {
            e.printStackTrace();
        }
    }

    public String register(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String vCode = (String) req.getSession().getAttribute("vCode");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String sid = req.getParameter("sid");
        String repassword = req.getParameter("repassword");
        String vcode = req.getParameter("vcode");

        //System.err.println(vCode);
        //System.err.println(vcode);
        if(vcode.trim().equals("") || email.trim().equals("") || sid.trim().equals("") || password.trim().equals("") || repassword.trim().equals("")){
            req.setAttribute("form", "所有信息必须都填写");
            reSet(req, email, sid, password);
            return "f:/jsp/register.jsp";
        }
        if (!vcode.toUpperCase().equals(vCode.toUpperCase())){
            req.setAttribute("email", "验证码错误");
            reSet(req, email, sid, password);
            return "f:/jsp/register.jsp";
        }
        if(!password.equals(repassword)){
            req.setAttribute("password", "两次密码不一致");
            reSet(req, email, sid, password);
            return  "f:/jsp/register.jsp";
        }
        if(password.length() < 8){
            req.setAttribute("password", "密码太短");
            reSet(req, email, sid, password);
            return  "f:/jsp/register.jsp";
        }
        if(password.length() > 20){
            req.setAttribute("password", "密码太长");
            reSet(req, email, sid, password);
            return  "f:/jsp/register.jsp";
        }
        if(sid.length() != 8){
            req.setAttribute("sid", "无效的学号");
            reSet(req, email, sid, password);
            return  "f:/jsp/register.jsp";
        }

        Member_information ti = new Member_information();
        ti.setEmail(email);
        ti.setPassword(password);
        ti.setStudent_id(sid);
        try {
            RS.sRegister(ti);
        } catch (User_informationException e) {
            req.setAttribute("msg", e.getMessage());
            return "f:/jsp/msg.jsp";
        }

        req.setAttribute("msg", "邮件已发送，请前往邮箱激活您的账号。<br>激活码1小时后失效。");
        return "f:/jsp/msg.jsp";
    }

    public String active(HttpServletRequest req, HttpServletResponse resp){
        String code = req.getParameter("code");
        try {
            RS.active(code);
            req.setAttribute("msg", "您的账号激活成功了。");
        } catch (User_informationException e) {
            req.setAttribute("msg", e.getMessage());
        }
        return "f:/jsp/msg.jsp";
    }

    private void reSet(HttpServletRequest req, String email, String sid, String password){
        if(!email.trim().equals(""))
            req.setAttribute("remail", email);
        if(!sid.trim().equals(""))
            req.setAttribute("rsid", sid);
        if(!password.trim().equals(""))
            req.setAttribute("rpassword", password);
    }
}
