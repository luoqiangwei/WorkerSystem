package cn.ovea.controller.service;

import cn.ovea.controller.dao.Teacher_informationDao;
import cn.ovea.model.Teacher_information;
import cn.ovea.model.exception.User_informationException;
import cn.ovea.tool.commons.RSA;
import cn.ovea.tool.commons.SHA;
import cn.ovea.tool.commons.exception.RSAException;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TeacherCenterService {
    Teacher_informationDao TID = new Teacher_informationDao();
    RSA rsa;
    SHA sha;

    public TeacherCenterService(){
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
        sha = new SHA();
    }

    public void baseSet(Teacher_information tm){
        Teacher_information ti = new Teacher_information();
        ti.setUser_id(tm.getUser_id());
        if(tm.getName() != null && !tm.getName().trim().equals("")){
            ti.setName(rsa.enCoding(tm.getName()));
        }
        if(tm.getPhone_number() != null && !tm.getPhone_number().trim().equals("")){
            ti.setPhone_number(rsa.enCoding(tm.getPhone_number()));
        }
        if(tm.getQq() != null && !tm.getQq().trim().equals("")){
            ti.setQq(rsa.enCoding(tm.getQq()));
        }
        ti.setSex(tm.isSex());
        ti.setStaff_id(rsa.enCoding(tm.getStaff_id()));
        TID.updateInfo(ti);
    }

    public void checkOPwd(Teacher_information tm, String opwd) throws User_informationException {
        if(!tm.getPassword().equals(sha.SHA512Encoding(opwd))){
            throw new User_informationException("旧密码输入错误。");
        }
    }

    public void pwdSet(Teacher_information tm, String npwd){
        Teacher_information ti = new Teacher_information();
        ti.setUser_id(tm.getUser_id());
        ti.setPassword(sha.SHA512Encoding(npwd));
        TID.updatePasswd(ti);
    }
}
