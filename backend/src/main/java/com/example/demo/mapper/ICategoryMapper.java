package com.example.demo.mapper;

import com.example.demo.dto.product.CategoryDTO;
import com.example.demo.model.entity.Category;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

import java.util.List;


    @Mapper(componentModel = "spring", uses = {}, nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    public interface ICategoryMapper {
        ICategoryMapper INSTANCE = Mappers.getMapper(ICategoryMapper.class);
        CategoryDTO toCategoryDto(Category category);

        Category toCategory(CategoryDTO DTO);

        List<CategoryDTO> toCategoriesDTO(List<Category> category);

        List<Category> toCategories(List<CategoryDTO> categoryDTO);
}