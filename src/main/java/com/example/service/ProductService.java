package com.example.service;

import com.example.dto.ProductDto;

import java.util.List;

public interface ProductService {

    ProductDto create(ProductDto dto);

    List<ProductDto> readAll();

    List<ProductDto> readByCategoryId(Long id);

    ProductDto update(ProductDto dto);

    void delete(Long id);
}
