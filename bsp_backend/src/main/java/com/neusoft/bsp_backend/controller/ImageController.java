package com.neusoft.bsp_backend.controller;

import com.neusoft.bsp_backend.common.base.BaseController;
import com.neusoft.bsp_backend.common.base.BaseModelJson;
import com.neusoft.bsp_backend.common.exception.BusinessException;
import com.neusoft.bsp_backend.common.file.service.FilesStorageService;
import com.neusoft.bsp_backend.common.image.entity.Image;
import com.neusoft.bsp_backend.common.image.service.ImageService;
import com.neusoft.bsp_backend.common.validationGroup.SelectGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.text.SimpleDateFormat;
import java.util.Date;

@CrossOrigin
@RestController
@RequestMapping("/image")
public class ImageController extends BaseController {

    @Autowired
    FilesStorageService storageService;

    @Autowired
    ImageService imageService;

    @Autowired
    Environment environment;

    @PostMapping("/uploadImage")
    public BaseModelJson<Image> uploadImage(@RequestParam("file")MultipartFile file) {

        String extension = "";
        String fileName =  file.getOriginalFilename();
        int i = fileName.lastIndexOf('.');
        if (i > 0) {
            extension = fileName.substring(i+1);
        }
        System.out.println(extension);
        if(!("jpg".equals(extension) || "png".equals(extension) || "gif".equals(extension) || "tiff".equals(extension))) {
            throw BusinessException.FILETYPE_NOT_PICTURE.newInstance("504", "File type is not picture", new Object[]{file.getOriginalFilename()});
        }
        try {
            String filename = storageService.save(file);
            BaseModelJson<Image> result = new BaseModelJson<>();
            Image image = new Image();
            System.out.println(environment.getProperty("local.server.port"));
            String url = "http://localhost:" + environment.getProperty("local.server.port") + "/File/files/" + filename;
            System.out.println(url);
            image.setUri(url);
            int j = imageService.insert(image);
            if (j == 1) {
                result.code = 200;
                result.message = "upload file success";
                result.data = image;
                return result;
            } else {
                throw BusinessException.INSERT_FAIL;
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw BusinessException.UPLOAD_FILE_FAIL;
        }
    }

    @PostMapping("getById")
    public BaseModelJson<Image> getImgById(int img_id) {
       Image image = imageService.getById(img_id);
        if (image == null) {
            throw BusinessException.NOT_EXISTS;
        } else {
            BaseModelJson<Image> result = new BaseModelJson<>();
            result.code = 200;
            result.data = image;
            return result;
        }
    }
}
