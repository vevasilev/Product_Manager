package com.example.dto.mapper;

import com.example.dto.CategoryDto;
import com.example.dto.ProductDto;
import com.example.entity.Category;
import com.example.entity.Product;
import com.example.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import static java.util.Objects.isNull;

@Component
@RequiredArgsConstructor
public class ProductMapper implements Mapper<Product, ProductDto> {

    private final CategoryService service;
    private final Mapper<Category, CategoryDto> mapper;

    @Override
    public Product toEntity(ProductDto dto) {
        if (isNull(dto)) {
            return null;
        }
        CategoryDto categoryDto = service.findById(dto.getCategoryId());
        return Product.builder()
                .id(dto.getId())
                .name(dto.getName())
                .amount(dto.getAmount())
                .category(mapper.toEntity(categoryDto))
                .build();
    }

    @Override
    public ProductDto toDto(Product entity) {
        if (isNull(entity)) {
            return null;
        }
        return ProductDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .amount(entity.getAmount())
                .categoryId(entity.getCategory().getId())
                .build();
    }
}