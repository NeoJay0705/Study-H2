package org.iisi.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * NormalConnection
 */
public class NormalConnection {

    public static void main(String[] args) throws SQLException {
        String jdbcURL = "jdbc:h2:file:./Data/test_1.0;USER=sa;PASSWORD=";
        for(int i = 0; i < 900; i++) {
            Connection connection = DriverManager.getConnection(jdbcURL);
            connection.close();
        }
    }
}