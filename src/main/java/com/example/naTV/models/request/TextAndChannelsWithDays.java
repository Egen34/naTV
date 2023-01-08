package com.example.naTV.models.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TextAndChannelsWithDays {
    String text;
    @JsonProperty("channels")
    List<ChannelIdAndDays> channelIdAndDaysList;

}
