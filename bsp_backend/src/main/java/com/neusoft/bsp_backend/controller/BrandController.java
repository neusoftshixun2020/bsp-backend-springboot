package com.neusoft.bsp_backend.controller;

import com.neusoft.bsp_backend.common.base.BaseController;
import com.neusoft.bsp_backend.common.base.BaseModel;
import com.neusoft.bsp_backend.common.base.BaseModelJson;
import com.neusoft.bsp_backend.common.exception.BusinessException;
import com.neusoft.bsp_backend.common.validationGroup.DeleteGroup;
import com.neusoft.bsp_backend.common.validationGroup.InsertGroup;
import com.neusoft.bsp_backend.common.validationGroup.UpdateGroup;
import com.neusoft.bsp_backend.mvoinfo.entity.Brand;
import com.neusoft.bsp_backend.mvoinfo.service.BrandService;
import com.neusoft.bsp_backend.user.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/brand")
public class BrandController extends BaseController {

    @Autowired
    BrandService brandService;

    @PostMapping("/getBrandByFilter")
    public BaseModelJson<List<Brand>> getAllByFilter(@RequestBody Brand brand) {
        Map<String, Object> map = new HashMap<>();
        map.put("man_id", brand.getMan_id());
        List<Brand> brands = brandService.getAllByFilter(map);
        if (brands.size() == 0) {
            throw BusinessException.USERNAME_NOT_EXISTS;
        } else {
            BaseModelJson<List<Brand>> result = new BaseModelJson<>();
            result.code = 200;
            result.data = brands;
            return result;
        }
    }

    @PostMapping("/addBrand")
    public BaseModel addBrand(@Validated({InsertGroup.class}) @RequestBody Brand brand, BindingResult bindingResult) {
        System.out.println(brand);
        if (bindingResult.hasErrors()) {
            throw BusinessException.INSERT_FAIL.newInstance("504", this.getErrorResponse(bindingResult), new Object[]{brand.toString()});
        } else {
            BaseModel result = new BaseModel();
            int i = brandService.insert(brand);
            if (i == 1) {
                result.code = 200;
                return result;
            } else {
                throw BusinessException.INSERT_FAIL;
            }
        }
    }

    @PostMapping("/deleteBrand")
    public BaseModel deleteBrand(@Validated({DeleteGroup.class}) @RequestBody Brand brand, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw BusinessException.USERID_NULL_ERROR.newInstance("504", this.getErrorResponse(bindingResult),
                    new Object[]{brand.toString()});
        } else {
            BaseModel result = new BaseModel();
            int i = brandService.delete(brand.getId());
            if (i == 1) {
                result.code = 200;
                return result;
            } else {
                throw BusinessException.DELETE_FAIL;
            }
        }
    }
    @PostMapping("/updateUser")
    public BaseModel updateUser(@Validated({UpdateGroup.class}) @RequestBody Brand brand, BindingResult bindingResult) {  //bindingResult用于获得validate的反馈信息
        if (bindingResult.hasErrors()) {
            throw BusinessException.USERID_NULL_ERROR.newInstance("504", this.getErrorResponse(bindingResult),
                    new Object[]{brand.toString()});
        } else {
            BaseModel result = new BaseModel();
            int i = brandService.update(brand);
            if(i==1){
                result.code = 200;
                return result;
            }else{
                throw BusinessException.UPDATE_FAIL;
            }
        }
    }
}
