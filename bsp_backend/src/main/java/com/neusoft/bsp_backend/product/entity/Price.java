package com.neusoft.bsp_backend.product.entity;

import com.neusoft.bsp_backend.common.base.BaseEntity;

import java.math.BigDecimal;
import java.util.Date;

public class Price implements BaseEntity<Integer> {

    int ofp_id;
    int pro_id;
    Date effective_start_date;
    Date effective_end_date;
    BigDecimal price;

    public int getOfp_id() {
        return ofp_id;
    }

    public void setOfp_id(int ofp_id) {
        this.ofp_id = ofp_id;
    }

    public int getPro_id() {
        return pro_id;
    }

    public void setPro_id(int pro_id) {
        this.pro_id = pro_id;
    }

    public Date getEffective_start_date() {
        return effective_start_date;
    }

    public void setEffective_start_date(Date effetive_start_date) {
        this.effective_start_date = effetive_start_date;
    }

    public Date getEffective_end_date() {
        return effective_end_date;
    }

    public void setEffective_end_date(Date effective_end_date) {
        this.effective_end_date = effective_end_date;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Price{" +
                "ofp_id=" + ofp_id +
                ", pro_id=" + pro_id +
                ", effetive_start_date=" + effective_start_date +
                ", effective_end_date=" + effective_end_date +
                ", price=" + price +
                '}';
    }

    @Override
    public Integer getId() {
        return ofp_id;
    }
}
