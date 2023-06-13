package com.ngomez.productpricefinder.infrastructure.api.controller;

import com.ngomez.productpricefinder.domain.model.ProductPrice;
import com.ngomez.productpricefinder.domain.port.usecase.FindProductPriceUseCase;
import com.ngomez.productpricefinder.infrastructure.api.exception.PriceNotFoundException;
import com.ngomez.productpricefinder.infrastructure.api.mapper.PriceApiMapper;
import com.ngomez.productpricefinder.infrastructure.api.model.ProductPriceApi;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class ProductPriceControllerImpl implements ProductPriceController {

    private final FindProductPriceUseCase findProductPriceUseCase;

    private final PriceApiMapper priceApiMapper = Mappers.getMapper(PriceApiMapper.class);

    @Override
    public ProductPriceApi getProductPrice(int productId, int brandId, LocalDateTime applicationDate) {
        Optional<ProductPrice> price = findProductPriceUseCase.findProductPrice(productId, brandId, applicationDate);

        return price
                .map(productPrice -> priceApiMapper.mapToPriceApi(productPrice, applicationDate))
                .orElseThrow(PriceNotFoundException::new);
    }
}
