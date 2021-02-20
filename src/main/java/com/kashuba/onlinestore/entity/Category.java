package com.kashuba.onlinestore.entity;

import java.util.List;
import java.util.Objects;

public class Category {
    private long id;
    private String name;
    private List<ProductAttribute> productAttribute;

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

    public List<ProductAttribute> getProductAttribute() {
        return productAttribute;
    }

    public void setProductAttribute(List<ProductAttribute> productAttribute) {
        this.productAttribute = productAttribute;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return id == category.id &&
                Objects.equals(name, category.name) &&
                Objects.equals(productAttribute, category.productAttribute);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, productAttribute);
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", productAttribute=" + productAttribute +
                '}';
    }
}
