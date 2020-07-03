package com.neusoft.bsp_backend.common.image.service.impl;

import com.neusoft.bsp_backend.common.image.entity.Image;
import com.neusoft.bsp_backend.common.image.mapper.ImageMapper;
import com.neusoft.bsp_backend.common.image.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("imageService")
public class ImageServiceImpl implements ImageService {
    @Autowired
    ImageMapper imageMapper;

    @Override
    public int insert(Image image) {
        return imageMapper.insert(image);
    }

    @Override
    public int delete(int pk) {
        return imageMapper.delete(pk);
    }

    @Override
    public  Image getById(int pk) {
        return imageMapper.getById(pk);
    }


}
