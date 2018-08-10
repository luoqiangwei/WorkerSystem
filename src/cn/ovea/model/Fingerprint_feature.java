package cn.ovea.model;

public class Fingerprint_feature {
    private String fingerprint_id;
    private String user_id;
    private String storage_uri;
    private boolean is_effective;

    public String getFingerprint_id() {
        return fingerprint_id;
    }

    public void setFingerprint_id(String fingerprint_id) {
        this.fingerprint_id = fingerprint_id;
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
        return "Fingerprint{" +
                "fingerprint_id='" + fingerprint_id + '\'' +
                ", user_id='" + user_id + '\'' +
                ", storage_uri='" + storage_uri + '\'' +
                ", is_effective='" + is_effective + '\'' +
                '}';
    }

    public Fingerprint_feature(String fingerprint_id, String user_id, String storage_uri, boolean is_effective) {
        this.fingerprint_id = fingerprint_id;
        this.user_id = user_id;
        this.storage_uri = storage_uri;
        this.is_effective = is_effective;
    }

    public Fingerprint_feature() {
    }
}
