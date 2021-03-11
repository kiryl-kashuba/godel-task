package com.kashuba.onlinestore.dao.impl;

import com.kashuba.onlinestore.dao.fileservice.FileInitialization;
import com.kashuba.onlinestore.entity.BaseEntity;

import java.util.List;

public abstract class CRUDDao<T extends BaseEntity> {

    public FileInitialization fileInitialization = FileInitialization.getInstance();

    public abstract List<T> create(T object);

    public abstract List<T> delete(int id);

    public abstract List<T> find();
}
