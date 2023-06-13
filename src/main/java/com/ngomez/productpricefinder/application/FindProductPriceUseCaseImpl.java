package com.ngomez.productpricefinder.application;

import com.ngomez.productpricefinder.domain.model.ProductPrice;
import com.ngomez.productpricefinder.domain.port.repository.ProductPriceRepository;
import com.ngomez.productpricefinder.domain.port.usecase.FindProductPriceUseCase;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public class FindProductPriceUseCaseImpl implements FindProductPriceUseCase {

    private final ProductPriceRepository productPriceRepository;

    public FindProductPriceUseCaseImpl(ProductPriceRepository productPriceRepository) {
        this.productPriceRepository = productPriceRepository;
    }


    @Override
    public Optional<ProductPrice> findProductPrice(int productId, int brandId, LocalDateTime applicationDate) {
        List<ProductPrice> productPrices = productPriceRepository.findProductsPriceOrderByPriorityDesc(productId, brandId, applicationDate);

        return productPrices.stream().findFirst();
    }
}
