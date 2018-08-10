package cn.ovea.controller.service;

import cn.ovea.controller.dao.Member_informationDao;
import cn.ovea.controller.dao.Teacher_informationDao;
import cn.ovea.controller.dao.User_informationDao;
import cn.ovea.model.Member_information;
import cn.ovea.model.Teacher_information;
import cn.ovea.model.User_information;
import cn.ovea.model.exception.User_informationException;
import cn.ovea.tool.commons.CommonUtils;
import cn.ovea.tool.commons.Nanoflake;
import cn.ovea.tool.commons.RSA;
import cn.ovea.tool.commons.SHA;
import cn.ovea.tool.commons.exception.NanoflakeException;
import cn.ovea.tool.commons.exception.RSAException;
import cn.ovea.tool.mail.Mail;
import cn.ovea.tool.mail.MailUtils;

import javax.mail.MessagingException;
import javax.mail.Session;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.Date;
import java.util.Properties;

public class RegisterService {
    Nanoflake nf;
    RSA rsa;
    Member_informationDao MID = new Member_informationDao();
    Teacher_informationDao TID = new Teacher_informationDao();
    User_informationDao UID = new User_informationDao();
    SHA sha;

    public RegisterService() throws NanoflakeException, RSAException {
        // 加载配置文件
        Properties props = new Properties();
        try {
            props.load(new BufferedInputStream(new FileInputStream(new File("D:\\Store\\CAH\\Creat\\2018\\config\\javaEE\\idea\\WorkerSystem\\config.properties"))));
        } catch (IOException e) {
            throw new RuntimeException("配置文件读取失败");
        }


        nf = new Nanoflake(1L);
        rsa = new RSA(props.getProperty("pubkeyPath"), props.getProperty("PrikeyPath"));
        sha = new SHA();
    }

    public void tRegister(Teacher_information TI){
        TI.setIs_effective(true);
        TI.setUser_id(nf.getNanoflake());
        TI.setStaff_id(rsa.enCoding(TI.getStaff_id()));
        TI.setEmail(rsa.enCoding(TI.getEmail()));
        TI.setPassword(sha.SHA512Encoding(TI.getPassword()));
        TID.add(TI);
    }

    public void sRegister(Member_information TI) throws IOException, User_informationException {
        Properties props = new Properties();
        props.load(this.getClass().getClassLoader().getResourceAsStream("config.properties"));
        String host = props.getProperty("host");
        String uname = props.getProperty("uname");
        String pwd = props.getProperty("pwd");
        String from = props.getProperty("from");
        String to = TI.getEmail();
        String subject = props.getProperty("subject");
        String content = props.getProperty("content");
        TI.setVerification_code(CommonUtils.uuid());
        content = MessageFormat.format(content, TI.getVerification_code());
        Session session = MailUtils.createSession(host, uname, pwd);
        Mail mail = new Mail(from, to, subject, content);
        try {
            MailUtils.send(session, mail);
        } catch (MessagingException e) {

        }

        TI.setIs_effective(false);
        TI.setUser_id(nf.getNanoflake());
        TI.setStudent_id(rsa.enCoding(TI.getStudent_id()));
        TI.setEmail(rsa.enCoding(TI.getEmail()));
        TI.setPassword(sha.SHA512Encoding(TI.getPassword()));
        TI.setGrade(rsa.enCoding("0000"));

        if(UID.findByEmail(TI.getEmail()) != null){
            throw new User_informationException("该邮箱已经注册。");
        }
        if(MID.findBySID(TI.getStudent_id()) != null){
            throw new User_informationException("该学号已经注册。");
        }
        TI.setValidation_code_update_time(new Date());

        MID.add(TI);
    }

    public void active(String code) throws User_informationException {
        User_information user = MID.findByCode(code);
        if(user == null) throw new User_informationException("激活码无效。");
        if(user.isIs_effective()) throw new User_informationException("您已经激活过了。");
        if(new Date().getTime() - user.getValidation_code_update_time().getTime() > 1000 * 60 * 60) throw new User_informationException("激活码已经失效。");
        MID.updateState(user.getUser_id(), true);
    }
}
