package com.example.demo.dto.province;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProvinceDto {
    private Integer id;
    @SerializedName("nombre")
    private String name;
}