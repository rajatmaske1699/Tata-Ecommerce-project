package com.tata_ecommerce.product_service.service;

import java.util.UUID;

import com.tata_ecommerce.product_service.dto.ProductRequest;
import com.tata_ecommerce.product_service.dto.ProductResponse;

public interface ProductService {
	
    public ProductResponse registerProduct(ProductRequest request);
    public ProductResponse getProductByProductNumber(UUID productNum);
}
