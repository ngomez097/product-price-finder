
package com.ngomez.productpricefinder.infrastructure.configuration.error;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter @Builder
public class ApiError {
    private String title;
    private int status;
    private String detail;
    private String path;
    private LocalDateTime timestamp;
}
