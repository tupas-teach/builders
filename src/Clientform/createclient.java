/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clientform;

import LoginForm.loginform;
import admin.adminforms;
import admin.createadmin;
import config.Session;
import config.dbConnector;
import config.passwordHasher;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.security.NoSuchAlgorithmException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import static javax.swing.SwingConstants.LEFT;
import static javax.swing.text.html.HTML.Tag.SELECT;

/**
 *
 * @author davetupas 
 */
public class createclient extends javax.swing.JFrame {


      
    public createclient() {
        initComponents();
        populateComboBoxes();
       
    } 
    
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

    


    public void loadActiveUsers() {
        dbConnector db = new dbConnector(); // Assumes this class has a connect field and getData method

        try {
            // ✅ SQL: Only load active users and combine first + last name
            String sqlUsers = "SELECT CONCAT(u_fn, ' ', u_ln) AS full_name FROM tbl_user WHERE u_status = 'active'";

            ResultSet rsUsers = db.getData(sqlUsers); // getData returns ResultSet
            DefaultComboBoxModel<String> userModel = new DefaultComboBoxModel<>();
            userModel.addElement("Select Employee");

            while (rsUsers.next()) {
                String userName = rsUsers.getString("full_name");
                userModel.addElement(userName);
                System.out.println("User Name loaded: " + userName);  // Optional debug log
            }

            assignner.setModel(userModel);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error fetching user data: " + ex.getMessage());
            ex.printStackTrace();
        } finally {
            try {
                if (db.connect != null && !db.connect.isClosed()) {
                    db.connect.close();
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error closing DB connection: " + ex.getMessage());
            }
        }
    
}


   
   private void populateComboBoxes() {
    dbConnector db = new dbConnector();
    try {
        String sqlProjects = "SELECT p_name FROM tbl_projects"; 
        ResultSet rsProjects = db.getData(sqlProjects);
        DefaultComboBoxModel<String> projectModel = new DefaultComboBoxModel<>();
        projectModel.addElement("Select Project");
        while (rsProjects.next()) {
            String projectName = rsProjects.getString("p_name");
            projectModel.addElement(projectName);
            System.out.println("Project Name loaded: " + projectName);  // Debug log
        }
        pname.setModel(projectModel);
        String sqlUsers = "SELECT u_fn FROM tbl_user"; 
        ResultSet rsUsers = db.getData(sqlUsers);
        DefaultComboBoxModel<String> userModel = new DefaultComboBoxModel<>();
        userModel.addElement("Select Employee");
        while (rsUsers.next()) {
            String userName = rsUsers.getString("u_fn");
            userModel.addElement(userName);
            System.out.println("User Name loaded: " + userName);  // Debug log
        }
        assignner.setModel(userModel);
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error fetching data: " + ex.getMessage());
    }
    
}


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fn = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        contact = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        Gender = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        assignner = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        cstatus = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        Email = new javax.swing.JTextField();
        Add = new javax.swing.JButton();
        update = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        uid = new javax.swing.JTextField();
        pname = new javax.swing.JComboBox<>();
        date = new com.toedter.calendar.JDateChooser();
        duedate = new com.toedter.calendar.JDateChooser();
        clients = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        cid = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        budget = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        client = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        image = new javax.swing.JLabel();
        select = new javax.swing.JButton();
        remove = new javax.swing.JButton();

        fn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fnActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3.setText("FirstName");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 153, 153));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/attachment_63634065.png"))); // NOI18N

        contact.setBackground(new java.awt.Color(153, 153, 255));
        contact.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel4.setText("Project budget");
        contact.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, -1, -1));

        jLabel5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel5.setText("Start Date");
        contact.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 300, -1, 20));

        jLabel6.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel6.setText("End Date");
        contact.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 340, -1, -1));

        jLabel10.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel10.setText("Gender:");
        contact.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 440, -1, -1));

        Gender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "select", "male", "female" }));
        contact.add(Gender, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 430, 258, 38));

        jLabel11.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel11.setText("Type Acc:");
        contact.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 390, -1, 31));

        assignner.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        assignner.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECT", "admin", "employee", "client" }));
        assignner.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                assignnerActionPerformed(evt);
            }
        });
        contact.add(assignner, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 380, 258, 38));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setText("Client Status");
        contact.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 520, -1, 31));

        cstatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "active", "In_active", "available" }));
        cstatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cstatusActionPerformed(evt);
            }
        });
        contact.add(cstatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 520, 258, 38));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setText("Email:");
        contact.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 490, -1, -1));

        Email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EmailActionPerformed(evt);
            }
        });
        contact.add(Email, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 480, 258, 35));

        Add.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        Add.setText("ADD");
        Add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddActionPerformed(evt);
            }
        });
        contact.add(Add, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 10, 120, 41));

        update.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        update.setText("UPDATE");
        update.setDoubleBuffered(true);
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });
        contact.add(update, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 10, -1, 41));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setText("Client name");
        contact.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, -1, -1));

        uid.setEnabled(false);
        uid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uidActionPerformed(evt);
            }
        });
        contact.add(uid, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 100, 260, 35));

        pname.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "select" }));
        pname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pnameActionPerformed(evt);
            }
        });
        contact.add(pname, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 190, 260, 40));
        contact.add(date, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 290, 260, 40));
        contact.add(duedate, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 330, 260, 40));

        clients.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clientsActionPerformed(evt);
            }
        });
        contact.add(clients, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 140, 260, 40));

        jLabel15.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        contact.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, -1, -1));

        jLabel16.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel16.setText("User id");
        contact.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 110, -1, -1));

        cid.setEnabled(false);
        cid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cidActionPerformed(evt);
            }
        });
        contact.add(cid, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 60, 260, 35));

        jLabel17.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel17.setText("Client id");
        contact.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, -1, -1));

        budget.setEnabled(false);
        contact.add(budget, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 240, 260, 40));

        jLabel8.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel8.setText("Project name");
        contact.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, -1, -1));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(contact, javax.swing.GroupLayout.PREFERRED_SIZE, 431, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(0, 99, Short.MAX_VALUE))
            .addComponent(contact, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 940, -1));

        client.setBackground(new java.awt.Color(153, 153, 255));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/back (1).png"))); // NOI18N
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });

        image.setText("     image not found");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(image, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(image, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
                .addContainerGap())
        );

        select.setText("Select");
        select.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectActionPerformed(evt);
            }
        });

        remove.setText("Remove");
        remove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout clientLayout = new javax.swing.GroupLayout(client);
        client.setLayout(clientLayout);
        clientLayout.setHorizontalGroup(
            clientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, clientLayout.createSequentialGroup()
                .addContainerGap(420, Short.MAX_VALUE)
                .addGroup(clientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, clientLayout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(51, 51, 51))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, clientLayout.createSequentialGroup()
                        .addGroup(clientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, clientLayout.createSequentialGroup()
                                .addComponent(select, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(remove))
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32))))
        );
        clientLayout.setVerticalGroup(
            clientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(clientLayout.createSequentialGroup()
                .addComponent(jLabel7)
                .addGap(113, 113, 113)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(clientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(select)
                    .addComponent(remove))
                .addGap(0, 235, Short.MAX_VALUE))
        );

        getContentPane().add(client, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 0, 650, 600));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void fnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fnActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
         Session sess = Session.getInstance();
      
      if(sess.getId()==0){
          JOptionPane.showMessageDialog(null,"No Account. Login First!");
          loginform lf = new loginform();
          lf.setVisible(true);
          this.dispose();
      }else{
          
         cid.setText(""+sess.getC_id());
          uid.setText(""+sess.getId());
          
       
         
         
          
      }
    }//GEN-LAST:event_formWindowActivated

    private void cidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cidActionPerformed

    private void clientsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clientsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_clientsActionPerformed

    private void pnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pnameActionPerformed
  String selectedProject = (String) pname.getSelectedItem();
