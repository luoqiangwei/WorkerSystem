package cn.ovea.controller.dao;

import cn.ovea.model.Admin_rights;
import cn.ovea.tool.jdbc.TxQueryRunner;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class Admin_rightsDao {
    private QueryRunner qr = new TxQueryRunner();

    public List<Admin_rights> findAll(){
        String sql = "select * from admin_rights where is_effective=1";
        try {
            return qr.query(sql, new BeanListHandler<Admin_rights>(Admin_rights.class));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Admin_rights findByUser_id(String user_id){
        String sql = "select * from admin_rights where user_id = ? and is_effective=1";
        try {
            return qr.query(sql, new BeanHandler<Admin_rights>(Admin_rights.class), user_id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void add(Admin_rights admin){
        String sql = "insert into admin_rights values(?, ?)";
        try {
            Object[] params = {admin.getUser_id(), admin.isIs_effective()};
            qr.update(sql, params);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateState(String uid, boolean state){
        String sql = "update admin_rights set is_effective=? where user_id=?";
        try {
            qr.update(sql, state, uid);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
