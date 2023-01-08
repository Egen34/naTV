package com.example.naTV.models.info;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * A Projection for the {@link com.example.naTV.models.entity.Price} entity
 */
public interface PriceInfo {
    Integer getRange();
    @JsonFormat(pattern = "YYYY.MM.DD")
    Date getStartDate();

    @JsonFormat(pattern = "YYYY.MM.DD")
    Date getEndDate();

    Double getPrice();


}