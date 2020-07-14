package com.neusoft.bsp_backend.bvo.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StoreMapperTest {
    @Autowired
    StoreMapper storeMapper;
    @Test
    void contextLoads() {
        Map<String, Object> map = new HashMap<>();
        map.put("platform_type", "1");
        //map.put("dsr_id", 1);
        storeMapper.getAllByFilter(map);
    }

}