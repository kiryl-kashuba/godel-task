package com.kashuba.onlinestore.dao.impl;

import com.kashuba.onlinestore.dao.fileservice.FileInitialization;
import com.kashuba.onlinestore.entity.BaseEntity;

import java.util.List;

public abstract class FileInitializationHolder {

    public FileInitialization fileInitialization = FileInitialization.getInstance();

    public abstract List<?> create(BaseEntity baseEntity);

    public abstract List<?> delete(int id);

    public abstract List<?> find();
}
