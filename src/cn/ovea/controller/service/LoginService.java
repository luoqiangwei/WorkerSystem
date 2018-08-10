package cn.ovea.controller.service;

import cn.ovea.controller.dao.Member_informationDao;
import cn.ovea.controller.dao.Teacher_informationDao;
import cn.ovea.controller.dao.User_informationDao;
import cn.ovea.model.Member_information;
import cn.ovea.model.Teacher_information;
import cn.ovea.model.User_information;
import cn.ovea.model.exception.User_informationException;
import cn.ovea.tool.commons.RSA;
import cn.ovea.tool.commons.SHA;
import cn.ovea.tool.commons.exception.RSAException;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class LoginService {
    RSA rsa;
    Member_informationDao MID = new Member_informationDao();
    Teacher_informationDao TID = new Teacher_informationDao();
    User_informationDao UID = new User_informationDao();
    SHA sha;

    public LoginService(){
        // 加载配置文件
        Properties props = new Properties();
        try {
            props.load(getClass().getClassLoader().getResourceAsStream("config.properties"));
        } catch (IOException e) {
            throw new RuntimeException("配置文件读取失败");
        }

        try {
            props.load(new BufferedInputStream(new FileInputStream(new File(props.getProperty("configPath")))));
        } catch (IOException e) {
            throw new RuntimeException("配置文件读取失败");
        }

        sha = new SHA();
        try {
            rsa = new RSA(props.getProperty("pubkeyPath"), props.getProperty("PrikeyPath"));
        } catch (RSAException e) {
            e.printStackTrace();
        }
    }

    public void login(HttpServletRequest req, User_information userInformation) throws User_informationException {
        userInformation.setEmail(rsa.enCoding(userInformation.getEmail()));
        userInformation.setPassword(sha.SHA512Encoding(userInformation.getPassword()));
        userInformation = UID.check(userInformation.getEmail(), userInformation.getPassword());
        if(userInformation == null){
            throw new User_informationException("密码错误");
        }
        String userId = userInformation.getUser_id();
        Member_information mi = MID.findByUser(userId);
        Teacher_information ti = TID.findByUser(userId);
        if(mi != null){
            mi.setStudent_id(rsa.deCoding(mi.getStudent_id()));
            if(mi.getName() != null && !"".equals(mi.getName()))
                mi.setName(rsa.deCoding(mi.getName()));
            mi.setEmail(rsa.deCoding(mi.getEmail()));
            if(mi.getPhone_number() != null && !"".equals(mi.getPhone_number()))
                mi.setPhone_number(rsa.deCoding(mi.getPhone_number()));
            if(mi.getQq() != null && !"".equals(mi.getQq()))
                mi.setQq(rsa.deCoding(mi.getQq()));
            mi.setGrade(rsa.deCoding(mi.getGrade()));
            if(mi.getHead_image_uri() != null && !"".equals(mi.getHead_image_uri()))
                mi.setHead_image_uri(rsa.deCoding(mi.getHead_image_uri()));
            req.getSession().setAttribute("userInfo", mi);
        }
        if(ti != null){
            ti.setStaff_id(rsa.deCoding(ti.getStaff_id()));
            if(ti.getName() != null && !"".equals(ti.getName()))
                ti.setName(rsa.deCoding(ti.getName()));
            ti.setEmail(rsa.deCoding(ti.getEmail()));
            if(ti.getPhone_number() != null && !"".equals(ti.getPhone_number()))
                ti.setPhone_number(rsa.deCoding(ti.getPhone_number()));
            if(ti.getQq() != null && !"".equals(ti.getQq()))
                ti.setQq(rsa.deCoding(ti.getQq()));
            if(ti.getHead_image_uri() != null && !"".equals(ti.getHead_image_uri()))
                ti.setHead_image_uri(rsa.deCoding(ti.getHead_image_uri()));
            req.getSession().setAttribute("userInfo", ti);
        }
        if(req.getSession().getAttribute("count") != null){
            req.getSession().removeAttribute("count");
        }
        if(req.getSession().getAttribute("loginError") != null){
            req.getSession().removeAttribute("loginError");
        }
    }
}
