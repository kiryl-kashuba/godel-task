package com.kashuba.onlinestore.pool;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayDeque;
import java.util.ResourceBundle;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ConnectionPool {
    private static final Logger logger = LogManager.getLogger();
    private static final String PROPERTIES_FILENAME = "config/database";
    private static final String DRIVER_NAME = "db.driver";
    private static final String URL = "db.url";
    private static final String LOGIN = "db.login";
    private static final String PASSWORD = "db.password";
    private static final int POOL_SIZE = 8;
    private static com.kashuba.onlinestore.pool.ConnectionPool connectionPool = new com.kashuba.onlinestore.pool.ConnectionPool();
    private ResourceBundle bundle;
    private BlockingQueue<ProxyConnection> freeConnections;
    private ArrayDeque<ProxyConnection> givenConnections;

    public static com.kashuba.onlinestore.pool.ConnectionPool getInstance() {
        return connectionPool;
    }

    private ConnectionPool() {
        try {
            bundle = ResourceBundle.getBundle(PROPERTIES_FILENAME);
            Class.forName(bundle.getString(DRIVER_NAME));
            freeConnections = new LinkedBlockingQueue<>(POOL_SIZE);
            givenConnections = new ArrayDeque<>(POOL_SIZE);

            for (int i = 0; i < POOL_SIZE; i++) {
                Connection connection = DriverManager.getConnection(bundle.getString(URL),
                        bundle.getString(LOGIN), bundle.getString(PASSWORD));
                freeConnections.offer(new ProxyConnection(connection));
            }
        } catch (ClassNotFoundException | SQLException e) {
            logger.log(Level.FATAL, "Error during connection pool creating", e);
            throw new RuntimeException("Error during connect to database", e);
        }
    }

    public Connection getConnection() {
        ProxyConnection connection = null;

        try {
            connection = freeConnections.take();
            if (connection != null) {
                givenConnections.offer(connection);
            }
        } catch (InterruptedException e) {
            logger.log(Level.ERROR, "Error in connection pool, pool can't provide connection", e);
        }

        return connection;
    }

    public void releaseConnection(Connection connection) {
        if (connection instanceof ProxyConnection) {
            if (givenConnections.remove(connection)) {
                freeConnections.offer((ProxyConnection) connection);
            }
        } else {
            logger.log(Level.ERROR, "Invalid connection to realising " + connection.getClass().getSimpleName());
        }
    }

    public void destroyPool() {
        try {
            for (int i = 0; i < POOL_SIZE; i++) {
                freeConnections.take().reallyClose();
            }
            deregisterDrivers();
        } catch (SQLException | InterruptedException e) {
            logger.log(Level.ERROR, "Error during application destroy pool", e);
        }
    }

    private void deregisterDrivers() throws SQLException {
        while (DriverManager.getDrivers().hasMoreElements()) {
            DriverManager.deregisterDriver(DriverManager.getDrivers().nextElement());
        }
    }
}
