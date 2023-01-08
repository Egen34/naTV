package com.example.naTV.mapper.EntityAndDTO;

import com.example.naTV.models.dto.OrderDto;
import com.example.naTV.models.entity.Order;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OrderMapper extends BaseMapper<Order, OrderDto>{
    OrderMapper INSTANCE= Mappers.getMapper(OrderMapper.class);

}
