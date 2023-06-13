package com.ngomez.price_finder.domain.port.repository;

import com.ngomez.price_finder.domain.model.ProductPrice;

import java.time.LocalDateTime;
import java.util.Optional;

public interface ProductPriceRepository {
    Optional<ProductPrice> findProductPriceOrderByPriorityDesc(LocalDateTime date, int brandId, int productId);
}
