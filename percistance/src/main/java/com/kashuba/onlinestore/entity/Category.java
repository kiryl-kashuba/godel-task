package com.kashuba.onlinestore.entity;

import java.util.List;
import java.util.Objects;

public class Category extends BaseEntity {

    private String name;
    private List<ProductAttribute> productAttribute;

    public Category(String name, List<ProductAttribute> productAttribute, long id) {
        super(id);
        this.name = name;
        this.productAttribute = productAttribute;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ProductAttribute> getProductAttribute() {
        return productAttribute;
    }

    public void setProductAttribute(List<ProductAttribute> productAttribute) {
        this.productAttribute = productAttribute;
    }

    @Override
    public String toString() {
        return "Category{" +
                "name='" + name + '\'' +
                ", productAttribute=" + productAttribute +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Category category = (Category) o;
        return Objects.equals(name, category.name) &&
                Objects.equals(productAttribute, category.productAttribute);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name, productAttribute);
    }
}
