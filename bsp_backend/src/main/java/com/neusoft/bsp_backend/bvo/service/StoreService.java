package com.neusoft.bsp_backend.bvo.service;

import com.neusoft.bsp_backend.bvo.entity.Store;
import com.neusoft.bsp_backend.bvo.entity.WishList;

import java.util.List;
import java.util.Map;

public interface StoreService {
    int insert(Store store);

    int update(Store store);

    int delete(int pk);

    Store getById(int pk);

    List<Store> getAllByFilter(Map<String, Object> map);

    List<Store> getAll();
}
