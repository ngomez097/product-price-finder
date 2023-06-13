package com.ngomez.productpricefinder.infrastructure.database.adapter;

import com.ngomez.productpricefinder.domain.model.ProductPrice;
import com.ngomez.productpricefinder.domain.port.repository.ProductPriceRepository;
import com.ngomez.productpricefinder.infrastructure.database.entity.ProductPriceEntity;
import com.ngomez.productpricefinder.infrastructure.database.mapper.ProductPriceEntityMapper;
import com.ngomez.productpricefinder.infrastructure.database.repository.ProductPriceJPARepository;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
public class ProductPriceRepositoryImpl implements ProductPriceRepository {

    private final ProductPriceJPARepository productPriceJPARepository;
    private final ProductPriceEntityMapper productPriceEntityMapper = Mappers.getMapper(ProductPriceEntityMapper.class);

    @Override
    public List<ProductPrice> findProductsPriceOrderByPriorityDesc(int productId, int brandId, LocalDateTime applicationDate) {
        List<ProductPriceEntity> pricesFiltered = productPriceJPARepository.findProductPricesOrderByPriorityDesc(productId, brandId, applicationDate);

        return productPriceEntityMapper.mapPrices(pricesFiltered);
    }
}
