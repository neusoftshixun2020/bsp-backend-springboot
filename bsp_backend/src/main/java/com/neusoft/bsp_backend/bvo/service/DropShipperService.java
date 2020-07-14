package com.neusoft.bsp_backend.bvo.service;

import com.neusoft.bsp_backend.bvo.entity.DropShipper;
import com.neusoft.bsp_backend.bvo.entity.StoreDropShipItem;

import java.util.List;
import java.util.Map;

public interface DropShipperService {
    int insert(DropShipper dropShipper);

    int update(DropShipper dropShipper);

    int delete(int pk);

    DropShipper getById(int pk);

    List<DropShipper> getAllByFilter(Map<String, Object> map);

    List<DropShipper> getAll();
}
