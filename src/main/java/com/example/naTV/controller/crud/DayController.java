package com.example.naTV.controller.crud;

import com.example.naTV.configurations.Swagger2Config;
import com.example.naTV.models.dto.DayDto;
import com.example.naTV.service.Interface.BaseService;
import com.example.naTV.service.Interface.DayService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;
@RestController
@RequestMapping("/api/v1/crud/day")
@Api(tags = Swagger2Config.DAY)
public class DayController extends BaseController<DayDto> {
    private DayService service;

    public DayController(DayService service) {
        super(service);
        this.service = service;
    }
}
