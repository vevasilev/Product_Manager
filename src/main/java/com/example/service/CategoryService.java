package com.example.service;

import com.example.dto.CategoryDto;

import java.util.List;

public interface CategoryService {

    CategoryDto create(CategoryDto dto);

    List<CategoryDto> findAll();

    CategoryDto findById(Long id);

    CategoryDto update(CategoryDto dto);

    void delete(Long id);
}
