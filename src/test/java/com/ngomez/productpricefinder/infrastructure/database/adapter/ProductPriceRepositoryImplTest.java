package com.ngomez.productpricefinder.infrastructure.database.adapter;

import com.ngomez.productpricefinder.domain.model.ProductPrice;
import com.ngomez.productpricefinder.domain.port.repository.ProductPriceRepository;
import com.ngomez.productpricefinder.infrastructure.database.entity.ProductPriceEntity;
import com.ngomez.productpricefinder.infrastructure.database.repository.ProductPriceJPARepository;
import data.PriceEntityDataBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDateTime;
import java.util.List;

import static java.util.Collections.emptyList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

class ProductPriceRepositoryImplTest {

    private ProductPriceJPARepository productPriceJPARepository;
    private ProductPriceRepository productPriceRepository;

    @BeforeEach
    void setUp() {
        productPriceJPARepository = Mockito.mock(ProductPriceJPARepository.class);
        productPriceRepository = new ProductPriceRepositoryImpl(productPriceJPARepository);
    }

    @Test
    void findProductsPriceOrderByPriorityDescShouldReturnOneElement() {
        LocalDateTime applicationDate = LocalDateTime.parse("2020-06-14T00:00:00");
        int brandId = 1;
        int productId = 35455;
        ProductPriceEntity productPriceEntity = PriceEntityDataBuilder.buildPriceEntity();
        List<ProductPriceEntity> pricesMock = List.of(productPriceEntity);

        when(productPriceJPARepository.findProductPricesOrderByPriorityDesc(productId, brandId, applicationDate))
                .thenReturn(pricesMock);

        List<ProductPrice> result = productPriceRepository.findProductsPriceOrderByPriorityDesc(productId, brandId, applicationDate);

        assertThat(result)
                .isNotNull()
                .hasSize(1);
    }

    @Test
    void findProductsPriceOrderByPriorityDescShouldReturnTwoElements() {
        LocalDateTime applicationDate = LocalDateTime.parse("2020-06-14T00:00:00");
        int brandId = 1;
        int productId = 35455;
        ProductPriceEntity productPriceEntityLowPriority = PriceEntityDataBuilder.buildPriceEntity();
        ProductPriceEntity productPriceEntityHighPriority = PriceEntityDataBuilder.buildPriceEntityHighPriority();
        List<ProductPriceEntity> pricesMock = List.of(productPriceEntityHighPriority, productPriceEntityLowPriority);

        when(productPriceJPARepository.findProductPricesOrderByPriorityDesc(productId, brandId, applicationDate))
                .thenReturn(pricesMock);

        List<ProductPrice> result = productPriceRepository.findProductsPriceOrderByPriorityDesc(productId, brandId, applicationDate);

        assertThat(result)
                .isNotNull()
                .hasSize(2);
    }

    @Test
    void findProductsPriceOrderByPriorityDescShouldReturnNoElements() {
        LocalDateTime applicationDate = LocalDateTime.parse("2019-01-01T00:00:00");
        int brandId = 1;
        int productId = 35455;

        when(productPriceJPARepository.findProductPricesOrderByPriorityDesc(productId, brandId, applicationDate))
                .thenReturn(emptyList());

        List<ProductPrice> result = productPriceRepository.findProductsPriceOrderByPriorityDesc(productId, brandId, applicationDate);

        assertThat(result)
                .isNotNull()
                .isEmpty();
    }
}