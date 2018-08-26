package cn.ovea.controller.service;

import cn.ovea.controller.dao.Punch_the_clockDao;
import cn.ovea.model.Punch_the_clock;
import cn.ovea.tool.commons.RSA;
import cn.ovea.tool.commons.exception.RSAException;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

public class PunchManageService {
    RSA rsa;
    Punch_the_clockDao PTCD = new Punch_the_clockDao();
    public PunchManageService(){
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
        List<Punch_the_clock> punList = PTCD.findAll();
        for(Punch_the_clock item : punList){
            if(!item.getPunch_location().trim().equals("")){
                item.setPunch_location(rsa.deCoding(item.getPunch_location()));
            }
            if(!item.getPunch_ip().trim().equals("")){
                item.setPunch_ip(rsa.deCoding(item.getPunch_ip()));
            }
            if(!item.getRemarks().trim().equals("")){
                item.setRemarks(rsa.deCoding(item.getRemarks()));
            }
        }
        req.setAttribute("punList", punList);
    }

    public void delete(String id) {
        PTCD.delete(id);
    }
}
