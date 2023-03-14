package com.api.delivery.services.impl;

import com.api.delivery.models.dtos.responses.ProductResponseDto;
import com.api.delivery.repositories.ProductRepository;
import com.api.delivery.services.ProductService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;

    @Override
    public ProductResponseDto getByProductId(Long idProduct) {
        return modelMapper.map(productRepository.findByProductId(idProduct)
                .orElseThrow(() -> new RuntimeException("Id not found!")), ProductResponseDto.class);
    }

    @Override
    public ProductResponseDto getByProductIdNative(Long idProduct) {
        return modelMapper.map(productRepository.findByProductIdNative(idProduct)
                .orElseThrow(() -> new RuntimeException("Id not found!")), ProductResponseDto.class);
    }

    @Override
    public List<ProductResponseDto> getAllProducts(){
        return productRepository.findAllProducts().stream().map(product -> modelMapper.map(product, ProductResponseDto.class)).toList();
    }

    @Override
    public List<ProductResponseDto> getAllProductsNative() {
        return productRepository.findAllProductsNative().stream().map(product -> modelMapper.map(product, ProductResponseDto.class)).toList();
    }

}
