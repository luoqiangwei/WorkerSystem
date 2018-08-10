package cn.ovea.controller.web.servlet;

import cn.ovea.controller.service.RegisterService;
import cn.ovea.model.Teacher_information;
import cn.ovea.tool.commons.exception.NanoflakeException;
import cn.ovea.tool.commons.exception.RSAException;
import cn.ovea.tool.servlet.BaseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//@WebServlet("/RegisterTestServlet")
public class RegisterTestServlet extends BaseServlet {
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
        String staffid = req.getParameter("staffid");
        String password = req.getParameter("password");
        String repassword = req.getParameter("repassword");
        String vcode = req.getParameter("vcode");
        if(vcode == null || email == null || staffid == null || password == null || repassword == null){
            req.setAttribute("form", "所有信息必须都填写");
            return "f:/test/register.jsp";
        }
        /*System.out.println(vCode + "  " + vcode);*/
        if (!vCode.toUpperCase().equals(vcode.toUpperCase())){
            req.setAttribute("email", "验证码错误");
            return "f:/test/register.jsp";
        }
        if(!password.equals(repassword)){
            req.setAttribute("password", "两次密码不一致");
            return  "f:/test/register.jsp";
        }
        if(password.length() < 8){
            req.setAttribute("password", "密码太短");
            return  "f:/test/register.jsp";
        }
        if(password.length() > 20){
            req.setAttribute("password", "密码太长");
            return  "f:/test/register.jsp";
        }
        if(staffid.length() != 4){
            req.setAttribute("staffid", "无效的职工号");
            return  "f:/test/register.jsp";
        }
//        String testEmail = "^([a-z0-9A-Z]+[-|\\\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\\\.)+[a-zA-Z]{2,}$";
//        Pattern p = Pattern.compile(testEmail);
//        Matcher m = p.matcher(email);
//        if(!m.matches()){
//            req.setAttribute("email", "邮箱不合法");
//            return  "f:/test/register.jsp";
//        }
        Teacher_information ti = new Teacher_information();
        ti.setEmail(email);
        ti.setPassword(password);
        ti.setStaff_id(staffid);
        RS.tRegister(ti);

        return "f:/test/succeed.jsp";
    }
}
