package cn.ovea.controller.dao;

import cn.ovea.model.Member_information;
import cn.ovea.model.User_information;
import cn.ovea.tool.jdbc.TxQueryRunner;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class Member_informationDao {
    private QueryRunner qr = new TxQueryRunner();

    public List<Member_information> findAll(){
        String sql = "select * from member_information where is_effective=1";
        try {
            return qr.query(sql, new BeanListHandler<Member_information>(Member_information.class));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Member_information findByUser(String uid){
        String sql = "select * from member_information where is_effective=1 and user_id =?";
        try {
            return qr.query(sql, new BeanHandler<Member_information>(Member_information.class), uid);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Member_information findBySID(String sid){
        String sql = "select * from member_information where is_effective=1 and student_id =?";
        try {
            return qr.query(sql, new BeanHandler<Member_information>(Member_information.class), sid);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void add(Member_information member_information){
        String sql = "insert into member_information values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        Object[] params = {member_information.getUser_id(), member_information.getStudent_id(), member_information.getName(), member_information.getEmail(), member_information.getPassword(), member_information.getVerification_code(), member_information.getValidation_code_update_time(), member_information.getPhone_number(), member_information.getQq(), member_information.isSex(), member_information.getGrade(), member_information.getHead_image_uri(), member_information.isIs_effective()};
        try {
            qr.update(sql, params);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateStateByUid(String uid, boolean state){
        String sql = "update member_information set is_effective=? where user_id=?";
        try {
            qr.update(sql, state, uid);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateStateBySid(String sid, boolean state){
        String sql = "update member_information set is_effective=? where student_id=?";
        try {
            qr.update(sql, state, sid);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Member_information findByEmail(String email) {
        String sql = "select * from member_information where is_effective=1 and email=?";
        try {
            return qr.query(sql, new BeanHandler<Member_information>(Member_information.class), email);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateState(String uid, boolean b) {
        String sql = "update member_information set is_effective=? where user_id=?";
        try {
            qr.update(sql, b, uid);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public User_information findByCode(String code) {
        String sql = "select * from member_information where verification_code=?";
        try {
            return qr.query(sql, new BeanHandler<User_information>(User_information.class), code);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateInfo(Member_information mi){
        String sql = "update member_information set student_id=?, name=?, phone_number=?, qq=?, sex=? where user_id=?";
        try {
            qr.update(sql, mi.getStudent_id(), mi.getName(), mi.getPhone_number(), mi.getQq(), mi.isSex(), mi.getUser_id());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updatePasswd(Member_information mi){
        String sql = "update member_information set password=? where user_id=?";
        try {
            qr.update(sql, mi.getPassword(), mi.getUser_id());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateItem(Member_information mi) {
        if(mi.getPassword().trim().equals("")){
            String sql = "update member_information set email=?, student_id=? where user_id=?";
            try {
                qr.update(sql, mi.getEmail(), mi.getStudent_id(), mi.getUser_id());
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }else{
            String sql = "update member_information set email=?, student_id=?, password=? where user_id=?";
            try {
                qr.update(sql, mi.getEmail(), mi.getStudent_id(), mi.getPassword(), mi.getUser_id());
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void fullModify(Member_information mi) {
        if(mi.getPassword().trim().equals("")){
            String sql = "update member_information set staff_id=?, name=?, email=?, phone_number=?, qq=?, sex=?, is_effective=?, grade=? where user_id=?";
            try {
                qr.update(sql, mi.getStudent_id(), mi.getName(), mi.getEmail(), mi.getPhone_number(), mi.getQq(), mi.isSex(), mi.isIs_effective(), mi.getGrade(), mi.getUser_id());
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }else{
            String sql = "update member_information set staff_id=?, name=?, email=?, password=?, phone_number=?, qq=?, sex=?, is_effective=?, grade=? where user_id=?";
            try {
                qr.update(sql, mi.getStudent_id(), mi.getName(), mi.getEmail(), mi.getPassword(), mi.getPhone_number(), mi.getQq(), mi.isSex(), mi.isIs_effective(), mi.getGrade(), mi.getUser_id());
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
