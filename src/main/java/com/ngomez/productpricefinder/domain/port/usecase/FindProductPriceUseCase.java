package com.ngomez.productpricefinder.domain.port.usecase;

import com.ngomez.productpricefinder.domain.model.ProductPrice;

import java.time.LocalDateTime;
import java.util.Optional;

public interface FindProductPriceUseCase {
    Optional<ProductPrice> findProductPrice(int productId, int brandId, LocalDateTime applicationDate);
}
