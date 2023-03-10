package com.example.naTV.service.impl;

import com.example.naTV.exception.NotFoundExcep;
import com.example.naTV.exception.Save4Exception;
import com.example.naTV.mapper.EntityAndDTO.BaseMapper;
import com.example.naTV.models.entity.BaseEntity;
import com.example.naTV.models.repository.BaseRepository;
import com.example.naTV.service.Interface.BaseService;
import com.example.naTV.utils.RBundle;
import com.querydsl.core.types.dsl.EntityPathBase;
import org.springframework.data.domain.Pageable;

import java.util.List;

public abstract class BaseServiceImpl<E extends BaseEntity,P extends EntityPathBase<E>,D > implements BaseService<D> {
    private BaseRepository<E,P,Long> rep;
    private BaseMapper<E,D> mapper;

    public BaseServiceImpl(BaseRepository<E,P, Long> repository, BaseMapper<E, D> mapper) {
        this.rep = repository;
        this.mapper = mapper;
    }

    @Override
    public D save(D d)throws Save4Exception {
        return mapper.toDTO(rep.save(mapper.toEntity(d)));
    }

    @Override
    public D findById(Long id){
        D dto=mapper.toDTO(rep.findById(id).orElse(null));
        if (dto==null)
            throw new NotFoundExcep(RBundle.SINGILTON.periodMessage("notFound"));

        return dto;//TODO
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
