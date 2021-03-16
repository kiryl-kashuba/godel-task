package com.kashuba.onlinestore.entity;

import java.util.Objects;

public class InstanceProductContainer extends BaseEntity {
    private InstanceProduct instanceProduct;
    private Integer count;

    public InstanceProductContainer(InstanceProduct instanceProduct, Integer count) {
        this.instanceProduct = instanceProduct;
        this.count = count;
    }

    public InstanceProductContainer() {
    }

    public InstanceProduct getInstanceProduct() {
        return instanceProduct;
    }

    public void setInstanceProduct(InstanceProduct instanceProduct) {
        this.instanceProduct = instanceProduct;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public void setСount(Integer count) {
        this.count = count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        InstanceProductContainer that = (InstanceProductContainer) o;
        return Objects.equals(instanceProduct, that.instanceProduct) &&
                Objects.equals(count, that.count);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), instanceProduct, count);
    }

    @Override
    public String toString() {
        return "InstanceProductContainer{" +
                "instanceProduct=" + instanceProduct +
                ", count=" + count +
                '}';
    }
}
