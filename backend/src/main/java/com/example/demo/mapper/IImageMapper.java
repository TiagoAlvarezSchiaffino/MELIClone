package com.example.demo.mapper;

import com.example.demo.dto.image.ImageDto;
import com.example.demo.model.entity.Image;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

import java.util.List;


    @Mapper(componentModel = "spring", uses = {}, nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    public interface IImageMapper {
        IImageMapper INSTANCE = Mappers.getMapper(IImageMapper.class);
        ImageDto toImageDto(Image imagey);

        Image toImage(ImageDto DTO);

        List<ImageDto> toImagesDTO(List<Image> images);

        List<Image> toImages(List<ImageDto> imagesDTO);
    }