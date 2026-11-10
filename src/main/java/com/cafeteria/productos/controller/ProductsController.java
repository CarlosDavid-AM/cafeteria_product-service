package com.cafeteria.productos.controller;

import com.cafeteria.productos.dto.request.ProductsRequestDTO;
import com.cafeteria.productos.dto.response.ProductsResponseDTO;
import com.cafeteria.productos.service.ProductsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/products")
public class ProductsController {

    private final ProductsService productsService;

    public ProductsController(ProductsService productsService) {
        this.productsService = productsService;
    }

    @GetMapping
    public ResponseEntity<List<ProductsResponseDTO>> findAll() {
        return ResponseEntity.ok(productsService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductsResponseDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(productsService.findById(id));
    }

    @PostMapping
    public ResponseEntity<ProductsResponseDTO> create(@RequestBody ProductsRequestDTO requestDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(productsService.create(requestDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductsResponseDTO> update(@PathVariable Long id,
                                                      @RequestBody ProductsRequestDTO requestDTO) {
        return ResponseEntity.ok(productsService.update(id, requestDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        productsService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
