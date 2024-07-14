package com.example.service;

import com.example.dto.ProductDto;
import com.example.dto.mapper.Mapper;
import com.example.entity.Product;
import com.example.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository repository;
    private final Mapper<Product, ProductDto> mapper;

    @Override
    public ProductDto create(ProductDto dto) {
        Product product = mapper.toEntity(dto);
        Product save = repository.save(product);
        return mapper.toDto(save);
    }

    @Override
    public List<ProductDto> readAll() {
        List<Product> products = repository.findAll();
        return products.stream().map(mapper::toDto).toList();
    }

    @Override
    public List<ProductDto> readByCategoryId(Long id) {
        List<Product> products = repository.findByCategoryId(id);
        return products.stream().map(mapper::toDto).toList();
    }

    @Override
    public ProductDto update(ProductDto dto) {
        if (dto.getId() == null) {
            return null;
        }
        Product product = mapper.toEntity(dto);
        Product save = repository.save(product);
        return mapper.toDto(save);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
