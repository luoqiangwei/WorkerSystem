package cn.ovea.model;

import java.util.Date;

public class Punch_the_clock {
    private String punch_id;
    private String user_id;
    private Date punch_date;
    private String punch_location;
    private String punch_ip;
    private String remarks;
    private boolean type;

    public String getPunch_id() {
        return punch_id;
    }

    public void setPunch_id(String punch_id) {
        this.punch_id = punch_id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public Date getPunch_date() {
        return punch_date;
    }

    public void setPunch_date(Date punch_date) {
        this.punch_date = punch_date;
    }

    public String getPunch_location() {
        return punch_location;
    }

    public void setPunch_location(String punch_location) {
        this.punch_location = punch_location;
    }

    public String getPunch_ip() {
        return punch_ip;
    }

    public void setPunch_ip(String punch_ip) {
        this.punch_ip = punch_ip;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public boolean isType() {
        return type;
    }

    public void setType(boolean type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Punch_the_clock{" +
                "punch_id='" + punch_id + '\'' +
                ", user_id='" + user_id + '\'' +
                ", punch_date=" + punch_date +
                ", punch_location='" + punch_location + '\'' +
                ", punch_ip='" + punch_ip + '\'' +
                ", remarks='" + remarks + '\'' +
                ", type=" + type +
                '}';
    }

    public Punch_the_clock() {
    }

    public Punch_the_clock(String punch_id, String user_id, Date punch_date, String punch_location, String punch_ip, String remarks, boolean type) {
        this.punch_id = punch_id;
        this.user_id = user_id;
        this.punch_date = punch_date;
        this.punch_location = punch_location;
        this.punch_ip = punch_ip;
        this.remarks = remarks;
        this.type = type;
    }
}
