package com.neusoft.bsp_backend.mvoinfo.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neusoft.bsp_backend.mvoinfo.entity.Brand;
import com.neusoft.bsp_backend.mvoinfo.mapper.BrandMapper;
import com.neusoft.bsp_backend.mvoinfo.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BrandServiceImpl implements BrandService {
    @Autowired
    BrandMapper brandMapper;

    @Override
    public int insert(Brand brand) {
        return brandMapper.insert(brand);
    }

    @Override
    public int update(Brand brand) {
        return brandMapper.update(brand);
    }

    @Override
    public int delete(int pk) {
        return brandMapper.delete(pk);
    }

    @Override
    public  Brand getById(int brd_id) {
        return brandMapper.getById(brd_id);
    }

    @Override
    public List<Brand> getAllByFilter(Map<String, Object> map) {
        return brandMapper.getAllByFilter(map);
    }

    @Override
    public List<Brand> getAll() {
        return brandMapper.getAll();
    }

    @Override
    public PageInfo<Brand> getAll(Integer pageNum, Integer pagesize) {
        return this.getAllByFilter(pageNum, pagesize, new HashMap<>());
    }

    @Override
    public PageInfo<Brand> getAllByFilter(Integer pageNum, Integer pagesize, Map<String, Object> map) {
        PageHelper.startPage(pageNum, pagesize, true);
        List<Brand> brands = brandMapper.getAllByFilter(map);
        return new PageInfo<>(brands);
    }
}
