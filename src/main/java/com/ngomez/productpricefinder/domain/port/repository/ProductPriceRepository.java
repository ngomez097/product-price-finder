package com.ngomez.productpricefinder.domain.port.repository;

import com.ngomez.productpricefinder.domain.model.ProductPrice;

import java.time.LocalDateTime;
import java.util.Optional;

public interface ProductPriceRepository {
    Optional<ProductPrice> findProductPriceOrderByPriorityDesc(LocalDateTime date, int brandId, int productId);
}
