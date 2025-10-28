package com.ecommerce.catalog_service.service;

import com.ecommerce.catalog_service.model.Product;
import com.ecommerce.catalog_service.repository.ProductRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductService {

    private final ProductRepository repo;

    public ProductService(ProductRepository repo) {
        this.repo = repo;
    }

    public List<Product> getAll() {
        return repo.findAll();
    }

    public Product getById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public Product create(Product product) {
        return repo.save(product);
    }

    public Product update(Long id, Product updated) {
        updated.setId(id);
        return repo.save(updated);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}
