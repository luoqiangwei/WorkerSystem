package cn.ovea.controller.web.servlet;

import cn.ovea.controller.service.MemberManageService;
import cn.ovea.model.Member_information;
import cn.ovea.tool.servlet.BaseServlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/MemberManage")
public class MemberManageServlet extends BaseServlet {
    MemberManageService MMS = new MemberManageService();

    public String findAll(HttpServletRequest req, HttpServletResponse resp){
        MMS.findAll(req);
        return "f:/jsp/admin/MemberManage.jsp";
    }

    public String find(HttpServletRequest req, HttpServletResponse resp){
        String keyWord = req.getParameter("find");
        if(keyWord.trim().equals("")){
            req.setAttribute("msg", "请输入关键词。");
            return "f:/jsp/admin/MemberManage.jsp";
        }
        MMS.find(req, keyWord);
        return "f:/jsp/admin/MemberManage.jsp";
    }

    public String insertItem(HttpServletRequest req, HttpServletResponse resp){
        String sid = req.getParameter("sid");
        String email = req.getParameter("email");
        String passwd = req.getParameter("passwd");
        Boolean isEff = Boolean.parseBoolean(req.getParameter("isEff"));
        if(sid.trim().equals("") || email.trim().equals("") || passwd.trim().equals("")){
            req.setAttribute("msg", "有信息未填写。");
            return "f:/jsp/admin/MemberManage.jsp";
        }
        if(sid.trim().length() != 8){
            req.setAttribute("msg", "学号必须为8位。");
            return "f:/jsp/admin/MemberManage.jsp";
        }
        if(passwd.trim().length() != 0 && passwd.length() < 8){
            req.setAttribute("msg", "密码过短。");
            return "f:/MemberManage?method=findAll";
        }

        if(passwd.trim().length() != 0 && passwd.length() > 20){
            req.setAttribute("msg", "密码过长。");
            return "f:/MemberManage?method=findAll";
        }
        Member_information mi = new Member_information();
        mi.setStudent_id(sid);
        mi.setEmail(email);
        mi.setPassword(passwd);
        mi.setIs_effective(isEff);
        MMS.insertItem(mi);
        return "f:/jsp/admin/MemberManage.jsp";
    }

    public String updateItem(HttpServletRequest req, HttpServletResponse resp){
        String id = req.getParameter("id");
        String sid = req.getParameter("sid");
        String email = req.getParameter("email");
        String passwd = req.getParameter("passwd");
        String isEff = req.getParameter("isEff");
        if (sid.trim().equals("") || email.trim().equals("")){
            req.setAttribute("msg", "必须填写学号或邮箱。");
            return "f:/MemberManage?method=findAll";
        }

        if(sid.trim().length() != 8){
            req.setAttribute("msg", "学号必须为8位。");
            return "f:/MemberManage?method=findAll";
        }

        if(!passwd.trim().equals("")){
            if(passwd.trim().length() != 0 && passwd.length() < 8){
                req.setAttribute("msg", "密码过短。");
                return "f:/MemberManage?method=findAll";
            }

            if(passwd.trim().length() != 0 && passwd.length() > 20){
                req.setAttribute("msg", "密码过长。");
                return "f:/MemberManage?method=findAll";
            }
        }

        Member_information mi = new Member_information();
        mi.setStudent_id(sid);
        mi.setUser_id(id);
        mi.setEmail(email);
        mi.setPassword(passwd);
        mi.setIs_effective(Boolean.parseBoolean(isEff));
        MMS.updateItem(mi);
        return "f:/MemberManage?method=findAll";
    }

    public String fullAdd(HttpServletRequest req, HttpServletResponse resp){
        String grade = req.getParameter("grade");
        String sid = req.getParameter("sid");
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String phone = req.getParameter("phone");
        String qq = req.getParameter("qq");
        String sex = req.getParameter("sex");
        String isEff = req.getParameter("isEff");
        if (sid.trim().equals("") || email.trim().equals("") || grade.trim().equals("")){
            req.setAttribute("msg", "必须填写红色提示的信息。");
            return "f:/jsp/admin/MemberManage.jsp";
        }

        if(sid.trim().length() != 8){
            req.setAttribute("msg", "学号必须为8位。");
            return "f:/jsp/admin/MemberManage.jsp";
        }
        if(password.trim().length() != 0 && password.length() < 8){
            req.setAttribute("msg", "密码过短。");
            return "f:/jsp/admin/MemberManage.jsp";
        }

        if(password.trim().length() != 0 && password.length() > 20){
            req.setAttribute("msg", "密码过长。");
            return "f:/jsp/admin/MemberManage.jsp";
        }

        Member_information mi = new Member_information();
        mi.setGrade(grade);
        mi.setStudent_id(sid);
        mi.setName(name);
        mi.setEmail(email);
        mi.setPassword(password);
        mi.setPhone_number(phone);
        mi.setQq(qq);
        mi.setSex(Boolean.parseBoolean(sex));
        mi.setIs_effective(Boolean.parseBoolean(isEff));
        MMS.fullAdd(mi);
        return "f:/MemberManage?method=findAll";
    }

    public String fullModify(HttpServletRequest req, HttpServletResponse resp){
        String uid = req.getParameter("id");
        String grade = req.getParameter("grade");
        String sid = req.getParameter("sid");
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String phone = req.getParameter("phone");
        String qq = req.getParameter("qq");
        String sex = req.getParameter("sex");
        String isEff = req.getParameter("isEff");
        if (sid.trim().equals("") || email.trim().equals("") || grade.trim().equals("")){
            req.setAttribute("msg", "必须填写紫色提示的信息。");
            return "f:/jsp/admin/MemberManage.jsp";
        }

        if(sid.trim().length() != 8){
            req.setAttribute("msg", "学号必须为8位。");
            return "f:/jsp/admin/MemberManage.jsp";
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

        Member_information mi = new Member_information();
        mi.setUser_id(uid);
        mi.setGrade(grade);
        mi.setStudent_id(sid);
        mi.setName(name);
        mi.setEmail(email);
        mi.setPassword(password);
        mi.setPhone_number(phone);
        mi.setQq(qq);
        mi.setSex(Boolean.parseBoolean(sex));
        mi.setIs_effective(Boolean.parseBoolean(isEff));

        MMS.fullModify(mi);

        return "";
    }
}
