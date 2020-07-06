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

    @PostMapping("/getProductCategoryByFilter")
    public BaseModelJson<List<ProductCategory>> getAllByFilter(@RequestBody Brand brand) {
        Map<String, Object> map = new HashMap<>();
        List<ProductCategory> productCategories = productCategoryService.getAllByFilter(map);
        if (productCategories.size() == 0) {
            throw BusinessException.NOT_EXISTS;
        } else {
            BaseModelJson<List<ProductCategory>> result = new BaseModelJson<>();
            result.code = 200;
            result.data = productCategories;
            return result;
        }
    }

    @PostMapping("/addProductCategory")
    public BaseModel addBrand(@RequestBody ProductCategory productCategory, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw BusinessException.INSERT_FAIL.newInstance("504", this.getErrorResponse(bindingResult), new Object[]{productCategory.toString()});
        } else {
            BaseModel result = new BaseModel();
            int i = productCategoryService.insert(productCategory);
            if (i == 1) {
                result.code = 200;
                return result;
            } else {
                throw BusinessException.INSERT_FAIL;
            }
        }
    }

    @PostMapping("/addOrUpdateProductCategory")
    public BaseModel addOrUpdateProductCategory(@Validated({UpdateGroup.class}) @RequestBody ProductCategory productCategory, BindingResult bindingResult) {
        System.out.println(productCategory);
        if (bindingResult.hasErrors()) {
            throw BusinessException.INSERT_FAIL.newInstance("504", this.getErrorResponse(bindingResult), new Object[]{productCategory.toString()});
        } else {
            BaseModel result = new BaseModel();
            int i = productCategoryService.insert(productCategory);
            if (i == 1) {
                result.code = 200;
                return result;
            } else {
                int j = productCategoryService.update(productCategory);
                if (j == 1) {
                    result.code = 200;
                    return result;
                } else {
                    throw BusinessException.OPERATION_FAIL;
                }
            }
        }
    }


    @PostMapping("/deleteProductCategory")
    public BaseModel deleteBrand(@Validated({DeleteGroup.class}) @RequestBody ProductCategory productCategory, BindingResult bindingResult) {
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
    @PostMapping("/updateBrand")
    public BaseModel updateBrand(@Validated({UpdateGroup.class}) @RequestBody ProductCategory productCategory, BindingResult bindingResult) {  //bindingResult用于获得validate的反馈信息
        if (bindingResult.hasErrors()) {
            throw BusinessException.NOT_EXISTS.newInstance("504", this.getErrorResponse(bindingResult),
                    new Object[]{productCategory.toString()});
        } else {
            BaseModel result = new BaseModel();
            int i = productCategoryService.update(productCategory);
            if(i==1){
                result.code = 200;
                return result;
            }else{
                throw BusinessException.UPDATE_FAIL;
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
