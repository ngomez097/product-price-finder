package com.ngomez.price_finder.domain.port.use_case;

import com.ngomez.price_finder.domain.model.ProductPrice;

import java.time.LocalDateTime;
import java.util.Optional;

public interface FindProductPriceUseCase {
    Optional<ProductPrice> findProductPrice(LocalDateTime date, int brandId, int productId);
}
