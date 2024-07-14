package com.example.controller;

import com.example.dto.ProductDto;
import com.example.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@AllArgsConstructor
public class ProductController {

    private final ProductService service;

    @PostMapping
    public ResponseEntity<ProductDto> create(@RequestBody ProductDto dto) {
        return new ResponseEntity<>(service.create(dto), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<ProductDto>> readAll() {
        return new ResponseEntity<>(service.readAll(), HttpStatus.OK);
    }

    @GetMapping("/category/{id}")
    public ResponseEntity<List<ProductDto>> readByCategoryId(@PathVariable("id") Long id) {
        return new ResponseEntity<>(service.readByCategoryId(id), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<ProductDto> update(@RequestBody ProductDto dto) {
        ProductDto update = service.update(dto);
        return update == null ?
                new ResponseEntity<>(new ProductDto(), HttpStatus.BAD_REQUEST) :
                new ResponseEntity<>(service.update(dto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public HttpStatus delete(@PathVariable("id") Long id) {
        service.delete(id);
        return HttpStatus.OK;
    }
}
