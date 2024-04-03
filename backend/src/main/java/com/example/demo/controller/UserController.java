package com.example.demo.controller;

import com.example.demo.dto.product.CategoryDTO;
import com.example.demo.dto.product.ImageDTO;
import com.example.demo.dto.product.ProductDTO;
import com.example.demo.dto.user.UserDto;
import com.example.demo.model.entity.Image;
import com.example.demo.model.entity.Product;
import com.example.demo.model.entity.User;
import com.example.demo.repository.IUserRepositoryJpa;
import com.example.demo.service.IUserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
@Tag(name = "Users", description = "Informacion usuario.")
public class UserController {

    private final IUserService userService;

    private final IUserRepositoryJpa userRepository;

    @GetMapping("/{userId}")
    public ResponseEntity<UserDto> findById(@PathVariable Long userId) {
        return new ResponseEntity<>(userService.findById(userId), HttpStatus.OK);
    }


    @GetMapping("/user/{userId}/products")
    public ResponseEntity<?> getUserProducts(@PathVariable("userId") Integer userId) {
        // Verificar si el usuario existe
        User user = userRepository.findById(userId).orElse(null);
        if (user == null) {
            // Manejar el caso de usuario no encontrado
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User not found");
        }

        // Obtener la lista de productos asociados al usuario
        List<Product> products = user.getProducts();

        // Crear una lista de ProductDTO para almacenar la información de los productos
        List<ProductDTO> productDTOs = new ArrayList<>();

        // Iterar sobre los productos y crear los objetos ProductDTO
        for (Product product : products) {
            ProductDTO productDTO = new ProductDTO().builder()
                    .name(product.getName())
                    .price(product.getPrice())
                    .stock(product.getStock())
                    .description(product.getDescription())
                    .category(CategoryDTO.builder()
                            .id(product.getCategory().getId())
                            .name(product.getCategory().getName())
                            .build())
                    .images(new ArrayList<>())
                    .build();

            // Obtener las imágenes del producto
            List<Image> images = product.getImages();

            // Iterar sobre las imágenes y crear los objetos ImageDTO
            for (Image image : images) {
                ImageDTO imageDTO = ImageDTO.builder()
                        .url(image.getUrl())
                        .build();

                // Agregar el ImageDTO a la lista de imágenes del ProductDTO
                productDTO.getImages().add(imageDTO);
                // Asignar otros atributos del producto según sea necesario
                // ...
            }
            // Agregar el ProductDTO a la lista
            productDTOs.add(productDTO);
        }

        // Devolver la lista de ProductDTO como respuesta
        return ResponseEntity.ok(productDTOs);
    }

}