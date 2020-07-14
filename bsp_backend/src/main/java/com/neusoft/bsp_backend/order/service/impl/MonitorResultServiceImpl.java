package com.neusoft.bsp_backend.order.service.impl;

import com.neusoft.bsp_backend.order.entity.MonitorResult;
import com.neusoft.bsp_backend.order.mapper.MonitorResultMapper;
import com.neusoft.bsp_backend.order.service.MonitorResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Transactional
@Service
public class MonitorResultServiceImpl implements MonitorResultService {
    @Autowired
    MonitorResultMapper monitorResultMapper;

    @Override
    public int insert(MonitorResult monitorResult) {
        return monitorResultMapper.insert(monitorResult);
    }

    @Override
    public int update(MonitorResult monitorResult) {
        return monitorResultMapper.update(monitorResult);
    }

    @Override
    public int delete(int pk) {
        return monitorResultMapper.delete(pk);
    }

    @Override
    public MonitorResult getById(int pk) {
        return monitorResultMapper.getById(pk);
    }

    @Override
    public List<MonitorResult> getAllByFilter(Map<String, Object> map) {
        return monitorResultMapper.getAllByFilter(map);
    }

    @Override
    public List<MonitorResult> getAll() {
        return monitorResultMapper.getAll();
    }
}
