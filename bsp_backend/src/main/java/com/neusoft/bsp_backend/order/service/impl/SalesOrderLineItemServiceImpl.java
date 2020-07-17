package com.neusoft.bsp_backend.order.service.impl;

import com.neusoft.bsp_backend.order.entity.SalesOrderLineItem;
import com.neusoft.bsp_backend.order.mapper.SalesOrderLineItemMapper;
import com.neusoft.bsp_backend.order.service.SalesOrderLineItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Transactional
@Service
public class SalesOrderLineItemServiceImpl implements SalesOrderLineItemService {
    @Autowired
    SalesOrderLineItemMapper salesOrderLineItemMapper;

    @Override
    public int insert(SalesOrderLineItem salesOrderLineItem) {
        return salesOrderLineItemMapper.insert(salesOrderLineItem);
    }

    @Override
    public int update(SalesOrderLineItem salesOrderLineItem) {
        return salesOrderLineItemMapper.update(salesOrderLineItem);
    }

    @Override
    public int delete(int pk) {
        return salesOrderLineItemMapper.delete(pk);
    }

    @Override
    public SalesOrderLineItem getById(int pk) {

        return salesOrderLineItemMapper.getById(pk);
    }

    @Override
    public List<SalesOrderLineItem> getAllByFilter(Map<String, Object> map) {
        return salesOrderLineItemMapper.getAllByFilter(map);
    }

    @Override
    public List<SalesOrderLineItem> getAll() {
        return salesOrderLineItemMapper.getAll();
    }
}
