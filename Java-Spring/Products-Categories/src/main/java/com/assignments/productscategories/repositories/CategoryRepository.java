package com.assignments.productscategories.repositories;

import com.assignments.productscategories.models.Category;
import com.assignments.productscategories.models.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {
    List<Category> findAll();

    List<Category> findByProductsNotContains(Product product);
}
