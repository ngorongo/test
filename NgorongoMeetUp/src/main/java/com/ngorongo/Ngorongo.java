/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.ngorongo;

import static com.ngorongo.NewJavaClass.getConnection;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Administrator
 */
public class Ngorongo {

    public static void main(String[] args) throws SQLException {
        String id = "1";
        selectData(id);
        createData();
        babashiku();
        DeleteExample();
        System.out.println(" WATOTO WANGU KAMA JAMAA : " + DatabaseConnection.getNgorongoKids());
    }

    public static String selectData(String id) {
        try {
            try (
                     Connection con = getConnection()) {
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("select * from users where id=" + id + "");
                while (rs.next()) {
                    System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3) + "  " + rs.getString(4));
                }
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return "";
    }

    public static String createData() {
        String resultData = "";
        Connection conn = null;
        Statement stmt = null;
        try {
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (Exception e) {
                System.out.println(e);
            }
            conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/ngorongo?useSSL=false", "root", "7974");
            System.out.println("Connection is created successfully:");
            stmt = (Statement) conn.createStatement();
            String query1 = "INSERT INTO users " + "VALUES (6, 'John', 34, 300,20)";
            stmt.executeUpdate(query1);
            query1 = "INSERT INTO users " + "VALUES (7, 'Carol', 42,340,21)";
            stmt.executeUpdate(query1);
            System.out.println("Record is inserted in the table successfully..................");
        } catch (SQLException excep) {
            excep.printStackTrace();
        } catch (Exception excep) {
            excep.printStackTrace();
        } finally {
            try {
                if (stmt != null) {
                    conn.close();
                }
            } catch (SQLException se) {
            }
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }

        }
        return resultData;
    }

    public static int babashiku() {
        int result = 0;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ngorongo?useSSL=false", "root", "7974");
            String sql = "update ngorongo.users  set password='ngrosh8888' where id=1;";
            Statement stmt = conn.createStatement();
            int rowsAffected = stmt.executeUpdate(sql);
            System.out.println(rowsAffected + " rows affected.");
            conn.close();
            System.out.println("Password is changed successfully!");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }

    public static String DeleteExample() throws SQLException {
        PreparedStatement pstmt = null;
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ngorongo?useSSL=false", "root", "7974");

            String sql = "DELETE FROM users WHERE id = ?";

            pstmt = conn.prepareStatement(sql);

            pstmt.setInt(1, 2);

            int rowsDeleted = pstmt.executeUpdate();

            System.out.println(rowsDeleted + " rows were deleted.");
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(Ngorongo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }
}
