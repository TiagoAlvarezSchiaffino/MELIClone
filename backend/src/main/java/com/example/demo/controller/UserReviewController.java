package com.example.demo.controller;
import com.example.demo.dto.userReview.UserReviewDto;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.entity.UserReview;
import com.example.demo.service.IUserReviewService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/userReviews")
@RequiredArgsConstructor
@Tag(name = "UserReview", description = "Review of a purchase item")

public class UserReviewController  {

    @Autowired
    IUserReviewService userReviewService;

    @GetMapping()
    public ResponseEntity<List<UserReviewDto>> getAll() {
        try {
            List<UserReviewDto> response = userReviewService.getAll();
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserReviewDto> getById(@PathVariable int id) throws ResourceNotFoundException {
        UserReviewDto response = userReviewService.getById(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<UserReviewDto> postUserReview(@RequestBody UserReview userReview) {
        UserReviewDto createdUserReview = userReviewService.post(userReview);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUserReview);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<UserReviewDto> patchUserReview(@PathVariable int id, @RequestBody UserReview userReview) throws ResourceNotFoundException {
        UserReviewDto updatedUserReview = userReviewService.patch(id, userReview);
        return ResponseEntity.ok(updatedUserReview);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUserReview(@PathVariable int id) throws ResourceNotFoundException {
        userReviewService.delete(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body("UserReview deleted");
    }


}