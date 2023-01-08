package com.example.naTV.models.response;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

/**
 * A Projection for the {@link com.example.naTV.models.entity.Channel} entity
 */
public interface GetChannalRespnonse extends Serializable {
    Long getId();

    String getName();

    String getPhoto();
    Set<DiscountInfo> getDiscounts();
    interface DiscountInfo {
        Double getPercent();

        int getMinDay();
    }
    interface PriceInfo{
        double getPrice();
        Date getEndDate();
    }

}