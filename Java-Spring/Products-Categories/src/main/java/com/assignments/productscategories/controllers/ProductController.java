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
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;
    private final CategoryService categoryService;

    public ProductController(ProductService productService, CategoryService categoryService) {
        this.productService = productService;
        this.categoryService = categoryService;
    }

    @RequestMapping("/new")
    public String insertProductPage(@ModelAttribute("product") Product product) {
        return "insertProduct.jsp";
    }

    @PostMapping("")
    public String insertProduct(@Valid @ModelAttribute("product") Product product, BindingResult result) {
        if (result.hasErrors()) {
            return "insertProduct.jsp";
        }
        productService.insertProduct(product);
        return "redirect:/products/new";
    }

    @RequestMapping("/{id}")
    public String showProductPage(@PathVariable("id") Long id, Model model) {
        Product product = productService.getProduct(id);
        model.addAttribute("product", product);
        model.addAttribute("categories", categoryService.getCategoriesNotInProduct(product));
        return "showProduct.jsp";
    }

    @PostMapping("/{id}")
    public String addCategoryToProduct(@PathVariable("id") Long id, @RequestParam(value = "categoryId") Long categoryId) {
        Product product = productService.getProduct(id);
        Category category = categoryService.getCategory(categoryId);
        product.getCategories().add(category);
        productService.insertProduct(product);
        return "redirect:/products/" + id;
    }
}
