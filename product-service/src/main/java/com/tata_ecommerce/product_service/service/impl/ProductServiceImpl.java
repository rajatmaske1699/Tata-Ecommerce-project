package com.tata_ecommerce.product_service.service.impl;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.tata_ecommerce.product_service.dto.ProductRequest;
import com.tata_ecommerce.product_service.dto.ProductResponse;
import com.tata_ecommerce.product_service.model.Product;
import com.tata_ecommerce.product_service.repository.ProductRepository;
import com.tata_ecommerce.product_service.service.ProductService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductServiceImpl implements ProductService{

	private final ProductRepository repo;
	
	@Override
	public ProductResponse registerProduct(ProductRequest request) {
		Product product = mapToProduct(request);
		product.setCreatedAt(LocalDateTime.now());
		product.setUpdatedAt(LocalDateTime.now());
		product.setProductNumber(UUID.randomUUID());
		Product result = repo.save(product);
		return mapToProductResponse(result);
	}

	@Override
	public ProductResponse getProductByProductNumber(UUID productNumber) {
		return mapToProductResponse(repo.getProductByProductNumber(productNumber));
	}
    
	Product mapToProduct(ProductRequest request){
		return Product.builder()
				.imageUrl(request.getImageUrl())
				.productBrand(request.getProductBrand())
				.productDesc(request.getProductDesc())
				.productName(request.getProductName())
				.productPrice(request.getProductPrice())
				.stockQuantity(request.getStockQuantity())
				.productType(request.getProductType())
				.build();
	}
	
	ProductResponse mapToProductResponse(Product product) {
		return ProductResponse.builder()
				.imageUrl(product.getImageUrl())
				.productBrand(product.getProductBrand())
				.productDesc(product.getProductDesc())
				.productName(product.getProductName())
				.productPrice(product.getProductPrice())
				.stockQuantity(product.getStockQuantity())
				.productType(product.getProductType())
				.createdAt(product.getCreatedAt())
				.updatedAt(product.getUpdatedAt())
				.productNumber(product.getProductNumber())
				.build();
	}
}
