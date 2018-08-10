package cn.ovea.model;

import java.util.Date;

public class Member_learning_records {
    private String record_id;
    private String user_id;
    private String title;
    private String content;
    private String remarks;
    private Date release_date;
    private boolean is_effective;

    public String getRecord_id() {
        return record_id;
    }

    public void setRecord_id(String record_id) {
        this.record_id = record_id;
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

    public Date getRelease_date() {
        return release_date;
    }

    public void setRelease_date(Date release_date) {
        this.release_date = release_date;
    }

    public boolean isIs_effective() {
        return is_effective;
    }

    public void setIs_effective(boolean is_effective) {
        this.is_effective = is_effective;
    }

    @Override
    public String toString() {
        return "Member_learning_records{" +
                "record_id='" + record_id + '\'' +
                ", user_id='" + user_id + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", remarks='" + remarks + '\'' +
                ", release_date=" + release_date +
                ", is_effective=" + is_effective +
                '}';
    }

    public Member_learning_records() {
    }

    public Member_learning_records(String record_id, String user_id, String title, String content, String remarks, Date release_date, boolean is_effective) {
        this.record_id = record_id;
        this.user_id = user_id;
        this.title = title;
        this.content = content;
        this.remarks = remarks;
        this.release_date = release_date;
        this.is_effective = is_effective;
    }
}
