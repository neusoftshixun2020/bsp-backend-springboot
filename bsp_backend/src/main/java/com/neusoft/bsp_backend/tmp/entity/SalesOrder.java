package com.neusoft.bsp_backend.tmp.entity;

import com.neusoft.bsp_backend.common.base.BaseEntity;

import java.math.BigDecimal;
import java.util.Date;

public class SalesOrder implements BaseEntity<Integer> {

    int sao_id;
    String created_by;
    Date creation_date;
    String last_update_by;
    Date last_update_date;
    int call_cnt;
    String remark;
    char sts_cd;
    int man_id;
    int war_id;
    Date sync_date;
    Date payment_date;
    Date push_date;
    Date track_no_date;
    Date fulfillment_date;
    Date settlement_date;
    BigDecimal product_amount;
    BigDecimal freight_cost;
    BigDecimal handling_fee;
    String customer_remark;
    String order_no;
    String order_sts;
    String refund_sts;
    String delivery_sts;
    int sto_id;
    BigDecimal last_freight_cost;
    Date cancle_time;
    String auto_pay_status;
    String buyer_checkout_message;
    String auto_pay_time;

    @Override
    public Integer getId() {
        return sao_id;
    }

    public int getSao_id() {
        return sao_id;
    }

    public void setSao_id(int sao_id) {
        this.sao_id = sao_id;
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

    public int getMan_id() {
        return man_id;
    }

    public void setMan_id(int man_id) {
        this.man_id = man_id;
    }

    public int getWar_id() {
        return war_id;
    }

    public void setWar_id(int war_id) {
        this.war_id = war_id;
    }

    public Date getSync_date() {
        return sync_date;
    }

    public void setSync_date(Date sync_date) {
        this.sync_date = sync_date;
    }

    public Date getPayment_date() {
        return payment_date;
    }

    public void setPayment_date(Date payment_date) {
        this.payment_date = payment_date;
    }

    public Date getPush_date() {
        return push_date;
    }

    public void setPush_date(Date push_date) {
        this.push_date = push_date;
    }

    public Date getTrack_no_date() {
        return track_no_date;
    }

    public void setTrack_no_date(Date track_no_date) {
        this.track_no_date = track_no_date;
    }

    public Date getFulfillment_date() {
        return fulfillment_date;
    }

    public void setFulfillment_date(Date fulfillment_date) {
        this.fulfillment_date = fulfillment_date;
    }

    public Date getSettlement_date() {
        return settlement_date;
    }

    public void setSettlement_date(Date settlement_date) {
        this.settlement_date = settlement_date;
    }

    public BigDecimal getProduct_amount() {
        return product_amount;
    }

    public void setProduct_amount(BigDecimal product_amount) {
        this.product_amount = product_amount;
    }

    public BigDecimal getFreight_cost() {
        return freight_cost;
    }

    public void setFreight_cost(BigDecimal freight_cost) {
        this.freight_cost = freight_cost;
    }

    public BigDecimal getHandling_fee() {
        return handling_fee;
    }

    public void setHandling_fee(BigDecimal handling_fee) {
        this.handling_fee = handling_fee;
    }

    public String getCustomer_remark() {
        return customer_remark;
    }

    public void setCustomer_remark(String customer_remark) {
        this.customer_remark = customer_remark;
    }

    public String getOrder_no() {
        return order_no;
    }

    public void setOrder_no(String order_no) {
        this.order_no = order_no;
    }

    public String getOrder_sts() {
        return order_sts;
    }

    public void setOrder_sts(String order_sts) {
        this.order_sts = order_sts;
    }

    public String getRefund_sts() {
        return refund_sts;
    }

    public void setRefund_sts(String refund_sts) {
        this.refund_sts = refund_sts;
    }

    public String getDelivery_sts() {
        return delivery_sts;
    }

    public void setDelivery_sts(String delivery_sts) {
        this.delivery_sts = delivery_sts;
    }

    public int getSto_id() {
        return sto_id;
    }

    public void setSto_id(int sto_id) {
        this.sto_id = sto_id;
    }

    public BigDecimal getLast_freight_cost() {
        return last_freight_cost;
    }

    public void setLast_freight_cost(BigDecimal last_freight_cost) {
        this.last_freight_cost = last_freight_cost;
    }

    public Date getCancle_time() {
        return cancle_time;
    }

    public void setCancle_time(Date cancle_time) {
        this.cancle_time = cancle_time;
    }

    public String getAuto_pay_status() {
        return auto_pay_status;
    }

    public void setAuto_pay_status(String auto_pay_status) {
        this.auto_pay_status = auto_pay_status;
    }

    public String getBuyer_checkout_message() {
        return buyer_checkout_message;
    }

    public void setBuyer_checkout_message(String buyer_checkout_message) {
        this.buyer_checkout_message = buyer_checkout_message;
    }

    public String getAuto_pay_time() {
        return auto_pay_time;
    }

    public void setAuto_pay_time(String auto_pay_time) {
        this.auto_pay_time = auto_pay_time;
    }
}
