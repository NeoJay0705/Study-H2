package org.iisi.demo;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

public class ServerConnect {

    public static void main(String[] args) {
        String db = "h2";
        String connectMode = "tcp://localhost:8001";
        String dbPath = "/";
        String dbName = "test_1.0";
        String userName = "sa";
        String password = "";
        String otherParameters = "IFEXISTS=TRUE;TRACE_LEVEL_FILE=2";

        String jdbcURL = "jdbc:" + db + ":" + connectMode + "" + dbPath + "/" + dbName + ";" + "USER=" + userName + ";PASSWORD=" + password + ";" + otherParameters;
        
        ServerConnect.serverConnect(jdbcURL);
    }

    public static void serverConnect(String jdbcURL) {
        try {
            Connection connection = DriverManager.getConnection(jdbcURL);
            new java.util.Scanner(System.in).nextLine();
            connection.createStatement().execute("SELECT * FROM CONNECTIONS");
            connection.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage().toString());
        }
    }
}