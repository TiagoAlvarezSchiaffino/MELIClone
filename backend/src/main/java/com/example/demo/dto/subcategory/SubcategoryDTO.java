package com.example.demo.dto.subcategory;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SubcategoryDTO {
    private Integer id;
    private String name;
    private int ProductCount;
}