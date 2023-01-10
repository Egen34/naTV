package com.example.naTV.models.repository;

import com.example.naTV.models.entity.BaseEntity;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.EntityPathBase;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;

@NoRepositoryBean
public interface BaseRepository<T extends BaseEntity,P extends EntityPathBase<T>,ID extends Serializable> extends JpaRepository<T ,ID>, QuerydslPredicateExecutor<T>, QuerydslBinderCustomizer<P> {

    @Transactional
    @Modifying
    @Query("update #{#entityName} c set c.active = ?1 where c.id = ?2")
    int updateActiveById(Boolean active, Long id);

    @Override
    default void customize(QuerydslBindings bindings, P root){}

    @Override
    Page<T> findAll(Predicate predicate, Pageable pageable);
}
