package com.neusoft.bsp_backend.order.service;


import com.neusoft.bsp_backend.order.entity.MonitorResult;

import java.util.List;
import java.util.Map;

public interface MonitorResultService {

    int insert(MonitorResult monitorResult);

    int update(MonitorResult monitorResult);

    int delete(int pk);

    MonitorResult getById(int pk);

    List<MonitorResult> getAllByFilter(Map<String, Object> map);

    List<MonitorResult> getAll();

}
