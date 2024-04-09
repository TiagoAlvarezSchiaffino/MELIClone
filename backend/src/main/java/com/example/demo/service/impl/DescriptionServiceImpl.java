package com.example.demo.service.impl;

import com.example.demo.dto.description.DescriptionDto;
import com.example.demo.mapper.IDescriptionMapper;
import com.example.demo.model.enums.DescriptionEnum;
import com.example.demo.repository.IDescriptionRepository;
import com.example.demo.service.IDescriptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DescriptionServiceImpl implements IDescriptionService {
    private final IDescriptionRepository descriptionRepository;

    private final IDescriptionMapper descriptionMapper;

    @Override
    public List<DescriptionDto> findAllByPriorityAndProductId(DescriptionEnum priority, Integer productId) {
        return this.descriptionMapper.toDescriptionDtos(
                this.descriptionRepository.
                        findAllByPriorityAndProductId(priority, productId));
    }


}