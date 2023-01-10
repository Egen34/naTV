package com.example.naTV.models.dto;

import lombok.*;

import java.io.Serializable;
import java.sql.Date;

/**
 * A DTO for the {@link com.example.naTV.models.entity.Order} entity
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class OrderDto implements Serializable {
    private Long id;
    private Boolean active;
    private String text;
    private String name;
    private String phone;
    private String email;
    private Double totalPrice;
    private Date addDate;
    private Date editDate;
    private Boolean status;
}