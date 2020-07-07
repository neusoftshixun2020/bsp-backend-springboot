package com.neusoft.bsp_backend.controller;

import com.github.pagehelper.PageInfo;
import com.neusoft.bsp_backend.common.base.BaseController;
import com.neusoft.bsp_backend.common.base.BaseModel;
import com.neusoft.bsp_backend.common.base.BaseModelJson;
import com.neusoft.bsp_backend.common.exception.BusinessException;
import com.neusoft.bsp_backend.common.validationGroup.DeleteGroup;
import com.neusoft.bsp_backend.common.validationGroup.InsertGroup;
import com.neusoft.bsp_backend.product.entity.Product;
import com.neusoft.bsp_backend.product.service.ProductService;
import com.neusoft.bsp_backend.user.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/product")
public class ProductController extends BaseController {

    @Autowired
    ProductService productService;

    @PostMapping("/getProducts")
    public BaseModelJson<PageInfo<Product>> getProducts(Integer pageNum, Integer pageSize) {
        Map<String, Object> map = new HashMap<>();
        BaseModelJson<PageInfo<Product>> result = new BaseModelJson();
        if (pageNum == null) {
            pageNum = 1;
        }
        if (pageSize == null) {
            pageSize = 10;
        }
        result.code = 200;
        result.data = productService.getAllByFilter(pageNum, pageSize, map);

        return result;
    }

    @PostMapping("/getProductByTitle")
    public BaseModelJson<PageInfo<Product>> getProductByTitle(Integer pageNum, Integer pageSize,
                                                              @RequestBody Product product){
        Map<String, Object> map = new HashMap<>();
        map.put("title", product.getTitle());
        BaseModelJson<PageInfo<Product>> result = new BaseModelJson();
        if (pageNum == null) {
            pageNum = 1;
        }
        if (pageSize == null) {
            pageSize = 10;
        }
        result.code = 200;
        result.data = productService.getAllByFilter(pageNum, pageSize, map);

        return result;
    }

    @PostMapping("/deleteProduct")
    public BaseModel deleteProduct(@Validated({DeleteGroup.class}) @RequestBody Product product, BindingResult bindingResult) {
        System.out.println(product);
        if (bindingResult.hasErrors()) {
            throw BusinessException.USERID_NULL_ERROR.newInstance("504", this.getErrorResponse(bindingResult),
                    new Object[]{product.toString()});
        } else {
            BaseModel result = new BaseModel();
            int i = productService.delete(product.getId());
            if (i == 1) {
                result.code = 200;
                return result;
            } else {
                throw BusinessException.DELETE_FAIL;
            }
        }
    }

    @PostMapping("/addAndUpdateProduct")
    public BaseModel addAndUpdateProduct(@RequestBody Product product, BindingResult bindingResult, String operationFlag) {
        System.out.println(product);
        System.out.println(operationFlag);
        if (bindingResult.hasErrors()) {
            throw BusinessException.INSERT_FAIL.newInstance("504", this.getErrorResponse(bindingResult), new Object[]{product.toString()});
        } else {
            BaseModel result = new BaseModel();
            int i=0;
            if (operationFlag.equals("add")){
                i = productService.insert(product);
            }else if (operationFlag.equals("modify")){
                i = productService.update(product);
            }
            if (i == 4) {
                result.code = 200;
                return result;
            } else {
                throw BusinessException.INSERT_FAIL;
            }
        }
    }
}
