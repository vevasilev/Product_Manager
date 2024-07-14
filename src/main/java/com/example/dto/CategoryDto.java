package com.example.dto;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class CategoryDto {
    private Long id;
    private String name;
}
