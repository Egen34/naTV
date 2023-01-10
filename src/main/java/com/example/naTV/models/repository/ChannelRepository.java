package com.example.naTV.models.repository;

import com.example.naTV.models.entity.Channel;
import com.example.naTV.models.entity.QChannel;
import com.example.naTV.models.response.GetChannalRespnonse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.binding.QuerydslBindings;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public interface ChannelRepository extends BaseRepository<Channel, QChannel, Long> {
    @Override
    default void customize(QuerydslBindings bindings, QChannel root) {
        bindings.bind(root.active).all(((path, value) -> Optional.ofNullable(path.eq(value.stream().toList().get(0)))));
        bindings.bind(root.id).all((path, value) -> Optional.of(path.eq(value.stream().findFirst().get())));


    }


    @Query("select (count(c) > 0) from channels c where c.name = ?1 and c.active=true")
    boolean existsByName(String name);


    @Query("select (count(c) > 0) from channels c where c.orderNum = ?1 and c.active=true ")
    boolean existsByOrderNum(Integer orderNum);


    @Query("""
            select  c  
            from channels c 
            left outer join c.discounts discounts
            left outer join c.prices p
            where  discounts.id is null or (c.active = true and discounts.active = true and
            discounts.startDate < CURRENT_DATE and discounts.endDate >= CURRENT_DATE and
            p.startDate < CURRENT_DATE and (p.endDate >= CURRENT_DATE or p.endDate is null))
            group by c.id
            order by c.orderNum
            """)
    Page<GetChannalRespnonse> findAlll(Pageable pageable);


}