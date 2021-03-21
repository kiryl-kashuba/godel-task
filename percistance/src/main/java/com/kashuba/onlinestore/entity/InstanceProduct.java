package com.kashuba.onlinestore.entity;

import java.util.List;
import java.util.Objects;

public class InstanceProduct extends BaseEntity {

    private String name;
    private String articulation;
    private int price;
    private Category category;
    private int number;
    private List<ProductAttributeValue> productAttributeValue;
    private Cart cart;


    public InstanceProduct(long id, String name, String articulation, int price, Category category, List<ProductAttributeValue> productAttributeValue) {
        super(id);
        this.name = name;
        this.articulation = articulation;
        this.price = price;
        this.category = category;
        this.productAttributeValue = productAttributeValue;
    }

    public InstanceProduct(String name, String articulation, int price) {
        this.name = name;
        this.articulation = articulation;
        this.price = price;
    }

    public InstanceProduct() {
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

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

    public List<ProductAttributeValue> getProductAttributeValue() {
        return productAttributeValue;
    }

    public void setProductAttributeValue(List<ProductAttributeValue> productAttributeValue) {
        this.productAttributeValue = productAttributeValue;
    }

    @Override
    public String toString() {
        return "InstanceProduct{" +
                "Id='" + super.getId() + '\'' +
                "name='" + name + '\'' +
                ", articulation='" + articulation + '\'' +
                ", price=" + price +
                ", category=" + category +
                ", number=" + number +
                ", productAttributeValue=" + productAttributeValue +
                ", cart=" + cart +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        InstanceProduct that = (InstanceProduct) o;
        return price == that.price &&
                number == that.number &&
                Objects.equals(name, that.name) &&
                Objects.equals(articulation, that.articulation) &&
                Objects.equals(category, that.category) &&
                Objects.equals(productAttributeValue, that.productAttributeValue) &&
                Objects.equals(cart, that.cart);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name, articulation, price, category, number, productAttributeValue, cart);
    }
}
