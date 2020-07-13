package com.neusoft.bsp_backend.order.entity;

import java.util.Date;

public class ShippingAddress  {

    String created_by;
    Date creation_date;
    String last_update_by;
    Date last_update_date;
    int call_cnt;
    String remark;
    char sts_cd;
    String family_name;
    String given_name;
    String country_name;
    String country_iso_cd;
    String state_or_province_name;
    String state_or_province_cd;
    String city_name;
    String address_line1;
    String address_line2;
    String address_line3;
    String postal_cd;
    String contact_phone_no;
    String email;
    int sto_id;
    String carrier_name;

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

    public String getFamily_name() {
        return family_name;
    }

    public void setFamily_name(String family_name) {
        this.family_name = family_name;
    }

    public String getGiven_name() {
        return given_name;
    }

    public void setGiven_name(String given_name) {
        this.given_name = given_name;
    }

    public String getCountry_name() {
        return country_name;
    }

    public void setCountry_name(String country_name) {
        this.country_name = country_name;
    }

    public String getCountry_iso_cd() {
        return country_iso_cd;
    }

    public void setCountry_iso_cd(String country_iso_cd) {
        this.country_iso_cd = country_iso_cd;
    }

    public String getState_or_province_name() {
        return state_or_province_name;
    }

    public void setState_or_province_name(String state_or_province_name) {
        this.state_or_province_name = state_or_province_name;
    }

    public String getState_or_province_cd() {
        return state_or_province_cd;
    }

    public void setState_or_province_cd(String state_or_province_cd) {
        this.state_or_province_cd = state_or_province_cd;
    }

    public String getCity_name() {
        return city_name;
    }

    public void setCity_name(String city_name) {
        this.city_name = city_name;
    }

    public String getAddress_line1() {
        return address_line1;
    }

    public void setAddress_line1(String address_line1) {
        this.address_line1 = address_line1;
    }

    public String getAddress_line2() {
        return address_line2;
    }

    public void setAddress_line2(String address_line2) {
        this.address_line2 = address_line2;
    }

    public String getAddress_line3() {
        return address_line3;
    }

    public void setAddress_line3(String address_line3) {
        this.address_line3 = address_line3;
    }

    public String getPostal_cd() {
        return postal_cd;
    }

    public void setPostal_cd(String postal_cd) {
        this.postal_cd = postal_cd;
    }

    public String getContact_phone_no() {
        return contact_phone_no;
    }

    public void setContact_phone_no(String contact_phone_no) {
        this.contact_phone_no = contact_phone_no;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getSto_id() {
        return sto_id;
    }

    public void setSto_id(int sto_id) {
        this.sto_id = sto_id;
    }

    public String getCarrier_name() {
        return carrier_name;
    }

    public void setCarrier_name(String carrier_name) {
        this.carrier_name = carrier_name;
    }

    @Override
    public String toString() {
        return "ShippingAddress{" +
                "created_by='" + created_by + '\'' +
                ", creation_date=" + creation_date +
                ", last_update_by='" + last_update_by + '\'' +
                ", last_update_date=" + last_update_date +
                ", call_cnt=" + call_cnt +
                ", remark='" + remark + '\'' +
                ", sts_cd=" + sts_cd +
                ", family_name='" + family_name + '\'' +
                ", given_name='" + given_name + '\'' +
                ", country_name='" + country_name + '\'' +
                ", country_iso_cd='" + country_iso_cd + '\'' +
                ", state_or_province_name='" + state_or_province_name + '\'' +
                ", state_or_province_cd='" + state_or_province_cd + '\'' +
                ", city_name='" + city_name + '\'' +
                ", address_line1='" + address_line1 + '\'' +
                ", address_line2='" + address_line2 + '\'' +
                ", address_line3='" + address_line3 + '\'' +
                ", postal_cd='" + postal_cd + '\'' +
                ", contact_phone_no='" + contact_phone_no + '\'' +
                ", email='" + email + '\'' +
                ", sto_id=" + sto_id +
                ", carrier_name='" + carrier_name + '\'' +
                '}';
    }
}
