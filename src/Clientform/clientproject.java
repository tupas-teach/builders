/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clientform;

import LoginForm.loginform;
import ProjectReports.individualPrintings;
import ProjectReports.projectReports;
import admin.createproject;
import config.Session;
import config.dbConnector;
import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author davetupas
 */
public class clientproject extends javax.swing.JFrame {
 
    
    public clientproject() {
        initComponents();
        displayData(null);
    }
public String destination ="";
    File selectedFile;
    public String oldpath;
    public String path;

    Color  navcolor = new Color(102,0,102);
    Color headcolor = new Color(102,102,255);
    Color bodycolor = new Color(153,153,255);
      
    public void displayData(String filterStatus) {
        try {
            dbConnector dbc = new dbConnector();
            ResultSet rs;

            if (filterStatus != null && !filterStatus.isEmpty()) {
                rs = dbc.getData("SELECT c_id, u_id, p_name, c_status, worker_assign, accept, approval FROM tbl_client WHERE approval = 'Pending' OR approval = 'Decline'");
            } else {
                rs = dbc.getData("SELECT c_id, u_id, p_name, c_status, worker_assign, accept, approval FROM tbl_client");
            }

            table_client.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (SQLException ex) {
            System.out.println("Errors: " + ex.getMessage());
        }
    }
        
        public int FileExistenceChecker(String path){
        File file = new File(path);
        String fileName = file.getName();
        
        Path filePath = Paths.get("src/userimages", fileName);
        boolean fileExists = Files.exists(filePath);
        
        if (fileExists) {
            return 1;
        } else {
            return 0;
        }
    }
        public static int getHeightFromWidth(String imagePath, int desiredWidth) {
        try {
            // Read the image file
            File imageFile = new File(imagePath);
            BufferedImage image = ImageIO.read(imageFile);
            
            // Get the original width and height of the image
            int originalWidth = image.getWidth();
            int originalHeight = image.getHeight();
            
            // Calculate the new height based on the desired width and the aspect ratio
            int newHeight = (int) ((double) desiredWidth / originalWidth * originalHeight);
            
            return newHeight;
        } catch (IOException ex) {
            System.out.println("No image found!");
        }
        
        return -1;
    }
        public  ImageIcon ResizeImage(String ImagePath, byte[] pic, JLabel label) {
    ImageIcon MyImage = null;
        if(ImagePath !=null){
            MyImage = new ImageIcon(ImagePath);
        }else{
            MyImage = new ImageIcon(pic);
        }
        
    int newHeight = getHeightFromWidth(ImagePath, label.getWidth());

    Image img = MyImage.getImage();
    Image newImg = img.getScaledInstance(label.getWidth(), newHeight, Image.SCALE_SMOOTH);
    ImageIcon image = new ImageIcon(newImg);
    return image;
}


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_client = new javax.swing.JTable();
        add = new javax.swing.JButton();
        aproved = new javax.swing.JButton();
        decline = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        pending = new javax.swing.JButton();
        refresh = new javax.swing.JButton();
        prints = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 0, 0));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/attachment_63634065.png"))); // NOI18N
        jLabel1.setText("jLabel1");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 446, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 4, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 450, 550));

        jPanel2.setBackground(new java.awt.Color(153, 153, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/customer-service.png"))); // NOI18N
        jLabel2.setText("jLabel2");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 16, 129, -1));

        table_client.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(table_client);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 258, 551, 284));

        add.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        add.setText("ADD");
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });
        jPanel2.add(add, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 200, 100, 40));

        aproved.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        aproved.setText("APROVED");
        aproved.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aprovedActionPerformed(evt);
            }
        });
        jPanel2.add(aproved, new org.netbeans.lib.awtextra.AbsoluteConstraints(275, 199, 130, 40));

        decline.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        decline.setText("DECLINE");
        decline.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                declineActionPerformed(evt);
            }
        });
        jPanel2.add(decline, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 199, 130, 40));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/logout.png"))); // NOI18N
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(454, 33, 75, -1));

        pending.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        pending.setText("PENDING");
        pending.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pendingActionPerformed(evt);
            }
        });
        jPanel2.add(pending, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 198, 125, 42));

        refresh.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        refresh.setText("REFRESH");
        refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshActionPerformed(evt);
            }
        });
        jPanel2.add(refresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 140, 125, 45));

        prints.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        prints.setText("PRINT");
        prints.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printsActionPerformed(evt);
            }
        });
        jPanel2.add(prints, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 140, 120, 50));

        jButton2.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jButton2.setText("Edit");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 150, 130, 40));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 0, 590, 550));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
   createclient cc = new createclient();
   cc.setVisible(true);
   this.dispose();
    }//GEN-LAST:event_addActionPerformed

    private void aprovedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aprovedActionPerformed
        int selectedRow = table_client.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(null, "Please select a Client to approve.");
            return;
        }

        Session sess = Session.getInstance();
        String currentUserFname = sess.getFn();
        String currentUserType = sess.getType();

        if (!"admin".equalsIgnoreCase(currentUserType)) {
            JOptionPane.showMessageDialog(null, "Only Admins are allowed to approve clients.");
            return;
        }

        int taskId = (int) table_client.getValueAt(selectedRow, 0);
        dbConnector dbc = new dbConnector();

        try (PreparedStatement checkPst = dbc.connect.prepareStatement("SELECT approval FROM tbl_client WHERE c_id = ?")) {
            checkPst.setInt(1, taskId);
            ResultSet rs = checkPst.executeQuery();

            if (rs.next() && "Approval".equalsIgnoreCase(rs.getString("approval"))) {
                JOptionPane.showMessageDialog(null, "This project has already been accepted.");
                return;
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Database error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try (PreparedStatement pst = dbc.connect.prepareStatement("UPDATE tbl_client SET approval = 'Approval', worker_assign = ? WHERE c_id = ?")) {
            pst.setString(1, currentUserFname);
            pst.setInt(2, taskId);
            int rowsAffected = pst.executeUpdate();

            if (rowsAffected > 0) {
                aproved.setText("Approval");
                aproved.setEnabled(false);
                JOptionPane.showMessageDialog(null, "Client accepted successfully!");
            } else {
                JOptionPane.showMessageDialog(null, "Error accepting Client.");
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Database error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            displayData(null);
        }
            
    }//GEN-LAST:event_aprovedActionPerformed

    private void declineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_declineActionPerformed
       int selectedRow = table_client.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(null, "Please select a task to decline.");
            return;
        }

        Session sess = Session.getInstance();
        String currentUserType = sess.getType();
        if (!"admin".equalsIgnoreCase(currentUserType)) {
            JOptionPane.showMessageDialog(null, "Only admins are allowed to decline clients.");
            return;
        }

        int taskId = (int) table_client.getValueAt(selectedRow, 0);
        dbConnector dbc = new dbConnector();

        try (PreparedStatement checkPst = dbc.connect.prepareStatement("SELECT approval FROM tbl_client WHERE c_id = ?")) {
            checkPst.setInt(1, taskId);
            ResultSet rs = checkPst.executeQuery();

            if (rs.next() && "Decline".equalsIgnoreCase(rs.getString("approval"))) {
                JOptionPane.showMessageDialog(null, "This client has already been declined.");
                return;
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Database error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try (PreparedStatement pst = dbc.connect.prepareStatement("UPDATE tbl_client SET approval = 'Decline' WHERE c_id = ?")) {
            pst.setInt(1, taskId);
            int rowsAffected = pst.executeUpdate();

            if (rowsAffected > 0) {
                decline.setText("Declined");
                decline.setEnabled(false);
                JOptionPane.showMessageDialog(null, "Client declined successfully!");
            } else {
                JOptionPane.showMessageDialog(null, "Error declining client.");
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Database error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_declineActionPerformed

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
    loginform l = new loginform();
     JOptionPane.showMessageDialog(null, "Logout Successfuly!");
     l.setVisible(true);
     this.dispose();
    }//GEN-LAST:event_jLabel4MouseClicked

    private void pendingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pendingActionPerformed
        displayData("filter");
    }//GEN-LAST:event_pendingActionPerformed

    private void refreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshActionPerformed
        displayData(null); // Show all data again (no filter)
    JOptionPane.showMessageDialog(null, "Table refreshed.");
    }//GEN-LAST:event_refreshActionPerformed

    private void printsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printsActionPerformed
        int rowIndex = table_client.getSelectedRow();
        if(rowIndex <0){
            JOptionPane.showMessageDialog(null, "Please select an Item!");
        }else{
            try{
                
                dbConnector db = new dbConnector();
                TableModel tbl =  table_client.getModel();
                ResultSet rs = db.getData("SELECT *FROM tbl_client WHERE c_id ='"+tbl.getValueAt(rowIndex, 0)+"'");
                if(rs.next()){
                    individualsPrintings ipt = new individualsPrintings();
                    ipt.cid.setText(""+rs.getInt("c_id"));
                    ipt.uid.setText(""+rs.getInt("u_id"));
                    ipt.clients.setText(""+rs.getString("c_fn"));
                    ipt.pname.setText(""+rs.getString("p_name"));
                    ipt.date.setText(rs.getString("c_date"));
                    ipt.due.setText(""+rs.getString("c_duedate"));
                    ipt.budget.setText(""+rs.getString("c_budget"));
                    ipt.Gender.setText(""+rs.getString("c_gender"));
                     ipt.assignner.setText(""+rs.getString("worker_assign"));
                    ipt.Email.setText(""+rs.getString("c_email"));
                    ipt.cstatus.setText(""+rs.getString("c_status"));
                    ipt.image.setIcon(ipt.ResizeImage(rs.getString("c_image"), null, ipt.image));
                    ipt.setVisible(true);
                }

            }catch(SQLException ex){
                System.out.println(""+ex);

            }
        }
    }//GEN-LAST:event_printsActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
 int rowIndex = table_client.getSelectedRow();
    if (rowIndex < 0) {
        JOptionPane.showMessageDialog(null, "Please select an Item!");
    } else {
        try {
            dbConnector dbc = new dbConnector();
            TableModel tbl = table_client.getModel();

            // Get p_id directly from the model (always first column in the model)
            int modelRow = table_client.convertRowIndexToModel(rowIndex);
            Object pIdValue = tbl.getValueAt(modelRow, 0); // 0 is p_id in model
            ResultSet rs = dbc.getData("SELECT * FROM tbl_projects WHERE p_id = '" + pIdValue + "'");

            if (rs.next()) {
                createclient cuf = new createclient();
                cuf.cid.setText(rs.getString("p_id"));
                cuf.uid.setText(rs.getString("u_id")); // Assuming these exist
                cuf.clients.setText(rs.getString("u_fn"));
                cuf.pname.setSelectedItem(rs.getString("p_name"));
                cuf.date.setDate(rs.getDate("p_date"));
                cuf.budget.setText(rs.getString("p_budget"));
                cuf.Gender.setSelectedItem(rs.getString("p_location"));
                cuf.duedate.setDate(rs.getDate("p_updatedate"));
                cuf.assignner.setSelectedItem(rs.getString("u_type")); // Adjust based on your column names
                cuf.Email.setText(rs.getString("c_email"));
                cuf.cstatus.setSelectedItem(rs.getString("p_status"));
                cuf.Add.setEnabled(false);
                cuf.update.setEnabled(true);
                cuf.image.setIcon(cuf.ResizeImage(rs.getString("p_image"), null, cuf.image));
                cuf.oldpath = rs.getString("p_image");
                cuf.path = rs.getString("p_image");
                cuf.destination = rs.getString("p_image");
                cuf.select.setEnabled(false);
                cuf.remove.setEnabled(true);

                if (rs.getString("p_image").isEmpty()) {
                    cuf.select.setEnabled(true);
                    cuf.remove.setEnabled(false);
                }

                cuf.setVisible(true);
                this.dispose();
            }

        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }      
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(clientproject.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(clientproject.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(clientproject.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(clientproject.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new clientproject().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add;
    private javax.swing.JButton aproved;
    private javax.swing.JButton decline;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton pending;
    public javax.swing.JButton prints;
    private javax.swing.JButton refresh;
    public javax.swing.JTable table_client;
    // End of variables declaration//GEN-END:variables
}
