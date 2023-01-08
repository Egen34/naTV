package com.example.naTV.models.dto;

import com.example.naTV.models.entity.Discount;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

/**
 * A DTO for the {@link Discount} entity
 */
@Builder
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class DiscountDto implements Serializable {
    private Long id;
    private Boolean active;
    private ChannelDto channel;
    private Double percent;
    private Date startDate;
    private Date endDate;
    private int minDay;
}