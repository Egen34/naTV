package com.example.naTV.service.Interface;

import com.example.naTV.models.dto.ChannelDto;
import com.example.naTV.models.response.GetChannalRespnonse;
import com.querydsl.core.types.Predicate;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ChannelService extends BaseService<ChannelDto> {


    List<ChannelDto> findAll(Predicate predicate,Pageable pageable);
    List<GetChannalRespnonse> getChannels(Pageable pageable);

    ChannelDto save(String name, int orderNum, MultipartFile photo, Double price);
}
