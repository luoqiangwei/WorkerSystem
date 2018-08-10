package cn.ovea.model;

public class Admin_rights {
    private String user_id;
    private boolean is_effective;

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public boolean isIs_effective() {
        return is_effective;
    }

    public void setIs_effective(boolean is_effective) {
        this.is_effective = is_effective;
    }

    @Override
    public String toString() {
        return "Admin_rightsDao{" +
                "user_id='" + user_id + '\'' +
                ", is_effective=" + is_effective +
                '}';
    }

    public Admin_rights() {
    }

    public Admin_rights(String user_id, boolean is_effective) {
        this.user_id = user_id;
        this.is_effective = is_effective;
    }
}
