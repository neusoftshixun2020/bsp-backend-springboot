package com.neusoft.bsp_backend.tmp.service.impl;

import com.neusoft.bsp_backend.common.base.BaseEntity;
import com.neusoft.bsp_backend.tmp.entity.SalesOrder;
import com.neusoft.bsp_backend.tmp.mapper.SalesOrderMapper;
import com.neusoft.bsp_backend.tmp.service.SalesOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Transactional
@Service
public class SalesOrderServiceImpl implements SalesOrderService {
    @Autowired
    SalesOrderMapper salesOrderMapper;

    @Override
    public int insert(SalesOrder salesOrder) {
        return salesOrderMapper.insert(salesOrder);
    }

    @Override
    public int update(SalesOrder salesOrder) {
        return salesOrderMapper.update(salesOrder);
    }

    @Override
    public int delete(int pk) {
        return salesOrderMapper.delete(pk);
    }

    @Override
    public SalesOrder getById(int pk) {
        return salesOrderMapper.getById(pk);
    }

    @Override
    public List<SalesOrder> getAllByFilter(Map<String, Object> map) {
        return salesOrderMapper.getAllByFilter(map);
    }

    @Override
    public List<SalesOrder> getAll() {
        return salesOrderMapper.getAll();
    }
}
