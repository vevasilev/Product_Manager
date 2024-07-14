package com.example.service;

import com.example.dto.CategoryDto;
import com.example.dto.mapper.Mapper;
import com.example.entity.Category;
import com.example.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository repository;
    private final Mapper<Category, CategoryDto> mapper;

    @Override
    public CategoryDto create(CategoryDto dto) {
        Category category = mapper.toEntity(dto);
        Category save = repository.save(category);
        return mapper.toDto(save);
    }

    @Override
    public List<CategoryDto> findAll() {
        List<Category> categories = repository.findAll();
        return categories.stream().map(mapper::toDto).toList();
    }

    @Override
    public CategoryDto findById(Long id) {
        Category category = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found " + id));
        return mapper.toDto(category);
    }

    @Override
    public CategoryDto update(CategoryDto dto) {
        if (dto.getId() == null) {
            return null;
        }
        Category category = mapper.toEntity(dto);
        Category save = repository.save(category);
        return mapper.toDto(save);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
