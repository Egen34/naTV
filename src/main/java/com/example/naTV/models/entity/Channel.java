package com.example.naTV.models.entity;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity(name = "channels")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Channel extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(unique = true)
    String name;
    @Column(name = "photo_path")
    String photo;

    Integer orderNum;

    @OneToMany(mappedBy = "channels")
    private Set<Price> prices = new LinkedHashSet<>();

    @OneToMany(mappedBy = "channel")
    private Set<OrderDetail> orderDetails = new LinkedHashSet<>();

    @OneToMany(mappedBy = "channel")
    private Set<Discount> discounts = new LinkedHashSet<>();


    @PrePersist
    void prePersist(){
        this.active=true;

    }


}
