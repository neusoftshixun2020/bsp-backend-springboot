package com.neusoft.bsp_backend.product.service;

import com.github.pagehelper.PageInfo;
import com.neusoft.bsp_backend.product.entity.Product;
import com.neusoft.bsp_backend.user.entity.User;

import java.util.List;
import java.util.Map;

public interface ProductService {
    int insert(Product product);

    int update(Product product);

    int delete(int pk);

    Product getById(int proid);

    List<Product> getAllByFilter(Map<String, Object> map);

    List<Product> getAll();

    PageInfo<Product> getAll(Integer pageNum, Integer pagesize);

    PageInfo<Product> getAllByFilter(Integer pageNum, Integer pagesize, Map<String, Object> map);
}
