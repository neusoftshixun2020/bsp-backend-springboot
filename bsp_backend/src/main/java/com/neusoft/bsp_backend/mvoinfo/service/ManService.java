package com.neusoft.bsp_backend.mvoinfo.service;

import com.github.pagehelper.PageInfo;
import com.neusoft.bsp_backend.mvoinfo.entity.Manufacturer;

import java.util.List;
import java.util.Map;

public interface ManService {
    int insert(Manufacturer manufacturer);

    int update(Manufacturer manufacturer);

    int delete(String pk);

    Manufacturer getById(String manid);

    List<Manufacturer> getAllByFilter(Map<String, Object> map);

    List<Manufacturer> getAll();

    PageInfo<Manufacturer> getAllByFilter(Integer pageNum, Integer pageSize, Map<String, Object> map);
}
