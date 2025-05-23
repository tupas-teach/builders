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
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;


/**
 *
 * @author davetupas
 */
public class createproject extends javax.swing.JFrame {

      
    public createproject() {
      
        initComponents();
 populateClientNameComboBox(client_name);
   populateEmployeeComboBox(employee);
  
        
    }
   


   public void populateEmployeeComboBox(JComboBox<String> comboBox) {
    dbConnector dbc = new dbConnector();
    String query = "SELECT CONCAT(u_fn, ' ', u_ln) AS full_name FROM tbl_user WHERE u_type = 'employee'";

    try {
        ResultSet rs = dbc.getData(query);

        comboBox.removeAllItems();  // Clear any existing items

        boolean hasEmployees = false;
        while (rs.next()) {
            comboBox.addItem(rs.getString("full_name"));  // Show full name
            hasEmployees = true;
        }
        rs.close();

        if (!hasEmployees) {
            comboBox.addItem("No employees found");
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error loading employees: " + e.getMessage());
    }

   }

    public void populateClientNameComboBox(JComboBox<String> comboBox) {
    dbConnector dbc = new dbConnector();
    String query = "SELECT DISTINCT u_fn FROM tbl_client"; // Now fetching from tbl_client

    try {
        ResultSet rs = dbc.getData(query);

        comboBox.removeAllItems(); // Clear existing items

        boolean hasClients = false;
        while (rs.next()) {
            String clientName = rs.getString("u_fn"); // Ensure u_fn exists in tbl_client
            if (clientName != null && !clientName.trim().isEmpty()) {
                comboBox.addItem(clientName);
                hasClients = true;
            }
        }
        rs.close();

        if (!hasClients) {
            comboBox.addItem("No clients found");
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error loading clients: " + e.getMessage());
    }
}



   

    public boolean checkadd = true;

    public String destination ="";
    File selectedFile;
    public String oldpath;
    public String path;
    
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

        cname = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        location = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        client_name = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        pstatus = new javax.swing.JComboBox<>();
        pname = new javax.swing.JComboBox<>();
        contact = new javax.swing.JTextField();
        endyear = new com.toedter.calendar.JDateChooser();
        date = new com.toedter.calendar.JDateChooser();
        uid = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        print = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        update = new javax.swing.JButton();
        Add = new javax.swing.JButton();
        employee = new javax.swing.JComboBox<>();
        budget = new javax.swing.JTextField();
        pid = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        image = new javax.swing.JLabel();
        removed = new javax.swing.JButton();
        select = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();

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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(0, 130, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 630));

        jPanel2.setBackground(new java.awt.Color(153, 153, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(153, 153, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel3.setText("Project Name");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 143, -1, -1));

        jLabel4.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel4.setText("Project Start");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 195, -1, -1));

