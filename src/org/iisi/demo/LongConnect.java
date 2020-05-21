package org.iisi.demo;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

public class LongConnect {
    public static void main(String[] args) {
        String db = "h2";
        String connectMode = "file";
        String dbPath = "./Data";
        String dbName = "test_1.0";
        String userName = "sa";
        String password = "";
        String otherParameters = "";

        String jdbcURL = "jdbc:" + db + ":" + connectMode + ":" + dbPath + "/" + dbName + ";" + "USER=" + userName + ";PASSWORD=" + password + ";" + otherParameters;
        
        LongConnect.longConnection(jdbcURL);
    }

    public static void longConnection(String jdbcURL) {
        try {
            Connection connection = DriverManager.getConnection(jdbcURL);
            String createAlias = "CREATE ALIAS HELLOW FOR \"org.iisi.demo.Hellow.hellow\";";
            connection.createStatement().execute(createAlias);
            String dropAlias = "DROP ALIAS HELLOW;";
            connection.createStatement().execute(dropAlias);
            new java.util.Scanner(System.in).nextLine();
            connection.close();
        } catch (SQLException e) {
            System.out.println("Error:" + e.getMessage().toString());
        }
    }
}