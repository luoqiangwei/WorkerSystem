package cn.ovea.model;

import java.util.Date;

public class Teacher_information {
    private String user_id;
    private String staff_id;
    private String name;
    private String email;
    private String password;
    private String verification_code;
    private Date validation_code_update_time;
    private String phone_number;
    private String qq;
    private boolean sex;
    private String head_image_uri;
    private boolean is_effective;

    public String getHead_image_uri() {
        return head_image_uri;
    }

    public void setHead_image_uri(String head_image_uri) {
        this.head_image_uri = head_image_uri;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getStaff_id() {
        return staff_id;
    }

    public void setStaff_id(String staff_id) {
        this.staff_id = staff_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Date getValidation_code_update_time() {
        return validation_code_update_time;
    }

    public void setValidation_code_update_time(Date validation_code_update_time) {
        this.validation_code_update_time = validation_code_update_time;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public boolean isIs_effective() {
        return is_effective;
    }

    public void setIs_effective(boolean is_effective) {
        this.is_effective = is_effective;
    }

    @Override
    public String toString() {
        return "Teacher_information{" +
                "user_id='" + user_id + '\'' +
                ", staff_id='" + staff_id + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", verification_code='" + verification_code + '\'' +
                ", validation_code_update_time=" + validation_code_update_time +
                ", phone_number='" + phone_number + '\'' +
                ", qq='" + qq + '\'' +
                ", sex=" + sex +
                ", head_image_uri='" + head_image_uri + '\'' +
                ", is_effective=" + is_effective +
                '}';
    }

    public Teacher_information(String user_id, String staff_id, String name, String email, String password, String verification_code, Date validation_code_update_time, String phone_number, String qq, boolean sex, String head_image_uri, boolean is_effective) {
        this.user_id = user_id;
        this.staff_id = staff_id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.verification_code = verification_code;
        this.validation_code_update_time = validation_code_update_time;
        this.phone_number = phone_number;
        this.qq = qq;
        this.sex = sex;
        this.head_image_uri = head_image_uri;
        this.is_effective = is_effective;
    }

    public Teacher_information() {
    }
}
