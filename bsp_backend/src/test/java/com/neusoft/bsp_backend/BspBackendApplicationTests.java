package com.neusoft.bsp_backend;

import com.neusoft.bsp_backend.mvoinfo.entity.Manufacturer;
import com.neusoft.bsp_backend.mvoinfo.mapper.ManMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class BspBackendApplicationTests {

    @Autowired
    ManMapper manMapper;
    @Test
    void contextLoads() {
        List<Manufacturer> manufacturers =  manMapper.getAll();
        for (Manufacturer manufacturer:manufacturers) {
            System.out.println(manufacturer);
        }
    }

}
