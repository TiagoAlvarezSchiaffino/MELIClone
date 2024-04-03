package com.example.demo.controller;

import com.example.demo.dto.order.OrderDto;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.entity.Order;
import com.example.demo.service.IOrderService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

 @RestController
 @RequestMapping("/api/v1/orders")
 @RequiredArgsConstructor
 @Tag(name = "Orders", description = "Purchase Order")

public class OrderController  {

    @Autowired
    IOrderService orderService;

    @GetMapping()
    public ResponseEntity<List<OrderDto>> getAll() {
        try {
            List<OrderDto> response = orderService.getAll();
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderDto> getById(@PathVariable int id) throws ResourceNotFoundException {
        OrderDto response = orderService.getById(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<OrderDto> postOrder(@RequestBody Order order) {
        OrderDto createdOrder = orderService.post(order);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdOrder);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<OrderDto> patchOrder(@PathVariable int id, @RequestBody Order order) throws ResourceNotFoundException {
        OrderDto updatedOrder = orderService.patch(id, order);
        return ResponseEntity.ok(updatedOrder);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteOrder(@PathVariable int id) throws ResourceNotFoundException {
        orderService.delete(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body("Order deleted");
    }

    @GetMapping("/user/{id}")
    @Operation(summary = "Ordenes por usuario, se envia el ID del usuario.")
    public ResponseEntity<List<OrderDto>> getByUser(@PathVariable int id) {
        List<OrderDto> orders = orderService.getByUser(id);
        return ResponseEntity.ok(orders);
        try {
            List<OrderDto> response = orderService.getByUser(id);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }


}