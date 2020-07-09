package com.neusoft.bsp_backend.bvo.service;

import com.github.pagehelper.PageInfo;
import com.neusoft.bsp_backend.bvo.entity.WishList;
import com.neusoft.bsp_backend.product.entity.Product;

import java.util.List;
import java.util.Map;

public interface WishListService{

    int insert(WishList wishList);

    int update(WishList wishList);

    int delete(int pk);

    WishList getById(int pk);

    List<WishList> getAllByFilter(Map<String, Object> map);

    List<WishList> getAll();

    PageInfo<WishList> getAll(Integer pageNum, Integer pagesize);

    PageInfo<WishList> getAllByFilter(Integer pageNum, Integer pagesize, Map<String, Object> map);
}
