package com.example.naTV.mapper.EntityAndDTO;

import com.example.naTV.models.dto.DiscountDto;
import com.example.naTV.models.entity.Discount;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DiscountMapper extends BaseMapper<Discount, DiscountDto> {
    DiscountMapper INSTANCE= Mappers.getMapper(DiscountMapper.class);
}
