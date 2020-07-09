package com.neusoft.bsp_backend.bvo.entity;

import com.neusoft.bsp_backend.common.base.BaseEntity;

import java.math.BigDecimal;
import java.util.Date;

public class StoreDropShipItem implements BaseEntity<Integer> {

    int dil_id;
    int pro_id;
    int str_id;
    int store_retention;
    BigDecimal dropship_price;
    String dropship_status;
    String created_by;
    Date creation_date;
    String last_update_by;
    int call_cnt;
    Date last_update_date;
    String remark;
    String sts_cd;
    int shelf_stock;
    Date prefer_date;

    public int getDil_id() {
        return dil_id;
    }

    public void setDil_id(int dil_id) {
        this.dil_id = dil_id;
    }

    public int getPro_id() {
        return pro_id;
    }

    public void setPro_id(int pro_id) {
        this.pro_id = pro_id;
    }

    public int getStr_id() {
        return str_id;
    }

    public void setStr_id(int str_id) {
        this.str_id = str_id;
    }

    public int getStore_retention() {
        return store_retention;
    }

    public void setStore_retention(int store_retention) {
        this.store_retention = store_retention;
    }

    public BigDecimal getDropship_price() {
        return dropship_price;
    }

    public void setDropship_price(BigDecimal dropship_price) {
        this.dropship_price = dropship_price;
    }

    public String getDropship_status() {
        return dropship_status;
    }

    public void setDropship_status(String dropship_status) {
        this.dropship_status = dropship_status;
    }

    public String getCreated_by() {
        return created_by;
    }

    public void setCreated_by(String created_by) {
        this.created_by = created_by;
    }

    public Date getCreation_date() {
        return creation_date;
    }

    public void setCreation_date(Date creation_date) {
        this.creation_date = creation_date;
    }

    public String getLast_update_by() {
        return last_update_by;
    }

    public void setLast_update_by(String last_update_by) {
        this.last_update_by = last_update_by;
    }

    public int getCall_cnt() {
        return call_cnt;
    }

    public void setCall_cnt(int call_cnt) {
        this.call_cnt = call_cnt;
    }

    public Date getLast_update_date() {
        return last_update_date;
    }

    public void setLast_update_date(Date last_update_date) {
        this.last_update_date = last_update_date;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getSts_cd() {
        return sts_cd;
    }

    public void setSts_cd(String sts_cd) {
        this.sts_cd = sts_cd;
    }

    public int getShelf_stock() {
        return shelf_stock;
    }

    public void setShelf_stock(int shelf_stock) {
        this.shelf_stock = shelf_stock;
    }

    public Date getPrefer_date() {
        return prefer_date;
    }

    public void setPrefer_date(Date prefer_date) {
        this.prefer_date = prefer_date;
    }

    @Override
    public String toString() {
        return "StoreDropShipItem{" +
                "dil_id=" + dil_id +
                ", pro_id=" + pro_id +
                ", str_id=" + str_id +
                ", store_retention=" + store_retention +
                ", dropship_price=" + dropship_price +
                ", dropship_status='" + dropship_status + '\'' +
                ", created_by='" + created_by + '\'' +
                ", creation_date=" + creation_date +
                ", last_update_by='" + last_update_by + '\'' +
                ", call_cnt=" + call_cnt +
                ", last_update_date=" + last_update_date +
                ", remark='" + remark + '\'' +
                ", sts_cd='" + sts_cd + '\'' +
                ", shelf_stock=" + shelf_stock +
                ", prefer_date=" + prefer_date +
                '}';
    }

    @Override
    public Integer getId() {
        return null;
    }
}
