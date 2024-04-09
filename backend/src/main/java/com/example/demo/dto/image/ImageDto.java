package com.example.demo.dto.image;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ImageDto {
    private Integer id;
    private String imageUrl;
}