package cn.ovea.model;

import java.util.Date;

public class Bulletin_information {
    private String notice_id;
    private String user_id;
    private String title;
    private String content;
    private Date release_time;
    private boolean is_effective;

    public String getNotice_id() {
        return notice_id;
    }

    public void setNotice_id(String notice_id) {
        this.notice_id = notice_id;
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

    public Date getRelease_time() {
        return release_time;
    }

    public void setRelease_time(Date release_time) {
        this.release_time = release_time;
    }

    public boolean isIs_effective() {
        return is_effective;
    }

    public void setIs_effective(boolean is_effective) {
        this.is_effective = is_effective;
    }

    @Override
    public String toString() {
        return "Bulletin_information{" +
                "notice_id='" + notice_id + '\'' +
                ", user_id='" + user_id + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", release_time=" + release_time +
                ", is_effective=" + is_effective +
                '}';
    }

    public Bulletin_information() {
    }

    public Bulletin_information(String notice_id, String user_id, String title, String content, Date release_time, boolean is_effective) {
        this.notice_id = notice_id;
        this.user_id = user_id;
        this.title = title;
        this.content = content;
        this.release_time = release_time;
        this.is_effective = is_effective;
    }
}
