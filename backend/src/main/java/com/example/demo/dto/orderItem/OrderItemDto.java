package com.example.demo.dto.orderItem;

import com.example.demo.dto.order.OrderDto;
import com.example.demo.dto.product.ProductDTO;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class OrderItemDto {

        private int id;
        private ProductDTO product;
        //private OrderDto order;
        private int quantity;

    }
