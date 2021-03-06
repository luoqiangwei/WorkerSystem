package cn.ovea.controller.service;

import cn.ovea.controller.dao.Member_learning_recordsDao;
import cn.ovea.controller.dao.Punch_the_clockDao;
import cn.ovea.model.Member_learning_records;
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

public class LearningRecordsService {
    Member_learning_recordsDao MLRD = new Member_learning_recordsDao();
    Nanoflake nf;
    RSA rsa;
    public LearningRecordsService(){
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

    public void insertRecord(Member_learning_records mlr){
        mlr.setRecord_id(nf.getNanoflake());
        mlr.setIs_effective(true);
        mlr.setRelease_date(new Date());
        mlr.setContent(rsa.enCoding(mlr.getContent()));
        mlr.setTitle(rsa.enCoding(mlr.getTitle()));
        if(!mlr.getRemarks().trim().equals("")){
            mlr.setRemarks(rsa.enCoding(mlr.getRemarks()));
        }
        MLRD.add(mlr);
    }

    public void findByUser(HttpServletRequest req, String userID){
        List<Member_learning_records> userLrc = MLRD.findByUid(userID);
        for(Member_learning_records tmp : userLrc){
            tmp.setTitle(rsa.deCoding(tmp.getTitle()));
            tmp.setContent(rsa.deCoding(tmp.getContent()));
            if(!tmp.getRemarks().equals("")){
                tmp.setRemarks(rsa.deCoding(tmp.getRemarks()));
            }
        }
        req.setAttribute("userLrc", userLrc);
    }

    public void findByRid(HttpServletRequest req, String rid) {
        Member_learning_records editRecord = MLRD.findByRid(rid);
        editRecord.setTitle(rsa.deCoding(editRecord.getTitle()));
        editRecord.setContent(rsa.deCoding(editRecord.getContent()));
        if(!editRecord.getRemarks().equals("")){
            editRecord.setRemarks(rsa.deCoding(editRecord.getRemarks()));
        }
        req.setAttribute("editRecord", editRecord);
    }

    public void updateRecord(Member_learning_records mlr) {
        mlr.setContent(rsa.enCoding(mlr.getContent()));
        mlr.setTitle(rsa.enCoding(mlr.getTitle()));
        if(!mlr.getRemarks().trim().equals("")){
            mlr.setRemarks(rsa.enCoding(mlr.getRemarks()));
        }
        MLRD.updateRecord(mlr);
    }
}
