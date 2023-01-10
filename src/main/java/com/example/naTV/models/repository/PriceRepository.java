package com.example.naTV.models.repository;

import com.example.naTV.models.entity.Price;
import com.example.naTV.models.entity.QPrice;
import com.example.naTV.models.info.PriceInfo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.sql.Date;
import java.util.List;

;

public interface PriceRepository extends BaseRepository<Price, QPrice, Long> {

    @Query(value = """
        select 
        p.price 
        from prices p
        where p.startDate=(select max(pp.startDate) from prices pp where pp.channels.id=?1) and p.channels.id=?1 and p.startDate<?2 and ( ?2<p.endDate or p.endDate is null)
""",nativeQuery = true)
    int findPrice( Long channelId,Date day);
    @Query("""
    select
     p.price as price
    from prices p 
    where p.active = true and p.startDate<=:day and (:day<p.endDate or p.endDate is null ) and p.channels.id = :id
    order by p.startDate desc
    """)
    List<PriceInfo> getActualPriceInRange(@Param("id") Long id, @Param("day") Date day);


}