package com.example.demo.service.impl;

import com.example.demo.dto.product.ProductDetailGetDto;
import com.example.demo.dto.product.ProductDto;
import com.example.demo.dto.product.ProductListGetDto;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.mapper.IProductMapper;
import com.example.demo.mapper.IProductDetailMapper;
import com.example.demo.model.entity.Product;
import com.example.demo.model.enums.DescriptionEnum;
import com.example.demo.repository.IProductRepository;
import com.example.demo.service.IDescriptionService;
import com.example.demo.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class ProductServiceImpl implements IProductService {


    @Autowired
    private IProductRepository productRepository;

    @Autowired
    private IProductMapper productMapper;

    @Autowired
    private IProductDetailMapper productDetailMapper;

    @Autowired
    private IDescriptionService descriptionService;

    @Override
    public List<ProductDto> getAll() {
        return productMapper.toProductsDTO(productRepository.findAll());
    }


    @Override
    public ProductDto getById(int id) throws ResourceNotFoundException {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product with id " + id + " not found"));
        return productMapper.toProductDto(product);
    }


    @Override
    public ProductDto post(Product product) {

        Product savedProduct = productRepository.save(product);
        return productMapper.toProductDto(savedProduct);
    }


    @Override
    public ProductDto patch(int id, Product product) throws ResourceNotFoundException {
        Product existingProduct = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product with id " + id + " not found"));
        if (product.getTitle() != null) {
            existingProduct.setTitle(product.getTitle());
        }
//        if (product.getDescription() != null) {
//            existingProduct.setDescription(product.getDescription());
//        }
        existingProduct.setPrice(product.getPrice());
        existingProduct.setImages(product.getImages());
        existingProduct.setUser(product.getUser());
        existingProduct.setStock(product.getStock());
        existingProduct.setCategory(product.getCategory());

        Product updatedProduct = productRepository.save(existingProduct);
        return productMapper.toProductDto(updatedProduct);
    }

    @Override
    public ProductDto delete(int id) throws ResourceNotFoundException {
        Product productToDelete = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product with id " + id + " not found"));
        productRepository.delete(productToDelete);
        return productMapper.toProductDto(productToDelete);
    }


    @Override
    public List<ProductDto> getByUser(int id) {
        return productMapper.toProductsDTO(productRepository.findByUser_id(id));

    }

    @Override
    public List<ProductListGetDto> findAllProduct() {

        return this.productMapper.toProductListGetDto(
                this.productRepository
                        .findAll()
                        .stream()
                        .peek(
                                product ->
                                {
                                    product.setPriceQuotas(product.getPrice() / product.getNumberQuotas());
                                    product.setPriceDiscount(product.getPrice() - (product.getPrice() * product.getDiscount()) / 100);
                                }
                        ).toList()
        );
    }

    @Override
    public ProductDetailGetDto findProductById(Integer productId) {

        ProductDetailGetDto productById = this.productRepository.findById(productId)
                .map(product -> {
                            product.setPriceQuotas(product.getPrice() / product.getNumberQuotas());
                            product.setPriceDiscount(product.getPrice() - (product.getPrice() * product.getDiscount()) / 100);
                            return this.productDetailMapper.toProductDetailGetDto(product);
                        }

                )
                .orElseThrow(() -> new RuntimeException("Error product by id"));

        productById.setDescriptionGeneric(
                this.descriptionService.findAllByPriorityAndProductId(
                        DescriptionEnum.GENERIC, productId));
        productById.setDescriptionRelevant(this.descriptionService.findAllByPriorityAndProductId(
                DescriptionEnum.RELEVANT, productId));

        return productById;
    }


}