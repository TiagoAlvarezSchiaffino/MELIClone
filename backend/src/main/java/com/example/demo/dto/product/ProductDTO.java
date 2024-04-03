package com.example.demo.dto.product;

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
public class ProductDTO {
    private String name;
    private double price;
    private Integer stock;
    private String description;
    private CategoryDTO category;
    private List<ImageDTO> images;
    private List<OrderItemDto> orders;
}