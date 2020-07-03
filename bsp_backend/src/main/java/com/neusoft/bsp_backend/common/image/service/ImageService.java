package com.neusoft.bsp_backend.common.image.service;

import com.neusoft.bsp_backend.common.image.entity.Image;

public interface ImageService {

        int insert(Image image);

        int delete(int pk);

        Image getById(int brd_id);


}
