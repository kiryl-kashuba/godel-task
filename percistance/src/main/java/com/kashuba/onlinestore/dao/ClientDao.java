package com.kashuba.onlinestore.dao;

import com.kashuba.onlinestore.entity.Client;

import java.util.List;

public interface ClientDao {

    List<Client> create(Client client);

    List<Client> delete(int id);

    List<Client> find();

}
