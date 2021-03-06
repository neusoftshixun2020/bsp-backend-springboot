package com.neusoft.bsp_backend.product.mapper;

import com.neusoft.bsp_backend.common.base.BaseMapper;
import com.neusoft.bsp_backend.product.entity.ProductCategory;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductCategoryMapper extends BaseMapper<Integer, ProductCategory> {

   int getProNum(int prc_id);

}
