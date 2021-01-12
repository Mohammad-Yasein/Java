package com.assignments.productscategories.services;

import com.assignments.productscategories.models.Category;
import com.assignments.productscategories.models.Product;
import com.assignments.productscategories.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    public Category getCategory(Long id) {
        return categoryRepository.findById(id).orElse(null);
    }

    public void insertCategory(Category category) {
        categoryRepository.save(category);
    }

    public List<Category> getCategoriesNotInProduct(Product product) {
        return categoryRepository.findByProductsNotContains(product);
    }
}
