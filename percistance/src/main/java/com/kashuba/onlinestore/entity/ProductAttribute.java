package com.kashuba.onlinestore.entity;

import java.util.Objects;

public class ProductAttribute extends BaseEntity {

    private String name;
    private boolean mandatory;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ProductAttribute that = (ProductAttribute) o;
        return mandatory == that.mandatory &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name, mandatory);
    }

    @Override
    public String toString() {
        return "ProductAttribute{" +
                "name='" + name + '\'' +
                ", mandatory=" + mandatory +
                '}';
    }
}
