/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin;


import LoginForm.loginform;
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
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.stage.FileChooser;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;


/**
 *
 * @author davetupas
 */
public class createadmin extends javax.swing.JFrame {

      public String username , email;
      
    public createadmin() {
      
        initComponents();
        
        
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

    
    
public boolean duplicateCheck(){
    dbConnector dbc = new dbConnector();
    try{
        String query = "SELECT * FROM tbl_user WHERE u_username='"+un.getText()+"' OR u_email ='"+em.getText()+"'";
        ResultSet resultSet = dbc.getData(query);
        try {
            resultSet = dbc.getData(query);
        } catch (SQLException ex) {
            Logger.getLogger(createadmin.class.getName()).log(Level.SEVERE, null, ex);
        }
            if(resultSet.next()){
                username = resultSet.getString("u_username");
                        if(username.equals(un.getText())){
                            JOptionPane.showMessageDialog(null, "Username is Already Active!");
                            un.setText("");
                        }
                        email = resultSet.getString("u_email");
                                if(email.equals(em.getText())){
                                    JOptionPane.showMessageDialog(null, "Email is Already Used!");
                                    em.setText("");
                                }
                                return true;
                     }else{
                return false;
                
        
    }
        } catch (SQLException ex) {
            Logger.getLogger(createadmin.class.getName()).log(Level.SEVERE, null, ex);
        }
            return false;
                }
    public boolean UpdateCheck(){
    dbConnector dbc = new dbConnector();
    try{
        String query = "SELECT * FROM tbl_user WHERE (u_username='"+un.getText()+"' OR u_email ='"+em.getText()+"')AND u_id=!'"+uid.getText()+"'";
        ResultSet resultSet = dbc.getData(query);
        try {
            resultSet = dbc.getData(query);
        } catch (SQLException ex) {
            Logger.getLogger(createadmin.class.getName()).log(Level.SEVERE, null, ex);
        }
            if(resultSet.next()){
                username = resultSet.getString("u_username");
                        if(username.equals(un.getText())){
                            JOptionPane.showMessageDialog(null, "Username is Already Active!");
                            un.setText("");
                        }
                        email = resultSet.getString("u_email");
                                if(email.equals(em.getText())){
                                    JOptionPane.showMessageDialog(null, "Email is Already Used!");
                                    em.setText("");
                                }
                                return true;
                     }else{
                return false;
                
        
    }
        } catch (SQLException ex) {
            Logger.getLogger(createadmin.class.getName()).log(Level.SEVERE, null, ex);
        }
            return false;
                }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        fn = new javax.swing.JTextField();
        mdn = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        ln = new javax.swing.JTextField();
        un = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        gender = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        type = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        us = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        em = new javax.swing.JTextField();
        contact = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        remove = new javax.swing.JButton();
        select = new javax.swing.JButton();
        uid = new javax.swing.JTextField();
        pass = new javax.swing.JPasswordField();
        jLabel7 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        image = new javax.swing.JLabel();
        Add = new javax.swing.JButton();
        update = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        cancel = new javax.swing.JButton();

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
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 517, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 153, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 670));

        jPanel2.setBackground(new java.awt.Color(153, 153, 255));

        jPanel3.setBackground(new java.awt.Color(153, 153, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setText("    Admin id");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3.setText("FirstName");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        jLabel4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel4.setText("MiddleName:");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 97, -1, -1));

        fn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fnActionPerformed(evt);
            }
        });
        jPanel3.add(fn, new org.netbeans.lib.awtextra.AbsoluteConstraints(98, 44, 260, 35));

        mdn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mdnActionPerformed(evt);
            }
        });
        jPanel3.add(mdn, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 87, 258, 35));

        jLabel5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel5.setText("LastName:");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, -1, -1));
        jPanel3.add(ln, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 140, 258, 35));

        un.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                unActionPerformed(evt);
            }
        });
        jPanel3.add(un, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 184, 258, 35));

        jLabel6.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel6.setText("Username:");
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, -1, -1));

        jLabel10.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel10.setText("Gender:");
        jPanel3.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 391, -1, -1));

        gender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "select", "male", "female" }));
        jPanel3.add(gender, new org.netbeans.lib.awtextra.AbsoluteConstraints(99, 379, 258, 38));

        jLabel11.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel11.setText("Type Acc:");
        jPanel3.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 328, -1, 31));

        type.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        type.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECT", "admin", "employee", "client" }));
        type.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                typeActionPerformed(evt);
            }
        });
        jPanel3.add(type, new org.netbeans.lib.awtextra.AbsoluteConstraints(99, 323, 258, 38));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setText("Admin Status");
        jPanel3.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 477, -1, 31));

        us.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "active", "In_active", "available" }));
        us.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usActionPerformed(evt);
            }
        });
        jPanel3.add(us, new org.netbeans.lib.awtextra.AbsoluteConstraints(99, 477, 258, 38));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setText("Email:");
        jPanel3.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 435, -1, -1));
        jPanel3.add(em, new org.netbeans.lib.awtextra.AbsoluteConstraints(99, 426, 258, 35));

        contact.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                contactActionPerformed(evt);
            }
        });
        jPanel3.add(contact, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 279, 258, 35));

        jLabel8.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel8.setText("ContactN");
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 289, -1, -1));

        remove.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        remove.setText("Remove");
        remove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeActionPerformed(evt);
            }
        });
        jPanel3.add(remove, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 330, -1, 40));

        select.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        select.setText("Select");
        select.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectActionPerformed(evt);
            }
        });
        jPanel3.add(select, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 330, 110, 38));

        uid.setEnabled(false);
        jPanel3.add(uid, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 0, 260, 35));
        jPanel3.add(pass, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 235, 258, 35));

        jLabel7.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel7.setText("Password");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, -1, -1));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(image, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(image, javax.swing.GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel3.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 90, -1, -1));

        Add.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        Add.setText("ADD");
        Add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddActionPerformed(evt);
            }
        });

        update.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        update.setText("UPDATE");
        update.setDoubleBuffered(true);
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jButton3.setText("DELETE");

        jButton4.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jButton4.setText("REFRESH");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jButton5.setText("CLEAR");

        cancel.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        cancel.setText("CANCEL");
        cancel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cancelMouseClicked(evt);
            }
        });
        cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(Add, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(update)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3)
                        .addGap(23, 23, 23)
                        .addComponent(jButton4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cancel)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 780, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Add, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(update, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 524, Short.MAX_VALUE)
                .addGap(39, 39, 39))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 0, 810, 670));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddActionPerformed
        if(fn.getText().isEmpty()&&mdn.getText().isEmpty()&&ln.getText().isEmpty()&&un.getText().isEmpty()&&pass.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "All fields are required!");
        }else if(pass.getText().length()<8){
            JOptionPane.showMessageDialog(null, "Password character should be 8 above!");
            pass.setText("");
        }else if(duplicateCheck()){
            System.out.println("Duplicate Exist");
        }else{
            try{
            dbConnector dbc = new dbConnector();
             String password = passwordHasher.hashPassword(pass.getText());
            dbc.insertData("INSERT INTO tbl_user(u_fn,u_middle,u_ln,u_username,u_Contact,u_password,u_type,u_gender,u_email,u_status,u_image)"+
                "VALUES('"+fn.getText()+"','"+mdn.getText()+"','"+ln.getText()+"','"+un.getText()+"','"+contact.getText()+"','"+password+"','"+type.getSelectedItem()+"','"+gender.getSelectedItem()+"','"+
                em.getText()+"','"+us.getSelectedItem()+"','"+destination+"')");

            try{
                Files.copy(selectedFile.toPath(),new File(destination).toPath(),StandardCopyOption.REPLACE_EXISTING);
                JOptionPane.showMessageDialog(null, "Register Success!");
                adminform af = new adminform();
                af.setVisible(true);
                this.dispose();

            }catch(IOException ex){
                System.out.println("Insert image Error:"+ ex);
            
            

            }     JOptionPane.showMessageDialog(null, "Connection Error!");

        } catch (NoSuchAlgorithmException ex) {
               System.out.println(""+ ex);
        }
        }
    }//GEN-LAST:event_AddActionPerformed

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
        if(fn.getText().isEmpty()&&mdn.getText().isEmpty()&&ln.getText().isEmpty()&&un.getText().isEmpty()&&pass.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "All fields are required!");
        }else if(pass.getText().length()<8){
            JOptionPane.showMessageDialog(null, "Password character should be 8 above!");
            pass.setText("");
        }else if(UpdateCheck()){
            System.out.println("Duplicate Exist");
        }else{
    

        }
           try {

        dbConnector dbc = new dbConnector();
         String password = passwordHasher.hashPassword(pass.getText());
        dbc.insertData(" UPDATE tbl_user SET u_fn = '"
            +fn.getText()+"', u_middle ='"+mdn.getText()+"',u_ln = '"+ln.getText()+"',u_username ='"+un.getText()+"',u_contact ='"+contact.getText()+"',u_password = '"+password+"', u_type ='"+type.getSelectedItem()+"',u_gender = '"+gender.getSelectedItem()+"',u_status='"+us.getSelectedItem()
            +"',u_image='"+destination+"' WHERE u_id ='"+uid.getText()+"'");
        JOptionPane.showMessageDialog(null, "Update Successfuly!");
        
          } catch (NoSuchAlgorithmException ex) {
               System.out.println(""+ ex);
          }
        adminform af = new adminform();
        af.setVisible(true);
        this.dispose();
                
    }//GEN-LAST:event_updateActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
          Session sess = Session.getInstance();
      
      if(sess.getId()==0){
          JOptionPane.showMessageDialog(null,"No Account. Login First!");
          loginform lf = new loginform();
          lf.setVisible(true);
          this.dispose();
      }else{
          pass.setText("");
          em.setText(""+sess.getEmail());
          uid.setText(""+sess.getId());
           
           
      }   
        
    }//GEN-LAST:event_formWindowActivated

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

    private void contactActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_contactActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_contactActionPerformed

    private void usActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usActionPerformed

    private void typeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_typeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_typeActionPerformed

    private void unActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_unActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_unActionPerformed

    private void fnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fnActionPerformed

    private void mdnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mdnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mdnActionPerformed

    private void cancelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelMouseClicked
        adminform a = new adminform();
          JOptionPane.showMessageDialog(null, "Back to admin Form!");
        a.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_cancelMouseClicked

    private void removeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeActionPerformed
     remove.setEnabled(false);
     select.setEnabled(true);
     image.setIcon(null);
      destination ="";
path ="";

    }//GEN-LAST:event_removeActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cancelActionPerformed

    
     
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
            java.util.logging.Logger.getLogger(createadmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(createadmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(createadmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(createadmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new createadmin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton Add;
    private javax.swing.JButton cancel;
    public javax.swing.JTextField contact;
    public javax.swing.JTextField em;
    public javax.swing.JTextField fn;
    public javax.swing.JComboBox<String> gender;
    public javax.swing.JLabel image;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    public javax.swing.JTextField ln;
    public javax.swing.JTextField mdn;
    public javax.swing.JPasswordField pass;
    public javax.swing.JButton remove;
    public javax.swing.JButton select;
    protected javax.swing.JComboBox<String> type;
    public javax.swing.JTextField uid;
    public javax.swing.JTextField un;
    public javax.swing.JButton update;
    public javax.swing.JComboBox<String> us;
    // End of variables declaration//GEN-END:variables
}
