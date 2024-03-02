package br.com.wellitonleal.swiftcatalog.services;

import br.com.wellitonleal.swiftcatalog.domain.category.Category;
import br.com.wellitonleal.swiftcatalog.domain.category.exceptions.CategoryNotFoundExcepetion;
import br.com.wellitonleal.swiftcatalog.domain.product.Product;
import br.com.wellitonleal.swiftcatalog.domain.product.ProductDTO;
import br.com.wellitonleal.swiftcatalog.domain.product.exceptions.ProductNotFoundException;
import br.com.wellitonleal.swiftcatalog.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private CategoryService categoryService;
    private ProductRepository productRepository;

    public ProductService(CategoryService categoryService, ProductRepository productRepository){
        this.categoryService = categoryService;
        this.productRepository = productRepository;
    }

    public Product create(ProductDTO productDTO){
        Category category = this.categoryService.getById(productDTO.categoryId()).
                orElseThrow(CategoryNotFoundExcepetion::new);

        Product newProduct = new Product(productDTO);
        newProduct.setCategory(category);
        this.productRepository.save(newProduct);
        return newProduct;
    }

    public List<Product> getAll(){
        return this.productRepository.findAll();
    }

    public Product update(String id, ProductDTO productDTO){
        Product product = this.productRepository.findById(id).
                orElseThrow(ProductNotFoundException::new);

       this.categoryService.getById(productDTO.categoryId()).
                ifPresent(product::setCategory);

        if (!productDTO.title().isEmpty()) {
            product.setTitle(productDTO.title());
        }
        if (!productDTO.description().isEmpty()) {
            product.setDescription(productDTO.description());
        }
        if (!(productDTO.price() == null)) {
            product.setPrice(productDTO.price());
        }
        this.productRepository.save(product);

        return product;
    }

    public void delete(String id) {
        Product product = this.productRepository.findById(id).
                orElseThrow(ProductNotFoundException::new);
        this.productRepository.delete(product);
    }
}