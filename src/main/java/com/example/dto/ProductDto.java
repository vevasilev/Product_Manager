package com.example.dto;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class ProductDto {
    private Long id;
    private String name;
    private Short amount;
    private Long categoryId;
}
