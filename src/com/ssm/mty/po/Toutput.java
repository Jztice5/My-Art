package com.ssm.mty.po;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

public class Toutput {

    private String id;
    private String no;
    private String name;
    private String category;
    private String material;
    private Integer quantity;
    private String applyTime;
    private String applyStatus;

    public void setId(String value) {
        this.id = value;
    }
    public String getId() {
       return this.id;
    }
    public void setNo(String value) {
        this.no = value;
    }
    public String getNo() {
       return this.no;
    }
    public void setName(String value) {
        this.name = value;
    }
    public String getName() {
       return this.name;
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
    public void setApplyStatus(String value) {
        this.applyStatus = value;
    }
    public String getApplyStatus() {
       return this.applyStatus;
    }

    public String getApplyTime() {
        return applyTime;
    }

    public void setApplyTime(String applyTime) {
        this.applyTime = applyTime;
    }
}
