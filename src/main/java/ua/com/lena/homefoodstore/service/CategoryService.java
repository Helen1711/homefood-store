package ua.com.lena.homefoodstore.service;

import org.springframework.stereotype.Service;
import ua.com.lena.homefoodstore.entities.Category;
import ua.com.lena.homefoodstore.repository.CategoryRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    private final CategoryRepository repository;

    public CategoryService(CategoryRepository repository) {
        this.repository = repository;
    }

    public List<Category> getAll() {
        return repository.findAll();
    }

    public Optional<Category> getById(Long id) {
        return repository.findById(id);
    }

    public Optional<Category> findByName(String name) {
        return repository.findByName(name);
    }

    public int remove(Long id) {
        return repository.drop(id);
    }

    public void save(Category category) {
        repository.save(category);
    }
}
