package com.kashuba.onlinestore.dao;

import com.kashuba.onlinestore.entity.BaseEntity;

import java.util.List;

public interface CRUDDao<T extends BaseEntity> {

    T create(T object);

    List<T> delete(int id);

    List<T> find();
}
