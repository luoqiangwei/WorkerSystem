package cn.ovea.controller.service;

import cn.ovea.controller.dao.Member_informationDao;
import cn.ovea.controller.dao.User_informationDao;
import cn.ovea.model.Member_information;
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

public class MemberManageService {
    Nanoflake nf;
    RSA rsa;
    SHA sha;
    Member_informationDao MID = new Member_informationDao();
    User_informationDao UID = new User_informationDao();

    public MemberManageService(){
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


    public void findAll(HttpServletRequest req) {
        List<Member_information> memList = MID.findAll();
        for(Member_information item : memList){
            item.setStudent_id(rsa.deCoding(item.getStudent_id()));
            if(!item.getName().equals("")){
                item.setName(rsa.deCoding(item.getName()));
            }
            item.setEmail(rsa.deCoding(item.getEmail()));
            if(!item.getPhone_number().equals("")){
                item.setPhone_number(rsa.deCoding(item.getPhone_number()));
            }
            if(!item.getQq().equals("")){
                item.setQq(rsa.deCoding(item.getQq()));
            }
            item.setGrade(rsa.deCoding(item.getGrade()));
        }
        req.setAttribute("memList", memList);
    }

    public void find(HttpServletRequest req, String keyWord) {
        Member_information mi = MID.findByEmail(keyWord);
        mi.setStudent_id(rsa.deCoding(mi.getStudent_id()));
        if(!mi.getName().equals("")){
            mi.setName(rsa.deCoding(mi.getName()));
        }
        mi.setEmail(rsa.deCoding(mi.getEmail()));
        if(!mi.getPhone_number().equals("")){
            mi.setPhone_number(rsa.deCoding(mi.getPhone_number()));
        }
        if(!mi.getQq().equals("")){
            mi.setQq(rsa.deCoding(mi.getQq()));
        }
        mi.setGrade(rsa.deCoding(mi.getGrade()));
        req.setAttribute("memList", mi);
    }

    public void insertItem(Member_information mi) {
        mi.setPassword(sha.SHA512Encoding(mi.getPassword()));
        mi.setEmail(rsa.enCoding(mi.getEmail()));
        mi.setStudent_id(rsa.enCoding(mi.getStudent_id()));
        mi.setUser_id(nf.getNanoflake());
        MID.add(mi);
    }

    public void updateItem(Member_information mi) {
        mi.setStudent_id(rsa.enCoding(mi.getStudent_id()));
        mi.setEmail(rsa.enCoding(mi.getEmail()));
        if(!mi.getPassword().trim().equals(""))
            mi.setPassword(sha.SHA512Encoding(mi.getPassword()));
        MID.updateItem(mi);
    }

    public void fullAdd(Member_information mi) {
        mi.setUser_id(nf.getNanoflake());
        mi.setStudent_id(rsa.enCoding(mi.getStudent_id()));
        if(!mi.getName().trim().equals("")){
            mi.setName(rsa.enCoding(mi.getName()));
        }
        mi.setEmail(rsa.enCoding(mi.getEmail()));
        mi.setPassword(sha.SHA512Encoding(mi.getPassword()));
        if(!mi.getPhone_number().trim().equals("")){
            mi.setPhone_number(rsa.enCoding(mi.getPhone_number()));
        }
        if(!mi.getQq().trim().equals("")){
            mi.setQq(rsa.enCoding(mi.getQq()));
        }
        mi.setGrade(rsa.enCoding(mi.getGrade()));
        MID.add(mi);
    }

    public void fullModify(Member_information mi) {
        mi.setStudent_id(rsa.enCoding(mi.getStudent_id()));
        if(!mi.getName().trim().equals("")){
            mi.setName(rsa.enCoding(mi.getName()));
        }
        mi.setEmail(rsa.enCoding(mi.getEmail()));
        if(!mi.getPassword().trim().equals("")){
            mi.setPassword(sha.SHA512Encoding(mi.getPassword()));
        }
        if(!mi.getPhone_number().trim().equals("")){
            mi.setPhone_number(rsa.enCoding(mi.getPhone_number()));
        }
        if(!mi.getQq().trim().equals("")){
            mi.setQq(rsa.enCoding(mi.getQq()));
        }
        mi.setGrade(rsa.enCoding(mi.getGrade()));
        MID.fullModify(mi);
    }
}