        jLabel5.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel5.setText("Project Budget");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 243, -1, -1));

        location.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                locationActionPerformed(evt);
            }
        });
        jPanel3.add(location, new org.netbeans.lib.awtextra.AbsoluteConstraints(146, 280, 258, 35));

        jLabel6.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel6.setText("Location");
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(67, 284, -1, -1));

        jLabel7.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel7.setText("Project End");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(41, 343, -1, -1));

        jLabel10.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel10.setText("Contact Number");
        jPanel3.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 457, -1, -1));

        jLabel11.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel11.setText("Client Name");
        jPanel3.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(35, 396, -1, 31));

        client_name.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        client_name.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "select", " " }));
        client_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                client_nameActionPerformed(evt);
            }
        });
        jPanel3.add(client_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(146, 392, 258, 38));

        jLabel12.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel12.setText("Project Status");
        jPanel3.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 504, -1, 31));

        pstatus.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        pstatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "Available", "Out Project", "Active Project", "Pending Project", "aproved" }));
        pstatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pstatusActionPerformed(evt);
            }
        });
        jPanel3.add(pstatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(146, 500, 258, 38));

        pname.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        pname.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "project 1 owner house", "project 2 apartments", "project 3 village", "project 4 condominiums" }));
        jPanel3.add(pname, new org.netbeans.lib.awtextra.AbsoluteConstraints(146, 137, 258, 35));
        jPanel3.add(contact, new org.netbeans.lib.awtextra.AbsoluteConstraints(146, 447, 258, 47));
        jPanel3.add(endyear, new org.netbeans.lib.awtextra.AbsoluteConstraints(146, 333, 258, 41));

        date.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dateMouseClicked(evt);
            }
        });
        jPanel3.add(date, new org.netbeans.lib.awtextra.AbsoluteConstraints(146, 182, 258, 39));

        uid.setEnabled(false);
        jPanel3.add(uid, new org.netbeans.lib.awtextra.AbsoluteConstraints(147, 54, 257, 36));

        jLabel8.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel8.setText("User ID");
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(79, 59, -1, -1));

        jLabel9.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel9.setText("Project Maker");
        jPanel3.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 102, -1, -1));

        print.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        print.setText("Print");
        print.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printActionPerformed(evt);
            }
        });
        jPanel3.add(print, new org.netbeans.lib.awtextra.AbsoluteConstraints(466, 68, 115, 40));

        jButton6.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jButton6.setText("CANCEL");
        jButton6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton6MouseClicked(evt);
            }
        });
        jPanel3.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(627, 68, 115, 40));

        update.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        update.setText("UPDATE");
        update.setDoubleBuffered(true);
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });
        jPanel3.add(update, new org.netbeans.lib.awtextra.AbsoluteConstraints(627, 17, 115, 40));

        Add.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        Add.setText("ADD");
        Add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddActionPerformed(evt);
            }
        });
        jPanel3.add(Add, new org.netbeans.lib.awtextra.AbsoluteConstraints(466, 17, 115, 40));

        employee.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        employee.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", " " }));
        employee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                employeeActionPerformed(evt);
            }
        });
        jPanel3.add(employee, new org.netbeans.lib.awtextra.AbsoluteConstraints(146, 96, 258, 35));

        budget.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                budgetActionPerformed(evt);
            }
        });
        jPanel3.add(budget, new org.netbeans.lib.awtextra.AbsoluteConstraints(146, 239, 258, 35));

        pid.setEnabled(false);
        jPanel3.add(pid, new org.netbeans.lib.awtextra.AbsoluteConstraints(146, 0, 257, 36));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel2.setText("Project ID");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(57, 5, -1, -1));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(image, javax.swing.GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(image, javax.swing.GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel3.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(466, 156, -1, -1));

        removed.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        removed.setText("Remove");
        removed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removedActionPerformed(evt);
            }
        });
        jPanel3.add(removed, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 400, 110, 40));

        select.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        select.setText("Select");
        select.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectActionPerformed(evt);
            }
        });
        jPanel3.add(select, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 400, 90, 40));

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 810, 600));

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/back (1).png"))); // NOI18N
        jLabel13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel13MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 10, -1, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 0, 810, 630));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        Session sess = Session.getInstance();
      
      if(sess.getId()==0){
          JOptionPane.showMessageDialog(null,"No Account. Login First!");
          loginform lf = new loginform();
          lf.setVisible(true);
          this.dispose();
      }else{
          
          pid.setText(""+sess.getP_id());
          uid.setText(""+sess.getId());
          
          
          
          
      }
      
    }//GEN-LAST:event_formWindowActivated

    private void employeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_employeeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_employeeActionPerformed

    private void AddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddActionPerformed
        if (checkadd) {
            if (location.getText().isEmpty() || contact.getText().isEmpty() || employee.getSelectedItem().equals("")
                || date.getDate() == null || endyear.getDate() == null) {
                JOptionPane.showMessageDialog(null, "All fields are required!");
            } else {
                try {
                    dbConnector dbc = new dbConnector();
                    java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
                    String formattedStartDate = sdf.format(date.getDate());
                    String formattedEndDate = sdf.format(endyear.getDate());

                    String query = "INSERT INTO tbl_projects (u_id , u_fn,p_name, p_date, p_location, p_budget, p_updatedate, u_type, p_contact, p_status,p_image) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?)";

                    PreparedStatement ps = dbc.getConnection().prepareStatement(query);
                    ps.setString(1, uid.getText());
                     ps.setString(2, employee.getSelectedItem().toString());
                    ps.setString(3, pname.getSelectedItem().toString());
                    ps.setString(4, formattedStartDate);
                    ps.setString(5, location.getText());
                    ps.setString(6, budget.getText());
                    ps.setString(7, formattedEndDate);
                    ps.setString(8, client_name.getSelectedItem().toString());
                    ps.setString(9, contact.getText());
                    ps.setString(10, pstatus.getSelectedItem().toString());
                     ps.setString(11, destination);
                
                
                      try{
                Files.copy(selectedFile.toPath(),new File(destination).toPath(),StandardCopyOption.REPLACE_EXISTING);
                JOptionPane.showMessageDialog(null, "Projects Success!");
                projectReports pj = new projectReports();
                pj.setVisible(true);
                this.dispose();

            }catch(IOException ex){
                System.out.println("Insert image Error:"+ ex);
            
            

            }     JOptionPane.showMessageDialog(null, "Connection Error!");

                    ps.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Successfully Added!");

                    projectReports pr = new projectReports();
                    pr.setVisible(true);
                    this.dispose();
                } catch (Exception e) {
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
                }
            }
        }
    }//GEN-LAST:event_AddActionPerformed

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
        if (pid.getText().isEmpty() || location.getText().isEmpty() || contact.getText().isEmpty()
            || employee.getSelectedItem().equals("")|| date.getDate() == null || endyear.getDate() == null) {
            JOptionPane.showMessageDialog(null, "All fields are required!");
        } else {
            try {
                dbConnector dbc = new dbConnector();
                java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
                String formattedStartDate = sdf.format(date.getDate());
                String formattedEndDate = sdf.format(endyear.getDate());

                String query = "UPDATE tbl_projects SET  u_fn = ?, p_name = ?, p_date = ?, "
                + "p_location = ?, p_budget = ?, p_updatedate = ?, u_type = ?, "
                + "p_contact = ?, p_status = ? , p_image = ? WHERE p_id = ?";
                PreparedStatement ps = dbc.getConnection().prepareStatement(query);
                 ps.setString(1, pid.getText());
                     ps.setString(2, employee.getSelectedItem().toString());
                    ps.setString(3, pname.getSelectedItem().toString());
                    ps.setString(4, formattedStartDate);
                    ps.setString(5, location.getText());
                    ps.setString(6, budget.getText());
                    ps.setString(7, formattedEndDate);
                    ps.setString(8, client_name.getSelectedItem().toString());
                    ps.setString(9, contact.getText());
                    ps.setString(10, pstatus.getSelectedItem().toString());
                     ps.setString(11, destination);
                    
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Updated Successfully!");

                projectReports pr = new projectReports();
                pr.setVisible(true);
                this.dispose();
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
            }
        }
    }//GEN-LAST:event_updateActionPerformed

    private void jButton6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton6MouseClicked
        projectReports pr = new  projectReports();
        JOptionPane.showMessageDialog(null, "Go back and ProjectReports!");
        pr.setVisible(true);
        this.dispose();

    }//GEN-LAST:event_jButton6MouseClicked

    private void pstatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pstatusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pstatusActionPerformed

    private void client_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_client_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_client_nameActionPerformed

    private void locationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_locationActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_locationActionPerformed

    private void jLabel13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseClicked
       adminforms ad = new adminforms();
       ad.setVisible(true);
       this.dispose();
    }//GEN-LAST:event_jLabel13MouseClicked

    private void selectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        int returnValue = fileChooser.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            try {
                selectedFile = fileChooser.getSelectedFile();
                destination = "src/userimages/" + selectedFile.getName();
                path  = selectedFile.getAbsolutePath();

                if(FileExistenceChecker(path) == 1){
                    JOptionPane.showMessageDialog(null, "File Already Exist, Rename or Choose another!");
                    destination = "";
                    path="";
                }else{
                    image.setIcon(ResizeImage(path, null, image));
                    select.setVisible(false);
                    removed.setVisible(true);
                }
            } catch (Exception ex) {
                System.out.println("File Error!");
            }
        }
    }//GEN-LAST:event_selectActionPerformed

    private void budgetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_budgetActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_budgetActionPerformed

    private void dateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dateMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_dateMouseClicked

    private void printActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printActionPerformed
      
    }//GEN-LAST:event_printActionPerformed

    private void removedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removedActionPerformed
       removed.setEnabled(false);
     select.setEnabled(true);
     image.setIcon(null);
      destination ="";
path ="";

    }//GEN-LAST:event_removedActionPerformed

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
            java.util.logging.Logger.getLogger(createproject.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(createproject.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(createproject.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(createproject.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new createproject().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton Add;
    public javax.swing.JTextField budget;
    public javax.swing.JComboBox<String> client_name;
    public javax.swing.JTextField cname;
    public javax.swing.JTextField contact;
    public com.toedter.calendar.JDateChooser date;
    public javax.swing.JComboBox<String> employee;
    public com.toedter.calendar.JDateChooser endyear;
    public javax.swing.JLabel image;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    public javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    public javax.swing.JTextField location;
    public javax.swing.JTextField pid;
    public javax.swing.JComboBox<String> pname;
    private javax.swing.JButton print;
    public javax.swing.JComboBox<String> pstatus;
    public javax.swing.JButton removed;
    public javax.swing.JButton select;
    public javax.swing.JTextField uid;
    public javax.swing.JButton update;
    // End of variables declaration//GEN-END:variables
}
