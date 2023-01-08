package com.example.naTV.service.impl;

import com.example.naTV.mapper.EntityAndDTO.PriceMapper;
import com.example.naTV.models.dto.ChannelDto;
import com.example.naTV.models.dto.PriceDto;
import com.example.naTV.models.entity.Price;
import com.example.naTV.models.info.PriceInfo;
import com.example.naTV.models.repository.PriceRepository;
import com.example.naTV.models.request.PriceRequest;
import com.example.naTV.service.Interface.PriceService;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PriceServiceImpl extends BaseServiceImpl<Price, PriceDto> implements PriceService {

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
    public Double getActualPrice(Long channelId, List<Date> days, int textLen) {
        double totalPrice = 0;
        Date max = days.stream().max(Date::compareTo).get();
        Date min = days.stream().min(Date::compareTo).get();
        List<PriceInfo> prices = priceRepository.getActualPriceInRange(channelId, min, max);
        for (var item : days) {
            if (!prices.isEmpty()) {
                totalPrice += prices
                        .stream()
                        .filter(p -> p.getStartDate().before(item) && (p.getEndDate() == null || p.getEndDate().after(item)))
                        .min((a, b) -> {
                            if (a.getRange() == null)
                                return (int) (b.getStartDate().getTime() - a.getStartDate().getTime());
                            if (b.getRange() == null)
                                return (int) (a.getStartDate().getTime() - b.getStartDate().getTime());
                            return a.getRange() - b.getRange();
                        })
                        .get()
                        .getPrice();
            }
        }

        return totalPrice * textLen;
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
                        .endDate(request.getEndDate())
                        .build()
        );
    }


}
