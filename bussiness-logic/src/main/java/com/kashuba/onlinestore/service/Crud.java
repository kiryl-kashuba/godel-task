package com.kashuba.onlinestore.service;

import java.util.List;
import java.util.Optional;

public interface Crud<T> {

    T create(T t);

    void deleteById(Long id);

    List<T> findAll();

    Optional<T> findById(Long id);
}
