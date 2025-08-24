package com.tata_ecommerce.product_service.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import com.tata_ecommerce.product_service.model.ProductType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductResponse {

    private UUID productNumber;
    private ProductType productType;
    private String productName;
    private String productDesc;
    private BigDecimal productPrice;
    private Integer stockQuantity;
    private String productBrand;
    private String imageUrl;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
