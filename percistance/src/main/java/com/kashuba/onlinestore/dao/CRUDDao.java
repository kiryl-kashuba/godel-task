package com.kashuba.onlinestore.dao;

import com.kashuba.onlinestore.entity.BaseEntity;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface CRUDDao<T extends BaseEntity> {

    Logger logger = LogManager.getLogger();

    T create(T object) throws Exception;

    List<T> delete(int id);

    List<T> find() throws Exception;

    default void autocommit(Connection connection, boolean type) {
        if (connection != null) {
            try {
                connection.setAutoCommit(type);
            } catch (SQLException e) {
                logger.log(Level.ERROR, "Error occurred while changing autocommit to " + type, e);
            }
        }
    }
}
