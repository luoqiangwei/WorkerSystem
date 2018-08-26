package cn.ovea.controller.service;

import cn.ovea.controller.dao.Bulletin_informationDao;
import cn.ovea.model.Bulletin_information;
import cn.ovea.tool.commons.RSA;
import cn.ovea.tool.commons.exception.RSAException;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

public class BulletinManageService {
    RSA rsa;
    Bulletin_informationDao BID = new Bulletin_informationDao();
    public BulletinManageService(){
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
        List<Bulletin_information> bullList = BID.findAll();
        for(Bulletin_information tmp : bullList){
            tmp.setTitle(rsa.deCoding(tmp.getTitle()));
            tmp.setContent(rsa.deCoding(tmp.getContent()));
        }
        req.setAttribute("bullList", bullList);
    }

    public void delete(String id) {
        BID.updateState(id, false);
    }
}
