package cn.ovea.controller.dao;

import cn.ovea.model.Member_learning_records;
import cn.ovea.tool.jdbc.TxQueryRunner;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class Member_learning_recordsDao {
    private QueryRunner qr = new TxQueryRunner();

    public List<Member_learning_records> findAll(){
        String sql = "select * from member_learning_records where is_effective=1";
        try {
            return qr.query(sql, new BeanListHandler<Member_learning_records>(Member_learning_records.class));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Member_learning_records findByRid(String  rid){
        String sql = "select * from member_learning_records where is_effective=1 and record_id=?";
        try {
            return qr.query(sql, new BeanHandler<Member_learning_records>(Member_learning_records.class), rid);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Member_learning_records> findByUid(String uid){
        String sql = "select * from member_learning_records where is_effective=1 and user_id=?";
        try {
            return qr.query(sql, new BeanListHandler<Member_learning_records>(Member_learning_records.class), uid);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void add(Member_learning_records member_learning_records){
        String sql = "insert into member_learning_records values(?,?,?,?,?,?,?)";
        Object[] params = {member_learning_records.getRecord_id(), member_learning_records.getUser_id(), member_learning_records.getTitle(), member_learning_records.getContent(), member_learning_records.getRemarks(), member_learning_records.getRelease_date(), member_learning_records.isIs_effective()};
        try {
            qr.update(sql, params);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateState(String rid, boolean state){
        String sql = "update member_learning_records set is_effective=? where record_id=?";
        try {
            qr.update(sql, state, rid);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
