/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin;

import Clientform.clientproject;
import LoginForm.loginform;
import ProjectReports.projectReports;
import config.Session;
import config.dbConnector;
import java.awt.Color;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;
import net.proteanit.sql.DbUtils;
import userslogs.Log;
import userslogs.logs;
/**
 *
 * @author davetupas
 */
public class adminform extends javax.swing.JFrame {

    /**
     * Creates new form adminform
     */
    public adminform() {
        initComponents(); 
        displayData();

    }
  
        Color  navcolor = new Color(102,0,102);
    Color headcolor = new Color(102,102,255);
    Color bodycolor = new Color(153,153,255);
         public void displayData(){
        try{
            dbConnector dbc = new dbConnector();
            ResultSet rs = dbc.getData("SELECT u_id,u_fn,u_status,u_type FROM tbl_user");
            tabl_user.setModel(DbUtils.resultSetToTableModel(rs));
            
        }catch(SQLException ex){
                    System.out.println("Errors:"+ex.getMessage());
      
        }
                
         }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        table_name = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        admin = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        navbar1 = new javax.swing.JPanel();
        add = new javax.swing.JLabel();
        navbar2 = new javax.swing.JPanel();
        edit = new javax.swing.JLabel();
        navbar3 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        dave = new javax.swing.JDesktopPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabl_user = new javax.swing.JTable();
        id_admin = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        navbar4 = new javax.swing.JPanel();
        client = new javax.swing.JLabel();

