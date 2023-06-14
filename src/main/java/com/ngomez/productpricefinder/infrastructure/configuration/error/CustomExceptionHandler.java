package com.ngomez.productpricefinder.infrastructure.configuration.error;

import com.ngomez.productpricefinder.infrastructure.api.exception.PriceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.context.MessageSource;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

import static com.ngomez.productpricefinder.infrastructure.configuration.LocaleConfiguration.getDefaultLocale;
import static com.ngomez.productpricefinder.infrastructure.configuration.PropertyConstants.INTERNAL_SERVER_ERROR;
import static com.ngomez.productpricefinder.infrastructure.configuration.PropertyConstants.PRICE_NOT_FOUND;
import static java.time.ZoneOffset.UTC;

@RestControllerAdvice
@RequiredArgsConstructor
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

    private final MessageSource messageSource;
    private final ApiErrorMapper apiErrorMapper = Mappers.getMapper(ApiErrorMapper.class);

    @ExceptionHandler(PriceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ApiError handlePriceNotFound(PriceNotFoundException priceNotFoundException, WebRequest request){
        return ApiError.builder()
                .title(HttpStatus.NOT_FOUND.getReasonPhrase())
                .status(HttpStatus.NOT_FOUND.value())
                .detail(messageSource.getMessage(PRICE_NOT_FOUND, new Object[]{}, getDefaultLocale()))
                .path(getPath(request))
                .timestamp(LocalDateTime.now(UTC))
                .build();
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ApiError defaultHandler(Exception exception, WebRequest request){
        return ApiError.builder()
                .title(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase())
                .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .detail(messageSource.getMessage(INTERNAL_SERVER_ERROR, new Object[]{}, getDefaultLocale()))
                .path(getPath(request))
                .timestamp(LocalDateTime.now(UTC))
                .build();
    }

    @Override
    protected ResponseEntity<Object> createResponseEntity(Object body, HttpHeaders headers, HttpStatusCode statusCode, WebRequest request) {
        Object finalBody = body;
        if(body instanceof ProblemDetail problemDetail){
            finalBody = apiErrorMapper.toApiError(problemDetail, LocalDateTime.now(UTC), getPath(request));
        }

        return new ResponseEntity<>(finalBody, headers, statusCode);
    }

    private String getPath(WebRequest request){
        if(request instanceof ServletWebRequest servletWebRequest){
            return servletWebRequest.getRequest().getRequestURI();
        }

        return "";
    }
}