if (selectedProject == null || selectedProject.equals("Select Project")) {
    date.setDate(null);
    duedate.setDate(null);
    budget.setText("");
    assignner.setSelectedItem("");
    return;
}

dbConnector db = new dbConnector();
try {
    String query = "SELECT p.p_date, p.p_updatedate, p.p_budget, u.u_fn "
                 + "FROM tbl_projects p "
                 + "LEFT JOIN tbl_user u ON p.u_id = u.u_id "
                 + "WHERE p.p_name = ?";

    try (PreparedStatement pst = db.connect.prepareStatement(query)) {
        pst.setString(1, selectedProject);
        ResultSet rs = pst.executeQuery();

        if (rs.next()) {
            java.sql.Date startDate = rs.getDate("p_date");
            java.sql.Date dueDate = rs.getDate("p_updatedate");
            String budgetValue = rs.getString("p_budget");
            String userFirstName = rs.getString("u_fn");

            date.setDate(startDate != null ? new java.util.Date(startDate.getTime()) : null);
            duedate.setDate(dueDate != null ? new java.util.Date(dueDate.getTime()) : null);
            budget.setText(budgetValue != null ? budgetValue : "");
            assignner.setSelectedItem(userFirstName != null ? userFirstName : "Unassigned");
        } else {
            date.setDate(null);
            duedate.setDate(null);
            budget.setText("");
            assignner.setSelectedItem("");
        }
    }
} catch (SQLException e) {
    JOptionPane.showMessageDialog(null, "Error fetching project data: " + e.getMessage());
    e.printStackTrace();
} finally {
    try {
        if (db.connect != null && !db.connect.isClosed()) {
            db.connect.close();
        }
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error closing DB connection: " + ex.getMessage());
    }
}

    }//GEN-LAST:event_pnameActionPerformed

    private void uidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_uidActionPerformed

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
        if (uid.getText().isEmpty() || pname.getSelectedItem().equals("Select Project") ||
            clients.getText().isEmpty() || date.getDate() == null ||
            duedate.getDate() == null || cstatus.getSelectedItem().equals("SELECT")) {

            JOptionPane.showMessageDialog(null, "All fields are required and status must be selected!");
            return;
        }

        dbConnector db = new dbConnector();

        try {
            java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
            String formattedDate = sdf.format(date.getDate());
            String formattedDueDate = sdf.format(duedate.getDate());
            String selectedProject = (String) pname.getSelectedItem();
            String currentuser = clients.getText().trim();
            String selectedUser = (String) assignner.getSelectedItem();
            int p_id = -1;
            int u_id = -1;
            String getPidQuery = "SELECT p_id FROM tbl_projects WHERE p_name = ?";
            try (PreparedStatement pst = db.connect.prepareStatement(getPidQuery)) {
                pst.setString(1, selectedProject);
                ResultSet rs = pst.executeQuery();
                if (rs.next()) {
                    p_id = rs.getInt("p_id");
                } else {
                    JOptionPane.showMessageDialog(null, "Project not found.");
                    return;
                }
            }
            String getUidQuery = "SELECT u_id FROM tbl_user WHERE u_fn = ?";
            try (PreparedStatement pst = db.connect.prepareStatement(getUidQuery)) {
                pst.setString(1, currentuser);
                ResultSet rs = pst.executeQuery();
                if (rs.next()) {
                    u_id = rs.getInt("u_id");
                } else {
                    JOptionPane.showMessageDialog(null, "User not found.");
                    return;
                }
            }
           String sql = "UPDATE tbl_client SET p_id = ?, u_id = ?, p_name = ?, u_fn = ?, worker_assign = ?, " +
             "c_date = ?, c_duedate = ?, c_gender = ?, c_email = ?, c_status = ?,c_image = ?, accept = ?, approval = ? " +
             "WHERE c_id = ?";
            try (PreparedStatement pst = db.connect.prepareStatement(sql)) {
                pst.setInt(1, p_id);
                pst.setInt(2, u_id);
                pst.setString(3, selectedProject);
                pst.setString(4, currentuser);
                pst.setString(5, selectedUser);
                pst.setString(6, formattedDate);
                pst.setString(7, formattedDueDate);
                pst.setString(8, Gender.getSelectedItem().toString());
                pst.setString(9, Email.getText());
                pst.setString(10, cstatus.getSelectedItem().toString());
                pst.setInt(11, Integer.parseInt(uid.getText()));
                int rowsAffected = pst.executeUpdate();
                if (rowsAffected > 0) {
                    JOptionPane.showMessageDialog(null, "Client updated successfully!");
                    clientproject cp = new clientproject();
                    cp.setVisible(true);
                    this.dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Failed to update Client.");
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Database error: " + ex.getMessage());
            ex.printStackTrace();
        } finally {
            try {
                if (db.connect != null && !db.connect.isClosed()) {
                    db.connect.close();
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error closing database connection: " + e.getMessage());
            }
        }
    }//GEN-LAST:event_updateActionPerformed

    private void AddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddActionPerformed
        String p_name = (String) pname.getSelectedItem();
        String c_gender = (String)Gender.getSelectedItem();
        String c_email = (String)Email.getText();
        String c_status = (String) cstatus.getSelectedItem();
        java.util.Date c_date = date.getDate();
        java.util.Date c_duedate = duedate.getDate();

        // Check if any required field is empty
        if (p_name.equals("Select Project") || c_status.equals("SELECT") || c_date == null || c_duedate == null) {
            JOptionPane.showMessageDialog(null, "Please fill in all required fields.");
            return;
        }

        // Get current date and time
        java.util.Date currentDate = new java.util.Date(); // Current date and time

        // Check if the task start date or due date is before the current date and time
        if (c_date.before(currentDate)) {
            JOptionPane.showMessageDialog(null, "Start date cannot be earlier than the current date.");
            return;
        }

        // Check if the due date is earlier than the current date and time
        if (c_duedate.before(c_date)) {
            JOptionPane.showMessageDialog(null, "Due date cannot be earlier than the start date.");
            return;
        }

        // Check if the start date is after the due date
        if (c_date.after(c_duedate)) {
            JOptionPane.showMessageDialog(null, "Start date cannot be after the due date.");
            return;
        }

        java.sql.Date sqlc_date = new java.sql.Date(c_date.getTime());
        java.sql.Date sqlc_duedate = new java.sql.Date(c_duedate.getTime());
        Session session = Session.getInstance();
        int creatorId = session.getId();
        String creatorName = session.getFn();
        String u_fn = creatorName != null ? creatorName : "Unknown";
        dbConnector db = new dbConnector();

        try {
            // Get Project ID based on project name
            String getPidQuery = "SELECT p_id FROM tbl_projects WHERE p_name = ?";
            int p_id = -1;
            try (PreparedStatement pst = db.connect.prepareStatement(getPidQuery)) {
                pst.setString(1, p_name);
                ResultSet rs = pst.executeQuery();
                if (rs.next()) {
                    p_id = rs.getInt("p_id");
                } else {
                    JOptionPane.showMessageDialog(null, "Project not found.");
                    return;
                }
            }

            // Get the assigned user
            String assignUser = (String)  assignner.getSelectedItem();
            String userAssign = (assignUser != null && !assignUser.trim().isEmpty() && !assignUser.equals("Select User")) ? assignUser : "";

            if (!userAssign.isEmpty()) {
                // Check if the assigned user exists in the tbl_users table
                String checkUserQuery = "SELECT COUNT(*) FROM tbl_user WHERE u_fn = ?";
                try (PreparedStatement pst = db.connect.prepareStatement(checkUserQuery)) {
                    pst.setString(1, userAssign);
                    ResultSet rs = pst.executeQuery();
                    if (!rs.next() || rs.getInt(1) == 0) {
                        JOptionPane.showMessageDialog(null, "Assigned user does not exist.");
                        return;
                    }
                }
            }

            // Insert the new task into tbl_task
            String insertQuery = "INSERT INTO tbl_client (p_id, u_id, p_name, u_fn, worker_assign, c_date, c_duedate,c_gender,c_email ,c_status, accept,approval) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?,?,?,?)";
            try (PreparedStatement pstInsert = db.connect.prepareStatement(insertQuery)) {
                pstInsert.setInt(1, p_id);
                pstInsert.setInt(2, creatorId);
                pstInsert.setString(3, p_name);
                pstInsert.setString(4, u_fn);
                pstInsert.setString(5, userAssign);
                pstInsert.setDate(6, sqlc_date);
                pstInsert.setDate(7, sqlc_duedate);
                pstInsert.setString(8, c_gender);
                pstInsert.setString(9, c_email);
                pstInsert.setString(10, c_status);
                

                if (!userAssign.isEmpty()) {
                    pstInsert.setString(11, "Accepted");
                     pstInsert.setString(12, "Pending"); // Or another status
                } else {
                    pstInsert.setNull(11, java.sql.Types.VARCHAR);
                    pstInsert.setString(12, "Pending");
                }

                int rowsAffected = pstInsert.executeUpdate();
                if (rowsAffected > 0) {
                    JOptionPane.showMessageDialog(null, "Client added successfully!");
                } else {
                    JOptionPane.showMessageDialog(null, "Error adding task.");
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Database error: " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                if (db.connect != null && !db.connect.isClosed()) {
                    db.connect.close();
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error closing database connection: " + e.getMessage());
            }
        }

    }//GEN-LAST:event_AddActionPerformed

    private void EmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EmailActionPerformed

    private void cstatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cstatusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cstatusActionPerformed

    private void assignnerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_assignnerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_assignnerActionPerformed

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        clientproject cp = new clientproject();
        cp.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel7MouseClicked

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

                    remove.setVisible(true);
                }
            } catch (Exception ex) {
                System.out.println("File Error!");
            }
        }
    }//GEN-LAST:event_selectActionPerformed

    private void removeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_removeActionPerformed

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
            java.util.logging.Logger.getLogger(createclient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(createclient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(createclient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(createclient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new createclient().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton Add;
    public javax.swing.JTextField Email;
    public javax.swing.JComboBox<String> Gender;
    protected javax.swing.JComboBox<String> assignner;
    public javax.swing.JTextField budget;
    public javax.swing.JTextField cid;
    private javax.swing.JPanel client;
    public javax.swing.JTextField clients;
    private javax.swing.JPanel contact;
    public javax.swing.JComboBox<String> cstatus;
    public com.toedter.calendar.JDateChooser date;
    public com.toedter.calendar.JDateChooser duedate;
    public javax.swing.JTextField fn;
    public javax.swing.JLabel image;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    public javax.swing.JComboBox<String> pname;
    public javax.swing.JButton remove;
    public javax.swing.JButton select;
    public javax.swing.JTextField uid;
    public javax.swing.JButton update;
    // End of variables declaration//GEN-END:variables
}
