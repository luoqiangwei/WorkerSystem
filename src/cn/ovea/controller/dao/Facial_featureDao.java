package cn.ovea.controller.dao;

import cn.ovea.model.Facial_feature;
import cn.ovea.tool.jdbc.TxQueryRunner;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class Facial_featureDao {
    private QueryRunner qr = new TxQueryRunner();

    public List<Facial_feature> findAll(){
        String sql = "select* from facial_feature where is_effective = 1";
        try {
            return qr.query(sql, new BeanListHandler<Facial_feature>(Facial_feature.class));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Facial_feature findByUser(String uid){
        String sql = "select * from facial_feature where is_effective = 1 and user_id = ?";
        try {
            return qr.query(sql, new BeanHandler<Facial_feature>(Facial_feature.class), uid);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Facial_feature findByFacial(String fid){
        String sql = "select * from facial_feature where is_effective = 1 and facial_id = ?";
        try {
            return qr.query(sql, new BeanHandler<Facial_feature>(Facial_feature.class), fid);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void add(Facial_feature facial_feature){
        String sql = "insert into facial_feature values(?, ?, ?, ?)";
        Object[] params = {facial_feature.getFacial_id(), facial_feature.getUser_id(), facial_feature.getStorage_uri(), facial_feature.isIs_effective()};
        try {
            qr.update(sql, params);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateStateByFid(String fid, boolean state){
        String sql = "update facial_feature set is_effective=? where facial_id=?";
        try {
            qr.update(sql, state, fid);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateStateByUid(String uid, boolean state){
        String sql = "update facial_feature set is_effective=? where user_id=?";
        try {
            qr.update(sql, state, uid);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
