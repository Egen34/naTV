package com.example.naTV.service.Interface;

import com.example.naTV.models.dto.DayDto;
import com.example.naTV.models.dto.OrderDetailDto;

import java.util.Date;
import java.util.List;

public interface DayService extends BaseService<DayDto>{
    void save(OrderDetailDto orderDetailDto, List<Date> days);
}
