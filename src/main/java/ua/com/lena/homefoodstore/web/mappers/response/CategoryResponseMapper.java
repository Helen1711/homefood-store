package ua.com.lena.homefoodstore.web.mappers.response;

import ua.com.lena.homefoodstore.entities.Category;
import ua.com.lena.homefoodstore.web.dto.response.CategoryResponse;

public class CategoryResponseMapper {
    public static Category toEntity(CategoryResponse response){
        Category category = new Category();
        category.setId(response.getId());
        category.setName(response.getName());
        return category;
    }

    public static CategoryResponse toDto (Category category){
        CategoryResponse response = new CategoryResponse();
        response.setId(category.getId());
        response.setName(category.getName());
        return response;
    }
}
