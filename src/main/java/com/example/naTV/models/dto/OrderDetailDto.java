package com.example.naTV.models.dto;

import lombok.*;

import java.io.Serializable;

/**
 * A DTO for the {@link com.example.naTV.models.entity.OrderDetail} entity
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class OrderDetailDto implements Serializable {
    private  Long id;
    private  Boolean active;
    private  ChannelDto channel;
    private  OrderDto orders;
    private  Double price;
}