package cn.ovea.controller.service;

import cn.ovea.controller.dao.Bulletin_informationDao;
import cn.ovea.model.Bulletin_information;
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
import java.util.Date;
import java.util.List;
import java.util.Properties;

public class BulletinService {
    Nanoflake nf;
    RSA rsa;
    SHA sha;
    Bulletin_informationDao BID = new Bulletin_informationDao();

    public BulletinService(){
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
        try {
            nf = new Nanoflake(1L);
        } catch (NanoflakeException e) {
            e.printStackTrace();
        }
    }

    public void add(Bulletin_information bi){
        bi.setTitle(rsa.enCoding(bi.getTitle()));
        bi.setContent(rsa.enCoding(bi.getContent()));
        bi.setIs_effective(true);
        bi.setNotice_id(nf.getNanoflake());
        bi.setRelease_time(new Date());
        BID.add(bi);
    }
}
