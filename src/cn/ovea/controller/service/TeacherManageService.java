package cn.ovea.controller.service;

import cn.ovea.controller.dao.Teacher_informationDao;
import cn.ovea.controller.dao.User_informationDao;
import cn.ovea.model.Teacher_information;
import cn.ovea.tool.commons.Nanoflake;
import cn.ovea.tool.commons.RSA;
import cn.ovea.tool.commons.SHA;
import cn.ovea.tool.commons.exception.NanoflakeException;
import cn.ovea.tool.commons.exception.RSAException;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

public class TeacherManageService {
    Nanoflake nf;
    RSA rsa;
    SHA sha;
    Teacher_informationDao TID = new Teacher_informationDao();
    User_informationDao UID = new User_informationDao();

    public TeacherManageService(){
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
            nf = new Nanoflake(1L);
        } catch (NanoflakeException e) {
            e.printStackTrace();
        }
        try {
            rsa = new RSA(props.getProperty("pubkeyPath"), props.getProperty("PrikeyPath"));
        } catch (RSAException e) {
            e.printStackTrace();
        }
        sha = new SHA();
    }

    public void findAll(HttpServletRequest req){
        List<Teacher_information> teaList = TID.findAll();
        for(Teacher_information tmp : teaList){
            tmp.setStaff_id(rsa.deCoding(tmp.getStaff_id()));
            if(!tmp.getName().equals("")){
                tmp.setName(rsa.deCoding(tmp.getName()));
            }
            tmp.setEmail(rsa.deCoding(tmp.getEmail()));
            if(!tmp.getPhone_number().equals("")){
                tmp.setPhone_number(rsa.deCoding(tmp.getPhone_number()));
            }
            if(!tmp.getQq().equals("")){
                tmp.setQq(rsa.deCoding(rsa.deCoding(tmp.getQq())));
            }
            if(!tmp.getHead_image_uri().equals("")){
                tmp.setHead_image_uri(rsa.deCoding(tmp.getHead_image_uri()));
            }
        }
        req.setAttribute("teaList", teaList);
    }
}
