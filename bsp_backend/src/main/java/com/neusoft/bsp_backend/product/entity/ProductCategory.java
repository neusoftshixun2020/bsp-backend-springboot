package com.neusoft.bsp_backend.product.entity;

import com.neusoft.bsp_backend.common.base.BaseEntity;
import java.sql.Timestamp;
import java.util.Date;

public class ProductCategory implements BaseEntity<Integer> {
    int prc_id;
    String category_id;
    String category_name;
    String category_path;
    String created_by;
    Date creation_date;
    String last_update_by;
    Date last_update_date;
    int call_cnt;
    int pro_num;
    String remark;
    String plateform_type;
    String product_status;
    String img_url;

    @Override
    public Integer getId() {
        return prc_id;
    }

    public int getPrc_id() {
        return prc_id;
    }

    public void setPrc_id(int prc_id) {
        this.prc_id = prc_id;
    }

    public String getCategory_id() {
        return category_id;
    }

    public void setCategory_id(String category_id) {
        this.category_id = category_id;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    public String getCategory_path() {
        return category_path;
    }

    public void setCategory_path(String category_path) {
        this.category_path = category_path;
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

    public Date getLast_update_date() {
        return last_update_date;
    }

    public void setLast_update_date(Date last_update_date) {
        this.last_update_date = last_update_date;
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getPlateform_type() {
        return plateform_type;
    }

    public void setPlateform_type(String plateform_type) {
        this.plateform_type = plateform_type;
    }

    public String getProduct_status() {
        return product_status;
    }

    public void setProduct_status(String product_status) {
        this.product_status = product_status;
    }

    public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }

    public int getPro_num() {
        return pro_num;
    }

    public void setPro_num(int pro_num) {
        this.pro_num = pro_num;
    }

    @Override
    public String toString() {
        return "ProductCategory{" +
                "prc_id=" + prc_id +
                ", category_id='" + category_id + '\'' +
                ", category_name='" + category_name + '\'' +
                ", category_path='" + category_path + '\'' +
                ", created_by='" + created_by + '\'' +
                ", creation_date=" + creation_date +
                ", last_update_by='" + last_update_by + '\'' +
                ", last_update_date=" + last_update_date +
                ", call_cnt=" + call_cnt +
                ", remark='" + remark + '\'' +
                ", plateform_type='" + plateform_type + '\'' +
                ", product_status='" + product_status + '\'' +
                ", img_url='" + img_url + '\'' +
                '}';
    }
}