        table_name.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(table_name);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 153));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/attachment_63634065.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(0, 20, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 488, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 42, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 520, 530));

        jPanel2.setBackground(new java.awt.Color(153, 153, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/admin (1).png"))); // NOI18N
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 68, -1, -1));

        admin.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        admin.setText("Admin");
        jPanel2.add(admin, new org.netbeans.lib.awtextra.AbsoluteConstraints(63, 205, -1, -1));

        jLabel4.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel4.setText("Current ID");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 450, 124, -1));

        jLabel8.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel8.setText("ADMIN FORM");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 242, -1));

        navbar1.setBackground(new java.awt.Color(102, 0, 102));
        navbar1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                navbar1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                navbar1MouseExited(evt);
            }
        });

        add.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        add.setForeground(new java.awt.Color(240, 240, 240));
        add.setText("   ADD");
        add.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout navbar1Layout = new javax.swing.GroupLayout(navbar1);
        navbar1.setLayout(navbar1Layout);
        navbar1Layout.setHorizontalGroup(
            navbar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, navbar1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(add, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );
        navbar1Layout.setVerticalGroup(
            navbar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(add)
        );

        jPanel2.add(navbar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 340, 120, -1));

        navbar2.setBackground(new java.awt.Color(102, 0, 102));
        navbar2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                navbar2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                navbar2MouseExited(evt);
            }
        });

        edit.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        edit.setForeground(new java.awt.Color(240, 240, 240));
        edit.setText("  EDIT");
        edit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                editMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout navbar2Layout = new javax.swing.GroupLayout(navbar2);
        navbar2.setLayout(navbar2Layout);
        navbar2Layout.setHorizontalGroup(
            navbar2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, navbar2Layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addComponent(edit, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );
        navbar2Layout.setVerticalGroup(
            navbar2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(edit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel2.add(navbar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 250, 120, -1));

        navbar3.setBackground(new java.awt.Color(102, 0, 102));
        navbar3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                navbar3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                navbar3MouseExited(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(240, 240, 240));
        jLabel9.setText("Print");
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel9MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout navbar3Layout = new javax.swing.GroupLayout(navbar3);
        navbar3.setLayout(navbar3Layout);
        navbar3Layout.setHorizontalGroup(
            navbar3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, navbar3Layout.createSequentialGroup()
                .addContainerGap(31, Short.MAX_VALUE)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );
        navbar3Layout.setVerticalGroup(
            navbar3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel2.add(navbar3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 390, 120, -1));

        tabl_user.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tabl_user);

        dave.setLayer(jScrollPane2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout daveLayout = new javax.swing.GroupLayout(dave);
        dave.setLayout(daveLayout);
        daveLayout.setHorizontalGroup(
            daveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 370, Short.MAX_VALUE)
        );
        daveLayout.setVerticalGroup(
            daveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 390, Short.MAX_VALUE)
        );

        jPanel2.add(dave, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 100, 370, 390));

        id_admin.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        id_admin.setText("ID ADMIN");
        jPanel2.add(id_admin, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 480, -1, -1));

        jButton1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(204, 0, 0));
        jButton1.setText("logs");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 60, 120, -1));

        jButton2.setBackground(new java.awt.Color(204, 0, 0));
        jButton2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButton2.setText("Project Reports");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 60, 150, 30));

        navbar4.setBackground(new java.awt.Color(102, 0, 102));
        navbar4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                navbar4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                navbar4MouseExited(evt);
            }
        });

        client.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        client.setForeground(new java.awt.Color(240, 240, 240));
        client.setText("Client");
        client.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clientMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout navbar4Layout = new javax.swing.GroupLayout(navbar4);
        navbar4.setLayout(navbar4Layout);
        navbar4Layout.setHorizontalGroup(
            navbar4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, navbar4Layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addComponent(client, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );
        navbar4Layout.setVerticalGroup(
            navbar4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(client, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel2.add(navbar4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 290, 120, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 0, 650, 530));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
         Session sess = Session.getInstance();
        if(sess.getId()==0){
            JOptionPane.showMessageDialog(null,"No account, Login First");
             loginform l = new loginform();
            l.setVisible(true);
            this.dispose();
        }else{
           
                       
                                        
        }
    }//GEN-LAST:event_formWindowActivated

    private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseClicked
        int rowIndex = tabl_user.getSelectedRow();
        if(rowIndex <0){
            JOptionPane.showMessageDialog(null, "Please select an Item!");
        }else{
            try{
                dbConnector db = new dbConnector();
                TableModel tbl =  tabl_user.getModel();
                ResultSet rs = db.getData("SELECT *FROM tbl_user WHERE u_id ='"+tbl.getValueAt(rowIndex, 0)+"'");
                if(rs.next()){
                    individualPrinting ipt = new individualPrinting();
                    ipt.uid.setText(""+rs.getInt("u_id"));
                    ipt.fn.setText(""+rs.getString("u_fn"));
                    ipt.mdn.setText(""+rs.getString("u_middle"));
                    ipt.ln.setText(""+rs.getString("u_ln"));
                    ipt.username.setText(""+rs.getString("u_username"));
                    ipt.contact.setText(""+rs.getString("u_Contact"));
                    ipt.email.setText(""+rs.getString("u_email"));
                    ipt.type.setText(""+rs.getString("u_type"));
                    ipt.gender.setText(""+rs.getString("u_gender"));
                    ipt.status.setText(""+rs.getString("u_status"));
                    ipt.image.setIcon(ipt.ResizeImage(rs.getString("u_image"), null, ipt.image));
                    ipt.setVisible(true);
                }

            }catch(SQLException ex){
                System.out.println(""+ex);

            }
        }
    }//GEN-LAST:event_jLabel9MouseClicked

    private void editMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editMouseClicked
        int rowIndex = tabl_user.getSelectedRow();
        if(rowIndex <0){
            JOptionPane.showMessageDialog(null, "Please select an Item!");
        }else{
            try{
                dbConnector dbc = new dbConnector();
                TableModel tbl =  tabl_user.getModel();
                ResultSet rs = dbc.getData("SELECT *FROM tbl_user WHERE u_id ='"+tbl.getValueAt(rowIndex, 0)+"'");
                if(rs.next()){
                    createadmin cuf = new createadmin();
                    cuf.uid.setText(""+rs.getInt("u_id"));
                    cuf.fn.setText(""+rs.getString("u_fn"));
                    cuf.mdn.setText(""+rs.getString("u_middle"));
                    cuf.ln.setText(""+rs.getString("u_ln"));
                    cuf.un.setText(""+rs.getString("u_username"));
                    cuf.contact.setText(""+rs.getString("u_Contact"));
                    cuf.Add.setEnabled(false);
                    cuf.update.setEnabled(true);
                    cuf.image.setIcon(cuf.ResizeImage(rs.getString("u_image"), null, cuf.image));
                    cuf.oldpath = rs.getString("u_image");
                    cuf.path =  rs.getString("u_image");
                    cuf.destination =  rs.getString("u_image");
                    cuf.select.setEnabled(false);
                    cuf.remove.setEnabled(true);
                    cuf.setVisible(true);
                    if( rs.getString("u_image").isEmpty()){
                        cuf.select.setEnabled(true);
                        cuf.remove.setEnabled(false);
                    }else{
                        cuf.select.setEnabled(false);
                        cuf.remove.setEnabled(true);
                    }
                    this.dispose();
                }

            }catch(SQLException ex){
                System.out.println(""+ex);

            }
        }
    }//GEN-LAST:event_editMouseClicked

    private void addMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addMouseClicked
        createadmin c = new createadmin();
        c.setVisible(true);
        c.select.setEnabled(true);
        c.remove.setEnabled(false);
        this.dispose();
    }//GEN-LAST:event_addMouseClicked

    private void navbar1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_navbar1MouseEntered
    navbar1.setBackground(bodycolor);
    }//GEN-LAST:event_navbar1MouseEntered

    private void navbar2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_navbar2MouseEntered
        navbar2.setBackground(bodycolor);
    }//GEN-LAST:event_navbar2MouseEntered

    private void navbar1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_navbar1MouseExited
        navbar1.setBackground(navcolor);
    }//GEN-LAST:event_navbar1MouseExited

    private void navbar2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_navbar2MouseExited
        navbar2.setBackground(navcolor);
    }//GEN-LAST:event_navbar2MouseExited

    private void navbar3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_navbar3MouseEntered
       navbar3.setBackground(bodycolor);
    }//GEN-LAST:event_navbar3MouseEntered

    private void navbar3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_navbar3MouseExited
        navbar1.setBackground(navcolor);
    }//GEN-LAST:event_navbar3MouseExited

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
       adminDetails ad = new adminDetails();
       ad.setVisible(true);
       this.dispose();
    }//GEN-LAST:event_jLabel2MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        logs l = new logs();
        l.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       projectReports pr = new projectReports();
       pr.setVisible(true);
       this.dispose();
       
    }//GEN-LAST:event_jButton2ActionPerformed

    private void clientMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clientMouseClicked
      clientproject pj = new clientproject();
      pj.setVisible(true);
      this.dispose();
      
    }//GEN-LAST:event_clientMouseClicked

    private void navbar4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_navbar4MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_navbar4MouseEntered

    private void navbar4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_navbar4MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_navbar4MouseExited

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
            java.util.logging.Logger.getLogger(adminform.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(adminform.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(adminform.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(adminform.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new adminform().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel add;
    private javax.swing.JLabel admin;
    private javax.swing.JLabel client;
    public javax.swing.JDesktopPane dave;
    private javax.swing.JLabel edit;
    private javax.swing.JLabel id_admin;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel navbar1;
    private javax.swing.JPanel navbar2;
    private javax.swing.JPanel navbar3;
    private javax.swing.JPanel navbar4;
    public javax.swing.JTable tabl_user;
    private javax.swing.JTable table_name;
    // End of variables declaration//GEN-END:variables
}
