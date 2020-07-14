package com.neusoft.bsp_backend.order.service.impl;

import com.neusoft.bsp_backend.order.entity.*;
import com.neusoft.bsp_backend.order.mapper.ShippingAddressMapper;
import com.neusoft.bsp_backend.order.mapper.StoreOrderLineItemMapper;
import com.neusoft.bsp_backend.order.mapper.StoreOrderMapper;
import com.neusoft.bsp_backend.order.service.SalesOrderService;
import com.neusoft.bsp_backend.order.service.StoreOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Transactional
@Service
public class StoreOrderServiceImpl implements StoreOrderService {

    @Autowired
    StoreOrderMapper storeOrderMapper;
    @Autowired
    StoreOrderLineItemMapper storeOrderLineItemMapper;
    @Autowired
    ShippingAddressMapper shippingAddressMapper;
    @Autowired
    SalesOrderService salesOrderService;

    @Override
    public int insert(StoreOrder storeOrder) {
        int i = storeOrderMapper.insert(storeOrder);
        if (i==0){
            return 0;
        }
        int i1 = shippingAddressMapper.insert(storeOrder.getShippingAddress());
        if (i1==0){
            return 0;
        }
        int i3 = salesOrderService.insert(storeOrder.getSalesOrder());
        if (i3==0){
            return 0;
        }
        for (StoreOrderLineItem storeOrderLineItem: storeOrder.getStoreOrderLineItems()){
            int i2 = storeOrderLineItemMapper.insert(storeOrderLineItem);
            if (i2==0){
                return 0;
            }
        }
        return 1;
    }

    @Override
    public int update(StoreOrder storeOrder) {
        int u = storeOrderMapper.update(storeOrder);
        if (u==0){
            return 0;
        }
        int u1 = shippingAddressMapper.update(storeOrder.getShippingAddress());
        if (u1==0){
            return 0;
        }
        int u3 = salesOrderService.update(storeOrder.getSalesOrder());
        if (u3==0){
            return 0;
        }
        for (StoreOrderLineItem storeOrderLineItem: storeOrder.getStoreOrderLineItems()){
            int u2 = storeOrderLineItemMapper.update(storeOrderLineItem);
            if (u2==0){
                return 0;
            }
        }
        return 1;
    }

    @Override
    public int delete(int pk) {
        return storeOrderMapper.delete(pk);
    }

    @Override
    public StoreOrder getById(int pk) {
        StoreOrder storeOrder = storeOrderMapper.getById(pk);
        ShippingAddress shippingAddress = shippingAddressMapper.getById(pk);
        SalesOrder salesOrder = salesOrderService.getByStoreOrderId(pk);
        storeOrder.setShippingAddress(shippingAddress);
        storeOrder.setSalesOrder(salesOrder);
        Map<String, Object> map1 = new HashMap<>();
        map1.put("sto_id", storeOrder.getSto_id());
        List<StoreOrderLineItem> storeOrderLineItems = storeOrderLineItemMapper.getAllByFilter(map1);
        storeOrder.setStoreOrderLineItems(storeOrderLineItems);
        return storeOrder;
    }

    @Override
    public List<StoreOrder> getAllByFilter(Map<String, Object> map) {
        List<StoreOrder> storeOrders = storeOrderMapper.getAllByFilter(map);
        for (StoreOrder storeOrder: storeOrders){
            ShippingAddress shippingAddress = shippingAddressMapper.getById(storeOrder.getSto_id());
            storeOrder.setShippingAddress(shippingAddress);
            SalesOrder salesOrder = salesOrderService.getByStoreOrderId(storeOrder.getSto_id());
            storeOrder.setSalesOrder(salesOrder);
            Map<String, Object> map1 = new HashMap<>();
            map1.put("sto_id", storeOrder.getSto_id());
            List<StoreOrderLineItem> storeOrderLineItems = storeOrderLineItemMapper.getAllByFilter(map1);
            storeOrder.setStoreOrderLineItems(storeOrderLineItems);
        }
        return storeOrders;
    }

    @Override
    public List<StoreOrder> getAll() {
        Map<String, Object> map1 = new HashMap<>();
        return this.getAllByFilter(map1);
    }
}
