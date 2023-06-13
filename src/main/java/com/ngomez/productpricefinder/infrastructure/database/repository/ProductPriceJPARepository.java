package com.ngomez.productpricefinder.infrastructure.database.repository;

import com.ngomez.productpricefinder.infrastructure.database.entity.ProductPriceEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ProductPriceJPARepository extends CrudRepository<ProductPriceEntity, Integer> {

    @Query("""
            SELECT p FROM ProductPriceEntity p
            WHERE
                p.brandId = :brandId AND
                p.productId = :productId AND
                p.startDate <= :applicationDate AND
                p.endDate >= :applicationDate
            ORDER BY p.priority DESC
    """)
    List<ProductPriceEntity> findProductPricesOrderByPriorityDesc(int productId, int brandId, LocalDateTime applicationDate);
}
