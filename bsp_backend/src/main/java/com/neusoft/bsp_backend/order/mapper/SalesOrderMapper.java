package com.neusoft.bsp_backend.order.mapper;

import com.neusoft.bsp_backend.common.base.BaseMapper;
import com.neusoft.bsp_backend.order.entity.SalesOrder;
import org.springframework.stereotype.Repository;

@Repository
public interface SalesOrderMapper extends BaseMapper<Integer, SalesOrder> {
    SalesOrder getByStoreOrderId(int sto_id);
}
