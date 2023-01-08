package com.example.naTV.mapper.EntityAndDTO;

import com.example.naTV.models.dto.OrderDetailDto;
import com.example.naTV.models.entity.OrderDetail;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OrderDetailMapper extends BaseMapper<OrderDetail, OrderDetailDto> {
    OrderDetailMapper INSTANCE= Mappers.getMapper(OrderDetailMapper.class);

}
