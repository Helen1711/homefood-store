package ua.com.lena.homefoodstore.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ua.com.lena.homefoodstore.entities.Product;
import ua.com.lena.homefoodstore.repository.ProductRepository;

import java.util.Optional;

@Service
public class ProductService {
    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public Page<Product> findProductsByCategoryId(long id, Pageable pageable) {
        return repository.findAllByCategoryId(id, pageable);
    }

    public Page<Product> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public Optional<Product> getById(Long id) {
        return repository.findById(id);
    }

    public void remove(Long id) {
        repository.deleteById(id);
    }

    public void save(Product product) {
        repository.save(product);
    }
}
