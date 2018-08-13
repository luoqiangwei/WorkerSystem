package cn.ovea.controller.web.servlet;

import cn.ovea.controller.service.LoginService;
import cn.ovea.model.Member_information;
import cn.ovea.model.User_information;
import cn.ovea.model.exception.User_informationException;
import cn.ovea.tool.servlet.BaseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Login")
public class LoginServlet extends BaseServlet {
    LoginService LS = new LoginService();
    public String login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getSession().getAttribute("userInfo") != null){
            req.setAttribute("form", "用户已登录");
            return "/jsp/login.jsp";
        }

        int count;
        if(req.getSession().getAttribute("count") != null){
            count = (int) req.getSession().getAttribute("count");
        }else {
            count = 0;
        }

        String email = req.getParameter("email");
        String password = req.getParameter("password");

        if(req.getSession().getAttribute("loginError") != null) {
            String vCode = (String) req.getSession().getAttribute("vCode");
            String vcode = req.getParameter("vcode");
            if(vcode.trim().equals("")){
                req.setAttribute("form", "所有信息必须都填写");
                reSet(req, email, password);
                count++;
                req.getSession().setAttribute("count", count);
                if(count >= 3){
                    req.getSession().setAttribute("loginError", "effective");
                }
                return "f:/jsp/login.jsp";
            }

            if (!vcode.toUpperCase().equals(vCode.toUpperCase())){
                req.setAttribute("email", "验证码错误");
                reSet(req, email, password);
                count++;
                req.getSession().setAttribute("count", count);
                if(count >= 3){
                    req.getSession().setAttribute("loginError", "effective");
                }
                return "f:/jsp/login.jsp";
            }
        }

        if(email.trim().equals("") || password.trim().equals("")){
            req.setAttribute("form", "所有信息必须都填写");
            reSet(req, email, password);
            count++;
            req.getSession().setAttribute("count", count);
            if(count >= 3){
                req.getSession().setAttribute("loginError", "effective");
            }
            return "f:/jsp/login.jsp";
        }

        if(password.length() < 8){
            req.setAttribute("password", "密码太短");
            reSet(req, email, password);
            count++;
            req.getSession().setAttribute("count", count);
            if(count >= 3){
                req.getSession().setAttribute("loginError", "effective");
            }
            return  "f:/jsp/login.jsp";
        }

        if(password.length() > 20){
            req.setAttribute("password", "密码太长");
            reSet(req, email, password);
            count++;
            req.getSession().setAttribute("count", count);
            if(count >= 3){
                req.getSession().setAttribute("loginError", "effective");
            }
            return  "f:/jsp/login.jsp";
        }

        User_information ui = new User_information();
        ui.setEmail(email);
        ui.setPassword(password);
        try {
            LS.login(req, ui);
        } catch (User_informationException e) {
            req.setAttribute("form", e.getMessage());
            return "f:/jsp/login.jsp";
        }

        return "/index.jsp";
    }

    private void reSet(HttpServletRequest req, String email, String password){
        if(!email.trim().equals(""))
            req.setAttribute("lemail", email);
        if(!password.trim().equals(""))
            req.setAttribute("lpassword", password);
    }

    public String cancellation(HttpServletRequest req, HttpServletResponse resp){
        if(req.getSession().getAttribute("userInfo") != null){
            req.getSession().removeAttribute("userInfo");
        }
        return "/index.jsp";
    }
}
