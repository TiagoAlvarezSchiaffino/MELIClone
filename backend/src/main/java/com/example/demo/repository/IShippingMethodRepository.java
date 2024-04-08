package com.example.demo.repository;

import com.example.demo.model.entity.ShippingMethod;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IShippingMethodRepository  extends JpaRepository<ShippingMethod,Long> {
}