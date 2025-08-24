package com.tata_ecommerce.product_service.controller;

import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tata_ecommerce.product_service.dto.ProductRequest;
import com.tata_ecommerce.product_service.dto.ProductResponse;
import com.tata_ecommerce.product_service.service.ProductService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/v1/product")
@RequiredArgsConstructor
@Slf4j
public class ProductController {
    
	private final ProductService service;
	
	@PostMapping
    public ResponseEntity<ProductResponse> registerProduct(@RequestBody ProductRequest request){
		log.info("in controller's registerProduct method ");
       return  ResponseEntity.ok().body(service.registerProduct(request));
    }
	
	@GetMapping
	public  ResponseEntity<ProductResponse> getByProductNumber(@RequestParam UUID productNumber){
		log.info("in controller's getByProductNumber method ");
		return  ResponseEntity.ok().body(service.getProductByProductNumber(productNumber));
	}
}
