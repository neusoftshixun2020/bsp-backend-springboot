package com.neusoft.bsp_backend.order.entity;

import com.neusoft.bsp_backend.common.base.BaseEntity;

import java.math.BigDecimal;
import java.util.Date;

public class StoreOrderLineItem implements BaseEntity<Integer> {

    int sol_id;
    String order_item_id;
    int sto_id;
    BigDecimal sales_price;
    int qty;
    String sku_no;
    String created_by;
    Date creation_date;
    String last_update_by;
    Date last_update_date;
    int call_cnt;
    String remark;
    char sts_cd;
    String buyer_checkout_message;

    @Override
    public Integer getId() {
        return sol_id;
    }

    public int getSol_id() {
        return sol_id;
    }

    public void setSol_id(int sol_id) {
        this.sol_id = sol_id;
    }

    public String getOrder_item_id() {
        return order_item_id;
    }

    public void setOrder_item_id(String order_item_id) {
        this.order_item_id = order_item_id;
    }

    public int getSto_id() {
        return sto_id;
    }

    public void setSto_id(int sto_id) {
        this.sto_id = sto_id;
    }

    public BigDecimal getSales_price() {
        return sales_price;
    }

    public void setSales_price(BigDecimal sales_price) {
        this.sales_price = sales_price;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public String getSku_no() {
        return sku_no;
    }

    public void setSku_no(String sku_no) {
        this.sku_no = sku_no;
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

    public String getBuyer_checkout_message() {
        return buyer_checkout_message;
    }

    public void setBuyer_checkout_message(String buyer_checkout_message) {
        this.buyer_checkout_message = buyer_checkout_message;
    }

    @Override
    public String toString() {
        return "StoreOrderLineItem{" +
                "sol_id=" + sol_id +
                ", order_item_id='" + order_item_id + '\'' +
                ", sto_id=" + sto_id +
                ", sales_price=" + sales_price +
                ", qty=" + qty +
                ", sku_no='" + sku_no + '\'' +
                ", created_by='" + created_by + '\'' +
                ", creation_date=" + creation_date +
                ", last_update_by='" + last_update_by + '\'' +
                ", last_update_date=" + last_update_date +
                ", call_cnt=" + call_cnt +
                ", remark='" + remark + '\'' +
                ", sts_cd=" + sts_cd +
                ", buyer_checkout_message='" + buyer_checkout_message + '\'' +
                '}';
    }
}
