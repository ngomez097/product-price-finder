package com.ngomez.productpricefinder.application;

import com.ngomez.productpricefinder.domain.model.ProductPrice;
import com.ngomez.productpricefinder.domain.port.repository.ProductPriceRepository;
import com.ngomez.productpricefinder.domain.port.usecase.FindProductPriceUseCase;
import data.ProductPriceDataBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

class FindProductPriceUseCaseImplTest {

    private FindProductPriceUseCase findProductPriceUseCase;
    private ProductPriceRepository productPriceRepository;

    @BeforeEach
    void setUp() {
        productPriceRepository = Mockito.mock(ProductPriceRepository.class);
        findProductPriceUseCase = new FindProductPriceUseCaseImpl(productPriceRepository);
    }

    @Test
    void findPriceShouldReturnAnOptionalOfPrice() {
        LocalDateTime applicationDate = LocalDateTime.parse("2020-07-01T00:00:00");
        int brandId = 1;
        int productId = 35455;
        ProductPrice priceMock = ProductPriceDataBuilder.buildProductPrice();

        when(productPriceRepository.findProductsPriceOrderByPriorityDesc(productId, brandId, applicationDate))
                .thenReturn(List.of(priceMock));

        Optional<ProductPrice> result = findProductPriceUseCase.findProductPrice(productId, brandId, applicationDate);

        assertThat(result)
                .isNotNull()
                .isPresent()
                .contains(priceMock);
    }

    @Test
    void findPriceShouldReturnTheHigherPriorityPrice() {
        LocalDateTime applicationDate = LocalDateTime.parse("2020-07-01T00:00:00");
        int brandId = 1;
        int productId = 35455;
        ProductPrice lowPriorityProductPrice = ProductPriceDataBuilder.buildProductPrice();
        ProductPrice highPriorityProductPrice = ProductPriceDataBuilder.buildProductPriceHighPriority();

        when(productPriceRepository.findProductsPriceOrderByPriorityDesc(productId, brandId, applicationDate))
                .thenReturn(List.of(highPriorityProductPrice, lowPriorityProductPrice));

        Optional<ProductPrice> result = findProductPriceUseCase.findProductPrice(productId, brandId, applicationDate);

        assertThat(result)
                .isNotNull()
                .isPresent()
                .contains(highPriorityProductPrice);
    }

    @Test
    void findPriceShouldReturnAnEmptyOptional() {
        LocalDateTime applicationDate = LocalDateTime.parse("2019-07-01T00:00:00");
        int brandId = 1;
        int productId = 35455;

        when(productPriceRepository.findProductsPriceOrderByPriorityDesc(productId, brandId, applicationDate))
                .thenReturn(List.of());

        Optional<ProductPrice> result = findProductPriceUseCase.findProductPrice(productId, brandId, applicationDate);

        assertThat(result)
                .isNotNull()
                .isEmpty();
    }
}