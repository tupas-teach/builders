/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class dbConnector {

    public Connection connect;

    // Constructor to establish connection
    public dbConnector() {
        try {
            connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/tupas.residentcial", "root", "");
            System.out.println("Database connected successfully.");
        } catch (SQLException ex) {
            System.out.println("Can't connect to database: " + ex.getMessage());
        }
    }

    // Getter to expose the connection
    public Connection getConnection() {
        return connect;
    }

    // Function to retrieve data
    public ResultSet getData(String sql) throws SQLException {
        Statement stmt = connect.createStatement();
        return stmt.executeQuery(sql);
    }

    // Function to insert data (using raw SQL — not recommended for dynamic data)
    public int insertData(String sql) {
        try (PreparedStatement pst = connect.prepareStatement(sql)) {
            pst.executeUpdate();
            System.out.println("Inserted successfully!");
            return 1;
        } catch (SQLException ex) {
            System.out.println("Insert Error: " + ex.getMessage());
            return 0;
        }
    }

    // Function to update data (using raw SQL)
    public void updateData(String sql) {
        try (PreparedStatement pst = connect.prepareStatement(sql)) {
            int rowsUpdated = pst.executeUpdate();
            if (rowsUpdated > 0) {
                JOptionPane.showMessageDialog(null, "Data updated successfully!");
            } else {
                System.out.println("No rows were updated.");
            }
        } catch (SQLException ex) {
            System.out.println("Update Error: " + ex.getMessage());
        }
    }

    // Function to delete data
    public void deleteData(String query) {
        try (PreparedStatement pst = connect.prepareStatement(query)) {
            int rowsDeleted = pst.executeUpdate();
            if (rowsDeleted > 0) {
                JOptionPane.showMessageDialog(null, "Record deleted successfully!");
            } else {
                JOptionPane.showMessageDialog(null, "No record was deleted. Please check the ID.");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error deleting record: " + ex.getMessage());
        }
    }
}
