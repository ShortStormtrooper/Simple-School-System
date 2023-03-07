/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Admin;

import JavaApp.Obligations;
import JavaApp.Student;
import static Admin.AdminFrame.WriteStudent;
import static JavaApp.LogInFrame.Student;
import static JavaApp.LogInFrame.arrayObligations;
import static JavaApp.LogInFrame.counterObligations;
import static JavaApp.LogInFrame.counterStudent;
import static JavaApp.LogInFrame.finalGrade;
import static JavaApp.LogInFrame.finalGradeCounter;
import static JavaApp.LogInFrame.returnCounterStudent;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author Samardzija Njegos
 */
public class AddStudent extends javax.swing.JFrame {

    /**
     * Creates new form AddStudent
     */
    public AddStudent() {
        initComponents();
        setBackground(new Color(0,0,0,0));
        
        errTextID.setText(" ");
        errTextName.setText(" ");
        errTextUsername.setText(" ");
        errTextPass.setText(" ");
        errTextYear.setText(" ");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        newJPanel1 = new AddOns.TransparentPanel();
        addStudentLabel = new javax.swing.JLabel();
        studentNameTextField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        studentUsernameTextField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        studentIDTextField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        studentYearTextField = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        studentPassTextField = new javax.swing.JTextField();
        exit = new AddOns.ProfilePicture();
        addStudentBtn = new AddOns.MyButton();
        errTextID = new javax.swing.JLabel();
        errTextName = new javax.swing.JLabel();
        errTextUsername = new javax.swing.JLabel();
        errTextPass = new javax.swing.JLabel();
        errTextYear = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        newJPanel1.setBackground(new java.awt.Color(87, 87, 87));

        addStudentLabel.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        addStudentLabel.setForeground(new java.awt.Color(255, 255, 255));
        addStudentLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        addStudentLabel.setText("Add Student");

        studentNameTextField.setBackground(new java.awt.Color(87, 87, 87));
        studentNameTextField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        studentNameTextField.setForeground(new java.awt.Color(255, 255, 255));
        studentNameTextField.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        studentNameTextField.setSelectedTextColor(new java.awt.Color(87, 87, 87));
        studentNameTextField.setSelectionColor(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Student name:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Student username:");

        studentUsernameTextField.setBackground(new java.awt.Color(87, 87, 87));
        studentUsernameTextField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        studentUsernameTextField.setForeground(new java.awt.Color(255, 255, 255));
        studentUsernameTextField.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        studentUsernameTextField.setSelectedTextColor(new java.awt.Color(87, 87, 87));
        studentUsernameTextField.setSelectionColor(new java.awt.Color(255, 255, 255));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Student ID:");

        studentIDTextField.setBackground(new java.awt.Color(87, 87, 87));
        studentIDTextField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        studentIDTextField.setForeground(new java.awt.Color(255, 255, 255));
        studentIDTextField.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        studentIDTextField.setSelectedTextColor(new java.awt.Color(87, 87, 87));
        studentIDTextField.setSelectionColor(new java.awt.Color(255, 255, 255));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Student password:");

        studentYearTextField.setBackground(new java.awt.Color(87, 87, 87));
        studentYearTextField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        studentYearTextField.setForeground(new java.awt.Color(255, 255, 255));
        studentYearTextField.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        studentYearTextField.setSelectedTextColor(new java.awt.Color(87, 87, 87));
        studentYearTextField.setSelectionColor(new java.awt.Color(255, 255, 255));
        studentYearTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                studentYearTextFieldActionPerformed(evt);
            }
        });
        studentYearTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                studentYearTextFieldKeyTyped(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Study year:");

        studentPassTextField.setBackground(new java.awt.Color(87, 87, 87));
        studentPassTextField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        studentPassTextField.setForeground(new java.awt.Color(255, 255, 255));
        studentPassTextField.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        studentPassTextField.setSelectedTextColor(new java.awt.Color(87, 87, 87));
        studentPassTextField.setSelectionColor(new java.awt.Color(255, 255, 255));
        studentPassTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                studentPassTextFieldActionPerformed(evt);
            }
        });

        exit.setBackground(new java.awt.Color(67, 67, 67));
        exit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/turn-off.png"))); // NOI18N
        exit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exitMouseClicked(evt);
            }
        });

        addStudentBtn.setText("Add Student");
        addStudentBtn.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        addStudentBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addStudentBtnActionPerformed(evt);
            }
        });

        errTextID.setForeground(java.awt.Color.red);
        errTextID.setText("jLabel7");

        errTextName.setForeground(java.awt.Color.red);
        errTextName.setText("jLabel8");

        errTextUsername.setForeground(java.awt.Color.red);
        errTextUsername.setText("jLabel9");

        errTextPass.setForeground(java.awt.Color.red);
        errTextPass.setText("jLabel10");

        errTextYear.setForeground(java.awt.Color.red);
        errTextYear.setText("jLabel11");

        javax.swing.GroupLayout newJPanel1Layout = new javax.swing.GroupLayout(newJPanel1);
        newJPanel1.setLayout(newJPanel1Layout);
        newJPanel1Layout.setHorizontalGroup(
            newJPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(newJPanel1Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(newJPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(newJPanel1Layout.createSequentialGroup()
                        .addComponent(errTextYear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(newJPanel1Layout.createSequentialGroup()
                        .addComponent(errTextID, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, newJPanel1Layout.createSequentialGroup()
                        .addGroup(newJPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(errTextPass, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(errTextUsername, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(errTextName, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(studentIDTextField, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(studentUsernameTextField, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(studentNameTextField)
                            .addComponent(studentPassTextField, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(studentYearTextField, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, newJPanel1Layout.createSequentialGroup()
                                .addGroup(newJPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(exit, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel6))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, newJPanel1Layout.createSequentialGroup()
                                .addGap(0, 107, Short.MAX_VALUE)
                                .addComponent(addStudentBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 107, Short.MAX_VALUE))
                            .addComponent(addStudentLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(8, 8, 8))))
        );
        newJPanel1Layout.setVerticalGroup(
            newJPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(newJPanel1Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(exit, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(addStudentLabel)
                .addGap(40, 40, 40)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(studentIDTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(errTextID)
                .addGap(17, 17, 17)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(studentNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(errTextName)
                .addGap(17, 17, 17)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(studentUsernameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(errTextUsername)
                .addGap(17, 17, 17)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(studentPassTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(errTextPass)
                .addGap(17, 17, 17)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(studentYearTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(errTextYear)
                .addGap(17, 17, 17)
                .addComponent(addStudentBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(newJPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(newJPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void studentPassTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_studentPassTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_studentPassTextFieldActionPerformed

    private void exitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitMouseClicked
        dispose();
    }//GEN-LAST:event_exitMouseClicked

    private void addStudentBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addStudentBtnActionPerformed
        String id = studentIDTextField.getText().trim();
        String name = studentNameTextField.getText().trim();
        String username = studentUsernameTextField.getText().trim();
        String pass = studentPassTextField.getText();
        String year = studentYearTextField.getText().trim();
        byte[] data = null;
        BufferedImage bImage = null;
        boolean found = false;
        
        errTextID.setText(" ");
        errTextName.setText(" ");
        errTextUsername.setText(" ");
        errTextPass.setText(" ");
        errTextYear.setText(" ");
        
        try {
            File fi = new File("/Icons/user.png");
            bImage = ImageIO.read(getClass().getResource("/Icons/user.png"));
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ImageIO.write(bImage, "png", bos );
            data = bos.toByteArray();
        } catch (IOException ex) {
            Logger.getLogger(AddStudent.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(id.isEmpty()){
            found = true;
            errTextID.setText("ID not entered!");
        }
        if(username.isEmpty()){
            found = true;
            errTextUsername.setText("Username not entered!");
        } 
        if(name.isEmpty()){
            found = true;
            errTextName.setText("Name not entered!");
        }
        if(!name.contains(" ")){
            found = true;
            errTextName.setText("Name not entered correctly!");
        }
        if(pass.isEmpty() || pass.equals(" ")){
            found = true;
            errTextPass.setText("Password not entered!");
        }
        if(!year.equals("1") && !year.equals("2") && !year.equals("3")){
            found = true;
            System.out.println(year);
            errTextYear.setText("Year must be 1, 2 or 3!");
        }
        
        for(int i = 0; i < counterStudent; i++){
            if(Student[i].getId().equals(id)){
                found = true;
                errTextID.setText("ID alredy exists!");
            }
            if(Student[i].getUsername().equals(username)){
                found = true;
                errTextUsername.setText("Username already exists!");
            }
        }
        
        if(found == false){
            Student[counterStudent] = new Student();
            Student[counterStudent].setId(id);
            Student[counterStudent].setName(name);
            Student[counterStudent].setUsername(username);
            Student[counterStudent].setPassword(pass);
            Student[counterStudent].setStudy_year(year);
            Student[counterStudent].setPicture(data);

            counterStudent++;

            returnCounterStudent(counterStudent);

            String newYearStudentID = "";
                found = false;
                for(int i = 0; i < counterStudent; i++){
                    if(Student[i].getStudy_year().equals(year) && found == false){
                        newYearStudentID = Student[i].getId();
                        found = true;
                    }
                }

                for(int i = 0; i < counterObligations; i++){
                    if(arrayObligations[i].getStudentID().equals(newYearStudentID)){
                        arrayObligations[counterObligations] = new Obligations();
                        arrayObligations[counterObligations].setStudentID(id);
                        arrayObligations[counterObligations].setSubjectName(arrayObligations[i].getSubjectName());
                        arrayObligations[counterObligations].setStudentName(name);
                        arrayObligations[counterObligations].setObligationType(arrayObligations[i].getObligationType());
                        arrayObligations[counterObligations].setObligationName(arrayObligations[i].getObligationName());
                        arrayObligations[counterObligations].setMaximumPoints(arrayObligations[i].getMaximumPoints());
                        arrayObligations[counterObligations].setScoredPoints(0);
                        arrayObligations[counterObligations].setPrecentage(0);
                        arrayObligations[counterObligations].setGrade(0);
                        counterObligations++;
                    }
                }

                for(int i = 0; i < finalGradeCounter; i+=3){
                    if(finalGrade[i+1].equals(newYearStudentID)){
                        finalGrade[finalGradeCounter] = finalGrade[i];
                        finalGradeCounter++;
                        finalGrade[finalGradeCounter] = id;
                        finalGradeCounter++;
                        finalGrade[finalGradeCounter] = "0";
                        finalGradeCounter++;
                    }
                }
            WriteStudent();     
            dispose();
        }
        
    }//GEN-LAST:event_addStudentBtnActionPerformed

    private void studentYearTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_studentYearTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_studentYearTextFieldActionPerformed

    private void studentYearTextFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_studentYearTextFieldKeyTyped
        char enteredChar = evt.getKeyChar();
        
        if(!Character.isDigit(enteredChar)){
            evt.consume();
        }
    }//GEN-LAST:event_studentYearTextFieldKeyTyped

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
            java.util.logging.Logger.getLogger(AddStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddStudent().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private AddOns.MyButton addStudentBtn;
    private javax.swing.JLabel addStudentLabel;
    private javax.swing.JLabel errTextID;
    private javax.swing.JLabel errTextName;
    private javax.swing.JLabel errTextPass;
    private javax.swing.JLabel errTextUsername;
    private javax.swing.JLabel errTextYear;
    private AddOns.ProfilePicture exit;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private AddOns.TransparentPanel newJPanel1;
    private javax.swing.JTextField studentIDTextField;
    private javax.swing.JTextField studentNameTextField;
    private javax.swing.JTextField studentPassTextField;
    private javax.swing.JTextField studentUsernameTextField;
    private javax.swing.JTextField studentYearTextField;
    // End of variables declaration//GEN-END:variables
}
