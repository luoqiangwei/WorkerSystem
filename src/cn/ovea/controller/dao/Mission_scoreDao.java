package cn.ovea.controller.dao;

import cn.ovea.model.Mission_score;
import cn.ovea.tool.jdbc.TxQueryRunner;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class Mission_scoreDao {
    private QueryRunner qr = new TxQueryRunner();

    public List<Mission_score> findAll(){
        String sql = "select * from mission_score";
        try {
            return qr.query(sql, new BeanListHandler<Mission_score>(Mission_score.class));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public  Mission_score findBySid(String sid){
        String sql = "select * from mission_score where score_id=?";
        try {
            return qr.query(sql, new BeanHandler<Mission_score>(Mission_score.class), sid);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Mission_score findBySubid(String sid){
        String sql = "select * from mission_score where submission_id=?";
        try {
            return qr.query(sql, new BeanHandler<Mission_score>(Mission_score.class), sid);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Mission_score> findByUid(String uid){
        String sql = "select * from mission_score where user_id=?";
        try {
            return qr.query(sql, new BeanListHandler<Mission_score>(Mission_score.class), uid);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void add(Mission_score mission_score){
        String sql = "insert into mission_score values(?,?,?,?,?,?)";
        Object[] params = {mission_score.getScore_id(), mission_score.getSubmission_id(), mission_score.getUser_id(), mission_score.getScore(), mission_score.getComment(), mission_score.getScore_date()};
        try {
            qr.update(sql, params);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
