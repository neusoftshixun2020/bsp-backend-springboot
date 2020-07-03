package com.neusoft.bsp_backend.common.image.mapper;

import com.neusoft.bsp_backend.common.image.entity.Image;
import com.neusoft.bsp_backend.common.base.BaseMapper;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageMapper {
    int insert(Image image);
    int delete(int pk);
    Image getById(int pk);
}
