package com.example.naTV.controller.crud;

import com.example.naTV.configurations.Swagger2Config;
import com.example.naTV.models.dto.OrderDto;
import com.example.naTV.service.Interface.BaseService;
import com.example.naTV.service.Interface.OrderService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/crud/order")
@Api(tags = Swagger2Config.ORDERS)
public class OrderController extends BaseController<OrderDto> {
    private OrderService service;

    public OrderController(OrderService service) {
        super(service);
        this.service = service;
    }
}
