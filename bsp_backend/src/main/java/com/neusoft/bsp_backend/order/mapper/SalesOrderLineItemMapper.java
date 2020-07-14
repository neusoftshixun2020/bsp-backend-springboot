package com.neusoft.bsp_backend.order.mapper;

import com.neusoft.bsp_backend.common.base.BaseMapper;
import com.neusoft.bsp_backend.order.entity.SalesOrderLineItem;
import org.springframework.stereotype.Repository;

@Repository
public interface SalesOrderLineItemMapper extends BaseMapper<Integer, SalesOrderLineItem> {
}
