package com.example.naTV.models.dto;

import com.example.naTV.models.entity.Discount;
import com.example.naTV.models.entity.OrderDetail;
import com.example.naTV.models.entity.Price;
import lombok.*;

import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * A DTO for the {@link com.example.naTV.models.entity.Channel} entity
 */
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ChannelDto implements Serializable {
    private Long id;
    private Boolean active;
    private String name;
    private String photo;
    private Integer orderNum;


}