package cn.ovea.controller.service;

import cn.ovea.controller.dao.Punch_the_clockDao;
import cn.ovea.model.Punch_the_clock;
import cn.ovea.tool.commons.Nanoflake;
import cn.ovea.tool.commons.RSA;
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

public class PunchService {
    Punch_the_clockDao PTCD = new Punch_the_clockDao();
    Nanoflake nf;
    RSA rsa;
    public PunchService(){
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
        try {
            nf = new Nanoflake(1L);
        } catch (NanoflakeException e) {
            e.printStackTrace();
        }
    }

    public void insertPunch(Punch_the_clock ptc){
        ptc.setPunch_id(nf.getNanoflake());
        ptc.setPunch_date(new Date());
        if(!ptc.getPunch_location().trim().equals("")){
            ptc.setPunch_location(rsa.enCoding(ptc.getPunch_location()));
        }
        if(!ptc.getPunch_ip().trim().equals("")){
            ptc.setPunch_ip(rsa.enCoding(ptc.getPunch_ip()));
        }
        if(!ptc.getRemarks().trim().equals("")){
            ptc.setRemarks(rsa.enCoding(ptc.getRemarks()));
        }
        ptc.setType(true);
        PTCD.add(ptc);
    }

    public void findByUser(HttpServletRequest req, String userID){
        List<Punch_the_clock> userPtc = PTCD.findByUidLimt(userID, 0, 5);
        for(Punch_the_clock temp : userPtc){
            if(!temp.getRemarks().equals("")){
                temp.setRemarks(rsa.deCoding(temp.getRemarks()));
            }
            if(!temp.getPunch_ip().equals("")){
                temp.setPunch_ip(rsa.deCoding(temp.getPunch_ip()));
            }
            if(!temp.getPunch_location().equals("")){
                temp.setPunch_location(rsa.deCoding(temp.getPunch_location()));
            }
        }
        req.setAttribute("userPtc", userPtc);
    }
}
