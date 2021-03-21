package com.kashuba.onlinestore.dao.impl;

import com.kashuba.onlinestore.dao.InstanceProductDao;
import com.kashuba.onlinestore.entity.InstanceProduct;
import com.kashuba.onlinestore.pool.ConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class InstanceProductDaoImpl extends AbstractCRUDDao<InstanceProduct> implements InstanceProductDao {

    private static InstanceProductDaoImpl instance;
    private static final String ADD_PRODUCT = "INSERT INTO instance_products(name, articulation, price, " +
            "category_id)VALUES (?, ?, ?, ?)";
    private static final String REMOVE_PRODUCT = "DELETE FROM carts WHERE id = ?";
    private static final String FIND_ALL = "SELECT id, email, password, role, first_name, second_name, " +
            "phone_number, status FROM clients";
    private static final String FIND_ALL_PRODUCT = FIND_ALL + "  WHERE id = ?";

    private InstanceProductDaoImpl() {
    }

    public static InstanceProductDaoImpl getInstance() {
        if (instance == null) {
            instance = new InstanceProductDaoImpl();
        }
        return instance;
    }

    @Override
    public InstanceProduct create(InstanceProduct instanceProduct) {
        ConnectionPool connectionPool = ConnectionPool.getInstance();

        try (Connection connection = connectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(ADD_PRODUCT)) {

            statement.setString(1, instanceProduct.getName());
            statement.setString(2, instanceProduct.getArticulation());
            statement.setInt(3, instanceProduct.getPrice());
            statement.setInt(4, (int) instanceProduct.getCategory().getId());

            statement.executeUpdate();
        } catch (SQLException e) {
            try {
                throw new Exception("Error when executing a query to add a category", e);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
        return instanceProduct;
    }

    @Override
    public List<InstanceProduct> find() {
        return null;
    }

    public List<InstanceProduct> update(int id, InstanceProduct instanceProduct) {

        return null;
    }

    @Override
    public List<InstanceProduct> delete(int idInstanceProduct) {
        return null;
    }
}
