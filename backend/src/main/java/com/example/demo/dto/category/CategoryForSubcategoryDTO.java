package com.example.demo.dto.category;

import com.example.demo.dto.subcategory.SubcategoryDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CategoryForSubcategoryDTO {
    private Integer id;
    private String name;
    private List<SubcategoryDTO> subcategories;
}