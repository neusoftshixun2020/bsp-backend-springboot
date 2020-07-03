package com.neusoft.bsp_backend;

import com.neusoft.bsp_backend.common.image.entity.Image;
import com.neusoft.bsp_backend.common.image.mapper.ImageMapper;
import com.neusoft.bsp_backend.mvoinfo.entity.Brand;
import com.neusoft.bsp_backend.mvoinfo.mapper.BrandMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class BspBackendApplicationTests {

    @Autowired
    BrandMapper brandMapper;

    @Autowired
    ImageMapper imageMapper;

    @Test
    void contextLoads() {
        List<Brand> brands = brandMapper.getAll();
        for (Brand brand:brands) {
            System.out.println(brand);
        }
    }

    @Test
    void contextLoads2() {
        Image image = new Image();
        imageMapper.insert(image);
    }
}
