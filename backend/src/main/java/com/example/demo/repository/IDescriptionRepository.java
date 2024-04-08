package com.example.demo.repository;

import com.example.demo.model.entity.Description;
import com.example.demo.model.enums.DescriptionEnum;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IDescriptionRepository extends JpaRepository<Description, Integer> {

    List<Description> findAllByPriorityAndProductId(DescriptionEnum priority, Integer productId);

}