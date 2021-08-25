package com.springboot.server.repository;

import com.springboot.server.model.AppProduct;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<AppProduct, Long> {

    void deleteProductByProductID(Long id);

    Optional<AppProduct> findProductByProductID(Long id);
}
