package com.example.naTV.service.Interface;


import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BaseService <T>{
    T save(T t);
    T findById(Long id);
    List<T> findAll(Pageable pageable);
    int deleteById(Long id);


}
