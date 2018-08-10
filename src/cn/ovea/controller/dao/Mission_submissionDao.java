package cn.ovea.controller.dao;

import cn.ovea.model.Mission_submission;
import cn.ovea.tool.jdbc.TxQueryRunner;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class Mission_submissionDao {
    private QueryRunner qr = new TxQueryRunner();
    public List<Mission_submission> findAll(){
        String sql = "select * from mission_submission";
        try {
            return qr.query(sql, new BeanListHandler<Mission_submission>(Mission_submission.class));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Mission_submission findBySid(String sid){
        String sql = "select * from mission_submission where submission_id=?";
        try {
            return qr.query(sql, new BeanHandler<Mission_submission>(Mission_submission.class), sid);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Mission_submission> findByMid(String mid){
        String sql = "select * from mission_submission where mission_id=?";
        try {
            return qr.query(sql, new BeanListHandler<Mission_submission>(Mission_submission.class), mid);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void add(Mission_submission mission_submission){
        String sql = "insert into mission_submission values(?,?,?,?,?,?,?)";
        Object[] params = {mission_submission.getSubmission_id(), mission_submission.getMission_id(), mission_submission.getUser_id(), mission_submission.getContent(), mission_submission.getRemarks(), mission_submission.getStorage_uri(), mission_submission.getSubmission_date()};
        try {
            qr.update(sql, params);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
