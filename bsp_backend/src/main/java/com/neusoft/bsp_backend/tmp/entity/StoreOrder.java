package com.neusoft.bsp_backend.tmp.entity;

import com.neusoft.bsp_backend.common.base.BaseEntity;

import java.util.Date;

public class StoreOrder implements BaseEntity<Integer> {

    int sto_id;
    int str_id;
    String order_id;
    String order_created_time;
    String paid_time;
    String last_modified_time;
    String created_by;
    Date creation_date;
    String last_update_by;
    Date last_update_date;
    int call_cnt;
    String remark;
    char sts_cd;
    String plateform_type;
    String cancel_complete_date;

    @Override
    public Integer getId() {
        return sto_id;
    }

    public int getSto_id() {
        return sto_id;
    }

    public void setSto_id(int sto_id) {
        this.sto_id = sto_id;
    }

    public int getStr_id() {
        return str_id;
    }

    public void setStr_id(int str_id) {
        this.str_id = str_id;
    }

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public String getOrder_created_time() {
        return order_created_time;
    }

    public void setOrder_created_time(String order_created_time) {
        this.order_created_time = order_created_time;
    }

    public String getPaid_time() {
        return paid_time;
    }

    public void setPaid_time(String paid_time) {
        this.paid_time = paid_time;
    }

    public String getLast_modified_time() {
        return last_modified_time;
    }

    public void setLast_modified_time(String last_modified_time) {
        this.last_modified_time = last_modified_time;
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public char getSts_cd() {
        return sts_cd;
    }

    public void setSts_cd(char sts_cd) {
        this.sts_cd = sts_cd;
    }

    public String getPlateform_type() {
        return plateform_type;
    }

    public void setPlateform_type(String plateform_type) {
        this.plateform_type = plateform_type;
    }

    public String getCancel_complete_date() {
        return cancel_complete_date;
    }

    public void setCancel_complete_date(String cancel_complete_date) {
        this.cancel_complete_date = cancel_complete_date;
    }
}
