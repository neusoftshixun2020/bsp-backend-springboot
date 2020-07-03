package com.neusoft.bsp_backend.controller;

import com.neusoft.bsp_backend.common.base.BaseController;
import com.neusoft.bsp_backend.common.base.BaseModel;
import com.neusoft.bsp_backend.common.base.BaseModelJson;
import com.neusoft.bsp_backend.common.exception.BusinessException;
import com.neusoft.bsp_backend.common.file.service.FilesStorageService;
import com.neusoft.bsp_backend.common.image.entity.Image;
import com.neusoft.bsp_backend.common.image.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.net.Inet4Address;

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

    @RequestMapping("/uploadImage")
    public BaseModelJson<Integer> uploadImage(@RequestParam("file")MultipartFile file) {
        String extension = "";
        String fileName = file.getOriginalFilename();
        int i = fileName.lastIndexOf('.');
        if (i > 0) {
            extension = fileName.substring(i+1);
        }
        System.out.println(extension);
        if(!("jpg".equals(extension) || "png".equals(extension) || "gif".equals(extension) || "tiff".equals(extension))) {
            throw BusinessException.FILETYPE_NOT_PICTURE.newInstance("504", "File type is not picture", new Object[]{file.getOriginalFilename()});
        }
        try {
            storageService.save(file);
            BaseModelJson<Integer> result = new BaseModelJson<>();
            Image image = new Image();
            System.out.println(environment.getProperty("local.server.port"));
            String url = "http://localhost:" + environment.getProperty("local.server.port") + "/File/files/" + file.getOriginalFilename();
            System.out.println(url);
            image.setUri(url);
            int j = imageService.insert(image);
            if (j == 1) {
                result.code = 200;
                result.message = "upload file success";
                result.data = image.getImg_id();
                return result;
            } else {
                throw BusinessException.INSERT_FAIL;
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw BusinessException.UPLOAD_FILE_FAIL;
        }
    }
}
