package com.neusoft.bsp_backend.controller;

import com.neusoft.bsp_backend.bvo.entity.DropShipper;
import com.neusoft.bsp_backend.bvo.entity.Store;
import com.neusoft.bsp_backend.bvo.service.DropShipperService;
import com.neusoft.bsp_backend.bvo.service.StoreService;
import com.neusoft.bsp_backend.common.base.BaseController;
import com.neusoft.bsp_backend.common.base.BaseModel;
import com.neusoft.bsp_backend.common.base.BaseModelJson;
import com.neusoft.bsp_backend.common.exception.BusinessException;
import com.neusoft.bsp_backend.common.validationGroup.UpdateGroup;
import com.neusoft.bsp_backend.mvoinfo.entity.Manufacturer;
import com.neusoft.bsp_backend.mvoinfo.service.ManService;
import com.neusoft.bsp_backend.order.entity.*;
import com.neusoft.bsp_backend.order.mapper.OrderTrackMapper;
import com.neusoft.bsp_backend.order.service.SalesOrderService;
import com.neusoft.bsp_backend.order.service.ShippingAddressService;
import com.neusoft.bsp_backend.order.service.StoreOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/order")
public class OrderController extends BaseController {
    @Autowired
    SalesOrderService salesOrderService;
    @Autowired
    ManService manService;
    @Autowired
    StoreOrderService storeOrderService;
    @Autowired
    ShippingAddressService shippingAddressService;
    @Autowired
    StoreService storeService;
    @Autowired
    DropShipperService dropShipperService;
    @Autowired
    OrderTrackMapper orderTrackMapper;

    @PostMapping("/getAwaitingPayment")
    public BaseModelJson<List<List<SalesOrder>>> getAwaitingPayment(@RequestBody Manufacturer manufacturer){
        Map<String, Object> map = new HashMap<>();
        map.put("user_id", manufacturer.getUser_id());
        List<Manufacturer> manufacturers = manService.getAllByFilter(map);
        List<List<SalesOrder>> allSalesOrders = new ArrayList<>();
        for(Manufacturer manufacturer1: manufacturers){
            Map<String, Object> map1 = new HashMap<>();
            map1.put("man_id", manufacturer1.getMan_id());
            map1.put("order_sts", "1");
            List<SalesOrder> salesOrders = salesOrderService.getAllByFilter(map1);
            allSalesOrders.add(salesOrders);
        }
        BaseModelJson<List<List<SalesOrder>>> result = new BaseModelJson<>();
        result.code = 200;
        result.data = allSalesOrders;
        return result;
    }

    @PostMapping("/getAwaitingShipment")
    public BaseModelJson<List<List<SalesOrder>>> getAwaitingShipment(@RequestBody Manufacturer manufacturer){
        Map<String, Object> map = new HashMap<>();
        map.put("user_id", manufacturer.getUser_id());
        List<Manufacturer> manufacturers = manService.getAllByFilter(map);
        List<List<SalesOrder>> allSalesOrders = new ArrayList<>();
        for(Manufacturer manufacturer1: manufacturers){
            Map<String, Object> map1 = new HashMap<>();
            map1.put("man_id", manufacturer1.getMan_id());
            map1.put("order_sts", "2");
            List<SalesOrder> salesOrders = salesOrderService.getAllByFilter(map1);
            allSalesOrders.add(salesOrders);
        }
        BaseModelJson<List<List<SalesOrder>>> result = new BaseModelJson<>();
        result.code = 200;
        result.data = allSalesOrders;
        return result;
    }

