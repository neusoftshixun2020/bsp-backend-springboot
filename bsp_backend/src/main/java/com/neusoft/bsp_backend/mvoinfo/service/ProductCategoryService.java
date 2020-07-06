package com.neusoft.bsp_backend.mvoinfo.service;

import com.github.pagehelper.PageInfo;
import com.neusoft.bsp_backend.mvoinfo.entity.Manufacturer;
import com.neusoft.bsp_backend.mvoinfo.entity.ProductCategory;

import java.util.List;
import java.util.Map;


public interface ProductCategoryService {

    int insert(ProductCategory productCategory);

    int update(ProductCategory productCategory);

    int delete(int pk);

    ProductCategory getById(int pk);

    List<ProductCategory> getAllByFilter(Map<String, Object> map);

    List<ProductCategory> getAll();

    PageInfo<ProductCategory> getAllByFilter(Integer pageNum, Integer pageSize, Map<String, Object> map);

    int getProNum(int prc_id);
}