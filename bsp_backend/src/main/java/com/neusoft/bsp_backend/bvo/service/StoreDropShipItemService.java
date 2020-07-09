package com.neusoft.bsp_backend.bvo.service;

import com.neusoft.bsp_backend.bvo.entity.Store;
import com.neusoft.bsp_backend.bvo.entity.StoreDropShipItem;

import java.util.List;
import java.util.Map;

public interface StoreDropShipItemService {
    int insert(StoreDropShipItem storeDropShipItem);

    int update(StoreDropShipItem storeDropShipItem);

    int delete(int pk);

    StoreDropShipItem getById(int pk);

    List<StoreDropShipItem> getAllByFilter(Map<String, Object> map);

    List<StoreDropShipItem> getAll();
}
