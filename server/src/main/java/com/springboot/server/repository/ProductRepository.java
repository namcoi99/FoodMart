package com.springboot.server.repository;

import com.springboot.server.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {

    void deleteProductByProductID(Long id);

    Optional<Product> findProductByProductID(Long id);
}
