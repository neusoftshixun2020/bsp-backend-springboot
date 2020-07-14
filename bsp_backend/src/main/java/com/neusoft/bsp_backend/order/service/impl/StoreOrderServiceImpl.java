package com.neusoft.bsp_backend.order.service.impl;

import com.neusoft.bsp_backend.order.entity.StoreOrder;
import com.neusoft.bsp_backend.order.mapper.StoreOrderMapper;
import com.neusoft.bsp_backend.order.service.StoreOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Transactional
@Service
public class StoreOrderServiceImpl implements StoreOrderService {

    @Autowired
    StoreOrderMapper storeOrderMapper;

    @Override
    public int insert(StoreOrder storeOrder) {
        return storeOrderMapper.insert(storeOrder);
    }

    @Override
    public int update(StoreOrder storeOrder) {
        return storeOrderMapper.update(storeOrder);
    }

    @Override
    public int delete(int pk) {
        return storeOrderMapper.delete(pk);
    }

    @Override
    public StoreOrder getById(int pk) {
        return storeOrderMapper.getById(pk);
    }

    @Override
    public List<StoreOrder> getAllByFilter(Map<String, Object> map) {
        return storeOrderMapper.getAllByFilter(map);
    }

    @Override
    public List<StoreOrder> getAll() {
        return storeOrderMapper.getAll();
    }
}
