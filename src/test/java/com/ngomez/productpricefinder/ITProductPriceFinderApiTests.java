package com.ngomez.productpricefinder;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDateTime;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class ITProductPriceFinderApiTests {

    private final MockMvc mockMvc;

    @Autowired
    public ITProductPriceFinderApiTests(MockMvc mockMvc) {
        this.mockMvc = mockMvc;
    }

    @ParameterizedTest
    @CsvSource({
            "35455,1,2020-06-14T00:00:00,35.5",
            "35455,1,2020-06-14T16:00:00,25.45",
            "35455,1,2020-06-14T21:00:00,35.5",
            "35455,1,2020-06-15T10:00:00,30.50",
            "35455,1,2020-06-16T21:00:00,38.95"
    })
    void ShouldReturnTheCorrectPrice(int productId, int brandId, LocalDateTime applicationDate, float expectedPrice) throws Exception {
        ResultActions result = mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/v1/products/{product_id}/price", productId)
                        .queryParam("brand_id", String.valueOf(brandId))
                        .queryParam("application_date", applicationDate.toString()));

        result.andExpect(status().isOk());
        result.andExpect(jsonPath("$.price").value(expectedPrice));
    }

    @Test
    void ShouldReturnMissingParameterBadRequest() throws Exception {
        int productId = 35455;
        LocalDateTime applicationDate = LocalDateTime.parse("2020-06-14T00:00:00");

        ResultActions result = mockMvc.perform(MockMvcRequestBuilders
                .get("/api/v1/products/{product_id}/price", productId)
                .queryParam("application_date", applicationDate.toString()));

        result.andExpect(status().isBadRequest());
        result.andExpect(jsonPath("$.detail", containsString("brand_id")));
    }

    @Test
    void ShouldReturnBadParameterTypeBadRequest() throws Exception {
        int productId = 35455;
        int brandId = 1;

        ResultActions result = mockMvc.perform(MockMvcRequestBuilders
                .get("/api/v1/products/{product_id}/price", productId)
                .queryParam("brand_id", String.valueOf(brandId))
                .queryParam("application_date", "2020-06-14"));


        result.andExpect(status().isBadRequest());
        result.andExpect(jsonPath("$.detail", containsString("application_date")));
    }

}
