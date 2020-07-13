package com.neusoft.bsp_backend.order.service;

import com.neusoft.bsp_backend.tmp.entity.SalesOrderLineItem;

import java.util.List;
import java.util.Map;

public interface SalesOrderLineItemService {
    int insert(SalesOrderLineItem salesOrderLineItem);

    int update(SalesOrderLineItem salesOrderLineItem);

    int delete(int pk);

    SalesOrderLineItem getById(int pk);

    List<SalesOrderLineItem> getAllByFilter(Map<String, Object> map);

    List<SalesOrderLineItem> getAll();
}
