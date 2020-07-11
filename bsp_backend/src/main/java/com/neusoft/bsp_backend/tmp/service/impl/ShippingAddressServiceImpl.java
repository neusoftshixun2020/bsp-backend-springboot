package com.neusoft.bsp_backend.tmp.service.impl;

import com.neusoft.bsp_backend.common.base.BaseEntity;
import com.neusoft.bsp_backend.tmp.entity.ShippingAddress;
import com.neusoft.bsp_backend.tmp.mapper.ShippingAddressMapper;
import com.neusoft.bsp_backend.tmp.service.ShippingAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Transactional
@Service
public class ShippingAddressServiceImpl implements ShippingAddressService {
    @Autowired
    ShippingAddressMapper shippingAddressMapper;

    @Override
    public int insert(ShippingAddress shippingAddress) {
        return shippingAddressMapper.insert(shippingAddress);
    }

    @Override
    public int update(ShippingAddress shippingAddress) {
        return shippingAddressMapper.update(shippingAddress);
    }

    @Override
    public int delete(int pk) {
        return shippingAddressMapper.delete(pk);
    }

    @Override
    public ShippingAddress getById(int pk) {
        return shippingAddressMapper.getById(pk);
    }

    @Override
    public List<ShippingAddress> getAllByFilter(Map<String, Object> map) {
        return shippingAddressMapper.getAllByFilter(map);
    }

    @Override
    public List<ShippingAddress> getAll() {
        return shippingAddressMapper.getAll();
    }
}
