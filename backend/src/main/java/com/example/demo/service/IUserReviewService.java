package com.example.demo.service;

import com.example.demo.dto.userReview.UserReviewDto;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.entity.UserReview;

import java.util.List;

public interface IUserReviewService {
    List<UserReviewDto> getAll();
    UserReviewDto getById(int id) throws ResourceNotFoundException;

    UserReviewDto post(UserReview userReview);

    UserReviewDto patch(int id,UserReview userReview) throws ResourceNotFoundException;

    UserReviewDto delete(int id) throws ResourceNotFoundException;


}