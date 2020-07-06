package com.neusoft.bsp_backend.product.mapper;

import com.neusoft.bsp_backend.common.base.BaseMapper;
import com.neusoft.bsp_backend.product.entity.Product;
import com.neusoft.bsp_backend.product.entity.ProductDescription;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductDescriptionMapper extends BaseMapper<String, ProductDescription> {
}
