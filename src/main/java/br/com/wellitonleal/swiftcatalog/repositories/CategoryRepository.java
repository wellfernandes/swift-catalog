package br.com.wellitonleal.swiftcatalog.repositories;

import br.com.wellitonleal.swiftcatalog.domain.category.Category;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends MongoRepository<Category, String> {
}