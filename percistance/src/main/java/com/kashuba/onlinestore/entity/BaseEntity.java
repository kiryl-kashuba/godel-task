package com.kashuba.onlinestore.entity;

import com.opencsv.bean.CsvBindByPosition;

import java.io.Serializable;
import java.util.Objects;

public abstract class BaseEntity implements Serializable {

    private long id;

    public BaseEntity(long id) {
        this.id = id;
    }

    public BaseEntity() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaseEntity that = (BaseEntity) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "BaseEntity{" +
                "id=" + id +
                '}';
    }
}
