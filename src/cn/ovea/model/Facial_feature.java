package cn.ovea.model;

public class Facial_feature {
    private String facial_id;
    private String user_id;
    private String storage_uri;
    private boolean is_effective;

    public String getFacial_id() {
        return facial_id;
    }

    public void setFacial_id(String facial_id) {
        this.facial_id = facial_id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getStorage_uri() {
        return storage_uri;
    }

    public void setStorage_uri(String storage_uri) {
        this.storage_uri = storage_uri;
    }

    public boolean isIs_effective() {
        return is_effective;
    }

    public void setIs_effective(boolean is_effective) {
        this.is_effective = is_effective;
    }

    @Override
    public String toString() {
        return "Facial{" +
                "facial_id='" + facial_id + '\'' +
                ", user_id='" + user_id + '\'' +
                ", storage_uri='" + storage_uri + '\'' +
                ", is_effective='" + is_effective + '\'' +
                '}';
    }


    public Facial_feature(String facial_id, String user_id, String storage_uri, boolean is_effective) {
        this.facial_id = facial_id;
        this.user_id = user_id;
        this.storage_uri = storage_uri;
        this.is_effective = is_effective;
    }

    public Facial_feature() {
    }
}
