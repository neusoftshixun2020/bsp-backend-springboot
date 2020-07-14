package com.neusoft.bsp_backend.order.service;

import com.neusoft.bsp_backend.order.entity.SalesOrder;

import java.util.List;
import java.util.Map;

public interface SalesOrderService {

    int insert(SalesOrder salesOrder);

    int update(SalesOrder salesOrder);

    int delete(int pk);

    SalesOrder getById(int pk);

    SalesOrder getByStoreOrderId(int sto_id);

    List<SalesOrder> getAllByFilter(Map<String, Object> map);

    List<SalesOrder> getAll();

}
