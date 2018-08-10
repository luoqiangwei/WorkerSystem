package cn.ovea.controller.dao;

import cn.ovea.model.Mission_release;
import cn.ovea.tool.jdbc.TxQueryRunner;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class Mission_releaseDao {
    private QueryRunner qr = new TxQueryRunner();

    public List<Mission_release> findAll(){
        String sql = "select * from mission_release where is_effective=1";
        try {
            return qr.query(sql, new BeanListHandler<Mission_release>(Mission_release.class));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Mission_release findByMid(String mid){
        String sql = "select * from mission_release where is_effective=1 and mission_id=?";
        try {
            return qr.query(sql, new BeanHandler<Mission_release>(Mission_release.class), mid);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Mission_release> findByUid(String uid){
        String sql = "select * from mission_release where is_effective=1 and user_id=?";
        try {
            return qr.query(sql, new BeanListHandler<Mission_release>(Mission_release.class), uid);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void add(Mission_release mission_release){
        String sql = "insert into mission_release values(?,?,?,?,?,?,?,?,?,?)";
        Object[] params = {mission_release.getMission_id(), mission_release.getUser_id(), mission_release.getTitle(), mission_release.getContent(), mission_release.getRemarks(), mission_release.getGrade(), mission_release.getStorage_uri(), mission_release.getRelease_date(), mission_release.getExpire_date(), mission_release.isIs_effective()};
        try {
            qr.update(sql, params);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateState(String mid, boolean state){
        String sql = "update mission_release set is_effective=? where mission_id=?";
        try {
            qr.update(sql, state, mid);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
