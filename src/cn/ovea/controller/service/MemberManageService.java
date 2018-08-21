package cn.ovea.controller.service;

import cn.ovea.controller.dao.Member_informationDao;
import cn.ovea.controller.dao.User_informationDao;
import cn.ovea.tool.commons.Nanoflake;
import cn.ovea.tool.commons.RSA;
import cn.ovea.tool.commons.SHA;
import cn.ovea.tool.commons.exception.NanoflakeException;
import cn.ovea.tool.commons.exception.RSAException;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
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


}
