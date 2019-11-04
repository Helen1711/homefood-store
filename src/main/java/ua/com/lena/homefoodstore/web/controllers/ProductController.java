package ua.com.lena.homefoodstore.web.controllers;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.com.lena.homefoodstore.entities.Product;
import ua.com.lena.homefoodstore.service.ProductService;
import ua.com.lena.homefoodstore.web.dto.request.ProductRequest;
import ua.com.lena.homefoodstore.web.dto.response.ProductResponse;
import ua.com.lena.homefoodstore.web.mappers.request.ProductRequestMapper;
import ua.com.lena.homefoodstore.web.mappers.response.ProductResponseMapper;

import javax.validation.Valid;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<Page<ProductResponse>> getProducts(@RequestParam("page") int page,
                                                             @RequestParam("size") int size,
                                                             @RequestParam(value = "sort",
                                                                     defaultValue = "DESC",
                                                                     required = false) String sort) {
        Page<ProductResponse> products = service
                .findAll(PageRequest.of(page, size, Sort.Direction.valueOf(sort)))
                .map(ProductResponseMapper::toDto);
        return ResponseEntity.ok(products);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> getProduct(@PathVariable Long id) {
        return service.getById(id)
                .map(ProductResponseMapper::toDto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        return service.getById(id)
                .map(product -> {
                    service.remove(id);
                    return ResponseEntity.noContent().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity create(@Valid @RequestBody ProductRequest request) {
        service.save(ProductRequestMapper.toEntity(new Product(), request));
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable Long id, @RequestBody ProductRequest request) {
        return service.getById(id)
                .map(product -> {
                    service.save(ProductRequestMapper.toEntity(product, request));
                    return ResponseEntity.ok().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
