package com.example.demo.mapper;

import com.example.demo.dto.userReview.UserReviewDto;
import com.example.demo.model.entity.UserReview;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

import java.util.List;


@Mapper(componentModel = "spring", uses = {IOrderItemMapper.class}, nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface IUserReviewMapper {
    IUserReviewMapper INSTANCE = Mappers.getMapper(IUserReviewMapper.class);
    UserReviewDto toUserReviewDto(UserReview userReview);

    UserReview toUserReview(UserReviewDto DTO);

    List<UserReviewDto> toUserReviewsDTO(List<UserReview> userReviews);

    List<UserReview> toUserReviews(List<UserReview> UserReviewsDTO);

}