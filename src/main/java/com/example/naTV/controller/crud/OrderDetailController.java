package com.example.naTV.controller.crud;

import com.example.naTV.configurations.Swagger2Config;
import com.example.naTV.models.dto.OrderDetailDto;
import com.example.naTV.service.Interface.BaseService;
import com.example.naTV.service.Interface.OrderDetailService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/crud/order/detail")
@Api(tags = Swagger2Config.ORDERDETAIL)
public class OrderDetailController extends BaseController<OrderDetailDto>{
    OrderDetailService service;

    public OrderDetailController(OrderDetailService service) {
        super(service);
        this.service = service;
    }
}
