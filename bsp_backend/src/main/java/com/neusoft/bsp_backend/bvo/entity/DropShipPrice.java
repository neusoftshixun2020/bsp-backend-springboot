package com.neusoft.bsp_backend.bvo.entity;

import com.neusoft.bsp_backend.common.base.BaseEntity;

import java.util.Date;

public class DropShipPrice implements BaseEntity<Integer> {

    int drp_id;
    int ofp_id;
    int dsr_id;
    int war_id;
    String created_by;
    Date creation_date;
    String last_update_by;
    Date last_update_date;
    int call_cnt;
    String remark;
    String sts_cd;

    public int getDrp_id() {
        return drp_id;
    }

    public void setDrp_id(int drp_id) {
        this.drp_id = drp_id;
    }

    public int getOfp_id() {
        return ofp_id;
    }

    public void setOfp_id(int ofp_id) {
        this.ofp_id = ofp_id;
    }

    public int getDsr_id() {
        return dsr_id;
    }

    public void setDsr_id(int dsr_id) {
        this.dsr_id = dsr_id;
    }

    public int getWar_id() {
        return war_id;
    }

    public void setWar_id(int war_id) {
        this.war_id = war_id;
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

    public String getSts_cd() {
        return sts_cd;
    }

    public void setSts_cd(String sts_cd) {
        this.sts_cd = sts_cd;
    }

    @Override
    public String toString() {
        return "DropShipPrice{" +
                "drp_id=" + drp_id +
                ", ofp_id=" + ofp_id +
                ", dsr_id=" + dsr_id +
                ", war_id=" + war_id +
                ", created_by='" + created_by + '\'' +
                ", creation_date=" + creation_date +
                ", last_update_by='" + last_update_by + '\'' +
                ", last_update_date=" + last_update_date +
                ", call_cnt=" + call_cnt +
                ", remark='" + remark + '\'' +
                ", sts_cd='" + sts_cd + '\'' +
                '}';
    }

    @Override
    public Integer getId() {
        return null;
    }
}
