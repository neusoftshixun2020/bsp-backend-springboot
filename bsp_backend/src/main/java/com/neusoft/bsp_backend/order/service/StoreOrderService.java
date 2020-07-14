package com.neusoft.bsp_backend.order.service;

import com.neusoft.bsp_backend.order.entity.StoreOrder;

import java.util.List;
import java.util.Map;

public interface StoreOrderService {
    int insert(StoreOrder storeOrder);

    int update(StoreOrder storeOrder);

    int delete(int pk);

    StoreOrder getById(int pk);

    List<StoreOrder> getAllByFilter(Map<String, Object> map);

    List<StoreOrder> getAll();
}
