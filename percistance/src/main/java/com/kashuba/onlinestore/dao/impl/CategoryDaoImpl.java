package com.kashuba.onlinestore.dao.impl;

import com.kashuba.onlinestore.builder.CategoryBuilder;
import com.kashuba.onlinestore.dao.CategoryDao;
import com.kashuba.onlinestore.entity.Category;
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
    private static final String FIND_ALL = "SELECT id, name FROM categories";
    private static final String FIND_CATEGORY_BY_ID = FIND_ALL + " WHERE id = ?";

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
                throw new Exception("Error when executing a query to add a category", e);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
        return category;
    }

    @Override
    public List<Category> delete(int id) {
        ConnectionPool connectionPool = ConnectionPool.getInstance();

        try (Connection connection = connectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(REMOVE_CATEGORY)) {
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


    public Category findById(int id) throws Exception {
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        Category category = null;

        try (Connection connection = connectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(FIND_CATEGORY_BY_ID)) {
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                category = (createCategory(resultSet));
            }

        } catch (SQLException e) {
            throw new Exception(e);
        } catch (Exception exception) {
            exception.printStackTrace();
        }

        return category;
    }

    @Override
    public List<Category> find() throws Exception {
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        List<Category> targetCategories = new ArrayList<>();

        try (Connection connection = connectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(FIND_ALL)) {

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                targetCategories.add(createCategory(resultSet));
            }

        } catch (SQLException e) {
            throw new Exception(e);
        } catch (Exception exception) {
            exception.printStackTrace();
        }

        return targetCategories;
    }


    private Category createCategory(ResultSet resultSet) throws SQLException {
        Map<String, Object> categoryParameters = new HashMap<>();
        categoryParameters.put("id", resultSet.getLong("id"));
        categoryParameters.put("name", resultSet.getString("name"));

        return CategoryBuilder.buildCategory(categoryParameters);
    }
}
