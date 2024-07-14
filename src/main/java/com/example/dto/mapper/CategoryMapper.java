package com.example.dto.mapper;

import com.example.dto.CategoryDto;
import com.example.entity.Category;
import org.springframework.stereotype.Component;

import static java.util.Objects.isNull;

@Component
public class CategoryMapper implements Mapper<Category, CategoryDto> {
    @Override
    public Category toEntity(CategoryDto dto) {
        if (isNull(dto)) {
            return null;
        }
        return Category.builder()
                .id(dto.getId())
                .name(dto.getName())
                .build();
    }

    @Override
    public CategoryDto toDto(Category entity) {
        if (isNull(entity)) {
            return null;
        }
        return CategoryDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .build();
    }
}
