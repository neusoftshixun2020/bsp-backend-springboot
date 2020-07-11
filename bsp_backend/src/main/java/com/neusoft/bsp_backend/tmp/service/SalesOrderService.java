package com.neusoft.bsp_backend.tmp.service;

import com.neusoft.bsp_backend.tmp.entity.SalesOrder;

import java.util.List;
import java.util.Map;

public interface SalesOrderService {

    int insert(SalesOrder salesOrder);

    int update(SalesOrder salesOrder);

    int delete(int pk);

    SalesOrder getById(int pk);

    List<SalesOrder> getAllByFilter(Map<String, Object> map);

    List<SalesOrder> getAll();

}
