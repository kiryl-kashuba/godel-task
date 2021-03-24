package com.kashuba.onlinestore.dao.impl;

import com.kashuba.onlinestore.builder.PABuilder;
import com.kashuba.onlinestore.dao.ProductAttributeDao;
import com.kashuba.onlinestore.entity.ProductAttribute;
import com.kashuba.onlinestore.pool.ConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductAttributeDaoImpl extends AbstractCRUDDao<ProductAttribute> implements ProductAttributeDao {

    private static ProductAttributeDaoImpl instance;
    private static final String ADD_PA = "INSERT INTO product_attributes (name, mandatory, category_id," +
            " type)VALUES (?, ?, ?, ?)";
    private static final String REMOVE_PA = "DELETE FROM carts WHERE id = ?";
    private static final String FIND_ALL = "SELECT id, email, password, role, first_name, second_name, " +
            "phone_number, status FROM clients";
    private static final String FIND_PA_BY_ID = FIND_ALL + " WHERE role = ?";

    private ProductAttributeDaoImpl() {
    }

    public static ProductAttributeDaoImpl getInstance() {
        if (instance == null) {
            instance = new ProductAttributeDaoImpl();
        }
        return instance;
    }

    @Override
    public ProductAttribute create(ProductAttribute productAttribute) {
        ConnectionPool connectionPool = ConnectionPool.getInstance();

        try (Connection connection = connectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(ADD_PA)) {
            int bool = 0;
            if (productAttribute.isMandatory()) {
                bool = 1;
            }
            statement.setString(1, productAttribute.getName());
            statement.setInt(2, bool);
            statement.setInt(3, (int) productAttribute.getCategory().getId());
            statement.setString(4, productAttribute.getType());

            statement.executeUpdate();
        } catch (SQLException e) {
            try {
                throw new Exception("Error when executing a query to add a category", e);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
        return productAttribute;
    }

    @Override
    public List<ProductAttribute> delete(int id) {
        ConnectionPool connectionPool = ConnectionPool.getInstance();

        try (Connection connection = connectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(REMOVE_PA)) {
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
    public List<ProductAttribute> findAll() {
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        List<ProductAttribute> targetCategories = new ArrayList<>();

        try (Connection connection = connectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(FIND_ALL)) {

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                targetCategories.add(createPA(resultSet));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error ", e);
        }

        return targetCategories;
    }

    private ProductAttribute createPA(ResultSet resultSet) throws SQLException {
        Map<String, Object> paParameters = new HashMap<>();
        paParameters.put("id", resultSet.getLong("id"));
        paParameters.put("name", resultSet.getString("name"));
        paParameters.put("name", resultSet.getString("name"));
        paParameters.put("name", resultSet.getString("name"));

        return PABuilder.buildPA(paParameters);
    }
}
