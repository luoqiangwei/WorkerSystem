package cn.ovea.model;

import java.util.Date;

public class Mission_submission {
    private String submission_id;
    private String mission_id;
    private String user_id;
    private String content;
    private String remarks;
    private String storage_uri;
    private Date submission_date;

    public String getSubmission_id() {
        return submission_id;
    }

    public void setSubmission_id(String submission_id) {
        this.submission_id = submission_id;
    }

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

    public String getStorage_uri() {
        return storage_uri;
    }

    public void setStorage_uri(String storage_uri) {
        this.storage_uri = storage_uri;
    }

    public Date getSubmission_date() {
        return submission_date;
    }

    public void setSubmission_date(Date submission_date) {
        this.submission_date = submission_date;
    }

    @Override
    public String toString() {
        return "Mission_submission{" +
                "submission_id='" + submission_id + '\'' +
                ", mission_id='" + mission_id + '\'' +
                ", user_id='" + user_id + '\'' +
                ", content='" + content + '\'' +
                ", remarks='" + remarks + '\'' +
                ", storage_uri='" + storage_uri + '\'' +
                ", submission_date=" + submission_date +
                '}';
    }

    public Mission_submission() {
    }

    public Mission_submission(String submission_id, String mission_id, String user_id, String content, String remarks, String storage_uri, Date submission_date) {
        this.submission_id = submission_id;
        this.mission_id = mission_id;
        this.user_id = user_id;
        this.content = content;
        this.remarks = remarks;
        this.storage_uri = storage_uri;
        this.submission_date = submission_date;
    }
}
