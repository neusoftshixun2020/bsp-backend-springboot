package com.neusoft.bsp_backend.order.service;

import com.neusoft.bsp_backend.tmp.entity.StoreOrderLineItem;

import java.util.List;
import java.util.Map;

public interface StoreOrderLineItemService {
    int insert(StoreOrderLineItem storeOrderLineItem);

    int update(StoreOrderLineItem storeOrderLineItem);

    int delete(int pk);

    StoreOrderLineItem getById(int pk);

    List<StoreOrderLineItem> getAllByFilter(Map<String, Object> map);

    List<StoreOrderLineItem> getAll();
}
