package com.example.demo.mapper;

import com.example.demo.dto.description.DescriptionDto;
import com.example.demo.model.entity.Description;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface IDescriptionMapper {

    DescriptionDto toDescriptionDto(Description description);

    List<DescriptionDto> toDescriptionDtos(List<Description> descriptions);
}