package ua.com.lena.homefoodstore.web.mappers.response;

import ua.com.lena.homefoodstore.entities.Product;
import ua.com.lena.homefoodstore.web.dto.response.ProductResponse;

public class ProductResponseMapper {
    public static Product toEntity(ProductResponse response){
        Product product = new Product();
        product.setId(response.getId());
        product.setName(response.getName());
        product.setPrice(response.getPrice());
        product.setEmasculate(response.isEmasculate());
        product.setType(response.getType());
        product.setAgeGroup(response.getAgeGroup());
        return product;
    }

    public static ProductResponse toDto(Product product){
        ProductResponse response = new ProductResponse();
        response.setId(product.getId());
        response.setPrice(product.getPrice());
        response.setName(product.getName());
        response.setEmasculate(product.isEmasculate());
        response.setType(product.getType());
        response.setAgeGroup(product.getAgeGroup());
        return response;
    }
}
