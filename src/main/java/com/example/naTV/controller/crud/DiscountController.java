package com.example.naTV.controller.crud;

import com.example.naTV.configurations.Swagger2Config;
import com.example.naTV.models.dto.DiscountDto;
import com.example.naTV.service.Interface.BaseService;
import com.example.naTV.service.Interface.DiscountService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/crud/discount")
@Api(tags = Swagger2Config.DISCOUNT)
public class DiscountController extends BaseController<DiscountDto> {
    private DiscountService service;

    public DiscountController(DiscountService service) {
        super(service);
        this.service = service;
    }
}
