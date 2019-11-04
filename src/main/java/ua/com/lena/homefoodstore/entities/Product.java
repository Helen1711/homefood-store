package ua.com.lena.homefoodstore.entities;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "product")
public class Product extends AbstractEntity {
    @Column(unique = true)
    private String name;
    private BigDecimal price;
    private boolean emasculate;
    @Enumerated(EnumType.STRING)
    private Type type;
    @Enumerated(EnumType.STRING)
    private AgeGroup ageGroup;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    public Product() {
    }

    public Product(String name, BigDecimal price, boolean emasculate, Type type, AgeGroup ageGroup, Category category) {
        this.name = name;
        this.price = price;
        this.emasculate = emasculate;
        this.type = type;
        this.ageGroup = ageGroup;
        this.category = category;
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

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public boolean isEmasculate() {
        return emasculate;
    }

    public void setEmasculate(boolean emasculate) {
        this.emasculate = emasculate;
    }

    public AgeGroup getAgeGroup() {
        return ageGroup;
    }

    public void setAgeGroup(AgeGroup ageGroup) {
        this.ageGroup = ageGroup;
    }

}
