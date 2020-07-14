package com.neusoft.bsp_backend.order.entity;

import com.neusoft.bsp_backend.common.base.BaseEntity;

import java.util.Date;

public class MonitorResult  implements BaseEntity<Integer> {

    int mor_id;
    String class_name;
    String json_string;
    Date create_date;
    String create_by;
    Date update_date;
    String update_by;
    String remark;
    char sts_cd;

    @Override
    public Integer getId() {
        return mor_id;
    }

    public int getMor_id() {
        return mor_id;
    }

    public void setMor_id(int mor_id) {
        this.mor_id = mor_id;
    }

    public String getClass_name() {
        return class_name;
    }

    public void setClass_name(String class_name) {
        this.class_name = class_name;
    }

    public String getJson_string() {
        return json_string;
    }

    public void setJson_string(String json_string) {
        this.json_string = json_string;
    }

    public Date getCreate_date() {
        return create_date;
    }

    public void setCreate_date(Date create_date) {
        this.create_date = create_date;
    }

    public String getCreate_by() {
        return create_by;
    }

    public void setCreate_by(String create_by) {
        this.create_by = create_by;
    }

    public Date getUpdate_date() {
        return update_date;
    }

    public void setUpdate_date(Date update_date) {
        this.update_date = update_date;
    }

    public String getUpdate_by() {
        return update_by;
    }

    public void setUpdate_by(String update_by) {
        this.update_by = update_by;
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
        return "MonitorResult{" +
                "mor_id=" + mor_id +
                ", class_name='" + class_name + '\'' +
                ", json_string='" + json_string + '\'' +
                ", create_date=" + create_date +
                ", create_by='" + create_by + '\'' +
                ", update_date=" + update_date +
                ", update_by='" + update_by + '\'' +
                ", remark='" + remark + '\'' +
                ", sts_cd=" + sts_cd +
                '}';
    }
}
