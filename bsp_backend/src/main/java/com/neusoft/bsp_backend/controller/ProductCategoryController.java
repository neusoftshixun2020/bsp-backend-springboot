package com.neusoft.bsp_backend.controller;

import com.neusoft.bsp_backend.common.base.BaseController;
import com.neusoft.bsp_backend.common.base.BaseModel;
import com.neusoft.bsp_backend.common.base.BaseModelJson;
import com.neusoft.bsp_backend.common.exception.BusinessException;
import com.neusoft.bsp_backend.common.validationGroup.DeleteGroup;
import com.neusoft.bsp_backend.common.validationGroup.UpdateGroup;
import com.neusoft.bsp_backend.mvoinfo.entity.Brand;
import com.neusoft.bsp_backend.product.entity.ProductCategory;
import com.neusoft.bsp_backend.product.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/productCategory")
public class ProductCategoryController extends BaseController {

    @Autowired
    ProductCategoryService productCategoryService;

    @PostMapping("/getAllCategory")
    public BaseModelJson<List<ProductCategory>> getAllCategory() {
        Map<String, Object> map = new HashMap<>();
        List<ProductCategory> productCategories = productCategoryService.getAllByFilter(map);
        for (ProductCategory productCategory: productCategories) {
            System.out.println("pro_num"+ productCategoryService.getProNum(productCategory.getPrc_id()));
            productCategory.setPro_num(productCategoryService.getProNum(productCategory.getPrc_id()));
        }
        BaseModelJson<List<ProductCategory>> result = new BaseModelJson<>();
        result.code = 200;
        result.data = productCategories;
        return result;
    }



    @PostMapping("/addOrUpdateProductCategory")
    public BaseModel addOrUpdateProductCategory(@Validated({UpdateGroup.class}) @RequestBody ProductCategory productCategory, String operationFlag, BindingResult bindingResult) {
        System.out.println(productCategory);
        System.out.println(operationFlag);
        if (bindingResult.hasErrors()) {
            throw BusinessException.INSERT_FAIL.newInstance("504", this.getErrorResponse(bindingResult), new Object[]{productCategory.toString()});
        } else {
            BaseModel result = new BaseModel();
            if (operationFlag.equals("add")) {
                int i = productCategoryService.insert(productCategory);
                if (i == 1) {
                    result.code = 200;
                    result.message = "add success";
                    return result;
                } else {
                    throw BusinessException.INSERT_FAIL;
                }
            } else if (operationFlag.equals("update")) {
                int j = productCategoryService.update(productCategory);
                if (j == 1) {
                    result.code = 200;
                    result.message = "update success";
                    return result;
                } else {
                    throw BusinessException.UPDATE_FAIL;
                }
            } else {
                throw BusinessException.OPERATION_FAIL;
            }
        }
    }


    @PostMapping("/deleteProductCategory")
    public BaseModel deleteProductCategory(@Validated({DeleteGroup.class}) @RequestBody ProductCategory productCategory, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw BusinessException.USERID_NULL_ERROR.newInstance("504", this.getErrorResponse(bindingResult),
                    new Object[]{productCategory.toString()});
        } else {
            BaseModel result = new BaseModel();
            int i = productCategoryService.delete(productCategory.getId());
            if (i == 1) {
                result.code = 200;
                return result;
            } else {
                throw BusinessException.DELETE_FAIL;
            }
        }
    }


    @PostMapping("getProNum")
    public BaseModelJson<Integer> getProNum(@RequestBody ProductCategory productCategory) {
        Integer prc_id =  productCategory.getPrc_id();
        Integer pro_num = productCategoryService.getProNum(prc_id);
        BaseModelJson<Integer> result = new BaseModelJson<>();
        result.code = 200;
        result.data = pro_num;
        System.out.println(pro_num);
        return result;
    }
}
