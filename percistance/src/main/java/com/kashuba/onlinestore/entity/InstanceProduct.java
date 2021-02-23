package com.kashuba.onlinestore.entity;

import java.util.Objects;

public class InstanceProduct extends BaseEntity {

    private String name;
    private String articulation;
    private int price;
    private Category category;
    private ProductAttributeValue productAttributeValue;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArticulation() {
        return articulation;
    }

    public void setArticulation(String articulation) {
        this.articulation = articulation;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public ProductAttributeValue getProductAttributeValue() {
        return productAttributeValue;
    }

    public void setProductAttributeValue(ProductAttributeValue productAttributeValue) {
        this.productAttributeValue = productAttributeValue;
    }

    @Override
    public String toString() {
        return "InstanceProduct{" +
                "name='" + name + '\'' +
                ", articulation='" + articulation + '\'' +
                ", price=" + price +
                ", category=" + category +
                ", productAttributeValue=" + productAttributeValue +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        InstanceProduct that = (InstanceProduct) o;
        return price == that.price &&
                Objects.equals(name, that.name) &&
                Objects.equals(articulation, that.articulation) &&
                Objects.equals(category, that.category) &&
                Objects.equals(productAttributeValue, that.productAttributeValue);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name, articulation, price, category, productAttributeValue);
    }
}
