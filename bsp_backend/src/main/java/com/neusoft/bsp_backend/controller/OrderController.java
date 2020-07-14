package com.neusoft.bsp_backend.controller;

import com.neusoft.bsp_backend.order.service.SalesOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    SalesOrderService salesOrderService;

}
