package com.neusoft.bsp_backend.order.service;

import com.neusoft.bsp_backend.tmp.entity.ShippingAddress;

import java.util.List;
import java.util.Map;

public interface ShippingAddressService {
    int insert(ShippingAddress shippingAddress);

    int update(ShippingAddress shippingAddress);

    int delete(int pk);

    ShippingAddress getById(int pk);

    List<ShippingAddress> getAllByFilter(Map<String, Object> map);

    List<ShippingAddress> getAll();
}
