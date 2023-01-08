package com.example.naTV.service.Interface;

import com.example.naTV.models.dto.OrderDetailDto;
import com.example.naTV.models.request.ChannelIdAndDays;
import com.example.naTV.models.request.OrderRequest;
import com.example.naTV.models.request.TextAndChannelsWithDays;
import com.example.naTV.models.response.ChannelPriceResponse;
import com.example.naTV.models.response.TotalPriceAndChannels;

public interface OrderDetailService extends BaseService<OrderDetailDto> {

    TotalPriceAndChannels getPricesByChannelsAndDays(TextAndChannelsWithDays request);
    ChannelPriceResponse getPriceByOnlyChannel(ChannelIdAndDays request, String text);

    TotalPriceAndChannels save(OrderRequest order);
}
