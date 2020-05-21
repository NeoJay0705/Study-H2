package org.iisi.demo;

import java.sql.SQLException;
import java.sql.Connection;
import org.h2.jdbcx.JdbcConnectionPool;

/**
 * PoolConnection
 */
public class PoolConnection {

    public static void main(String[] args) throws SQLException {
        String jdbcURL = "jdbc:h2:file:./data/test_1.0";
        JdbcConnectionPool connectionPool = JdbcConnectionPool.create(jdbcURL, "sa", "");
        for(int i = 0; i < 900; i++) {
            Connection connection = connectionPool.getConnection();
            connection.close();
        }
        connectionPool.dispose();
    }
}