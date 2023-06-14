package com.ngomez.productpricefinder.infrastructure.configuration.error;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.http.ProblemDetail;

import java.time.LocalDateTime;

@Mapper
public interface ApiErrorMapper {

    @Mapping(target = "timestamp", source = "timestamp")
    @Mapping(target = "path", source = "path")
    ApiError toApiError(ProblemDetail problemDetail, LocalDateTime timestamp, String path);
}
