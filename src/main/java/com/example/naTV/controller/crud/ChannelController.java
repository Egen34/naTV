package com.example.naTV.controller.crud;

import com.example.naTV.configurations.Swagger2Config;
import com.example.naTV.models.dto.ChannelDto;
import com.example.naTV.service.Interface.BaseService;
import com.example.naTV.service.Interface.ChannelService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.Tag;
import org.springframework.lang.NonNullApi;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

@RestController
@RequestMapping("/api/v1/crud/channel")
@Api(tags = Swagger2Config.CHANNELS)
public class ChannelController extends BaseController<ChannelDto>{
    private final ChannelService service;
    public ChannelController(ChannelService service) {
        super(service);
        this.service=service;
    }
}
