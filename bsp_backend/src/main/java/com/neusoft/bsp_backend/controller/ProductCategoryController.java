package com.neusoft.bsp_backend.controller;

import com.neusoft.bsp_backend.common.base.BaseController;
import com.neusoft.bsp_backend.common.base.BaseModel;
import com.neusoft.bsp_backend.common.base.BaseModelJson;
import com.neusoft.bsp_backend.common.exception.BusinessException;
import com.neusoft.bsp_backend.common.validationGroup.DeleteGroup;
import com.neusoft.bsp_backend.common.validationGroup.UpdateGroup;
import com.neusoft.bsp_backend.mvoinfo.entity.Brand;
import com.neusoft.bsp_backend.product.entity.Product;
import com.neusoft.bsp_backend.product.entity.ProductCategory;
import com.neusoft.bsp_backend.product.service.ProductCategoryService;
import com.neusoft.bsp_backend.product.service.ProductService;
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

    @Autowired
    ProductService productService;

    @PostMapping("/getAllCategory")
    public BaseModelJson<List<ProductCategory>> getAllCategory() {
        Map<String, Object> map = new HashMap<>();
        List<ProductCategory> productCategories = productCategoryService.getAllByFilter(map);
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
                Map<String, Object> map = new HashMap<>();
                map.put("title", productCategory.getProduct().getTitle());
                List<Product> productList = productService.getAllByFilter(map);
                if (productList.size() == 0) {
                    throw BusinessException.PRODUCT_NOT_EXISTS.newInstance("504", "product not exist", new Object[]{productCategory.getProduct().getTitle()});
                } else {
                    Product product = productList.get(0);
                    productCategory.setPro_id(product.getPro_id());
                }
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
}
