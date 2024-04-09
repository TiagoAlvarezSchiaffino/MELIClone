package com.example.demo.service;

import com.example.demo.dto.product.ProductDetailGetDto;
import com.example.demo.dto.product.ProductDto;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.entity.Product;
import com.example.demo.dto.product.ProductListGetDto;

import java.util.List;

public interface IProductService {
    List<ProductDto> getAll();

    ProductDto getById(int id) throws ResourceNotFoundException;

    ProductDto post(Product product);

    ProductDto patch(int id, Product product) throws ResourceNotFoundException;

    ProductDto delete(int id) throws ResourceNotFoundException;

    List<ProductDto> getByUser(int id);


    List<ProductListGetDto> findAllProduct();

    ProductDetailGetDto findProductById(Integer productId);

}