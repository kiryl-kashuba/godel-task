package com.kashuba.onlinestore.service;

import com.kashuba.onlinestore.entity.Client;
import com.kashuba.onlinestore.entity.User;
import com.kashuba.onlinestore.exeption.ServiceProjectException;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface ClientService {

    boolean add(Map<String, String> clientParameters) throws ServiceProjectException;

    boolean updateClientStatus(Client updatingClient, String statusData) throws ServiceProjectException;

    List<Client> findClientsByStatus(String clientStatusData) throws ServiceProjectException;

    boolean authorizeUser(String email, String password) throws ServiceProjectException;

    boolean existUser(String email) throws ServiceProjectException;

}
