package com.example.naTV.controller.crud;

import com.example.naTV.configurations.Swagger2Config;
import com.example.naTV.models.dto.PriceDto;
import com.example.naTV.service.Interface.BaseService;
import com.example.naTV.service.Interface.PriceService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/crud/price")
@Api(tags = Swagger2Config.PRICE)
public class PriceController extends BaseController<PriceDto> {
    private PriceService service;

    public PriceController(PriceService service) {
        super(service);
        this.service = service;
    }
}
