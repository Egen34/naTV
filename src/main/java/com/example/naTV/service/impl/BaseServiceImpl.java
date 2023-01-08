package com.example.naTV.service.impl;

import com.example.naTV.mapper.EntityAndDTO.BaseMapper;
import com.example.naTV.models.entity.BaseEntity;
import com.example.naTV.models.repository.BaseRepository;
import com.example.naTV.service.Interface.BaseService;
import org.springframework.data.domain.Pageable;

import java.util.List;

public abstract class BaseServiceImpl<E extends BaseEntity,D > implements BaseService<D> {
    private BaseRepository<E,Long> rep;
    private BaseMapper<E,D> mapper;

    public BaseServiceImpl(BaseRepository<E, Long> repository, BaseMapper<E, D> mapper) {
        this.rep = repository;
        this.mapper = mapper;
    }

    @Override
    public D save(D d) {
        return mapper.toDTO(rep.save(mapper.toEntity(d)));
    }

    @Override
    public D findById(Long id) {
        return mapper.toDTO(rep.findById(id).orElseThrow());//TODO
    }

    @Override
    public List<D> findAll(Pageable pageable) {
        return mapper.toListDTO(rep.findAll(pageable).toList());
    }

    @Override
    public int deleteById(Long id) {
        return rep.updateActiveById(false,id);
    }
}
