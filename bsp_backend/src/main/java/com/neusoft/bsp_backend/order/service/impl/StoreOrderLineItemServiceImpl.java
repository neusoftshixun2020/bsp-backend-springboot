package com.neusoft.bsp_backend.order.service.impl;

import com.neusoft.bsp_backend.order.entity.StoreOrderLineItem;
import com.neusoft.bsp_backend.order.mapper.StoreOrderLineItemMapper;
import com.neusoft.bsp_backend.order.service.StoreOrderLineItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Transactional
@Service
public class StoreOrderLineItemServiceImpl implements StoreOrderLineItemService {

    @Autowired
    StoreOrderLineItemMapper storeOrderLineItemMapper;

    @Override
    public int insert(StoreOrderLineItem storeOrderLineItem) {
        return storeOrderLineItemMapper.insert(storeOrderLineItem);
    }

    @Override
    public int update(StoreOrderLineItem storeOrderLineItem) {
        return storeOrderLineItemMapper.update(storeOrderLineItem);
    }

    @Override
    public int delete(int pk) {
        return storeOrderLineItemMapper.delete(pk);
    }

    @Override
    public StoreOrderLineItem getById(int pk) {
        return storeOrderLineItemMapper.getById(pk);
    }

    @Override
    public List<StoreOrderLineItem> getAllByFilter(Map<String, Object> map) {
        return storeOrderLineItemMapper.getAllByFilter(map);
    }

    @Override
    public List<StoreOrderLineItem> getAll() {
        return storeOrderLineItemMapper.getAll();
    }

}
