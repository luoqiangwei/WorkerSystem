package cn.ovea.model;

import java.util.Date;

public class User_information {
    private String user_id;
    private String email;
    private String password;
    private String verification_code;
    private Date validation_code_update_time;
    private boolean is_effective;

    @Override
    public String toString() {
        return "User_information{" +
                "user_id='" + user_id + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", verification_code='" + verification_code + '\'' +
                ", validation_code_update_time=" + validation_code_update_time +
                ", is_effective=" + is_effective +
                '}';
    }

    public Date getValidation_code_update_time() {
        return validation_code_update_time;
    }

    public void setValidation_code_update_time(Date validation_code_update_time) {
        this.validation_code_update_time = validation_code_update_time;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getVerification_code() {
        return verification_code;
    }

    public void setVerification_code(String verification_code) {
        this.verification_code = verification_code;
    }

    public boolean isIs_effective() {
        return is_effective;
    }

    public void setIs_effective(boolean is_effective) {
        this.is_effective = is_effective;
    }

    public User_information(String user_id, String email, String password, String verification_code, boolean is_effective) {
        this.user_id = user_id;
        this.email = email;
        this.password = password;
        this.verification_code = verification_code;
        this.is_effective = is_effective;
    }

    public User_information() {
    }
}
