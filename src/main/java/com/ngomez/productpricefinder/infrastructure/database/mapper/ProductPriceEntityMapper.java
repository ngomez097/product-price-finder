package com.ngomez.productpricefinder.infrastructure.database.mapper;

import com.ngomez.productpricefinder.domain.model.ProductPrice;
import com.ngomez.productpricefinder.infrastructure.database.entity.ProductPriceEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface ProductPriceEntityMapper {

    ProductPrice mapPrice(ProductPriceEntity productPriceEntity);

    List<ProductPrice> mapPrices(List<ProductPriceEntity> priceEntities);
}
