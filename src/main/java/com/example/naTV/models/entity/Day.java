package com.example.naTV.models.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "days")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Day extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @JoinColumn(name = "id_order_detail")
    @ManyToOne
    OrderDetail orderDetails;
    Date day;
    @PrePersist
    void prePersist(){
        this.active=true;
    }
}
