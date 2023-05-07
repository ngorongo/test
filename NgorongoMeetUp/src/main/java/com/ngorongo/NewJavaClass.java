package com.ngorongo;

import java.sql.*;

/**
 *
 * @author Administrator
 */
public class NewJavaClass {

    public static Connection getConnection() {
        Connection conn = null;
        try {
            String url = "jdbc:mysql://localhost:3306/ngorongo?useSSL=false";
            String user = "root";
            String password = "7974";
            conn = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            System.out.println(e);
        }
        return conn;
    }
}
