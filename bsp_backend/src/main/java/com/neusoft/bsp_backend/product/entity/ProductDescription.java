package com.neusoft.bsp_backend.product.entity;

import com.neusoft.bsp_backend.common.base.BaseEntity;

public class ProductDescription implements BaseEntity<String> {
    int pdn_id;
    int pro_id;
    String description;

    public int getPdn_id() {
        return pdn_id;
    }

    public void setPdn_id(int pdn_id) {
        this.pdn_id = pdn_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPro_id() {
        return pro_id;
    }

    public void setPro_id(int pro_id) {
        this.pro_id = pro_id;
    }

    @Override
    public String toString() {
        return "ProductDescription{" +
                "pro_id=" + pro_id +
                ", description='" + description + '\'' +
                '}';
    }

    @Override
    public String getId() {
        return null;
    }
}
