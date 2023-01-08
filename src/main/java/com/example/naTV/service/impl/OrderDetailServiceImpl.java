package com.example.naTV.service.impl;

import com.example.naTV.mapper.EntityAndDTO.OrderDetailMapper;
import com.example.naTV.models.dto.OrderDetailDto;
import com.example.naTV.models.dto.OrderDto;
import com.example.naTV.models.entity.OrderDetail;
import com.example.naTV.models.repository.BaseRepository;
import com.example.naTV.models.request.ChannelIdAndDays;
import com.example.naTV.models.request.OrderRequest;
import com.example.naTV.models.request.TextAndChannelsWithDays;
import com.example.naTV.models.response.ChannelPriceResponse;
import com.example.naTV.models.response.TotalPriceAndChannels;
import com.example.naTV.service.Interface.*;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OrderDetailServiceImpl extends BaseServiceImpl<OrderDetail, OrderDetailDto> implements OrderDetailService {
    private final PriceService priceService;
    private final DiscountService discountService;
    private final ChannelService channelService;

    private final OrderService orderService;
    private final DayService dayService;

    @Autowired
    public OrderDetailServiceImpl(BaseRepository<OrderDetail, Long> repository, PriceService priceService, DiscountService discountService, ChannelService channelService, OrderService orderService, DayService dayService) {
        super(repository, OrderDetailMapper.INSTANCE);
        this.priceService = priceService;
        this.discountService = discountService;
        this.channelService = channelService;
        this.orderService = orderService;
        this.dayService = dayService;
    }


    @Override
    public TotalPriceAndChannels getPricesByChannelsAndDays(TextAndChannelsWithDays request) {
        Double price = 0d;
        Double priceDiscount = 0d;
        List<ChannelPriceResponse> list = new ArrayList<>();
        for (var item : request.getChannelIdAndDaysList()) {
            ChannelPriceResponse priceResponse = getPriceByOnlyChannel(item, request.getText());
            price += priceResponse.getPrice();
            priceDiscount += priceResponse.getDiscountPrice();
            list.add(priceResponse);
        }

        return TotalPriceAndChannels
                .builder()
                .totalPrice(price)
                .channelPriceResponseList(list)
                .totalPriceWithDiscount(priceDiscount)
                .build();
    }

    @Override
    public ChannelPriceResponse getPriceByOnlyChannel(ChannelIdAndDays request, String text) {
        int textLen = text.length() - StringUtils.countOccurrencesOf(text, " ");
        double price = priceService.getActualPrice(request.getId(), request.getDays(), textLen);
        return ChannelPriceResponse.builder()
                .id(request.getId())
                .price(price)
                .discountPrice(
                        price * discountService
                                .getDiscountNegativePercent(
                                        request.getId(),
                                        request.getDays().size()
                                )
                )
                .build();
    }

    @Override
    public TotalPriceAndChannels save(OrderRequest request) {
        TotalPriceAndChannels totalPriceAndChannels = getPricesByChannelsAndDays(
                TextAndChannelsWithDays
                        .builder()
                        .text(request.getText())
                        .channelIdAndDaysList(request.getChannels())
                        .build()
        );
        OrderDto orderDto = orderService.save(
                OrderDto
                        .builder()
                        .email(request.getEmail())
                        .phone(request.getPhone())
                        .name(request.getName())
                        .totalPrice(totalPriceAndChannels.getTotalPriceWithDiscount())
                        .text(request.getText())
                        .build()
        );


        Map<Long, Double> priceMap = new HashMap<>();
        for (var i : totalPriceAndChannels.getChannelPriceResponseList()) {
            priceMap.put(i.getId(), i.getDiscountPrice());
        }
        for (var item : request.getChannels()) {
            OrderDetailDto orderDetailDto = this.save(
                    OrderDetailDto
                            .builder()
                            .orders(orderDto)
                            .price(priceMap.get(item.getId()))
                            .channel(channelService.findById(item.getId()))
                            .build()
            );
            dayService.save(orderDetailDto, item.getDays());

        }


        return totalPriceAndChannels;
    }
}
