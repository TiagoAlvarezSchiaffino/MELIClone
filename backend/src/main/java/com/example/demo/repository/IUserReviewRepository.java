package com.example.demo.repository;

import com.example.demo.model.entity.UserReview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IUserReviewRepository extends JpaRepository<UserReview, Integer> {
}