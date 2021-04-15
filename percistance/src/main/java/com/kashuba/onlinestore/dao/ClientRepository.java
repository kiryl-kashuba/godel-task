package com.kashuba.onlinestore.dao;

import com.kashuba.onlinestore.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
    Client findByEmail(String email);
}