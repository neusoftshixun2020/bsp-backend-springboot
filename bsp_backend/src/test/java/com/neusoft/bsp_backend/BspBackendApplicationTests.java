package com.neusoft.bsp_backend;

import com.neusoft.bsp_backend.mvoinfo.entity.Manufacturer;
import com.neusoft.bsp_backend.mvoinfo.entity.ProductCategory;
import com.neusoft.bsp_backend.mvoinfo.mapper.ManMapper;

import com.neusoft.bsp_backend.common.image.entity.Image;
import com.neusoft.bsp_backend.common.image.mapper.ImageMapper;
import com.neusoft.bsp_backend.mvoinfo.entity.Brand;
import com.neusoft.bsp_backend.mvoinfo.mapper.BrandMapper;

import com.neusoft.bsp_backend.product.entity.Product;
import com.neusoft.bsp_backend.product.service.ProductService;
import com.neusoft.bsp_backend.mvoinfo.mapper.ProductCategoryMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class BspBackendApplicationTests {

    @Autowired
    ManMapper manMapper;

    @Autowired
    BrandMapper brandMapper;

    @Autowired
    ImageMapper imageMapper;

    @Autowired
    ProductService productService;

    @Test
    void testProduct(){
        List<Product> products = productService.getAll();
        for (Product product: products){
            System.out.println(product);
        }
    }
    ProductCategoryMapper productCategoryMapper;

    @Test
    void contextLoads() {
        List<Manufacturer> manufacturers = manMapper.getAll();
        for (Manufacturer manufacturer : manufacturers) {
            System.out.println(manufacturer);
            BrandMapper brandMapper;

        }
    }

    @Test
    void contextLoads1 () {
        List<Brand> brands = brandMapper.getAll();
        for (Brand brand : brands) {
            System.out.println(brand);
        }
    }

    @Test
    void contextLoads2() {
        Image image = new Image();
        imageMapper.insert(image);
    }

    @Test
    void contextLoads3() {
        ProductCategory productCategory = new ProductCategory();
        int i = productCategoryMapper.getProNum(1);
        System.out.println(i);
    }
}
