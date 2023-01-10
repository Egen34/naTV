package com.example.naTV.controller.crud;

import com.example.naTV.configurations.Swagger2Config;
import com.example.naTV.models.dto.ChannelDto;
import com.example.naTV.models.entity.Channel;
import com.example.naTV.models.repository.ChannelRepository;
import com.example.naTV.service.Interface.ChannelService;
import com.querydsl.core.types.Predicate;
import io.swagger.annotations.Api;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.querydsl.binding.QuerydslPredicate;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/crud/channel")
@Api(tags = Swagger2Config.CHANNELS)
public class ChannelController extends BaseController<ChannelDto> {
    private final ChannelService service;

    public ChannelController(ChannelService service) {
        super(service);
        this.service = service;
    }

}
