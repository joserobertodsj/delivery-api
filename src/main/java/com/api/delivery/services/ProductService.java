package com.api.delivery.services;

import com.api.delivery.models.dtos.responses.ProductResponseDto;

import java.util.List;

public interface ProductService {
    ProductResponseDto getByProductId(Long idProduct);
    ProductResponseDto getByProductIdNative(Long idProduct);

    List<ProductResponseDto> getAllProducts();
    List<ProductResponseDto> getAllProductsNative();


}
