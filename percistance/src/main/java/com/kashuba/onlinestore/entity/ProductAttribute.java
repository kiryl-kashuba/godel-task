package com.kashuba.onlinestore.entity;

import java.util.Objects;

public class ProductAttribute extends BaseEntity {

    private String name;
    private boolean mandatory;
    private String type;


    public String getType() { return type; }

    public void setType(String type) { this.type = type; }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isMandatory() {
        return mandatory;
    }

    public void setMandatory(boolean mandatory) {
        this.mandatory = mandatory;
    }

    public ProductAttribute(String name, boolean mandatory, String type) {
        this.name = name;
        this.mandatory = mandatory;
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ProductAttribute that = (ProductAttribute) o;
        return mandatory == that.mandatory &&
                Objects.equals(name, that.name) &&
                Objects.equals(type, that.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name, mandatory, type);
    }

    @Override
    public String toString() {
        return "ProductAttribute{" +
                "Id='" + super.getId() + '\'' +
                "name='" + name + '\'' +
                ", mandatory=" + mandatory +
                ", type='" + type + '\'' +
                '}';
    }
}
