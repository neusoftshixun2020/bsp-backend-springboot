package com.neusoft.bsp_backend.mvoinfo.service;

import com.github.pagehelper.PageInfo;
import com.neusoft.bsp_backend.mvoinfo.entity.Brand;

import java.util.List;
import java.util.Map;

public interface BrandService {

        int insert(Brand brand);

        int update(Brand brand);

        int delete(int pk);

        Brand getById(int brd_id);

        List<Brand> getAllByFilter(Map<String, Object> map);

        List<Brand> getAll();

        PageInfo<Brand> getAll(Integer pageNum, Integer pagesize);

        PageInfo<Brand> getAllByFilter(Integer pageNum, Integer pagesize, Map<String, Object> map);
}
