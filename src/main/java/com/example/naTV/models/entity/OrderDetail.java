package com.example.naTV.models.entity;


import javax.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;


@Entity(name = "order_detail")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OrderDetail extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @ManyToOne
    @JoinColumn(name = "channel_id")
    Channel channel;
    @JoinColumn(name = "id_order")
    @ManyToOne
    Order orders;

    Double price;
    @PrePersist
    void prePersist(){
        this.active=true;
    }
}
