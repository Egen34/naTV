package com.example.naTV.models.request;

import lombok.*;

import java.util.List;
@Getter
@Setter
@RequiredArgsConstructor

public class OrderRequest {
    String text;
    String name;
    String phone;
    String email;
    List<ChannelIdAndDays> channels;

}
