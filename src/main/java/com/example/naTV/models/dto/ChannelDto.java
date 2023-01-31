package com.example.naTV.models.dto;

import lombok.*;

import java.io.Serializable;

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