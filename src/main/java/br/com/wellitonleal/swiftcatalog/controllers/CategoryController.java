package br.com.wellitonleal.swiftcatalog.controllers;

import br.com.wellitonleal.swiftcatalog.domain.category.Category;
import br.com.wellitonleal.swiftcatalog.domain.category.CategoryDTO;
import br.com.wellitonleal.swiftcatalog.services.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/category")
public class CategoryController {
    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService){
        this.categoryService = categoryService;
    }

    @PostMapping
    public ResponseEntity<Category> create(@RequestBody CategoryDTO categoryDTO) {
        Category newCategory = this.categoryService.create(categoryDTO);
        return ResponseEntity.ok(newCategory);
    }
}