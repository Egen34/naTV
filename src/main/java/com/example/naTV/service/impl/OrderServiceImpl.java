package com.example.naTV.service.impl;

import com.example.naTV.mapper.EntityAndDTO.OrderMapper;
import com.example.naTV.models.dto.OrderDto;
import com.example.naTV.models.entity.Order;
import com.example.naTV.models.repository.OrderRepository;
import com.example.naTV.service.Interface.OrderService;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OrderServiceImpl extends BaseServiceImpl<Order, OrderDto> implements OrderService {

    private OrderServiceImpl(OrderRepository rep) {

        super(rep, OrderMapper.INSTANCE);

    }



}
