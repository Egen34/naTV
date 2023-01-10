package com.example.naTV.models.response;

import lombok.*;

import java.sql.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DayAndPriceResponse {
    Date day;
    Double price;
}
