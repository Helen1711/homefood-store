package ua.com.lena.homefoodstore.web.dto.response;

import ua.com.lena.homefoodstore.entities.AgeGroup;
import ua.com.lena.homefoodstore.entities.Type;

import java.math.BigDecimal;

public class ProductResponse {
    private long id;
    private String name;
    private BigDecimal price;
    private boolean emasculate;
    private Type type;
    private AgeGroup ageGroup;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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

    public boolean isEmasculate() {
        return emasculate;
    }

    public void setEmasculate(boolean emasculate) {
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
}
