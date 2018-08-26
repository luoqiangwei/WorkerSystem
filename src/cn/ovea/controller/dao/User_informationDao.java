package cn.ovea.controller.dao;

import cn.ovea.model.User_information;
import cn.ovea.model.exception.User_informationException;
import cn.ovea.tool.jdbc.TxQueryRunner;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class User_informationDao {
    private QueryRunner qr = new TxQueryRunner();

    public User_information findByUser(String uid){
        String sql = "select * from user_information where user_id=?";
        try {
            return qr.query(sql, new BeanHandler<User_information>(User_information.class), uid);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public User_information findByCode(String code) {
        String sql = "select * from user_information where verification_code=?";
        try {
            return qr.query(sql, new BeanHandler<User_information>(User_information.class), code);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public User_information findByEmail(String email) {
        String sql = "select * from user_information where email=?";
        try {
            return qr.query(sql, new BeanHandler<User_information>(User_information.class), email);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public User_information check(String email, String password) throws User_informationException {
        if(findByEmail(email) == null) throw new User_informationException("该用户不存在");
        String sql = "select * from user_information where email=? and password=?";
        try {
            return qr.query(sql, new BeanHandler<User_information>(User_information.class), email, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<User_information> findUnAdmin() {
        String sql = "select * from user_information where user_id not in (select user_id from admin_rights)";
        try {
            return qr.query(sql, new BeanListHandler<User_information>(User_information.class));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
