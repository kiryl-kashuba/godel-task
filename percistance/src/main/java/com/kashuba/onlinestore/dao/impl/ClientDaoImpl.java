package com.kashuba.onlinestore.dao.impl;

import com.kashuba.onlinestore.builder.ClientBuilder;
import com.kashuba.onlinestore.dao.ClientDao;
import com.kashuba.onlinestore.entity.Client;
import com.kashuba.onlinestore.entity.User;
import com.kashuba.onlinestore.pool.ConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClientDaoImpl extends AbstractCRUDDao<Client> implements ClientDao {

    private static ClientDaoImpl instance;
    private static final String ADD_CLIENT = "INSERT INTO clients(email, password, role, first_name, " +
            "second_name, phone_number, status)VALUES (?, ?, ?, ?, ?, ?, ?)";
    private static final String ADD_CART = "INSERT INTO carts(id) VALUES (LAST_INSERT_ID())";
    private static final String REMOVE_CLIENT = "DELETE FROM clients WHERE id = ?";
    private static final String FIND_ALL = "SELECT id, email, password, role, first_name, second_name, " +
            "phone_number, status FROM clients";
    private static final String FIND_ALL_CLIENTS = FIND_ALL + " WHERE role = 1";


    private ClientDaoImpl() {
    }

    public static ClientDaoImpl getInstance() {
        if (instance == null) {
            instance = new ClientDaoImpl();
        }
        return instance;
    }

    @Override
    public Client create(Client client) {
        ConnectionPool connectionPool = ConnectionPool.getInstance();

        try (Connection connection = connectionPool.getConnection();
             PreparedStatement clientStatement = connection.prepareStatement(ADD_CLIENT);
             PreparedStatement cartStatement = connection.prepareStatement(ADD_CART)) {
            clientStatement.setString(1, client.getEmail());
            clientStatement.setString(2, client.getPassword());
            clientStatement.setInt(3, client.getRole().ordinal());
            clientStatement.setString(4, client.getFirstName());
            clientStatement.setString(5, client.getSecondName());
            clientStatement.setLong(6, client.getPhoneNumber());
            clientStatement.setInt(7, client.getStatus().ordinal());

            clientStatement.executeUpdate();
            cartStatement.executeUpdate();
        } catch (SQLException e) {
            try {
                throw new Exception("Error when executing a query to add a client", e);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
        return client;
    }

    @Override
    public List<Client> delete(int id) {
        ConnectionPool connectionPool = ConnectionPool.getInstance();

        try (Connection connection = connectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(REMOVE_CLIENT)) {
            statement.setLong(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            try {
                throw new Exception("Error ", e);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }

        return null;
    }

    @Override
    public List<Client> find() throws Exception {
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        List<Client> targetClients = new ArrayList<>();

        try (Connection connection = connectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(FIND_ALL_CLIENTS)) {

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                targetClients.add(createClient(resultSet));
            }

        } catch (SQLException e) {
            throw new Exception(e);
        } catch (Exception exception) {
            exception.printStackTrace();
        }


        return targetClients;
    }

    private Client createClient(ResultSet resultSet) throws SQLException {
        Map<String, Object> userParameters = new HashMap<>();
        userParameters.put("id", resultSet.getLong("id"));
        userParameters.put("email", resultSet.getString("email"));
        userParameters.put("role", User.Role.getUserRole(resultSet.getInt("role")));
        userParameters.put("first_name", resultSet.getString("first_name"));
        userParameters.put("second_name", resultSet.getString("second_name"));
        userParameters.put("phone_number", resultSet.getLong("phone_number"));
        userParameters.put("status", Client.Status.getClientStatus(resultSet.getInt("status")));

        return ClientBuilder.buildClient(userParameters);
    }

}
