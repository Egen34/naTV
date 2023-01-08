package com.example.naTV.models.repository;

import com.example.naTV.models.entity.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;

@NoRepositoryBean
public interface BaseRepository<T extends BaseEntity,ID extends Serializable> extends JpaRepository<T ,ID> {
    @Transactional
    @Modifying
    @Query("update #{#entityName} c set c.active = ?1 where c.id = ?2")
    int updateActiveById(Boolean active, Long id);

}
