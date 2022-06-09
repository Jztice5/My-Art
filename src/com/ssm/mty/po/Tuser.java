package com.ssm.mty.po;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

public class Tuser {

    private String id;
    private String type;
    private String username;
    private String password;
    private String sex;
    private String phone;
    private String passwords;

    public void setId(String value) {
        this.id = value;
    }
    public String getId() {
       return this.id;
    }
    public void setType(String value) {
        this.type = value;
    }
    public String getType() {
       return this.type;
    }
    public void setUsername(String value) {
        this.username = value;
    }
    public String getUsername() {
       return this.username;
    }
    public void setPassword(String value) {
        this.password = value;
    }
    public String getPassword() {
       return this.password;
    }
    public void setSex(String value) {
        this.sex = value;
    }
    public String getSex() {
       return this.sex;
    }
    public void setPhone(String value) {
        this.phone = value;
    }
    public String getPhone() {
       return this.phone;
    }

    public String getPasswords() {
        return passwords;
    }

    public void setPasswords(String passwords) {
        this.passwords = passwords;
    }
}
