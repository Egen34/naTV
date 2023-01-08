package com.example.naTV.service.impl;

import com.example.naTV.mapper.EntityAndDTO.DayMapper;
import com.example.naTV.models.dto.DayDto;
import com.example.naTV.models.dto.OrderDetailDto;
import com.example.naTV.models.entity.Day;
import com.example.naTV.models.repository.DayRepository;
import com.example.naTV.service.Interface.DayService;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DayServiceImpl extends BaseServiceImpl<Day, DayDto> implements DayService {

    private DayServiceImpl(DayRepository rep) {

        super(rep, DayMapper.INSTANCE);
    }

    @Override
    public void save(OrderDetailDto orderDetailDto, List<Date> days) {
        for (var day:days){
            DayDto dto=new DayDto();
            dto.setOrderDetails(orderDetailDto);
            dto.setDay(day);
            this.save(dto);
        }

    }
}
