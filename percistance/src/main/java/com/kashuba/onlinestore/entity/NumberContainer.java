package com.kashuba.onlinestore.entity;

import java.util.Objects;

public class NumberContainer extends BaseEntity {
    private InstanceProduct instanceProduct;
    private Integer number;

    public NumberContainer(InstanceProduct instanceProduct, Integer number) {
        this.instanceProduct = instanceProduct;
        this.number = number;
    }

    public InstanceProduct getInstanceProduct() {
        return instanceProduct;
    }

    public void setInstanceProduct(InstanceProduct instanceProduct) {
        this.instanceProduct = instanceProduct;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        NumberContainer that = (NumberContainer) o;
        return Objects.equals(instanceProduct, that.instanceProduct) &&
                Objects.equals(number, that.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), instanceProduct, number);
    }

    @Override
    public String toString() {
        return "NumberContainer{" +
                "instanceProduct=" + instanceProduct +
                ", number=" + number +
                '}';
    }
}
