package com.ssm.mty.po;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

public class Tinput {

    private String id;
    private String category;
    private String material;
    private Integer quantity;
    private String money;
    private String purseTime;
    private String purseId;
    private String registerTime;
    private String registerId;

    public void setId(String value) {
        this.id = value;
    }
    public String getId() {
       return this.id;
    }
    public void setCategory(String value) {
        this.category = value;
    }
    public String getCategory() {
       return this.category;
    }
    public void setMaterial(String value) {
        this.material = value;
    }
    public String getMaterial() {
       return this.material;
    }
    public void setQuantity(Integer value) {
        this.quantity = value;
    }
    public Integer getQuantity() {
       return this.quantity;
    }
    public void setMoney(String value) {
        this.money = value;
    }
    public String getMoney() {
       return this.money;
    }
    public void setPurseId(String value) {
        this.purseId = value;
    }
    public String getPurseId() {
       return this.purseId;
    }
    public void setRegisterId(String value) {
        this.registerId = value;
    }
    public String getRegisterId() {
       return this.registerId;
    }

    public String getPurseTime() {
        return purseTime;
    }

    public void setPurseTime(String purseTime) {
        this.purseTime = purseTime;
    }

    public String getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(String registerTime) {
        this.registerTime = registerTime;
    }
}
