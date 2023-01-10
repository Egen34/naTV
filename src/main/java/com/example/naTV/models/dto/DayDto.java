package com.example.naTV.models.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.sql.Date;

/**
 * A DTO for the {@link com.example.naTV.models.entity.Day} entity
 */
@RequiredArgsConstructor
@Getter
@Setter
@ToString

public class DayDto implements Serializable {
    private Long id;
    private Boolean active;
    private OrderDetailDto orderDetails;
    private Date day;
}