package com.ngomez.productpricefinder.infrastructure.configuration;

import com.ngomez.productpricefinder.application.FindProductPriceUseCaseImpl;
import com.ngomez.productpricefinder.domain.port.repository.ProductPriceRepository;
import com.ngomez.productpricefinder.domain.port.usecase.FindProductPriceUseCase;
import com.ngomez.productpricefinder.infrastructure.database.adapter.ProductPriceRepositoryImpl;
import com.ngomez.productpricefinder.infrastructure.database.repository.ProductPriceJPARepository;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;

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

    @Bean
    public MessageSource messageSource() {
        final ResourceBundleMessageSource source = new ResourceBundleMessageSource();
        source.setBasename("messages");
        return source;
    }
}
