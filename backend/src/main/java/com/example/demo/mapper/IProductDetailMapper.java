package com.example.demo.mapper;

import com.example.demo.dto.product.ProductDetailGetDto;
import com.example.demo.model.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)

public interface IProductDetailMapper {

    @Mappings({
            @Mapping(target = "descriptionGeneric", ignore = true),
            @Mapping(target = "descriptionRelevant", ignore = true),
            @Mapping(target = "colors", source = "productJoined")

    }
    )
    ProductDetailGetDto toProductDetailGetDto(Product product);


}