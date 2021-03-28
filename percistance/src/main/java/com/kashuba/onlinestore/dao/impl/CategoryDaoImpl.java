package com.kashuba.onlinestore.dao.impl;

import com.kashuba.onlinestore.builder.CategoryBuilder;
import com.kashuba.onlinestore.dao.CategoryDao;
import com.kashuba.onlinestore.entity.Category;
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

public class CategoryDaoImpl extends AbstractCRUDDao<Category> implements CategoryDao {

    private static CategoryDaoImpl instance;
    private static final String ADD_CATEGORY = "INSERT INTO categories(name)VALUES (?)";
    private static final String REMOVE_CATEGORY = "DELETE FROM categories WHERE id = ?";
    private static final String FIND_ALL = "SELECT categories.id, categories.name, product_attributes.name, " +
            "product_attributes.mandatory, product_attributes.type, product_attributes.category_id, " +
            "product_attributes.id FROM categories LEFT OUTER JOIN " +
            "product_attributes ON categories.id = product_attributes.category_id";
    private static final String FIND_CATEGORY_BY_ID = FIND_ALL + " WHERE categories.id = ?";

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
            throw new RuntimeException(e);
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
            throw new RuntimeException("Error ", e);
            }
        return null;
    }

//
//    public Category findById(int id) throws Exception {
//        ConnectionPool connectionPool = ConnectionPool.getInstance();
//        Category category = null;
//
//        try (Connection connection = connectionPool.getConnection();
//             PreparedStatement statement = connection.prepareStatement(FIND_CATEGORY_BY_ID)) {
//            statement.setLong(1, id);
//            ResultSet resultSet = statement.executeQuery();
//            if (resultSet.next()) {
//                category = (createCategory(resultSet));
//            }
//
//        } catch (SQLException e) {
//            throw new Exception(e);
//        } catch (Exception exception) {
//            exception.printStackTrace();
//        }
//
//        return category;
//    }

    @Override
    public List<Category> findAll() {
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        List<Category> targetCategories = new ArrayList<>();
        List<Category> individualCategories = new ArrayList<>();

        try (Connection connection = connectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(FIND_ALL)) {

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                individualCategories.add(createCategory(resultSet));
            }
            Map<Long, List<Category>> categoriesById = new HashMap<>();
            for (Category category : individualCategories) {
                categoriesById.computeIfAbsent(category.getId(), k -> new ArrayList<>()).add(category);
            }
            for (List<Category> categories : categoriesById.values()) {
                List<ProductAttribute> productAttributes = new ArrayList<>();
                for (Category category : categories) {
                    productAttributes.addAll(category.getProductAttribute());
                }
                Category DbCategory = categories.get(0);
                DbCategory.setProductAttribute(productAttributes);
                targetCategories.add(DbCategory);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error ", e);
        }
        return targetCategories;
    }

    public Category findById(int id) {
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        Category DbCategory = null;

        try (Connection connection = connectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(FIND_CATEGORY_BY_ID)) {
            statement.setLong(1, id);

            List<Category> individualCategories = new ArrayList<>();
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                individualCategories.add(createCategory(resultSet));
            }

            Map<Long, List<Category>> categoriesById = new HashMap<>();
            for (Category category : individualCategories) {
                categoriesById.computeIfAbsent(category.getId(), k -> new ArrayList<>()).add(category);
            }
            for (List<Category> categories : categoriesById.values()) {
                List<ProductAttribute> productAttributes = new ArrayList<>();
                for (Category category : categories) {
                    productAttributes.addAll(category.getProductAttribute());
                }
                DbCategory = categories.get(0);
                DbCategory.setProductAttribute(productAttributes);
            }


//            List<Category> categories = categoriesById.values().stream()
//                    .map(values -> {
//                        List<ProductAttribute> productAttributes = values.stream()
//                                .flatMap(category -> category.getProductAttribute().stream())
//                                .collect(Collectors.toList());
//                        Category category = values.get(0);
//                        category.setProductAttribute(productAttributes);
//                        return category;
//                    })
//                    .collect(Collectors.toList());
//            //categories.get(0);


        } catch (SQLException e) {
            throw new RuntimeException("Error ", e);
        }
        return DbCategory;
    }


    private Category createCategory(ResultSet resultSet) throws SQLException {
        Map<String, Object> categoryParameters = new HashMap<>();
        categoryParameters.put("id", resultSet.getLong("id"));
        categoryParameters.put("name", resultSet.getString("name"));
        categoryParameters.put("product_attributes.name", resultSet.getString("product_attributes.name"));
        categoryParameters.put("product_attributes.mandatory", resultSet.getInt("product_attributes.mandatory"));
        categoryParameters.put("product_attributes.type", resultSet.getString("product_attributes.type"));
        categoryParameters.put("product_attributes.category_id", resultSet.getInt("product_attributes.category_id"));
        categoryParameters.put("product_attributes.id", resultSet.getInt("product_attributes.id"));

        // Сделать в билдере билдер для атрибута
        return CategoryBuilder.buildCategory(categoryParameters);
    }
}
