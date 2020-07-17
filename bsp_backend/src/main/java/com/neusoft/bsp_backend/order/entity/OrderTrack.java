package com.neusoft.bsp_backend.order.entity;

import com.neusoft.bsp_backend.common.base.BaseEntity;

import java.util.Date;

public class OrderTrack implements BaseEntity<String> {
    String track_no;
    String start;
    Date start_time;
    String address1;
    String address2;
    String address3;
    Date update_time1;
    Date update_time2;
    Date update_time3;
    String destination;
    Date end_time;

    public String getTrack_no() {
        return track_no;
    }

    public void setTrack_no(String track_no) {
        this.track_no = track_no;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public Date getStart_time() {
        return start_time;
    }

    public void setStart_time(Date start_time) {
        this.start_time = start_time;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getAddress3() {
        return address3;
    }

    public void setAddress3(String address3) {
        this.address3 = address3;
    }

    public Date getUpdate_time1() {
        return update_time1;
    }

    public void setUpdate_time1(Date update_time1) {
        this.update_time1 = update_time1;
    }

    public Date getUpdate_time2() {
        return update_time2;
    }

    public void setUpdate_time2(Date update_time2) {
        this.update_time2 = update_time2;
    }

    public Date getUpdate_time3() {
        return update_time3;
    }

    public void setUpdate_time3(Date update_time3) {
        this.update_time3 = update_time3;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Date getEnd_time() {
        return end_time;
    }

    public void setEnd_time(Date end_time) {
        this.end_time = end_time;
    }

    @Override
    public String toString() {
        return "OrderTrack{" +
                "track_no='" + track_no + '\'' +
                ", start='" + start + '\'' +
                ", start_time=" + start_time +
                ", address1='" + address1 + '\'' +
                ", address2='" + address2 + '\'' +
                ", address3='" + address3 + '\'' +
                ", update_time1=" + update_time1 +
                ", update_time2=" + update_time2 +
                ", update_time3=" + update_time3 +
                ", destination='" + destination + '\'' +
                ", end_time=" + end_time +
                '}';
    }

    @Override
    public String getId() {
        return null;
    }
}
