package com.example.naTV.service.impl;

import com.example.naTV.mapper.EntityAndDTO.PriceMapper;
import com.example.naTV.models.dto.ChannelDto;
import com.example.naTV.models.dto.PriceDto;
import com.example.naTV.models.entity.Price;
import com.example.naTV.models.entity.QPrice;
import com.example.naTV.models.repository.PriceRepository;
import com.example.naTV.models.request.PriceRequest;
import com.example.naTV.models.response.DayAndPriceResponse;
import com.example.naTV.models.response.DayAndTotalPrice;
import com.example.naTV.service.Interface.PriceService;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PriceServiceImpl extends BaseServiceImpl<Price, QPrice, PriceDto> implements PriceService {

    private final PriceRepository priceRepository;

    private PriceServiceImpl(PriceRepository rep,
                             PriceRepository priceRepository) {
        super(rep, PriceMapper.INSTANCE);
        this.priceRepository = priceRepository;
    }


    @Override
    public PriceDto save(ChannelDto channelDto, Double price) {
        PriceDto dto = new PriceDto();
        dto.setPrice(price);
        dto.setChannels(channelDto);
        return super.save(dto);
    }

    @Override
    public DayAndTotalPrice getActualPrice(Long channelId, List<Date> days, int textLen) {
        double totalPrice = 0;
        List<DayAndPriceResponse> dayAndPriceResponseList=new ArrayList<>();
        for (var item : days) {
            Double price=priceRepository.getActualPriceInRange(channelId, item).get(0).getPrice();
            totalPrice += price;
            dayAndPriceResponseList.add(DayAndPriceResponse.builder()
                    .day(item)
                    .price(price)
                    .build());
        }

        return DayAndTotalPrice.builder()
                .totalPrice(totalPrice * textLen)
                .dayAndPriceResponses(dayAndPriceResponseList)
                .build();

    }

    @Override
    public PriceDto save(PriceRequest request) {
        return save(
                PriceDto.builder()
                        .startDate(request.getStartDate())
                        .channels(ChannelDto.builder()
                                .id(request.getChannelId())
                                .build()
                        )
                        .price(request.getPrice())
                        .endDate(request.getEndDate())
                        .build()
        );
    }


}
