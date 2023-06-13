package com.ngomez.productpricefinder.domain.port.repository;

import com.ngomez.productpricefinder.domain.model.ProductPrice;

import java.time.LocalDateTime;
import java.util.List;

public interface ProductPriceRepository {
    List<ProductPrice> findProductsPriceOrderByPriorityDesc(int productId, int brandId, LocalDateTime applicationDate);
}
