package com.example.demo.service;

import com.example.demo.dto.product.ProductDTO;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.entity.Product;

import java.util.List;

public interface IProductService {
    List<ProductDTO> getAll();
    ProductDTO getById(int id) throws ResourceNotFoundException;

    ProductDTO post(Product product);

    ProductDTO patch(int id,Product product) throws ResourceNotFoundException;

    ProductDTO delete(int id) throws ResourceNotFoundException;

    List<ProductDTO> getByUser(int id);

}