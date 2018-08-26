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
import java.util.*;

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
            if(tmp.getName() != null && !tmp.getName().equals("")){
                tmp.setName(rsa.deCoding(tmp.getName()));
            }
            tmp.setEmail(rsa.deCoding(tmp.getEmail()));
            if(tmp.getPhone_number() != null && !tmp.getPhone_number().equals("")){
                tmp.setPhone_number(rsa.deCoding(tmp.getPhone_number()));
            }
            if(tmp.getQq() != null && !tmp.getQq().equals("")){
                tmp.setQq(rsa.deCoding(tmp.getQq()));
            }
            if(tmp.getHead_image_uri() != null && !tmp.getHead_image_uri().equals("")){
                tmp.setHead_image_uri(rsa.deCoding(tmp.getHead_image_uri()));
            }
        }
        req.setAttribute("teaList", teaList);
    }

    public void updateItem(Teacher_information ti){
        ti.setStaff_id(rsa.enCoding(ti.getStaff_id()));
        ti.setEmail(rsa.enCoding(ti.getEmail()));
        if(ti.getPassword().trim().length() != 0)
            ti.setPassword(sha.SHA512Encoding(ti.getPassword()));
        TID.updateItem(ti);
    }

    public void fullAdd(Teacher_information ti){
        ti.setStaff_id(rsa.enCoding(ti.getStaff_id()));
        ti.setEmail(rsa.enCoding(ti.getEmail()));
        ti.setPassword(sha.SHA512Encoding(ti.getPassword()));
        if(!ti.getName().trim().equals("")){
            ti.setName(rsa.enCoding(ti.getName()));
        }
        if(!ti.getPhone_number().trim().equals("")){
            ti.setPhone_number(rsa.enCoding(ti.getPhone_number()));
        }
        if(!ti.getQq().trim().equals("")){
            ti.setQq(rsa.enCoding(ti.getQq()));
        }
        ti.setUser_id(nf.getNanoflake());
        TID.add(ti);
    }

    public void fullModify(Teacher_information ti) {
        ti.setStaff_id(rsa.enCoding(ti.getStaff_id()));
        ti.setEmail(rsa.enCoding(ti.getEmail()));
        ti.setPassword(sha.SHA512Encoding(ti.getPassword()));
        if(!ti.getName().trim().equals("")){
            ti.setName(rsa.enCoding(ti.getName()));
        }
        if(!ti.getPhone_number().trim().equals("")){
            ti.setPhone_number(rsa.enCoding(ti.getPhone_number()));
        }
        if(!ti.getQq().trim().equals("")){
            ti.setQq(rsa.enCoding(ti.getQq()));
        }
        TID.fullModify(ti);
    }

    public void find(HttpServletRequest req, String keyWord) {
        Teacher_information ti = TID.findByEmail(keyWord);
        ti.setStaff_id(rsa.deCoding(ti.getStaff_id()));
        if(ti.getName() != null && !ti.getName().equals("")){
            ti.setName(rsa.deCoding(ti.getName()));
        }
        ti.setEmail(rsa.deCoding(ti.getEmail()));
        if(ti.getPhone_number() != null && !ti.getPhone_number().equals("")){
            ti.setPhone_number(rsa.deCoding(ti.getPhone_number()));
        }
        if(ti.getQq() != null && !ti.getQq().equals("")){
            ti.setQq(rsa.deCoding(ti.getQq()));
        }
        if(ti.getHead_image_uri() != null && !ti.getHead_image_uri().equals("")){
            ti.setHead_image_uri(rsa.deCoding(ti.getHead_image_uri()));
        }
        List<Teacher_information> teaList = new ArrayList<>();
        teaList.add(ti);
        req.setAttribute("teaList", teaList);
    }

    public void insertItem(Teacher_information ti) {
        if(!ti.getPassword().trim().equals(""))
            ti.setPassword(sha.SHA512Encoding(ti.getPassword()));
        ti.setEmail(rsa.enCoding(ti.getEmail()));
        ti.setStaff_id(rsa.enCoding(ti.getStaff_id()));
        ti.setUser_id(nf.getNanoflake());
        TID.add(ti);
    }
}
