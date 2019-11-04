package ua.com.lena.homefoodstore.web.dto.request;

import ua.com.lena.homefoodstore.entities.AgeGroup;
import ua.com.lena.homefoodstore.entities.Type;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

public class ProductRequest {
    @NotNull
    @Size(max = 40)
    private String name;
    @DecimalMin("0.0")
    private BigDecimal price;
    @NotNull
    private Boolean emasculate;
    @NotNull
    private Type type;
    @NotNull
    private AgeGroup ageGroup;
    @NotNull
    private Long categoryId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Boolean isEmasculate() {
        return emasculate;
    }

    public void setEmasculate(Boolean emasculate) {
        this.emasculate = emasculate;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public AgeGroup getAgeGroup() {
        return ageGroup;
    }

    public void setAgeGroup(AgeGroup ageGroup) {
        this.ageGroup = ageGroup;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }
}
