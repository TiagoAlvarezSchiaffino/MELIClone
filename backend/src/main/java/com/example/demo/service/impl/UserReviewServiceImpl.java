package com.example.demo.service.impl;

import com.example.demo.dto.userReview.UserReviewDto;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.mapper.IUserReviewMapper;
import com.example.demo.model.entity.UserReview;
import com.example.demo.repository.IUserReviewRepository;
import com.example.demo.service.IUserReviewService;
import com.example.demo.service.IUserReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserReviewServiceImpl implements IUserReviewService {
    @Autowired
    private IUserReviewRepository userReviewRepository;

    @Autowired
    private IUserReviewMapper userReviewMapper;


    @Override
    public List<UserReviewDto> getAll() {
        return userReviewMapper.toUserReviewsDTO(userReviewRepository.findAll());
    }


    @Override
    public UserReviewDto getById(Long id) throws ResourceNotFoundException {
        UserReview userReview = userReviewRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("UserReview with id " + id + " not found"));
        return userReviewMapper.toUserReviewDto(userReview);
    }


    @Override
    public UserReviewDto post(UserReview userReview) {
        UserReview savedUserReview = userReviewRepository.save(userReview);
        return userReviewMapper.toUserReviewDto(savedUserReview);
    }




    @Override
    public UserReviewDto patch(Long id, UserReview userReview) throws ResourceNotFoundException {
        UserReview existingUserReview = userReviewRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("UserReview with id " + id + " not found"));
        if (userReview.getComments() != null) {
            existingUserReview.setComments(userReview.getComments());
        }
        existingUserReview.setRatingValue(userReview.getRatingValue());
        existingUserReview.setItem(userReview.getItem());
        UserReview updatedUserReview = userReviewRepository.save(existingUserReview);
        return userReviewMapper.toUserReviewDto(updatedUserReview);
    }

    @Override
    public UserReviewDto delete(Long id) throws ResourceNotFoundException {
        UserReview userReviewToDelete = userReviewRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("UserReview with id " + id + " not found"));
        userReviewRepository.delete(userReviewToDelete);
        return userReviewMapper.toUserReviewDto(userReviewToDelete);
    }


}