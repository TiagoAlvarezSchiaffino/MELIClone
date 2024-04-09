package com.example.demo.service;

import com.example.demo.dto.userReview.UserReviewDto;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.entity.UserReview;

import java.util.List;

public interface IUserReviewService {
    List<UserReviewDto> getAll();
    UserReviewDto getById(Long id) throws ResourceNotFoundException;

    UserReviewDto post(UserReview userReview);

    UserReviewDto patch(Long id,UserReview userReview) throws ResourceNotFoundException;

    UserReviewDto delete(Long id) throws ResourceNotFoundException;


}