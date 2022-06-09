package com.ssm.mty.po;


import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

public class Tpurchase {

    private String id;
    private String category;
    private String material;
    private Integer quantity;
    private String unitPrice;
    private String purseTime;
    private String purseId;

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
    public void setUnitPrice(String value) {
        this.unitPrice = value;
    }
    public String getUnitPrice() {
       return this.unitPrice;
    }
    public void setPurseId(String value) {
        this.purseId = value;
    }
    public String getPurseId() {
       return this.purseId;
    }

    public String getPurseTime() {
        return purseTime;
    }

    public void setPurseTime(String purseTime) {
        this.purseTime = purseTime;
    }
}
