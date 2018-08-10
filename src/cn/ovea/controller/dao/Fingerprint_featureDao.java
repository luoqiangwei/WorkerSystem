package cn.ovea.controller.dao;

import cn.ovea.model.Fingerprint_feature;
import cn.ovea.tool.jdbc.TxQueryRunner;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class Fingerprint_featureDao {
    private QueryRunner qr = new TxQueryRunner();

    public List<Fingerprint_feature> findAll(){
        String sql = "select * from fingerprint_feature where is_effective=1";
        try {
            return qr.query(sql, new BeanListHandler<Fingerprint_feature>(Fingerprint_feature.class));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Fingerprint_feature findByFID(String fid){
        String sql = "select * from fingerprint_feature where is_effective=1 and fingerprint_id=?";
        try {
            return qr.query(sql, new BeanHandler<Fingerprint_feature>(Fingerprint_feature.class), fid);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void add(Fingerprint_feature fingerprint_feature){
        String sql = "insert into fingerprint_feature values(?, ?, ?, ?)";
        Object[] params = {fingerprint_feature.getFingerprint_id(), fingerprint_feature.getUser_id(), fingerprint_feature.getStorage_uri(), fingerprint_feature.isIs_effective()};
        try {
            qr.update(sql, params);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateStateByFid(String fid, boolean state){
        String sql = "update fingerprint_feature set is_effective=? where facial_id=?";
        try {
            qr.update(sql, state, fid);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateStateByUid(String uid, boolean state){
        String sql = "update fingerprint_feature set is_effective=? where user_id=?";
        try {
            qr.update(sql, state, uid);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
