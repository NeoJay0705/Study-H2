package org.iisi.demo;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

public class EmbeddedConnect {
    public static void main(String[] args) {
        String db = "h2";
        String connectMode = "file";
        String dbPath = "./Data";
        String dbName = "test_1.0";
        String userName = "sa";
        String password = "";
        String otherParameters = "IFEXISTS=TRUE;AUTO_SERVER=TRUE;AUTO_SERVER_PORT=8001;";

        String jdbcURL = "jdbc:" + db + ":" + connectMode + ":" + dbPath + "/" + dbName + ";" + "USER=" + userName + ";PASSWORD=" + password + ";" + otherParameters;
        
        EmbeddedConnect.embeddedConnect(jdbcURL);
    }

    public static void embeddedConnect(String jdbcURL) {
        try {
            Connection connection = DriverManager.getConnection(jdbcURL);
            new java.util.Scanner(System.in).nextLine();
            connection.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage().toString());
        }
    }
}