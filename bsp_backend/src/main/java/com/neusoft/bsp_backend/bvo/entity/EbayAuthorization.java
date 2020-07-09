package com.neusoft.bsp_backend.bvo.entity;

import com.neusoft.bsp_backend.common.base.BaseEntity;

import java.util.Date;

public class EbayAuthorization implements BaseEntity<Integer> {

    int eba_id;
    int str_id;
    String app_id;
    String secret_key;
    String token;
    String created_by;
    Date creation_date;
    String last_update_by;
    Date last_update_date;
    int call_cnt;
    String remark;
    String sts_cd;
    Date exp_date;
    Date cancle_date;
    String account_id;

    public int getEba_id() {
        return eba_id;
    }

    public void setEba_id(int eba_id) {
        this.eba_id = eba_id;
    }

    public int getStr_id() {
        return str_id;
    }

    public void setStr_id(int str_id) {
        this.str_id = str_id;
    }

    public String getApp_id() {
        return app_id;
    }

    public void setApp_id(String app_id) {
        this.app_id = app_id;
    }

    public String getSecret_key() {
        return secret_key;
    }

    public void setSecret_key(String secret_key) {
        this.secret_key = secret_key;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
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

    public Date getExp_date() {
        return exp_date;
    }

    public void setExp_date(Date exp_date) {
        this.exp_date = exp_date;
    }

    public Date getCancle_date() {
        return cancle_date;
    }

    public void setCancle_date(Date cancle_date) {
        this.cancle_date = cancle_date;
    }

    public String getAccount_id() {
        return account_id;
    }

    public void setAccount_id(String account_id) {
        this.account_id = account_id;
    }

    @Override
    public String toString() {
        return "EbayAuthorization{" +
                "eba_id=" + eba_id +
                ", str_id=" + str_id +
                ", app_id='" + app_id + '\'' +
                ", secret_key='" + secret_key + '\'' +
                ", token='" + token + '\'' +
                ", created_by='" + created_by + '\'' +
                ", creation_date=" + creation_date +
                ", last_update_by='" + last_update_by + '\'' +
                ", last_update_date=" + last_update_date +
                ", call_cnt=" + call_cnt +
                ", remark='" + remark + '\'' +
                ", sts_cd='" + sts_cd + '\'' +
                ", exp_date=" + exp_date +
                ", cancle_date=" + cancle_date +
                ", account_id='" + account_id + '\'' +
                '}';
    }

    @Override
    public Integer getId() {
        return null;
    }
}
