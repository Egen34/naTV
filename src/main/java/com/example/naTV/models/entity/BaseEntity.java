package com.example.naTV.models.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.util.Date;

@MappedSuperclass
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public abstract class BaseEntity {
    boolean active;
    @Column(name = "add_date")
    Date addDate;
    @Column(name = "edit_date")
    Date editDate;

}
