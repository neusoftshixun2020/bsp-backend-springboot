package com.neusoft.bsp_backend.order.entity;

import com.neusoft.bsp_backend.common.base.BaseEntity;

import java.util.Date;

public class GovernmentArea implements BaseEntity<Integer> {

    int goa_id;
    String zip_code;
    String state;
    String state_shorthand;
    String city;
    String created_by;
    Date creation_date;
    String last_update_by;
    int call_cnt;
    Date last_update_date;
    String remark;
    char sts_cd;

    @Override
    public Integer getId() {
        return goa_id;
    }

    public int getGoa_id() {
        return goa_id;
    }

    public void setGoa_id(int goa_id) {
        this.goa_id = goa_id;
    }

    public String getZip_code() {
        return zip_code;
    }

    public void setZip_code(String zip_code) {
        this.zip_code = zip_code;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getState_shorthand() {
        return state_shorthand;
    }

    public void setState_shorthand(String state_shorthand) {
        this.state_shorthand = state_shorthand;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
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

    public char getSts_cd() {
        return sts_cd;
    }

    public void setSts_cd(char sts_cd) {
        this.sts_cd = sts_cd;
    }

    @Override
    public String toString() {
        return "GovernmentArea{" +
                "goa_id=" + goa_id +
                ", zip_code='" + zip_code + '\'' +
                ", state='" + state + '\'' +
                ", state_shorthand='" + state_shorthand + '\'' +
                ", city='" + city + '\'' +
                ", created_by='" + created_by + '\'' +
                ", creation_date=" + creation_date +
                ", last_update_by='" + last_update_by + '\'' +
                ", call_cnt=" + call_cnt +
                ", last_update_date=" + last_update_date +
                ", remark='" + remark + '\'' +
                ", sts_cd=" + sts_cd +
                '}';
    }
}
