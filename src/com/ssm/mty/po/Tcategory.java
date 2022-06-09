package com.ssm.mty.po;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

public class Tcategory {

    private String id;
    private String code;
    private String name;
    private String description;

    public void setId(String value) {
        this.id = value;
    }
    public String getId() {
       return this.id;
    }
    public void setCode(String value) {
        this.code = value;
    }
    public String getCode() {
       return this.code;
    }
    public void setName(String value) {
        this.name = value;
    }
    public String getName() {
       return this.name;
    }
    public void setDescription(String value) {
        this.description = value;
    }
    public String getDescription() {
       return this.description;
    }
}
