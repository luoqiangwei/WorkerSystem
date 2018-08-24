package cn.ovea.controller.web.servlet;

import cn.ovea.controller.service.BulletinService;
import cn.ovea.model.Bulletin_information;
import cn.ovea.model.Teacher_information;
import cn.ovea.tool.servlet.BaseServlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Bulletin")
public class BulletinServlet extends BaseServlet {
    BulletinService BS = new BulletinService();
    public String add(HttpServletRequest req, HttpServletResponse resp){
        String title = req.getParameter("title");
        String content = req.getParameter("content");
        Teacher_information ti = (Teacher_information) req.getSession().getAttribute("userInfo");

        if(title.trim().equals("") || content.trim().equals("")){
            req.setAttribute("msg", "所有信息必须填写。");
            if(!title.trim().equals("")){
                req.setAttribute("title", title);
            }
            if(!content.trim().equals("")){
                req.setAttribute("content", content);
            }
            return "f:/jsp/teacher/bulletin/bulletin.jsp";
        }

        Bulletin_information bi = new Bulletin_information();
        bi.setContent(content);
        bi.setTitle(title);
        bi.setUser_id(ti.getUser_id());
        BS.add(bi);
        req.setAttribute("msg", "公告发布成功。");
        req.setAttribute("toUrl", "/index.jsp");
        return "f:/jsp/msg.jsp";
    }
}
