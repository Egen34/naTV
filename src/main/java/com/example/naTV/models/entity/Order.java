package com.example.naTV.models.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

import java.util.Date;

@Entity(name = "orders")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Order  extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String text;
    String name;
    String phone;
    String email;
    @Column(name = "total_price")
    Double totalPrice;

    Boolean status;
    @PrePersist
    void prePersist(){
        this.addDate= new Date(System.currentTimeMillis());
        this.active=true;
    }
}
