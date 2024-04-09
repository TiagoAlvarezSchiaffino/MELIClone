package com.example.demo.service;

import com.example.demo.dto.description.DescriptionDto;
import com.example.demo.model.enums.DescriptionEnum;

import java.util.List;

public interface IDescriptionService {

    List<DescriptionDto> findAllByPriorityAndProductId(DescriptionEnum priority, Integer productId);
}