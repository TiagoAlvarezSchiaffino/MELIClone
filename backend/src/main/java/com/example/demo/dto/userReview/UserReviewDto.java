package com.example.demo.dto.userReview;

import com.example.demo.dto.orderItem.OrderItemDto;
import com.example.demo.dto.product.ProductDTO;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class  UserReviewDto {

    private int id;
    private int  ratingValue;
    private String comments;
    private OrderItemDto item;
}
