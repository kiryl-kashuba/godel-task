package com.kashuba.onlinestore.entity;

import java.util.Objects;

public class ProductAttributeValue {

    private long id;
    private String value;
    private String type;
    private ProductAttribute productAttribute;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public ProductAttribute getProductAttribute() {
        return productAttribute;
    }

    public void setProductAttribute(ProductAttribute productAttribute) {
        this.productAttribute = productAttribute;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductAttributeValue that = (ProductAttributeValue) o;
        return id == that.id &&
                Objects.equals(value, that.value) &&
                Objects.equals(type, that.type) &&
                Objects.equals(productAttribute, that.productAttribute);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, value, type, productAttribute);
    }

    @Override
    public String toString() {
        return "ProductAttributeValue{" +
                "id=" + id +
                ", value='" + value + '\'' +
                ", type='" + type + '\'' +
                ", productAttribute=" + productAttribute +
                '}';
    }
}
