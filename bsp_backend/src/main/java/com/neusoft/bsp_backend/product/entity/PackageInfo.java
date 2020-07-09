package com.neusoft.bsp_backend.product.entity;

import com.neusoft.bsp_backend.common.base.BaseEntity;

import java.math.BigDecimal;

public class PackageInfo implements BaseEntity<Integer> {
    int pck_id;
    int pro_id;
    BigDecimal width;
    BigDecimal height;
    BigDecimal length;
    BigDecimal weight;

    public int getPck_id() {
        return pck_id;
    }

    public void setPck_id(int pck_id) {
        this.pck_id = pck_id;
    }

    public int getPro_id() {
        return pro_id;
    }

    public void setPro_id(int pro_id) {
        this.pro_id = pro_id;
    }

    public BigDecimal getWidth() {
        return width;
    }

    public void setWidth(BigDecimal width) {
        this.width = width;
    }

    public BigDecimal getHeight() {
        return height;
    }

    public void setHeight(BigDecimal height) {
        this.height = height;
    }

    public BigDecimal getLength() {
        return length;
    }

    public void setLength(BigDecimal length) {
        this.length = length;
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "PackageInfo{" +
                "pck_id=" + pck_id +
                ", pro_id=" + pro_id +
                ", width=" + width +
                ", height=" + height +
                ", length=" + length +
                ", weight=" + weight +
                '}';
    }

    @Override
    public Integer getId() {
        return null;
    }
}
