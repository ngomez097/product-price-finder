package com.ngomez.productpricefinder.infrastructure.database.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "price")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductPriceEntity {

    @Id
    @GeneratedValue
    private Integer id;

    private int brandId;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private int priceList;
    private int productId;
    private int priority;
    private float price;

    @Column(length = 3)
    private String currency;
}
