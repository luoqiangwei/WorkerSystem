package cn.ovea.controller.dao;

import cn.ovea.model.Member_information;
import cn.ovea.model.Teacher_information;
import cn.ovea.tool.jdbc.TxQueryRunner;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class Teacher_informationDao {
    private QueryRunner qr = new TxQueryRunner();

    public List<Teacher_information> findAll(){
        String sql = "select * from teacher_information where is_effective=1";
        try {
            return qr.query(sql, new BeanListHandler<Teacher_information>(Teacher_information.class));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void add(Teacher_information teacher_information){
        String sql = "insert into teacher_information values(?,?,?,?,?,?,?,?,?,?,?,?)";
        Object[] params = {teacher_information.getUser_id(), teacher_information.getStaff_id(), teacher_information.getName(), teacher_information.getEmail(), teacher_information.getPassword(), teacher_information.getVerification_code(), teacher_information.getValidation_code_update_time(), teacher_information.getPhone_number(), teacher_information.getQq(), teacher_information.isSex(), teacher_information.getHead_image_uri(), teacher_information.isIs_effective()};
        try {
            qr.update(sql, params);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateState(String uid, boolean state){
        String sql = "update teacher_information set is_effective=? where user_id=?";
        try {
            qr.update(sql, state, uid);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateInfo(Teacher_information ti){
        String sql = "update teacher_information set staff_id=?, name=?, phone_number=?, qq=?, sex=? where user_id=?";
        try {
            qr.update(sql, ti.getStaff_id(), ti.getName(), ti.getPhone_number(), ti.getQq(), ti.isSex(), ti.getUser_id());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updatePasswd(Teacher_information ti){
        String sql = "update teacher_information set password=? where user_id=?";
        try {
            qr.update(sql, ti.getPassword(), ti.getUser_id());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Teacher_information findByUser(String userId) {
        String sql = "select * from teacher_information where is_effective=1 and user_id =?";
        try {
            return qr.query(sql, new BeanHandler<Teacher_information>(Teacher_information.class), userId);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateItem(Teacher_information ti){
        if(ti.getPassword().trim().length() != 0){
            String sql = "update teacher_information set password=?, staff_id=?, email=?, is_effective=? where user_id=?";
            try {
                qr.update(sql, ti.getPassword(), ti.getStaff_id(), ti.getEmail(), ti.isIs_effective(), ti.getUser_id());
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }else{
            String sql = "update teacher_information set staff_id=?, email=?, is_effective=? where user_id=?";
            try {
                qr.update(sql, ti.getStaff_id(), ti.getEmail(), ti.isIs_effective(), ti.getUser_id());
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
