package com.neusoft.bsp_backend.product.entity;

import com.neusoft.bsp_backend.common.base.BaseEntity;
import com.neusoft.bsp_backend.common.validationGroup.DeleteGroup;
import com.neusoft.bsp_backend.common.validationGroup.InsertGroup;
import com.neusoft.bsp_backend.common.validationGroup.SelectGroup;
import com.neusoft.bsp_backend.common.validationGroup.UpdateGroup;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

public class Product implements BaseEntity<Integer> {
    @NotNull(groups={InsertGroup.class, UpdateGroup.class, SelectGroup.class, DeleteGroup.class}, message = "proid should not be null")
    int pro_id;
    String sku_cd;
    int brd_id;
    int man_id;
    String title;
    String upc;
    String ean;
    String model;
    String warranty_day;
    int replenishment_period;
    String warranty;
    String time_unit;
    int img_id;
    int prc_id;
    ProductDescription productDescription;
    PackageInfo packageInfo;
    Price price;


    public Integer getId(){
        return pro_id;
    }

    public int getImg_id() {
        return img_id;
    }

    public void setImg_id(int img_id) {
        this.img_id = img_id;
    }

    public int getPrc_id() {
        return prc_id;
    }

    public void setPrc_id(int prc_id) {
        this.prc_id = prc_id;
    }

    public int getPro_id() {
        return pro_id;
    }

    public void setPro_id(int pro_id) {
        this.pro_id = pro_id;
    }

    public String getSku_cd() {
        return sku_cd;
    }

    public void setSku_cd(String sku_cd) {
        this.sku_cd = sku_cd;
    }

    public int getBrd_id() {
        return brd_id;
    }

    public void setBrd_id(int brd_id) {
        this.brd_id = brd_id;
    }

    public int getMan_id() {
        return man_id;
    }

    public void setMan_id(int man_id) {
        this.man_id = man_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUpc() {
        return upc;
    }

    public void setUpc(String upc) {
        this.upc = upc;
    }

    public String getEan() {
        return ean;
    }

    public void setEan(String ean) {
        this.ean = ean;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getWarranty_day() {
        return warranty_day;
    }

    public void setWarranty_day(String warranty_day) {
        this.warranty_day = warranty_day;
    }

    public int getReplenishment_period() {
        return replenishment_period;
    }

    public void setReplenishment_period(int replenishment_period) {
        this.replenishment_period = replenishment_period;
    }

    public String getWarranty() {
        return warranty;
    }

    public void setWarranty(String warranty) {
        this.warranty = warranty;
    }

    public String getTime_unit() {
        return time_unit;
    }

    public void setTime_unit(String time_unit) {
        this.time_unit = time_unit;
    }

    public ProductDescription getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(ProductDescription productDescription) {
        this.productDescription = productDescription;
    }

    public PackageInfo getPackageInfo() {
        return packageInfo;
    }

    public void setPackageInfo(PackageInfo packageInfo) {
        this.packageInfo = packageInfo;
    }

    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "pro_id=" + pro_id +
                ", sku_cd='" + sku_cd + '\'' +
                ", brd_id=" + brd_id +
                ", man_id=" + man_id +
                ", title='" + title + '\'' +
                ", upc='" + upc + '\'' +
                ", ean='" + ean + '\'' +
                ", model='" + model + '\'' +
                ", warranty_day='" + warranty_day + '\'' +
                ", replenishment_period=" + replenishment_period +
                ", warranty='" + warranty + '\'' +
                ", time_unit='" + time_unit + '\'' +
                ", img_id=" + img_id +
                ", prc_id=" + prc_id +
                ", productDescription=" + productDescription +
                ", packageInfo=" + packageInfo +
                ", price=" + price +
                '}';
    }


}
