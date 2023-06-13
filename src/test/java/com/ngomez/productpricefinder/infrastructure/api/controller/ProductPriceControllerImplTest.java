package com.ngomez.productpricefinder.infrastructure.api.controller;

import com.ngomez.productpricefinder.domain.model.ProductPrice;
import com.ngomez.productpricefinder.domain.port.usecase.FindProductPriceUseCase;
import com.ngomez.productpricefinder.infrastructure.api.exception.PriceNotFoundException;
import com.ngomez.productpricefinder.infrastructure.api.model.ProductPriceApi;
import data.ProductPriceDataBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class ProductPriceControllerImplTest {

    private FindProductPriceUseCase findProductPriceUseCase;
    private ProductPriceController productPriceController;

    @BeforeEach
    void setUp() {
        findProductPriceUseCase = Mockito.mock(FindProductPriceUseCase.class);
        productPriceController = new ProductPriceControllerImpl(findProductPriceUseCase);
    }

    @Test
    void getProductPriceShouldReturnACorrectProductPriceApiElement() {
        LocalDateTime applicationDate = LocalDateTime.parse("2020-06-14T00:00:00");
        int brandId = 1;
        int productId = 35455;
        ProductPrice productPriceMock = ProductPriceDataBuilder.buildProductPrice();

        when(findProductPriceUseCase.findProductPrice(productId, brandId, applicationDate))
                .thenReturn(Optional.of(productPriceMock));

        ProductPriceApi result = productPriceController.getProductPrice(productId, brandId, applicationDate);

        assertThat(result)
                .isNotNull()
                .hasFieldOrPropertyWithValue("productId", productPriceMock.getProductId())
                .hasFieldOrPropertyWithValue("brandId", productPriceMock.getBrandId())
                .hasFieldOrPropertyWithValue("applicationDate", applicationDate)
                .hasFieldOrPropertyWithValue("priceList", productPriceMock.getPriceList())
                .hasFieldOrPropertyWithValue("price", productPriceMock.getPrice())
                .hasFieldOrPropertyWithValue("currency", productPriceMock.getCurrency());
    }

    @Test
    void getProductPriceShouldThrowPriceNotFoundExceptionWhenPriceNotFound() {
        LocalDateTime applicationDate = LocalDateTime.parse("2019-06-14T00:00:00");
        int brandId = 1;
        int productId = 35455;

        when(findProductPriceUseCase.findProductPrice(productId, brandId, applicationDate))
                .thenReturn(Optional.empty());

        assertThrowsExactly(PriceNotFoundException.class, () ->
            productPriceController.getProductPrice(productId, brandId, applicationDate)
        );
    }
}