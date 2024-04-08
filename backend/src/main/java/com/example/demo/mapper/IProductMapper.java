package com.example.demo.mapper;

import com.example.demo.dto.description.DescriptionDto;
import com.example.demo.dto.product.ProductDetailGetDto;
import com.example.demo.dto.product.ProductDto;
import com.example.demo.dto.product.ProductListGetDto;

import com.example.demo.model.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring", uses = {IUserMapper.class, ICategoryMapper.class, IImageMapper.class, IOrderItemMapper.class}, nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface IProductMapper {
    IProductMapper INSTANCE = Mappers.getMapper(IProductMapper.class);

    ProductDto toProductDto(Product product);

    Product toProduct(ProductDto DTO);

    List<ProductListGetDto> toProductListGetDto(List<Product> product);

    @Mappings({
            @Mapping(target = "descriptionGeneric", ignore = true),
            @Mapping(target = "descriptionRelevant", ignore = true)
    }
    )
    ProductDetailGetDto toProductDetailGetDto(Product product);


    List<ProductDto> toProductsDTO(List<Product> products);

    List<Product> toProducts(List<ProductDto> ProductsDTO);

}