package com.example.naTV.models.repository;

import com.example.naTV.models.entity.Channel;
import com.example.naTV.models.response.GetChannalRespnonse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface ChannelRepository extends BaseRepository<Channel, Long> {

    @Query("select (count(c) > 0) from channels c where c.name = ?1 and c.active=true")
    boolean existsByName(String name);




    @Query("select (count(c) > 0) from channels c where c.orderNum = ?1 and c.active=true ")
    boolean existsByOrderNum(Integer orderNum);










    @Query("""
            select  c  from channels c left outer join c.discounts discounts
            where  discounts.id is null or c.active = true and discounts.active = true and
            discounts.startDate < CURRENT_DATE and discounts.endDate >= CURRENT_DATE
            order by c.orderNum
            """)

    Page<GetChannalRespnonse> findAlll(Pageable pageable);








}