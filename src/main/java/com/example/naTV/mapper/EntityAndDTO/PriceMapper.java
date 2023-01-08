package com.example.naTV.mapper.EntityAndDTO;

import com.example.naTV.models.dto.PriceDto;
import com.example.naTV.models.entity.Price;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PriceMapper extends BaseMapper<Price, PriceDto> {
    PriceMapper INSTANCE= Mappers.getMapper(PriceMapper.class);
}
