package com.neusoft.bsp_backend.bvo.service.impl;

import com.neusoft.bsp_backend.bvo.entity.DropShipper;
import com.neusoft.bsp_backend.bvo.mapper.DropShipperMapper;
import com.neusoft.bsp_backend.bvo.service.DropShipperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
@Service
@Transactional
public class DropShipperServiceImpl implements DropShipperService {
    @Autowired
    DropShipperMapper dropShipperMapper;
    @Override
    public int insert(DropShipper dropShipper) {
        return dropShipperMapper.insert(dropShipper);
    }

    @Override
    public int update(DropShipper dropShipper) {
        return dropShipperMapper.update(dropShipper);
    }

    @Override
    public int delete(int pk) {
        return dropShipperMapper.delete(pk);
    }

    @Override
    public DropShipper getById(int pk) {
        return dropShipperMapper.getById(pk);
    }

    @Override
    public List<DropShipper> getAllByFilter(Map<String, Object> map) {
        return dropShipperMapper.getAllByFilter(map);
    }

    @Override
    public List<DropShipper> getAll() {
        return dropShipperMapper.getAll();
    }
}
