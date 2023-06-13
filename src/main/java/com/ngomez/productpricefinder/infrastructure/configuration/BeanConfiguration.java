package com.ngomez.productpricefinder.infrastructure.configuration;

import com.ngomez.productpricefinder.application.FindProductPriceUseCaseImpl;
import com.ngomez.productpricefinder.domain.port.repository.ProductPriceRepository;
import com.ngomez.productpricefinder.domain.port.usecase.FindProductPriceUseCase;
import com.ngomez.productpricefinder.infrastructure.database.adapter.ProductPriceRepositoryImpl;
import com.ngomez.productpricefinder.infrastructure.database.repository.ProductPriceJPARepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public ProductPriceRepository beanPriceRepository(ProductPriceJPARepository priceJPARepository){
        return new ProductPriceRepositoryImpl(priceJPARepository);
    }

    @Bean
    public FindProductPriceUseCase beanGetPriceUseCase(ProductPriceRepository priceRepository){
        return new FindProductPriceUseCaseImpl(priceRepository);
    }
}
