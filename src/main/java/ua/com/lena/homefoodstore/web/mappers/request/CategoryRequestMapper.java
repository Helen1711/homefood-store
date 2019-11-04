package ua.com.lena.homefoodstore.web.mappers.request;

import ua.com.lena.homefoodstore.entities.Category;
import ua.com.lena.homefoodstore.web.dto.request.CategoryRequest;

public class CategoryRequestMapper {
    public static Category toEntity(Category category, CategoryRequest request){
        category.setName(request.getName());
        return category;
    }

    public static CategoryRequest toDto (Category category){
        CategoryRequest request = new CategoryRequest();
        request.setName(category.getName());
        return request;
    }
}
