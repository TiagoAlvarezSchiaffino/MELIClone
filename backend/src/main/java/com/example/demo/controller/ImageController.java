package com.example.demo.controller;

import com.example.demo.dto.image.ImageDto;
import com.example.demo.service.impl.CloudinaryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/v1/images")
@RequiredArgsConstructor
public class ImageController {

    private final CloudinaryService cloudinaryService;

    @PostMapping("")
    public ResponseEntity<List<String>> uploadImage(
            @RequestParam("file") MultipartFile[] file) {
        return new ResponseEntity<>(cloudinaryService.uploads(file), HttpStatus.CREATED);
    }
}