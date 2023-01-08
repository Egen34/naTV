package com.example.naTV.service.Interface;

import com.example.naTV.models.dto.ChannelDto;
import com.example.naTV.models.dto.PriceDto;
import com.example.naTV.models.request.PriceRequest;

;
import java.util.Date;
import java.util.List;

public interface PriceService extends BaseService<PriceDto> {
   PriceDto save(ChannelDto dto, Double price);


    Double getActualPrice(Long channelId, List<Date> days, int textLen);

    PriceDto save(PriceRequest request);
}
