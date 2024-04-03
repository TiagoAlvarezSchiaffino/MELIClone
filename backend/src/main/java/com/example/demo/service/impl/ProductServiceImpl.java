package com.example.demo.service.impl;

import com.example.demo.dto.product.ProductDTO;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.mapper.IProductMapper;
import com.example.demo.model.entity.Product;
import com.example.demo.repository.product_repository.ProductRepository;
import com.example.demo.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class  ProductServiceImpl implements IProductService {


    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private IProductMapper productMapper;


    @Override
    public List<ProductDTO> getAll() {
        return productMapper.toProductsDTO(productRepository.findAll());
    }


    @Override
    public ProductDTO getById(int id) throws ResourceNotFoundException {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product with id " + id + " not found"));
        return productMapper.toProductDto(product);
    }




    @Override
    public ProductDTO post(Product product) {

        Product savedProduct = productRepository.save(product);
        return productMapper.toProductDto(savedProduct);
    }




    @Override
    public ProductDTO patch(int id, Product product) throws ResourceNotFoundException {
        Product existingProduct = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product with id " + id + " not found"));
        if (product.getName() != null) {
            existingProduct.setName(product.getName());
        }
        if (product.getDescription() != null) {
            existingProduct.setDescription(product.getDescription());
        }
        existingProduct.setPrice(product.getPrice());
        existingProduct.setImages(product.getImages());
        existingProduct.setUser(product.getUser());
        existingProduct.setStock(product.getStock());
        existingProduct.setCategory(product.getCategory());

        Product updatedProduct = productRepository.save(existingProduct);
        return productMapper.toProductDto(updatedProduct);
    }

    @Override
    public ProductDTO delete(int id) throws ResourceNotFoundException {
        Product productToDelete = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product with id " + id + " not found"));
        productRepository.delete(productToDelete);
        return productMapper.toProductDto(productToDelete);
    }


    @Override
    public List<ProductDTO> getByUser (int id) {
        return productMapper.toProductsDTO(productRepository.findByUser_id(id));

    }


}