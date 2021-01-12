package com.assignments.productscategories.services;

import com.assignments.productscategories.models.Category;
import com.assignments.productscategories.models.Product;
import com.assignments.productscategories.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProduct(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    public void insertProduct(Product product) {
        productRepository.save(product);
    }

    public List<Product> getProductsNotInCategory(Category category) {
        return productRepository.findByCategoriesNotContains(category);
    }
}
