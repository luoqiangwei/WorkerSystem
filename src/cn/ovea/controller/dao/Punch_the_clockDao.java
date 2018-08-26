package cn.ovea.controller.dao;

import cn.ovea.model.Punch_the_clock;
import cn.ovea.tool.jdbc.TxQueryRunner;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class Punch_the_clockDao {
    private QueryRunner qr = new TxQueryRunner();

    public List<Punch_the_clock> findAll(){
        String sql = "select * from punch_the_clock order by punch_id desc";
        try {
            return qr.query(sql, new BeanListHandler<Punch_the_clock>(Punch_the_clock.class));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Punch_the_clock> findByUid(String uid){
        String sql = "select * from punch_the_clock where user_id=? order by punch_id desc";
        try {
            return qr.query(sql, new BeanListHandler<Punch_the_clock>(Punch_the_clock.class), uid);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     *
     * @param uid
     * @param point
     * @param size
     * @return
     */
    public List<Punch_the_clock> findByUidLimt(String uid, int point, int size){
        String sql = "select * from punch_the_clock where user_id=? order by punch_id desc Limit ?, ?";
        try {
            return qr.query(sql, new BeanListHandler<Punch_the_clock>(Punch_the_clock.class), uid, point, size);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void add(Punch_the_clock punch_the_clock){
        String sql = "insert into punch_the_clock values(?,?,?,?,?,?,?)";
        Object[] params = {punch_the_clock.getPunch_id(), punch_the_clock.getUser_id(), punch_the_clock.getPunch_date(), punch_the_clock.getPunch_location(), punch_the_clock.getPunch_ip(), punch_the_clock.getRemarks(), punch_the_clock.isType()};
        try {
            qr.update(sql, params);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void delete(String id) {
        String sql = "delete from punch_the_clock where punch_id=?";
        try {
            qr.update(sql, id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
