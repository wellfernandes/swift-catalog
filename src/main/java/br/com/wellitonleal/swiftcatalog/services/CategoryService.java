package br.com.wellitonleal.swiftcatalog.services;

import br.com.wellitonleal.swiftcatalog.domain.category.Category;
import br.com.wellitonleal.swiftcatalog.domain.category.CategoryDTO;
import br.com.wellitonleal.swiftcatalog.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
    private CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }

    public Category create(CategoryDTO categoryDTO){
        Category newCategory = new Category(categoryDTO);
        this.categoryRepository.save(newCategory);
        return newCategory;
    }
}