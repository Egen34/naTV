package com.example.naTV.models.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DiscountRequest {
    Double percent;
    @JsonProperty("start_date")
    Date startDate;
    @JsonProperty("end_date")
    Date endDate;
    @JsonProperty("min_day")
    int minDay;
    @JsonProperty("channel_id")
    Long channelId;

}
