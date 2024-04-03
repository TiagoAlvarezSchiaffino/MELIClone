package com.example.demo.controller;

import com.example.demo.dto.shippingMethod.ShippingMethodDto;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.entity.ShippingMethod;
import com.example.demo.service.IShippingMethodService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/shippingMethods")
@RequiredArgsConstructor
@Tag(name = "ShippingMethod", description = "Shipping Method  of Purchase Order")

public class ShippingMethodController  {

    @Autowired
    IShippingMethodService shippingMethodService;

    @GetMapping()
    public ResponseEntity<List<ShippingMethodDto>> getAll() {
        try {
            List<ShippingMethodDto> response = shippingMethodService.getAll();
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ShippingMethodDto> getById(@PathVariable int id) throws ResourceNotFoundException {
        ShippingMethodDto response = shippingMethodService.getById(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<ShippingMethodDto> postShippingMethod(@RequestBody ShippingMethod shippingMethod) {
        ShippingMethodDto createdShippingMethod = shippingMethodService.post(shippingMethod);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdShippingMethod);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ShippingMethodDto> patchShippingMethod(@PathVariable int id, @RequestBody ShippingMethod shippingMethod) throws ResourceNotFoundException {
        ShippingMethodDto updatedShippingMethod = shippingMethodService.patch(id, shippingMethod);
        return ResponseEntity.ok(updatedShippingMethod);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteShippingMethod(@PathVariable int id) throws ResourceNotFoundException {
        shippingMethodService.delete(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body("ShippingMethod deleted");
    }


}
