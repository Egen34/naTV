package com.example.naTV.mapper.EntityAndDTO;

import com.example.naTV.models.dto.ChannelDto;
import com.example.naTV.models.entity.Channel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ChannelMapper extends BaseMapper<Channel, ChannelDto> {
    ChannelMapper INSTANCE= Mappers.getMapper(ChannelMapper.class);
}
