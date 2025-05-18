/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjectReports;

import Clientform.clientproject;
import admin.adminform;
import admin.createadmin;
import admin.createproject;
import admin.individualPrinting;
import config.Session;
import config.dbConnector;
import java.awt.Color;
import static java.awt.Color.gray;
import static java.awt.Color.red;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;
import net.proteanit.sql.DbUtils;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.sql.PreparedStatement;


/**
 *
 * @author davetupas
 */
public class projectReports extends javax.swing.JFrame {

    public projectReports() {
        initComponents();
        displayData();
    }
    boolean checkadd = true;
      Color  navcolor = new Color(102,0,102);
    Color headcolor = new Color(102,102,255);
    Color bodycolor = new Color(153,153,255);
     public void displayData(){
        try{
            dbConnector dbc = new dbConnector();
            ResultSet rs = dbc.getData("SELECT p_id,u_fn, p_name, u_type, p_date, p_updatedate, p_location, p_status,approval FROM tbl_projects");
            table_project.setModel(DbUtils.resultSetToTableModel(rs));
            table_project.getColumnModel().getColumn(0).setHeaderValue("P ID");
            table_project.getColumnModel().getColumn(1).setHeaderValue("Maker Name");
            table_project.getColumnModel().getColumn(2).setHeaderValue("Project Name");
            table_project.getColumnModel().getColumn(3).setHeaderValue("Client Name");
            table_project.getColumnModel().getColumn(4).setHeaderValue("Start Date");
            table_project.getColumnModel().getColumn(5).setHeaderValue("Due Date");
            table_project.getColumnModel().getColumn(6).setHeaderValue("Location");
            table_project.getColumnModel().getColumn(7).setHeaderValue("Status");
             table_project.getColumnModel().getColumn(8).setHeaderValue("Approval");
            
        }catch(SQLException ex){
                    System.out.println("Errors:"+ex.getMessage());
      
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        table_product = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        table_project = new javax.swing.JTable();
        clear = new javax.swing.JButton();
        add = new javax.swing.JButton();
        update = new javax.swing.JButton();
        clear1 = new javax.swing.JButton();
        aproved = new javax.swing.JButton();
        decline = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        table_product.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        table_product.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_productMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table_product);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(51, 255, 0));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/attachment_63634065.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 525, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(0, 100, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-1, 0, 500, 600));

        jPanel2.setBackground(new java.awt.Color(153, 153, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/supervisor.png"))); // NOI18N
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 54, -1, -1));

        table_project.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane3.setViewportView(table_project);

        jPanel2.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 70, 510, -1));

        clear.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        clear.setText("CLIENT");
        clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearActionPerformed(evt);
            }
        });
        jPanel2.add(clear, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 420, 130, 40));

        add.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        add.setText("ADD");
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });
        jPanel2.add(add, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 250, 130, 40));

        update.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        update.setText("UPDATE");
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });
        jPanel2.add(update, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 310, 130, 40));

        clear1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        clear1.setText("CLEAR");
        jPanel2.add(clear1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 370, 130, 40));

        aproved.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        aproved.setText("APROVED");
        aproved.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aprovedActionPerformed(evt);
            }
        });
        jPanel2.add(aproved, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 20, 130, 40));

        decline.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        decline.setText("DECLINE");
        decline.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                declineActionPerformed(evt);
            }
        });
        jPanel2.add(decline, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 20, 130, 40));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/back (1).png"))); // NOI18N
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 10, -1, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 0, 750, 600));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void table_productMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_productMouseClicked
       
    }//GEN-LAST:event_table_productMouseClicked

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
      
    }//GEN-LAST:event_formWindowActivated

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_updateActionPerformed

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
        createproject cp = new createproject();
        cp.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_addActionPerformed

    private void clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearActionPerformed
     clientproject cp = new clientproject();
     cp.setVisible(true);
     this.dispose();
    }//GEN-LAST:event_clearActionPerformed

    private void aprovedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aprovedActionPerformed
        int selectedRow = table_project.getSelectedRow();

    if (selectedRow == -1) {
        JOptionPane.showMessageDialog(null, "Please select a project to aproval.");
        return;
    }

    int taskId = (int) table_project.getValueAt(selectedRow, 0);

    // Get the current logged-in user's name from session
    Session sess = Session.getInstance();
    String currentUserFname = sess.getFn();  // Get user from session

    dbConnector dbc = new dbConnector();

    // Step 1: Check if the task is already accepted
    String checkQuery = "SELECT approval FROM tbl_projects WHERE p_id = ?";
    try (PreparedStatement checkPst = dbc.connect.prepareStatement(checkQuery)) {
        checkPst.setInt(1, taskId);
        ResultSet rs = checkPst.executeQuery();

        if (rs.next()) {
            String acceptStatus = rs.getString("approval");
            if ("Approval".equalsIgnoreCase(acceptStatus)) {
                JOptionPane.showMessageDialog(null, "This project has already been accepted.");
                return;
            }
        }
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Database error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Step 2: Accept the task and assign the user
    String updateQuery = "UPDATE tbl_projects SET approval = 'Approval', u_fn = ? WHERE p_id = ?";
    try (PreparedStatement pst = dbc.connect.prepareStatement(updateQuery)) {
        pst.setString(1, currentUserFname);
        pst.setInt(2, taskId);
        int rowsAffected = pst.executeUpdate();

        if (rowsAffected > 0) {
            aproved.setText("Approval");
            aproved.setEnabled(false);
            JOptionPane.showMessageDialog(null, "Project accepted successfully!");
        } else {
            JOptionPane.showMessageDialog(null, "Error accepting Project.");
        }
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Database error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    } finally {
        displayData();
        try {
            if (dbc.connect != null && !dbc.connect.isClosed()) {
                dbc.connect.close();
            }
        } catch (SQLException e) { 
            System.out.println("Error closing connection: " + e.getMessage());
        }
    }
    }//GEN-LAST:event_aprovedActionPerformed

    private void declineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_declineActionPerformed
        int selectedRow = table_project.getSelectedRow();
    
    if (selectedRow == -1) {
        // No row selected, show an error message
        JOptionPane.showMessageDialog(null, "Please select a task to decline.");
        return;
    }

    // Get the task ID from the selected row (assuming the task ID is in the first column)
    int taskId = (int) table_project.getValueAt(selectedRow, 0);
    
    // Step 1: Check if the selected task is already accepted
    String checkQuery = "SELECT decline FROM tbl_projects WHERE p_id = ?";
    dbConnector dbc = new dbConnector();
    
    try (PreparedStatement checkPst = dbc.connect.prepareStatement(checkQuery)) {
        checkPst.setInt(1, taskId);
        ResultSet rs = checkPst.executeQuery();

        if (rs.next()) {
            // If the task is already accepted, show an error message
            String acceptStatus = rs.getString("decline");
            if ("Yes".equals(acceptStatus)) {
                JOptionPane.showMessageDialog(null, "This task has already been accepted and cannot be declined.");
                return;
            }
        }
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Database error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }    
     // Step 2: Update the accept column to "No" for the selected task (decline it)
    String updateQuery = "UPDATE tbl_projects SET approval = 'decline' WHERE p_id = ?";
    
    try (PreparedStatement pst = dbc.connect.prepareStatement(updateQuery)) {
        pst.setInt(1, taskId);
        int rowsAffected = pst.executeUpdate();

        if (rowsAffected > 0) {
            // If update is successful, change the button text and disable it
            decline.setText("Decline");
            decline.setEnabled(false);  // Disable the button to prevent multiple decline actions
            JOptionPane.showMessageDialog(null, "Task declined successfully!");
        } else {
            JOptionPane.showMessageDialog(null, "Error declining task.");
        }
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Database error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    } finally {
        // Optionally, you can reload the table data after declining a task
        displayData();
        
        // Close the database connection
        try {
            if (dbc.connect != null && !dbc.connect.isClosed()) {
                dbc.connect.close();
            }
        } catch (SQLException e) {
            System.out.println("Error closing connection: " + e.getMessage());
        }
    }

    }//GEN-LAST:event_declineActionPerformed

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
       adminform a = new adminform();
       a.setVisible(true);
       this.dispose();
    }//GEN-LAST:event_jLabel4MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(projectReports.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(projectReports.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(projectReports.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(projectReports.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new projectReports().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add;
    private javax.swing.JButton aproved;
    private javax.swing.JButton clear;
    private javax.swing.JButton clear1;
    private javax.swing.JButton decline;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable table_product;
    public javax.swing.JTable table_project;
    private javax.swing.JButton update;
    // End of variables declaration//GEN-END:variables
}
