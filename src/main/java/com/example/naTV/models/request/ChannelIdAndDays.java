package com.example.naTV.models.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;


import java.sql.Date;
import java.util.List;


@RequiredArgsConstructor
@Getter
@Setter
public class ChannelIdAndDays {
    @JsonProperty("channel_id")
    Long id;


    List<Date> days;
}
