package com.example.naTV.service.impl;

import com.example.naTV.models.dto.ChannelDto;
import com.example.naTV.models.dto.DiscountDto;
import com.example.naTV.models.entity.Discount;
import com.example.naTV.mapper.EntityAndDTO.DiscountMapper;
import com.example.naTV.models.info.ActualDiscount;
import com.example.naTV.models.repository.DiscountRepository;
import com.example.naTV.models.request.DiscountRequest;
import com.example.naTV.service.Interface.DiscountService;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DiscountServiceImpl extends BaseServiceImpl<Discount, DiscountDto> implements DiscountService {
    private final DiscountRepository rep;

    private DiscountServiceImpl(DiscountRepository rep) {
        super(rep, DiscountMapper.INSTANCE);
        this.rep = rep;
    }


    @Override
    public double getDiscountNegativePercent(Long channelId, int dayCount) {
        ActualDiscount actualDiscount = rep.getActualDiscount(channelId, dayCount);
        if (actualDiscount == null)
            return 1;
        return (100 - actualDiscount.getPercent()) / 100;
    }

    @Override
    public DiscountDto save(DiscountRequest request) {

        return save(
                DiscountDto.builder()
                        .channel(ChannelDto.builder()
                                .id(request.getChannelId())
                                .build()
                        )
                        .percent(request.getPercent())
                        .minDay(request.getMinDay())
                        .startDate(request.getStartDate())
                        .endDate(request.getEndDate())
                        .build()
        );
    }
}
