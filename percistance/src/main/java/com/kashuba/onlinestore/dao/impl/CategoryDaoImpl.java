package com.kashuba.onlinestore.dao.impl;

import com.kashuba.onlinestore.builder.ClientBuilder;
import com.kashuba.onlinestore.dao.CategoryDao;
import com.kashuba.onlinestore.entity.Category;
import com.kashuba.onlinestore.entity.Client;
import com.kashuba.onlinestore.pool.ConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CategoryDaoImpl extends AbstractCRUDDao<Category> implements CategoryDao {

    private static CategoryDaoImpl instance;
    private static final String ADD_CATEGORY = "INSERT INTO categories(name)VALUES (?)";
    private static final String REMOVE_CATEGORY = "DELETE FROM categories WHERE id = ?";
    private static final String FIND_ALL = "SELECT name FROM categories";
    private static final String FIND_ALL_CATEGORIES = FIND_ALL + " WHERE role = 1";

    private CategoryDaoImpl() {
    }

    public static CategoryDaoImpl getInstance() {
        if (instance == null) {
            instance = new CategoryDaoImpl();
        }
        return instance;
    }

    @Override
    public Category create(Category category) {
        ConnectionPool connectionPool = ConnectionPool.getInstance();

        try (Connection connection = connectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(ADD_CATEGORY)) {
            statement.setString(1, category.getName());

            statement.executeUpdate();
        } catch (SQLException e) {
            try {
                throw new Exception("Error when executing a query to add a client", e);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
        return category;
    }

    @Override
    public List<Category> delete(int id) {
        return null;
    }

    @Override
    public List<Category> find() throws Exception {
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        List<Client> targetClients = new ArrayList<>();

        try (Connection connection = connectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(FIND_ALL_CLIENTS)) {

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                targetClients.add((Client) createClient(resultSet));
            }

        } catch (SQLException e) {
            throw new Exception(e);
        } catch (Exception exception) {
            exception.printStackTrace();
        }

        return null;
    }

    private Client createCategory(ResultSet resultSet) throws SQLException {
        Map<String, Object> userParameters = new HashMap<>();
        userParameters.put("id", resultSet.getLong("id"));
        userParameters.put("name", resultSet.getString("name"));

        return ClientBuilder.buildClient(userParameters);
    }

}
