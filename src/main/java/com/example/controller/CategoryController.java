package com.example.controller;

import com.example.dto.CategoryDto;
import com.example.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/categories")
@AllArgsConstructor
public class CategoryController {

    private final CategoryService service;

    @PostMapping
    public ResponseEntity<CategoryDto> create(@RequestBody CategoryDto dto) {
        return new ResponseEntity<>(service.create(dto), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<CategoryDto>> readAll() {
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<CategoryDto> update(@RequestBody CategoryDto dto) {
        CategoryDto update = service.update(dto);
        return update == null ?
                new ResponseEntity<>(new CategoryDto(), HttpStatus.BAD_REQUEST) :
                new ResponseEntity<>(service.update(dto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public HttpStatus delete(@PathVariable("id") Long id) {
        service.delete(id);
        return HttpStatus.OK;
    }
}
