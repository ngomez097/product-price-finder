package com.ngomez.productpricefinder.infrastructure.api.mapper;

import com.ngomez.productpricefinder.domain.model.ProductPrice;
import com.ngomez.productpricefinder.infrastructure.api.model.ProductPriceApi;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.time.LocalDateTime;

@Mapper
public interface PriceApiMapper {

    @Mapping(target = "applicationDate", source = "applicationDate")
    ProductPriceApi mapToPriceApi(ProductPrice price, LocalDateTime applicationDate);
}
