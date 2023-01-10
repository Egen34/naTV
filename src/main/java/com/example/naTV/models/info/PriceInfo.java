package com.example.naTV.models.info;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.sql.Date;

/**
 * A Projection for the {@link com.example.naTV.models.entity.Price} entity
 */
public interface PriceInfo {

    @JsonFormat(pattern = "YYYY.MM.DD")
    Date getStartDate();

    @JsonFormat(pattern = "YYYY.MM.DD")
    Date getEndDate();

    Double getPrice();


}