package ua.com.lena.homefoodstore.web.mappers.request;

import ua.com.lena.homefoodstore.entities.Category;
import ua.com.lena.homefoodstore.entities.Product;
import ua.com.lena.homefoodstore.web.dto.request.ProductRequest;

public class ProductRequestMapper {
    public static Product toEntity(Product product, ProductRequest request){
        product.setName(request.getName());
        product.setPrice(request.getPrice());
        product.setEmasculate(request.isEmasculate());
        product.setType(request.getType());
        product.setAgeGroup(request.getAgeGroup());
        Category category = new Category();
        category.setId(request.getCategoryId());
        product.setCategory(category);
        return product;
    }

    public static ProductRequest toDto(Product product){
        ProductRequest request = new ProductRequest();
        request.setName(product.getName());
        request.setPrice(product.getPrice());
        request.setEmasculate(product.isEmasculate());
        request.setType(product.getType());
        request.setAgeGroup(product.getAgeGroup());
        request.setCategoryId(product.getCategory().getId());
        return request;
    }
}
