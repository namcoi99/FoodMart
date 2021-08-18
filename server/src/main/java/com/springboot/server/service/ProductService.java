package com.springboot.server.service;

import com.springboot.server.exception.ProductNotFoundException;
import com.springboot.server.model.Product;
import com.springboot.server.model.User;
import com.springboot.server.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    public List<Product> findAllProducts() {
        return productRepository.findAll();
    }

    public Product updateProduct(Product product) {
        return productRepository.save(product);
    }

    public void deleteProduct(Long id) {
        productRepository.deleteProductByProductID(id);
    }

    public Product findProductById(Long id) {
        return productRepository.findProductByProductID(id)
                .orElseThrow(() -> new ProductNotFoundException("Product with id " + id + " was not found."));
    }
}
