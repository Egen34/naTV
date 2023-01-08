package com.example.naTV.models.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class TotalPriceAndChannels {
    @JsonProperty("total_price")
    Double totalPrice;
    @JsonProperty("total_price_with_discount")
    Double totalPriceWithDiscount;
    @JsonProperty("channels")
    List<ChannelPriceResponse> channelPriceResponseList;
}
