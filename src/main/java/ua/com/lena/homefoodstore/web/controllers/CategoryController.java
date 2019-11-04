package ua.com.lena.homefoodstore.web.controllers;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.com.lena.homefoodstore.entities.Category;
import ua.com.lena.homefoodstore.service.CategoryService;
import ua.com.lena.homefoodstore.service.ProductService;
import ua.com.lena.homefoodstore.web.dto.request.CategoryRequest;
import ua.com.lena.homefoodstore.web.dto.response.CategoryResponse;
import ua.com.lena.homefoodstore.web.dto.response.ProductResponse;
import ua.com.lena.homefoodstore.web.mappers.request.CategoryRequestMapper;
import ua.com.lena.homefoodstore.web.mappers.response.CategoryResponseMapper;
import ua.com.lena.homefoodstore.web.mappers.response.ProductResponseMapper;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/categories")
public class CategoryController {
    private final CategoryService service;
    private final ProductService productService;

    public CategoryController(CategoryService service, ProductService productService) {
        this.service = service;
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<List<CategoryResponse>> getCategories() {
        List<CategoryResponse> responses = service.getAll()
                .stream()
                .map(CategoryResponseMapper::toDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(responses);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryResponse> getCategory(@PathVariable Long id) {
        return service.getById(id)
                .map(CategoryResponseMapper::toDto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/{id}/products")
    public ResponseEntity<Page<ProductResponse>> getAllProducts(@PathVariable long id,
                                                                @RequestParam("page") int page,
                                                                @RequestParam("size") int size,
                                                                Pageable pageable) {
        Page<ProductResponse> products = productService.findProductsByCategoryId(id, pageable)
                .map(ProductResponseMapper::toDto);
        return ResponseEntity.ok(products);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        if (!service.getById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        if (service.remove(id) > 0) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.unprocessableEntity().build();
        }
    }

    @PostMapping
    public ResponseEntity create(@Valid @RequestBody CategoryRequest request) {
        if (service.findByName(request.getName()).isPresent()) {
            return new ResponseEntity(HttpStatus.CONFLICT);
        }
        service.save(CategoryRequestMapper.toEntity(new Category(), request));
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable Long id, @RequestBody CategoryRequest request) {
        return service.getById(id)
                .map(category -> {
                    service.save(CategoryRequestMapper.toEntity(category, request));
                    return ResponseEntity.ok().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