    @PostMapping("/deliver")
    public BaseModel deliver(@Validated({UpdateGroup.class}) @RequestBody List<SalesOrder> salesOrders, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new BusinessException().UPDATE_FAIL.newInstance("504", this.getErrorResponse(bindingResult), new Object[]{salesOrders.toString()});
        } else {
            BaseModel result = new BaseModel();
            for (SalesOrder salesOrder: salesOrders){
                int i = salesOrderService.update(salesOrder);
                if (i==0){
                    throw BusinessException.UPDATE_FAIL;
                }
            }
            result.code = 200;
            return result;
        }
    }

    @PostMapping("/getShiped")
    public BaseModelJson<List<List<SalesOrder>>> getShiped(@RequestBody Manufacturer manufacturer){
        Map<String, Object> map = new HashMap<>();
        map.put("user_id", manufacturer.getUser_id());
        List<Manufacturer> manufacturers = manService.getAllByFilter(map);
        List<List<SalesOrder>> allSalesOrders = new ArrayList<>();
        for(Manufacturer manufacturer1: manufacturers){
            Map<String, Object> map1 = new HashMap<>();
            map1.put("man_id", manufacturer1.getMan_id());
            map1.put("order_sts", "3");
            List<SalesOrder> salesOrders = salesOrderService.getAllByFilter(map1);
            allSalesOrders.add(salesOrders);
        }
        BaseModelJson<List<List<SalesOrder>>> result = new BaseModelJson<>();
        result.code = 200;
        result.data = allSalesOrders;
        return result;
    }

    @PostMapping("/cancelOrder")
    public BaseModel cancelOrder(@Validated({UpdateGroup.class}) @RequestBody List<SalesOrder> salesOrders, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new BusinessException().UPDATE_FAIL.newInstance("504", this.getErrorResponse(bindingResult), new Object[]{salesOrders.toString()});
        } else {
            BaseModel result = new BaseModel();
            for (SalesOrder salesOrder: salesOrders){
                int i = salesOrderService.update(salesOrder);
                if (i==0){
                    throw BusinessException.UPDATE_FAIL;
                }
            }
            result.code = 200;
            return result;
        }
    }

    @PostMapping("/getCompleted")
    public BaseModelJson<List<List<SalesOrder>>> getCompleted(@RequestBody Manufacturer manufacturer){
        Map<String, Object> map = new HashMap<>();
        map.put("user_id", manufacturer.getUser_id());
        List<Manufacturer> manufacturers = manService.getAllByFilter(map);
        List<List<SalesOrder>> allSalesOrders = new ArrayList<>();
        for(Manufacturer manufacturer1: manufacturers){
            Map<String, Object> map1 = new HashMap<>();
            map1.put("man_id", manufacturer1.getMan_id());
            map1.put("order_sts", "4");
            List<SalesOrder> salesOrders = salesOrderService.getAllByFilter(map1);
            allSalesOrders.add(salesOrders);
        }
        BaseModelJson<List<List<SalesOrder>>> result = new BaseModelJson<>();
        result.code = 200;
        result.data = allSalesOrders;
        return result;
    }

    @PostMapping("/getCancelled")
    public BaseModelJson<List<List<SalesOrder>>> getCancelled(@RequestBody Manufacturer manufacturer){
        Map<String, Object> map = new HashMap<>();
        map.put("user_id", manufacturer.getUser_id());
        List<Manufacturer> manufacturers = manService.getAllByFilter(map);
        List<List<SalesOrder>> allSalesOrders = new ArrayList<>();
        for(Manufacturer manufacturer1: manufacturers){
            Map<String, Object> map1 = new HashMap<>();
            map1.put("man_id", manufacturer1.getMan_id());
            map1.put("order_sts", "5");
            List<SalesOrder> salesOrders = salesOrderService.getAllByFilter(map1);
            allSalesOrders.add(salesOrders);
        }
        BaseModelJson<List<List<SalesOrder>>> result = new BaseModelJson<>();
        result.code = 200;
        result.data = allSalesOrders;
        return result;
    }

    @PostMapping("/getTrack")
    public BaseModelJson<List<OrderTrack>> getTrack(@RequestBody SalesOrder salesOrder){
        List<SalesOrderLineItem> salesOrderLineItems = salesOrder.getSalesOrderLineItems();
        List<OrderTrack> orderTracks = new ArrayList<>();
        for (SalesOrderLineItem salesOrderLineItem: salesOrderLineItems){
            orderTracks.add(orderTrackMapper.getById(salesOrderLineItem.getTracking_no()));
        }
        BaseModelJson<List<OrderTrack>> result = new BaseModelJson<>();
        result.code = 200;
        result.data = orderTracks;
        return result;
    }

    @PostMapping("/getShippingAddress")
    public BaseModelJson<List<ShippingAddress>> getShippingAddress(@RequestBody SalesOrder salesOrder){
        Map<String, Object> map = new HashMap<>();
        map.put("sto_id", salesOrder.getSto_id());
        BaseModelJson<List<ShippingAddress>> result = new BaseModelJson<>();
        result.code = 200;
        result.data = shippingAddressService.getAllByFilter(map);
        return result;
    }

    @PostMapping("/getDsr")
    public BaseModelJson<List<DropShipper>> getDsr(@RequestBody String userid){
        String userid1 = userid.substring(0, userid.length()-1);
        BaseModelJson<List<DropShipper>> result = new BaseModelJson<>();
        Map<String, Object> map = new HashMap<>();
        map.put("user_id", userid1);
        result.code = 200;
        result.data = dropShipperService.getAllByFilter(map);
        return result;
    }
    @PostMapping("/getBvoAwaitingPayment")
    public BaseModelJson<List<List<SalesOrder>>> getBvoAwaitingPayment(@RequestBody DropShipper dropShipper){
        Map<String, Object> map = new HashMap<>();
        map.put("dsr_id", dropShipper.getDsr_id());
        List<Store> stores = storeService.getAllByFilter(map);
        List<List<SalesOrder>> allSalesOrders = new ArrayList<>();
        for(Store store: stores){
            Map<String, Object> map1 = new HashMap<>();
            map1.put("str_id", store.getStr_id());

            List<StoreOrder> storeOrders = storeOrderService.getAllByFilter(map1);
            List<SalesOrder> salesOrders = new ArrayList<>();
            for (StoreOrder storeOrder: storeOrders){
                SalesOrder salesOrder = salesOrderService.getByStoreOrderId(storeOrder.getSto_id());
                if (salesOrder.getOrder_sts().equals("1")){
                    salesOrders.add(salesOrder);
                }
            }
            allSalesOrders.add(salesOrders);
        }
        BaseModelJson<List<List<SalesOrder>>> result = new BaseModelJson<>();
        result.code = 200;
        result.data = allSalesOrders;
        return result;
    }

    @PostMapping("/getBvoAwaitingShipment")
    public BaseModelJson<List<List<SalesOrder>>> getBvoAwaitingShipment(@RequestBody DropShipper dropShipper){
        Map<String, Object> map = new HashMap<>();
        map.put("dsr_id", dropShipper.getDsr_id());
        List<Store> stores = storeService.getAllByFilter(map);
        List<List<SalesOrder>> allSalesOrders = new ArrayList<>();
        for(Store store: stores){
            Map<String, Object> map1 = new HashMap<>();
            map1.put("str_id", store.getStr_id());

            List<StoreOrder> storeOrders = storeOrderService.getAllByFilter(map1);
            List<SalesOrder> salesOrders = new ArrayList<>();
            for (StoreOrder storeOrder: storeOrders){
                SalesOrder salesOrder = salesOrderService.getByStoreOrderId(storeOrder.getSto_id());
                if (salesOrder.getOrder_sts().equals("2")){
                    salesOrders.add(salesOrder);
                }
            }
            allSalesOrders.add(salesOrders);
        }
        BaseModelJson<List<List<SalesOrder>>> result = new BaseModelJson<>();
        result.code = 200;
        result.data = allSalesOrders;
        return result;
    }
    @PostMapping("/getBvoShiped")
    public BaseModelJson<List<List<SalesOrder>>> getBvoShiped(@RequestBody DropShipper dropShipper){
        Map<String, Object> map = new HashMap<>();
        map.put("dsr_id", dropShipper.getDsr_id());
        List<Store> stores = storeService.getAllByFilter(map);
        List<List<SalesOrder>> allSalesOrders = new ArrayList<>();
        for(Store store: stores){
            Map<String, Object> map1 = new HashMap<>();
            map1.put("str_id", store.getStr_id());

            List<StoreOrder> storeOrders = storeOrderService.getAllByFilter(map1);
            List<SalesOrder> salesOrders = new ArrayList<>();
            for (StoreOrder storeOrder: storeOrders){
                SalesOrder salesOrder = salesOrderService.getByStoreOrderId(storeOrder.getSto_id());
                if (salesOrder.getOrder_sts().equals("3")){
                    salesOrders.add(salesOrder);
                }
            }
            allSalesOrders.add(salesOrders);
        }
        BaseModelJson<List<List<SalesOrder>>> result = new BaseModelJson<>();
        result.code = 200;
        result.data = allSalesOrders;
        return result;
    }
    @PostMapping("/getBvoCompleted")
    public BaseModelJson<List<List<SalesOrder>>> getBvoCompleted(@RequestBody DropShipper dropShipper){
        Map<String, Object> map = new HashMap<>();
        map.put("dsr_id", dropShipper.getDsr_id());
        List<Store> stores = storeService.getAllByFilter(map);
        List<List<SalesOrder>> allSalesOrders = new ArrayList<>();
        for(Store store: stores){
            Map<String, Object> map1 = new HashMap<>();
            map1.put("str_id", store.getStr_id());

            List<StoreOrder> storeOrders = storeOrderService.getAllByFilter(map1);
            List<SalesOrder> salesOrders = new ArrayList<>();
            for (StoreOrder storeOrder: storeOrders){
                SalesOrder salesOrder = salesOrderService.getByStoreOrderId(storeOrder.getSto_id());
                if (salesOrder.getOrder_sts().equals("4")){
                    salesOrders.add(salesOrder);
                }
            }
            allSalesOrders.add(salesOrders);
        }
        BaseModelJson<List<List<SalesOrder>>> result = new BaseModelJson<>();
        result.code = 200;
        result.data = allSalesOrders;
        return result;
    }

    @PostMapping("/getBvoCancelled")
    public BaseModelJson<List<List<SalesOrder>>> getBvoCancelled(@RequestBody DropShipper dropShipper){
        Map<String, Object> map = new HashMap<>();
        map.put("dsr_id", dropShipper.getDsr_id());
        List<Store> stores = storeService.getAllByFilter(map);
        List<List<SalesOrder>> allSalesOrders = new ArrayList<>();
        for(Store store: stores){
            Map<String, Object> map1 = new HashMap<>();
            map1.put("str_id", store.getStr_id());

            List<StoreOrder> storeOrders = storeOrderService.getAllByFilter(map1);
            List<SalesOrder> salesOrders = new ArrayList<>();
            for (StoreOrder storeOrder: storeOrders){
                SalesOrder salesOrder = salesOrderService.getByStoreOrderId(storeOrder.getSto_id());
                if (salesOrder.getOrder_sts().equals("5")){
                    salesOrders.add(salesOrder);
                }
            }
            allSalesOrders.add(salesOrders);
        }
        BaseModelJson<List<List<SalesOrder>>> result = new BaseModelJson<>();
        result.code = 200;
        result.data = allSalesOrders;
        return result;
    }
}
