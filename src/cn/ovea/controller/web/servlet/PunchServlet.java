package cn.ovea.controller.web.servlet;

import cn.ovea.controller.service.PunchService;
import cn.ovea.model.Member_information;
import cn.ovea.model.Punch_the_clock;
import cn.ovea.model.Teacher_information;
import cn.ovea.tool.servlet.BaseServlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Punch")
public class PunchServlet extends BaseServlet {
    PunchService PS = new PunchService();
    public String punch(HttpServletRequest req, HttpServletResponse resp){
        String location = req.getParameter("location");
        String remake = req.getParameter("remake");
        String ip = req.getRemoteAddr();
        if(req.getSession().getAttribute("userInfo") instanceof Teacher_information){
            Teacher_information ti = (Teacher_information) req.getSession().getAttribute("userInfo");
            Punch_the_clock ptc = new Punch_the_clock();
            ptc.setPunch_ip(ip);
            ptc.setPunch_location(location);
            ptc.setRemarks(remake);
            ptc.setUser_id(ti.getUser_id());
            PS.insertPunch(ptc);
        }else{
            Member_information mi = (Member_information) req.getSession().getAttribute("userInfo");
            Punch_the_clock ptc = new Punch_the_clock();
            ptc.setPunch_ip(ip);
            ptc.setPunch_location(location);
            ptc.setRemarks(remake);
            ptc.setUser_id(mi.getUser_id());
            PS.insertPunch(ptc);
        }
        req.setAttribute("msg", "打卡成功");
        return "/jsp/msg.jsp";
    }
}
