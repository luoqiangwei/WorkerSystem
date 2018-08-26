package cn.ovea.controller.web.servlet;

import cn.ovea.controller.service.TeacherManageService;
import cn.ovea.model.Teacher_information;
import cn.ovea.tool.servlet.BaseServlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/TeacherManage")
public class TeacherManageServlet extends BaseServlet {
    TeacherManageService TMS = new TeacherManageService();
    public String findAll(HttpServletRequest req, HttpServletResponse resp){
        TMS.findAll(req);
        return "f:/jsp/admin/TeacherManage.jsp";
    }

    public String insertItem(HttpServletRequest req, HttpServletResponse resp){
        String sid = req.getParameter("sid");
        String email = req.getParameter("email");
        String passwd = req.getParameter("passwd");
        Boolean isEff = Boolean.parseBoolean(req.getParameter("isEff"));
        Teacher_information ti = new Teacher_information();
        ti.setStaff_id(sid);
        ti.setEmail(email);
        ti.setPassword(passwd);
        ti.setIs_effective(isEff);
        TMS.insertItem(ti);
        return "f:/jsp/admin/TeacherManage.jsp";
    }

    public String find(HttpServletRequest req, HttpServletResponse resp){
        String keyWord = req.getParameter("find");
        if(keyWord.trim().equals("")){
            req.setAttribute("msg", "请输入关键词。");
            return "f:/jsp/admin/TeacherManage.jsp";
        }
        TMS.find(req, keyWord);
        return "f:/jsp/admin/TeacherManage.jsp";
    }

    public String updateItem(HttpServletRequest req, HttpServletResponse resp){
//        System.out.println(req.getParameter("sid"));
        String id = req.getParameter("id");
        String sid = req.getParameter("sid");
        String email = req.getParameter("email");
        String passwd = req.getParameter("passwd");
        String isEff = req.getParameter("isEff");
//        System.out.println(id + " " + sid + " " + email + " " + passwd + " " + isEff);
        if (sid.trim().equals("") || email.trim().equals("")){
            req.setAttribute("msg", "必须填写职工号或邮箱。");
            return "f:/TeacherManage?method=findAll";
        }

        if(sid.trim().length() != 4){
            req.setAttribute("msg", "职工号必须为4位。");
            return "f:/TeacherManage?method=findAll";
        }

        if(!passwd.trim().equals("")){
            if(passwd.trim().length() != 0 && passwd.length() < 8){
                req.setAttribute("msg", "密码过短。");
                return "f:/TeacherManage?method=findAll";
            }

            if(passwd.trim().length() != 0 && passwd.length() > 20){
                req.setAttribute("msg", "密码过长。");
                return "f:/TeacherManage?method=findAll";
            }

        }
        Teacher_information ti = new Teacher_information();
        ti.setUser_id(id);
        ti.setStaff_id(sid);
        ti.setEmail(email);
        ti.setPassword(passwd);
        ti.setIs_effective(Boolean.parseBoolean(isEff));

        TMS.updateItem(ti);

        return "f:/TeacherManage?method=findAll";
    }

    public String fullAdd(HttpServletRequest req, HttpServletResponse resp){
        String sid = req.getParameter("sid");
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String phone = req.getParameter("phone");
        String qq = req.getParameter("qq");
        String sex = req.getParameter("sex");
        String isEff = req.getParameter("isEff");

        if (sid.trim().equals("") || email.trim().equals("") || password.trim().equals("")){
            req.setAttribute("msg", "必须填写红色标识的信息。");
            return "f:/TeacherManage?method=findAll";
        }

        if(sid.trim().length() != 4){
            req.setAttribute("msg", "职工号必须为4位。");
            return "f:/TeacherManage?method=findAll";
        }

        if(password.trim().length() != 0 && password.length() < 8){
            req.setAttribute("msg", "密码过短。");
            return "f:/TeacherManage?method=findAll";
        }

        Teacher_information ti = new Teacher_information();
        ti.setStaff_id(sid);
        ti.setName(name);
        ti.setEmail(email);
        ti.setPassword(password);
        ti.setPhone_number(phone);
        ti.setQq(qq);
        ti.setSex(Boolean.parseBoolean(sex));
        ti.setIs_effective(Boolean.parseBoolean(isEff));

        TMS.fullAdd(ti);

        return "f:/TeacherManage?method=findAll";
    }

    public String fullModify(HttpServletRequest req, HttpServletResponse resp){
        String uid = req.getParameter("id");
        String sid = req.getParameter("sid");
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String phone = req.getParameter("phone");
        String qq = req.getParameter("qq");
        String sex = req.getParameter("sex");
        String isEff = req.getParameter("isEff");

        if (sid.trim().equals("") || email.trim().equals("") || password.trim().equals("")){
            req.setAttribute("msg", "必须填写紫色标识的信息。");
            return "f:/TeacherManage?method=findAll";
        }

        if(sid.trim().length() != 4){
            req.setAttribute("msg", "职工号必须为4位。");
            return "f:/TeacherManage?method=findAll";
        }

        if(!password.trim().equals("")){
            if(password.trim().length() != 0 && password.length() < 8){
                req.setAttribute("msg", "密码过短。");
                return "f:/jsp/admin/MemberManage.jsp";
            }

            if(password.trim().length() != 0 && password.length() > 20){
                req.setAttribute("msg", "密码过长。");
                return "f:/jsp/admin/MemberManage.jsp";
            }
        }

        Teacher_information ti = new Teacher_information();
        ti.setUser_id(uid);
        ti.setStaff_id(sid);
        ti.setName(name);
        ti.setEmail(email);
        ti.setPassword(password);
        ti.setPhone_number(phone);
        ti.setQq(qq);
        ti.setSex(Boolean.parseBoolean(sex));
        ti.setIs_effective(Boolean.parseBoolean(isEff));

        TMS.fullModify(ti);

        return "f:/TeacherManage?method=findAll";
    }
}
