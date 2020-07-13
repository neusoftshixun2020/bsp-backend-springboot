package com.neusoft.bsp_backend.controller;

import com.neusoft.bsp_backend.bvo.entity.Store;
import com.neusoft.bsp_backend.bvo.entity.StoreDropShipItem;
import com.neusoft.bsp_backend.bvo.entity.WishList;
import com.neusoft.bsp_backend.bvo.service.StoreDropShipItemService;
import com.neusoft.bsp_backend.bvo.service.StoreService;
import com.neusoft.bsp_backend.bvo.service.WishListService;
import com.neusoft.bsp_backend.common.base.BaseController;
import com.neusoft.bsp_backend.common.base.BaseModel;
import com.neusoft.bsp_backend.common.base.BaseModelJson;
import com.neusoft.bsp_backend.common.exception.BusinessException;
import com.neusoft.bsp_backend.common.validationGroup.DeleteGroup;
import com.neusoft.bsp_backend.product.entity.Product;
import com.neusoft.bsp_backend.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@CrossOrigin
@RestController
@RequestMapping("/bvo")
public class BvoController extends BaseController {
    @Autowired
    WishListService wishListService;
    @Autowired
    StoreDropShipItemService storeDropShipItemService;
    @Autowired
    StoreService storeService;
    @Autowired
    ProductService productService;
    @PostMapping("/addStore")
    public BaseModel addStore(@RequestBody Store store, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            throw BusinessException.INSERT_FAIL.newInstance("504", this.getErrorResponse(bindingResult), new Object[]{store.toString()});
        }else {
            BaseModel result = new BaseModel();
            int i = storeService.insert(store);
            if (i == 1) {
                result.code = 200;
                return result;
            } else {
                throw BusinessException.INSERT_FAIL;
            }
        }
    }

    @PostMapping("/getEbayStore")
    public BaseModelJson<List<Store>> getEbayStore(@RequestBody Store store){
        Map<String, Object> map = new HashMap<>();
        map.put("plataeform_type", store.getPlataeform_type());
        map.put("dsr_id", store.getDsr_id());
        BaseModelJson<List<Store>> result = new BaseModelJson<>();
        result.code = 200;
        result.data = storeService.getAllByFilter(map);
        return result;
    }

    @PostMapping("/getAmazonStore")
    public BaseModelJson<List<Store>> getAmazonStore(@RequestBody Store store){
        Map<String, Object> map = new HashMap<>();
        map.put("plataeform_type", store.getPlataeform_type());
        map.put("dsr_id", store.getDsr_id());
        BaseModelJson<List<Store>> result = new BaseModelJson<>();
        result.code = 200;
        result.data = storeService.getAllByFilter(map);
        return result;
    }
    @PostMapping("/getWishListProducts")
    public BaseModelJson<List<WishList>> getWishListProducts(@RequestBody WishList wishList){
        Map<String, Object> map = new HashMap<>();
        map.put("dsr_id", wishList.getDsr_id());
        List<WishList> wishLists= wishListService.getAllByFilter(map);
        BaseModelJson<List<WishList>> result = new BaseModelJson<>();
        result.code = 200;
        result.data = wishLists;
        return result;
    }
    @PostMapping("/addWishList")
    public BaseModel addWishList(@RequestBody WishList wishList, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            throw BusinessException.INSERT_FAIL.newInstance("504", this.getErrorResponse(bindingResult), new Object[]{wishList.toString()});
        }else {
            BaseModel result = new BaseModel();
            int i = wishListService.insert(wishList);
            if (i == 1) {
                result.code = 200;
                return result;
            } else {
                throw BusinessException.INSERT_FAIL;
            }
        }
    }
    @PostMapping("/deleteWishList")
    public BaseModel deleteWishList(@Validated({DeleteGroup.class}) @RequestBody WishList wishList, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw BusinessException.USERID_NULL_ERROR.newInstance("504", this.getErrorResponse(bindingResult),
                    new Object[]{wishList.toString()});
        } else {
            BaseModel result = new BaseModel();
            int i = wishListService.delete(wishList.getId());
            if (i == 1) {
                result.code = 200;
                return result;
            } else {
                throw BusinessException.DELETE_FAIL;
            }
        }
    }
    @PostMapping("/addDropShipItem")
    public BaseModel addDropShipItem(@RequestBody List<StoreDropShipItem> storeDropShipItems, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            throw BusinessException.INSERT_FAIL.newInstance("504", this.getErrorResponse(bindingResult), new Object[]{storeDropShipItems.toString()});
        }else {
            BaseModel result = new BaseModel();
            for (StoreDropShipItem storeDropShipItem: storeDropShipItems){
                int i = storeDropShipItemService.insert(storeDropShipItem);
                if (i != 1){
                    result.code = 504;
                    throw BusinessException.INSERT_FAIL;
                }
            }
            result.code = 200;
            return result;
        }
    }


}
