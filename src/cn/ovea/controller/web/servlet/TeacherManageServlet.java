package cn.ovea.controller.web.servlet;

import cn.ovea.tool.servlet.BaseServlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/TeacherManage")
public class TeacherManageServlet extends BaseServlet {
    public String findAll(HttpServletRequest req, HttpServletResponse resp){

        return "f:/TeacherManage";
    }
}
