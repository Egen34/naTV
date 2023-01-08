package com.example.naTV.models.dto;

import com.example.naTV.models.entity.Price;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

/**
 * A DTO for the {@link Price} entity
 */

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class PriceDto implements Serializable {
    private Long id;
    private Boolean active;
    private ChannelDto channels;
    private Date startDate;
    private Date endDate;
    private Double price;
}