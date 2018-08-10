package cn.ovea.model;

import java.util.Date;

public class Mission_release {
    private String mission_id;
    private String user_id;
    private String title;
    private String content;
    private String remarks;
    private String grade;
    private String storage_uri;
    private Date release_date;
    private Date expire_date;
    private boolean is_effective;

    public String getMission_id() {
        return mission_id;
    }

    public void setMission_id(String mission_id) {
        this.mission_id = mission_id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getStorage_uri() {
        return storage_uri;
    }

    public void setStorage_uri(String storage_uri) {
        this.storage_uri = storage_uri;
    }

    public Date getRelease_date() {
        return release_date;
    }

    public void setRelease_date(Date release_date) {
        this.release_date = release_date;
    }

    public Date getExpire_date() {
        return expire_date;
    }

    public void setExpire_date(Date expire_date) {
        this.expire_date = expire_date;
    }

    public boolean isIs_effective() {
        return is_effective;
    }

    public void setIs_effective(boolean is_effective) {
        this.is_effective = is_effective;
    }

    @Override
    public String toString() {
        return "Mission_release{" +
                "mission_id='" + mission_id + '\'' +
                ", user_id='" + user_id + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", remarks='" + remarks + '\'' +
                ", grade='" + grade + '\'' +
                ", storage_uri='" + storage_uri + '\'' +
                ", release_date=" + release_date +
                ", expire_date=" + expire_date +
                ", is_effective=" + is_effective +
                '}';
    }

    public Mission_release(String mission_id, String user_id, String title, String content, String remarks, String grade, String storage_uri, Date release_date, Date expire_date, boolean is_effective) {
        this.mission_id = mission_id;
        this.user_id = user_id;
        this.title = title;
        this.content = content;
        this.remarks = remarks;
        this.grade = grade;
        this.storage_uri = storage_uri;
        this.release_date = release_date;
        this.expire_date = expire_date;
        this.is_effective = is_effective;
    }

    public Mission_release() {
    }
}
