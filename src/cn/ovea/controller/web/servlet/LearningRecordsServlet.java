package cn.ovea.controller.web.servlet;

import cn.ovea.controller.service.LearningRecordsService;
import cn.ovea.model.Member_information;
import cn.ovea.model.Member_learning_records;
import cn.ovea.model.Teacher_information;
import cn.ovea.tool.servlet.BaseServlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LearningRecords")
public class LearningRecordsServlet extends BaseServlet {
    LearningRecordsService LRS = new LearningRecordsService();

    public String addRecord(HttpServletRequest req, HttpServletResponse resp){
        String title = req.getParameter("title");
        String remake = req.getParameter("remake");
        String content = req.getParameter("content");
        if(title.trim().equals("") || content.trim().equals("")){
            req.setAttribute("form", "未填写标题或内容。");
            return "f:/jsp/common/record/learningRecords.jsp";
        }
        if(req.getSession().getAttribute("userInfo") instanceof Teacher_information){
            Teacher_information ti = (Teacher_information) req.getSession().getAttribute("userInfo");
            Member_learning_records mlr = new Member_learning_records();
            mlr.setUser_id(ti.getUser_id());
            mlr.setTitle(title);
            mlr.setRemarks(remake);
            mlr.setContent(content);
            LRS.insertRecord(mlr);
        }else {
            Member_information mi = (Member_information) req.getSession().getAttribute("userInfo");
            Member_learning_records mlr = new Member_learning_records();
            mlr.setUser_id(mi.getUser_id());
            mlr.setTitle(title);
            mlr.setRemarks(remake);
            mlr.setContent(content);
            LRS.insertRecord(mlr);
        }

        req.setAttribute("msg", "学习记录添加成功");
        return "f:/jsp/msg.jsp";
    }
}
