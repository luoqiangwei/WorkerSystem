package cn.ovea.controller.service;

import cn.ovea.controller.dao.Member_informationDao;
import cn.ovea.model.Member_information;
import cn.ovea.model.exception.User_informationException;
import cn.ovea.tool.commons.RSA;
import cn.ovea.tool.commons.SHA;
import cn.ovea.tool.commons.exception.RSAException;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class MemberCenterService {
    Member_informationDao MID = new Member_informationDao();
    RSA rsa;
    SHA sha;

    public MemberCenterService(){
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

    public void baseSet(Member_information mm){
        Member_information mi = new Member_information();
        mi.setUser_id(mm.getUser_id());
        if(mm.getName() != null && !mm.getName().equals("")){
            mi.setName(rsa.enCoding(mm.getName()));
        }
        if(mm.getPhone_number() != null && !mm.getPhone_number().equals("")){
            mi.setPhone_number(rsa.enCoding(mm.getPhone_number()));
        }
        if(mm.getQq() != null && !mm.getQq().equals("")){
            mi.setQq(rsa.enCoding(mm.getQq()));
        }
        mi.setSex(mm.isSex());
        mi.setStudent_id(rsa.enCoding(mm.getStudent_id()));
        MID.updateInfo(mi);
    }

    public void checkOPwd(Member_information mi, String opwd) throws User_informationException {
        if(!mi.getPassword().equals(sha.SHA512Encoding(opwd))){
            throw new User_informationException("旧密码输入错误。");
        }
    }

    public void pwdSet(Member_information mm, String npwd){
        Member_information mi = new Member_information();
        mi.setUser_id(mm.getUser_id());
        mi.setPassword(sha.SHA512Encoding(npwd));
        MID.updatePasswd(mi);
    }
}
