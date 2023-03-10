package com.example.naTV.controller.defaults;

import com.example.naTV.configurations.Swagger2Config;
import com.example.naTV.models.request.OrderRequest;
import com.example.naTV.models.request.TextAndChannelsWithDays;
import com.example.naTV.models.response.TotalPriceAndChannels;
import com.example.naTV.service.Interface.OrderDetailService;
import io.swagger.annotations.Api;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/order")
@Api(tags = Swagger2Config.ORDERS)
public class OrderContr {
    OrderDetailService orderDetailService;

    public OrderContr(OrderDetailService orderDetailService) {
        this.orderDetailService = orderDetailService;
    }

    @PostMapping("save/orders")
//    @ApiOperation("метод для получения данных")
    ResponseEntity<?> saveOrder(@RequestBody OrderRequest request){

        return ResponseEntity.ok(orderDetailService.save(request));//TODO Нужно уточнить
    }



    @PostMapping ("order/price")
    ResponseEntity<TotalPriceAndChannels> getOrderPrice(@RequestBody TextAndChannelsWithDays request){
        return ResponseEntity.ok(orderDetailService.getPricesByChannelsAndDays(request));
    }



}
