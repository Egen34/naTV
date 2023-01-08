package com.example.naTV.service.Interface;

import com.example.naTV.models.dto.DiscountDto;
import com.example.naTV.models.request.DiscountRequest;

public interface DiscountService extends BaseService<DiscountDto> {
    double getDiscountNegativePercent(Long channelId, int dayCount);

    DiscountDto save(DiscountRequest request);
}
