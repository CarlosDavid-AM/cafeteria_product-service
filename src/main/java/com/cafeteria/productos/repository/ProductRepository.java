package com.cafeteria.productos.repository;

import com.cafeteria.productos.entity.Products;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Products, Long> {
}
