package data;

import com.ngomez.productpricefinder.infrastructure.database.entity.ProductPriceEntity;

import java.time.LocalDateTime;

public class PriceEntityDataBuilder {

    private PriceEntityDataBuilder(){}

    public static ProductPriceEntity buildPriceEntity(){
        return ProductPriceEntity.builder()
                .id(1)
                .brandId(1)
                .startDate(LocalDateTime.parse("2020-06-14T00:00:00"))
                .endDate(LocalDateTime.parse("2020-12-31T23:59:59"))
                .priceList(1)
                .productId(35455)
                .priority(0)
                .price(35.50f)
                .currency("EUR")
                .build();
    }

    public static ProductPriceEntity buildPriceEntityHighPriority(){
        return ProductPriceEntity.builder()
                .id(2)
                .brandId(1)
                .startDate(LocalDateTime.parse("2020-06-14T00:00:00"))
                .endDate(LocalDateTime.parse("2020-10-31T23:59:59"))
                .priceList(1)
                .productId(35455)
                .priority(1)
                .price(49.25f)
                .currency("EUR")
                .build();
    }
}
