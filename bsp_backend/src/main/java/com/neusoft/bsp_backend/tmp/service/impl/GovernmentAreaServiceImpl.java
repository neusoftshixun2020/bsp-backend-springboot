package com.neusoft.bsp_backend.tmp.service.impl;

import com.neusoft.bsp_backend.common.base.BaseEntity;
import com.neusoft.bsp_backend.tmp.entity.GovernmentArea;
import com.neusoft.bsp_backend.tmp.mapper.GovernmentAreaMapper;
import com.neusoft.bsp_backend.tmp.service.GovernmentAreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Transactional
@Service
public class GovernmentAreaServiceImpl implements GovernmentAreaService {
    @Autowired
    GovernmentAreaMapper governmentAreaMapper;

    @Override
    public int insert(GovernmentArea governmentArea) {
        return governmentAreaMapper.insert(governmentArea);
    }

    @Override
    public int update(GovernmentArea governmentArea) {
        return governmentAreaMapper.update(governmentArea);
    }

    @Override
    public int delete(int pk) {
        return governmentAreaMapper.delete(pk);
    }

    @Override
    public GovernmentArea getById(int pk) {
        return governmentAreaMapper.getById(pk);
    }

    @Override
    public List<GovernmentArea> getAllByFilter(Map<String, Object> map) {
        return governmentAreaMapper.getAllByFilter(map);
    }

    @Override
    public List<GovernmentArea> getAll() {
        return governmentAreaMapper.getAll();
    }
}
