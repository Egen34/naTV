package com.example.naTV.models.repository;


import com.example.naTV.models.entity.Discount;
import com.example.naTV.models.info.ActualDiscount;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

;
import java.util.Optional;

public interface DiscountRepository extends BaseRepository<Discount, Long> {
    @Query("""
            select 
            max(d.minDay)  as minDay,
            d.percent as percent
            from discount d
            where d.active = true and d.channel.id = :id and d.minDay<=:dayCount and
            d.startDate < CURRENT_DATE and (d.endDate >CURRENT_DATE or d.endDate is null)  
            group by d.id
            """)
    ActualDiscount getActualDiscount(@Param("id") Long id, @Param("dayCount") int dayCount);


}