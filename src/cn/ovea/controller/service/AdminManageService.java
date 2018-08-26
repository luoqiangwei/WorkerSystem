package cn.ovea.controller.service;

import cn.ovea.controller.dao.Admin_rightsDao;
import cn.ovea.controller.dao.User_informationDao;
import cn.ovea.model.Admin_rights;
import cn.ovea.model.User_information;
import cn.ovea.tool.commons.RSA;
import cn.ovea.tool.commons.exception.RSAException;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class AdminManageService {
    RSA rsa;
    User_informationDao UID = new User_informationDao();
    Admin_rightsDao ARD = new Admin_rightsDao();
    public AdminManageService(){
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

        try {
            rsa = new RSA(props.getProperty("pubkeyPath"), props.getProperty("PrikeyPath"));
        } catch (RSAException e) {
            e.printStackTrace();
        }
    }

    public void pre(HttpServletRequest req) {
        List<Admin_rights> aList = ARD.findAll();
        List<User_information> admList = new ArrayList<>();
        for(Admin_rights item : aList){
            User_information tmp = UID.findByUser(item.getUser_id());
            tmp.setEmail(rsa.deCoding(tmp.getEmail()));
            admList.add(tmp);
        }
        req.setAttribute("admList", admList);
    }

    public void delete(String id) {
        ARD.delete(id);
    }

    public void preAdd(HttpServletRequest req) {
        List<User_information> list = UID.findUnAdmin();
        for(User_information ui : list){
            ui.setEmail(rsa.deCoding(ui.getEmail()));
        }
        req.setAttribute("list", list);
    }

    public void add(String id) {
        Admin_rights ar = new Admin_rights();
        ar.setUser_id(id);
        ar.setIs_effective(true);
        ARD.add(ar);
    }
}
