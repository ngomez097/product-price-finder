package data;

import com.ngomez.productpricefinder.domain.model.ProductPrice;

import java.time.LocalDateTime;

public class ProductPriceDataBuilder {

    public static ProductPrice buildProductPrice(){
        return ProductPrice.builder()
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

    public static ProductPrice buildProductPriceHighPriority(){
        return ProductPrice.builder()
                .id(2)
                .brandId(1)
                .startDate(LocalDateTime.parse("2020-06-14T00:00:00"))
                .endDate(LocalDateTime.parse("2020-08-31T23:59:59"))
                .priceList(2)
                .productId(35455)
                .priority(1)
                .price(25.50f)
                .currency("EUR")
                .build();
    }
}
