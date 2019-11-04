package ua.com.lena.homefoodstore.web.dto.request;

import javax.validation.constraints.Size;

public class CategoryRequest {
    @Size(min = 3, max = 20)
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
