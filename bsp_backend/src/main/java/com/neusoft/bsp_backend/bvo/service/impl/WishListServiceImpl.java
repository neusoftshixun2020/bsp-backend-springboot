package com.neusoft.bsp_backend.bvo.service.impl;

import com.github.pagehelper.PageInfo;
import com.neusoft.bsp_backend.bvo.entity.WishList;
import com.neusoft.bsp_backend.bvo.mapper.WishListMapper;
import com.neusoft.bsp_backend.bvo.service.WishListService;
import com.neusoft.bsp_backend.product.entity.Product;
import com.neusoft.bsp_backend.product.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Transactional
@Service
public class WishListServiceImpl implements WishListService {

    @Autowired
    WishListMapper wishListMapper;

    @Autowired
    ProductMapper productMapper;

    @Override
    public int insert(WishList wishList) {
        return wishListMapper.insert(wishList);
    }

    @Override
    public int update(WishList wishList) {
        return wishListMapper.update(wishList);
    }

    @Override
    public int delete(int pk) {
        return wishListMapper.delete(pk);
    }

    @Override
    public WishList getById(int pk) {
        WishList wishList = wishListMapper.getById(pk);
        Product product = productMapper.getById(wishList.getPro_id());
        wishList.setProduct(product);
        return wishList;
    }

    @Override
    public List<WishList> getAllByFilter(Map<String, Object> map) {
        List<WishList> wishLists = wishListMapper.getAllByFilter(map);
        for (WishList wishList: wishLists){
            Product product = productMapper.getById(wishList.getPro_id());
            wishList.setProduct(product);
        }
        return wishLists;
    }

    @Override
    public List<WishList> getAll() {
        List<WishList> wishLists = wishListMapper.getAll();
        for (WishList wishList: wishLists){
            Product product = productMapper.getById(wishList.getPro_id());
            wishList.setProduct(product);
        }
        return wishLists;
    }

    @Override
    public PageInfo<WishList> getAll(Integer pageNum, Integer pagesize) {
        return null;
    }

    @Override
    public PageInfo<WishList> getAllByFilter(Integer pageNum, Integer pagesize, Map<String, Object> map) {
        return null;
    }
}
