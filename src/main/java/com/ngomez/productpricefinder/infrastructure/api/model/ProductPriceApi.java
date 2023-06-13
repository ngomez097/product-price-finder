package com.ngomez.productpricefinder.infrastructure.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter @Setter
public class ProductPriceApi {
    @JsonProperty("product_id")
    @Schema(name = "product_id", description = "The product identifier")
    int productId;

    @JsonProperty("brand_id")
    @Schema(name = "brand_id", description = "The brand identifier")
    private int brandId;

    @JsonProperty("application_date")
    @Schema(name = "application_date", description = "The date for the price")
    LocalDateTime applicationDate;

    @JsonProperty("price_list")
    @Schema(name = "price_list", description = "The price list")
    int priceList;


    @Schema(name = "price", description = "The price of the product")
    float price;

    @Schema(name = "currency", description = "The currency associated with the price")
    String currency;
}
