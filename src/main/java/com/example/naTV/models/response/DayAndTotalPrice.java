package com.example.naTV.models.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DayAndTotalPrice {
    List<DayAndPriceResponse> dayAndPriceResponses;
    @JsonProperty("total_price")
    Double totalPrice;
}
