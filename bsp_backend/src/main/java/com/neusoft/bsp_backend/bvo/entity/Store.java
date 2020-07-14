package com.neusoft.bsp_backend.bvo.entity;

import com.neusoft.bsp_backend.common.base.BaseEntity;

import java.util.Date;

public class Store implements BaseEntity<Integer> {

    int str_id;
    int dsr_id;
    String platform_type;
    String store_name;
    String store_sts_cd;
    String created_by;
    Date creation_date;
    String last_update_by;
    Date last_update_date;
    int call_cnt;
    String sts_cd;
    String remark;

    public int getStr_id() {
        return str_id;
    }

    public void setStr_id(int str_id) {
        this.str_id = str_id;
    }

    public int getDsr_id() {
        return dsr_id;
    }

    public void setDsr_id(int dsr_id) {
        this.dsr_id = dsr_id;
    }

    public String getPlatform_type() {
        return platform_type;
    }

    public void setPlatform_type(String plataeform_type) {
        this.platform_type = plataeform_type;
    }

    public String getStore_name() {
        return store_name;
    }

    public void setStore_name(String store_name) {
        this.store_name = store_name;
    }

    public String getStore_sts_cd() {
        return store_sts_cd;
    }

    public void setStore_sts_cd(String store_sts_cd) {
        this.store_sts_cd = store_sts_cd;
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

    public Date getLast_update_date() {
        return last_update_date;
    }

    public void setLast_update_date(Date last_update_date) {
        this.last_update_date = last_update_date;
    }

    public int getCall_cnt() {
        return call_cnt;
    }

    public void setCall_cnt(int call_cnt) {
        this.call_cnt = call_cnt;
    }

    public String getSts_cd() {
        return sts_cd;
    }

    public void setSts_cd(String sts_cd) {
        this.sts_cd = sts_cd;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "Store{" +
                "str_id=" + str_id +
                ", dsr_id=" + dsr_id +
                ", plataeform_type='" + platform_type + '\'' +
                ", store_name='" + store_name + '\'' +
                ", store_sts_cd='" + store_sts_cd + '\'' +
                ", created_by='" + created_by + '\'' +
                ", creation_date=" + creation_date +
                ", last_update_by='" + last_update_by + '\'' +
                ", last_update_date=" + last_update_date +
                ", call_cnt=" + call_cnt +
                ", sts_cd='" + sts_cd + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }

    @Override
    public Integer getId() {
        return null;
    }
}
