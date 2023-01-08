package com.example.naTV.mapper.EntityAndDTO;

import java.util.List;

public interface BaseMapper<E ,D > {
    E toEntity(D d);
    D toDTO(E e);
    List<E> toListEntity(List<D> dList);
    List<D> toListDTO(List<E> eList);
}
