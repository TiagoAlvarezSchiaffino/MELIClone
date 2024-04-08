package com.example.demo.repository;

import com.example.demo.model.entity.Subcategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISubcategoryRepository extends JpaRepository<Subcategory, Integer> {
}