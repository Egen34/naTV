package com.example.naTV.models.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ChannelPriceResponse {
    @JsonProperty("channel_id")
    Long id;
    String name;

    Double price;
    @JsonProperty("price_with_discount")
    Double discountPrice;
    @JsonProperty("day_and_price")
    DayAndTotalPrice dayAndPrice;
}
