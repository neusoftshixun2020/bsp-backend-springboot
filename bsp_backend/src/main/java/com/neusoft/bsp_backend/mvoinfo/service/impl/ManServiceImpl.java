package com.neusoft.bsp_backend.mvoinfo.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import com.neusoft.bsp_backend.mvoinfo.entity.Manufacturer;
import com.neusoft.bsp_backend.mvoinfo.mapper.ManMapper;
import com.neusoft.bsp_backend.mvoinfo.service.ManService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ManServiceImpl implements ManService {

    @Autowired
    ManMapper manMapper;

    @Override
    public int insert(Manufacturer manufacturer) {
        return manMapper.insert(manufacturer);
    }

    @Override
    public int update(Manufacturer manufacturer) {
        return manMapper.update(manufacturer);
    }

    @Override
    public int delete(String pk) {
        return manMapper.delete(pk);
    }

    @Override
    public Manufacturer getById(String manid) {
        return manMapper.getById(manid);
    }

    @Override
    public List<Manufacturer> getAllByFilter(Map<String, Object> map) {
        return manMapper.getAllByFilter(map);
    }

    @Override
    public List<Manufacturer> getAll() {
        return manMapper.getAll();
    }

    @Override
    public PageInfo<Manufacturer> getAllByFilter(Integer pageNum, Integer pageSize, Map<String, Object> map) {
        PageHelper.startPage(pageNum,pageSize,true);
        List<Manufacturer> manufacturer = manMapper.getAllByFilter(map);
        return new PageInfo<>(manufacturer);
    }
}
