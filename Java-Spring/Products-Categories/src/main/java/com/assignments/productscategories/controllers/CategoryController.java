package com.assignments.productscategories.controllers;

import com.assignments.productscategories.models.Category;
import com.assignments.productscategories.models.Product;
import com.assignments.productscategories.services.CategoryService;
import com.assignments.productscategories.services.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/categories")
public class CategoryController {
    private final ProductService productService;
    private final CategoryService categoryService;

    public CategoryController(ProductService productService, CategoryService categoryService) {
        this.productService = productService;
        this.categoryService = categoryService;
    }

    @RequestMapping("/new")
    public String insertCategoryPage(@ModelAttribute("category") Category category) {
        return "insertCategory.jsp";
    }

    @PostMapping("")
    public String insertCategory(@Valid @ModelAttribute("category") Category category, BindingResult result) {
        if (result.hasErrors()) {
            return "insertCategory.jsp";
        }
        categoryService.insertCategory(category);
        return "redirect:/categories/new";
    }

    @RequestMapping("/{id}")
    public String showCategoryPage(@PathVariable("id") Long id, Model model) {
        Category category = categoryService.getCategory(id);
        model.addAttribute("category", category);
        model.addAttribute("products", productService.getProductsNotInCategory(category));
        return "showCategory.jsp";
    }

    @PostMapping("/{id}")
    public String addProductToCategory(@PathVariable("id") Long id, @RequestParam(value = "productId") Long productId) {
        Category category = categoryService.getCategory(id);
        Product product = productService.getProduct(productId);
        category.getProducts().add(product);
        categoryService.insertCategory(category);
        return "redirect:/categories/" + id;
    }
}
