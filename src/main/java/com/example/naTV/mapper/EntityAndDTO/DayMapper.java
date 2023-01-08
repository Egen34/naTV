package com.example.naTV.mapper.EntityAndDTO;

import com.example.naTV.models.dto.DayDto;
import com.example.naTV.models.entity.Day;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DayMapper extends BaseMapper<Day, DayDto> {
    DayMapper INSTANCE= Mappers.getMapper(DayMapper.class);
}
