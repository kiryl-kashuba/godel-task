package com.kashuba.simplewebapp.service;

import java.util.List;

public interface Crud<T> {

    int create(T t);

    int update(T t);

    void delete(Long id);

    List<T> findAll();

    T find(Long id);
}
