package com.kashuba.onlinestore.entity;

import java.util.Objects;

public class ProductAttributeValue extends BaseEntity{

    private String value;
    private String type;
    private ProductAttribute productAttribute;

    public ProductAttributeValue(String value, String type, ProductAttribute productAttribute, long id) {
        super(id);
        this.value = value;
        this.type = type;
        this.productAttribute = productAttribute;
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
    public String toString() {
        return "ProductAttributeValue{" +
                "value='" + value + '\'' +
                ", type='" + type + '\'' +
                ", productAttribute=" + productAttribute +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ProductAttributeValue that = (ProductAttributeValue) o;
        return Objects.equals(value, that.value) &&
                Objects.equals(type, that.type) &&
                Objects.equals(productAttribute, that.productAttribute);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), value, type, productAttribute);
    }

}
