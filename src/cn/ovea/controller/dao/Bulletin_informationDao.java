package cn.ovea.controller.dao;

import cn.ovea.model.Bulletin_information;
import cn.ovea.tool.jdbc.TxQueryRunner;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.io.BufferedReader;
import java.sql.SQLException;
import java.util.List;

public class Bulletin_informationDao {
    private QueryRunner qr = new TxQueryRunner();

    public List<Bulletin_information> findAll(){
        String sql = "select * from bulletin_information where is_effective=1";
        try {
            return qr.query(sql, new BeanListHandler<Bulletin_information>(Bulletin_information.class));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Bulletin_information findByNotice(String noticeID){
        String sql = "select * from bulletin_information where is_effective=1 add notice_id = ?";
        try {
            return qr.query(sql, new BeanHandler<Bulletin_information>(Bulletin_information.class), noticeID);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Bulletin_information> findByUser(String userID){
        String sql = "select * from bulletin_information where is_effective=1 add user_id=?";
        try {
            return qr.query(sql, new BeanListHandler<Bulletin_information>(Bulletin_information.class), userID);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void add(Bulletin_information bulletin_information){
        String sql = "insert into bulletin_information values(?, ?, ?, ?, ?, ?)";
        Object[] params = {bulletin_information.getNotice_id(), bulletin_information.getUser_id(), bulletin_information.getTitle(), bulletin_information.getContent(), bulletin_information.getRelease_time(), bulletin_information.isIs_effective()};
        try {
            qr.update(sql, params);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateState(String noticeID, boolean state){
        String sql = "update bulletin_information set is_effective=? where notice_id=?";
        try {
            qr.update(sql, state, noticeID);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
