package cn.ovea.model;

import java.util.Date;

public class Mission_score {
    private String score_id;
    private String submission_id;
    private String user_id;
    private String score;
    private String comment;
    private Date score_date;

    public String getScore_id() {
        return score_id;
    }

    public void setScore_id(String score_id) {
        this.score_id = score_id;
    }

    public String getSubmission_id() {
        return submission_id;
    }

    public void setSubmission_id(String submission_id) {
        this.submission_id = submission_id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getScore_date() {
        return score_date;
    }

    public void setScore_date(Date score_date) {
        this.score_date = score_date;
    }

    @Override
    public String toString() {
        return "Mission_score{" +
                "score_id='" + score_id + '\'' +
                ", submission_id='" + submission_id + '\'' +
                ", user_id='" + user_id + '\'' +
                ", score='" + score + '\'' +
                ", comment='" + comment + '\'' +
                ", score_date=" + score_date +
                '}';
    }

    public Mission_score() {
    }

    public Mission_score(String score_id, String submission_id, String user_id, String score, String comment, Date score_date) {
        this.score_id = score_id;
        this.submission_id = submission_id;
        this.user_id = user_id;
        this.score = score;
        this.comment = comment;
        this.score_date = score_date;
    }
}
