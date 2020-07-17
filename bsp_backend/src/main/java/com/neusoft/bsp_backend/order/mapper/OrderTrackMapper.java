package com.neusoft.bsp_backend.order.mapper;

import com.neusoft.bsp_backend.common.base.BaseMapper;
import com.neusoft.bsp_backend.order.entity.OrderTrack;
import com.neusoft.bsp_backend.order.entity.SalesOrderLineItem;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderTrackMapper extends BaseMapper<String, OrderTrack> {
}
