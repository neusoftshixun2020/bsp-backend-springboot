package com.neusoft.bsp_backend.controller;


import com.github.pagehelper.PageInfo;
import com.neusoft.bsp_backend.common.base.BaseController;
import com.neusoft.bsp_backend.common.base.BaseModel;
import com.neusoft.bsp_backend.common.base.BaseModelJson;
import com.neusoft.bsp_backend.common.exception.BusinessException;
import com.neusoft.bsp_backend.common.validationGroup.InsertGroup;
import com.neusoft.bsp_backend.common.validationGroup.UpdateGroup;
import com.neusoft.bsp_backend.mvoinfo.entity.Manufacturer;
import com.neusoft.bsp_backend.mvoinfo.service.ManService;
import com.neusoft.bsp_backend.user.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/manufacturer")
public class ManController extends BaseController {

    @Autowired
    ManService manService;

    @PostMapping("/addManufacturer")
    public BaseModel addManufacturer(@Validated({InsertGroup.class}) @RequestBody Manufacturer manufacturer, BindingResult bindingResult) {
        System.out.println(manufacturer);
        if (bindingResult.hasErrors()) {
            throw new BusinessException().INSERT_FAIL.newInstance("504", this.getErrorResponse(bindingResult), new Object[]{manufacturer.toString()});
        } else {
            BaseModel result = new BaseModel();
            int i = manService.insert(manufacturer);
            if (i == 1) {
                result.code = 200;
                return result;
            } else {
                throw BusinessException.INSERT_FAIL.newInstance("504", "Insert into database failed",new Object[]{manufacturer.toString()} );
            }
        }
    }

    @PostMapping("/UpdateManufacturer")
    public BaseModel updateManufacturer(@Validated({UpdateGroup.class}) @RequestBody Manufacturer manufacturer, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new BusinessException().UPDATE_FAIL.newInstance("504", this.getErrorResponse(bindingResult), new Object[]{manufacturer.toString()});
        } else {
            BaseModel result = new BaseModel();
            int i = manService.update(manufacturer);
            if (i == 1) {
                result.code = 200;
                return result;
            } else {
                throw BusinessException.UPDATE_FAIL;
            }
        }
    }

    @PostMapping("/getManByFilter")
    public BaseModelJson<PageInfo<Manufacturer>> getManList(Integer pageNum, Integer pageSize,
                                                     @RequestBody Manufacturer manufacturer) {
        Map<String, Object> map = new HashMap<>();
        BaseModelJson<PageInfo<Manufacturer>> result = new BaseModelJson();
        if (pageNum == null) {
            pageNum = 1;
        }
        if (pageSize == null) {
            pageSize = 10;
        }
        result.code = 200;
        result.data = manService.getAllByFilter(pageNum, pageSize, map);

        return result;
    }

}
