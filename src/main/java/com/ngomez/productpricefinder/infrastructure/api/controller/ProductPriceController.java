package com.ngomez.productpricefinder.infrastructure.api.controller;

import com.ngomez.productpricefinder.infrastructure.api.model.ProductPriceApi;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RequestMapping("${server.url.base:}")
public interface ProductPriceController {

    /**
     * GET /products/{product_id}/price : Retrieve a product price
     * Retrieve the product price by the &#39;product_id&#39;, &#39;brand_id&#39; and &#39;application_date&#39; parameters
     *
     * @param brandId The specific brand identifier (required)
     * @param applicationDate The date for the required price (required)
     * @param productId  (required)
     * @return Price Found (status code 200)
     */
    @Operation(
            operationId = "getProductPrice",
            summary = "Retrieve a product price",
            description = "Retrieve the product price by the 'product_id', 'brand_id' and 'application_date' parameters"
    )
    @GetMapping("/products/{product_id}/price")
    ProductPriceApi getProductPrice(
            @Parameter(name = "product_id", description = "The product identifier", required = true, in = ParameterIn.PATH) @PathVariable("product_id") int productId,
            @NotNull @Parameter(name = "brand_id", description = "The specific brand identifier", required = true, in = ParameterIn.QUERY) @Valid @RequestParam(value = "brand_id") int brandId,
            @NotNull @Parameter(name = "application_date", description = "The date for the required price", required = true, in = ParameterIn.QUERY) @Valid @RequestParam(value = "application_date") LocalDateTime applicationDate
    );

}
