package com.example.demo.dto.product;

import com.example.demo.dto.brand.BrandDTO;
import com.example.demo.dto.category.CategoryDto;
import com.example.demo.dto.image.ImageDto;
import com.example.demo.dto.orderItem.OrderItemDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductsDTO {
    private Integer id;
    private String name;
    private double price;
    private Integer stock;
    private String description;
    private Integer discount;
    private double priceDiscount;
    private Integer numberQuotas;
    private Double priceQuotas;
    private CategoryDto category;
    private BrandDTO brand;
    private List<ImageDto> images;
    private List<OrderItemDto> orders;
}