package com.api.delivery.controllers;

import com.api.delivery.models.dtos.responses.ProductResponseDto;
import com.api.delivery.services.impl.ProductServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
@AllArgsConstructor
public class ProductController {

    private final ProductServiceImpl productService;

    @GetMapping("/product/{idProduct}")
    public ResponseEntity<ProductResponseDto> getByIdProduct(@PathVariable(value = "idProduct") Long id){
        return ResponseEntity.status(HttpStatus.OK).body(productService.getByProductId(id));
    }

    @GetMapping("/product-native/{idProduct}")
    public ResponseEntity<ProductResponseDto> getByIdProductNative(@PathVariable(value = "idProduct") Long id){
        return ResponseEntity.status(HttpStatus.OK).body(productService.getByProductIdNative(id));
    }

    @GetMapping("/all-products")
    public ResponseEntity<List<ProductResponseDto>> getAllProducts(){
        return ResponseEntity.status(HttpStatus.OK).body(productService.getAllProducts());
    }

    @GetMapping("/all-products-native")
    public ResponseEntity<List<ProductResponseDto>> getAllProductsNative(){
        return ResponseEntity.status(HttpStatus.OK).body(productService.getAllProductsNative());
    }






}
