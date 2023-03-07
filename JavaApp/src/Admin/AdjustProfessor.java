/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Admin;

import static Admin.AdminFrame.WriteProfessor;
import static JavaApp.LogInFrame.arrayObligations;
import static JavaApp.LogInFrame.arraySubjects;
import static JavaApp.LogInFrame.counterObligations;
import static JavaApp.LogInFrame.counterProfessorAdmin;
import static JavaApp.LogInFrame.counterSubjects;
import static JavaApp.LogInFrame.professorAdmin;
import java.awt.Color;

/**
 *
 * @author Samardzija Njegos
 */
public class AdjustProfessor extends javax.swing.JFrame {

    /**
     * Creates new form AdjustProfessor
     */
    public AdjustProfessor() {
        initComponents();
        setBackground(new Color(0, 0, 0, 0));

        errTextID.setText(" ");
        errTextName.setText(" ");
        errTextUsername.setText(" ");
        errTextPass.setText(" ");
    }

    static String id;
    static String name;
    static String username;
    static String pass;

    public static void pass(String studentId, String studentName, String studentUsername, String studentPass) {
        id = studentId;
        name = studentName;
        username = studentUsername;
        pass = studentPass;

        professorIDTextField.setText(id);
        professorNameTextField.setText(name);
        professorUsernameTextField.setText(username);
        professorPassTextField.setText(pass);

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
        exit = new AddOns.ProfilePicture();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        professorIDTextField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        professorNameTextField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        professorUsernameTextField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        professorPassTextField = new javax.swing.JTextField();
        adjustProfessorBtn = new AddOns.MyButton();
        errTextID = new javax.swing.JLabel();
        errTextName = new javax.swing.JLabel();
        errTextUsername = new javax.swing.JLabel();
        errTextPass = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        newJPanel1.setBackground(new java.awt.Color(87, 87, 87));

        exit.setBackground(new java.awt.Color(67, 67, 67));
        exit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/turn-off.png"))); // NOI18N
        exit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exitMouseClicked(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Adjust Professor");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Professor ID:");

        professorIDTextField.setBackground(new java.awt.Color(87, 87, 87));
        professorIDTextField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        professorIDTextField.setForeground(new java.awt.Color(255, 255, 255));
        professorIDTextField.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        professorIDTextField.setSelectedTextColor(new java.awt.Color(87, 87, 87));
        professorIDTextField.setSelectionColor(new java.awt.Color(255, 255, 255));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Professor name:");

        professorNameTextField.setBackground(new java.awt.Color(87, 87, 87));
        professorNameTextField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        professorNameTextField.setForeground(new java.awt.Color(255, 255, 255));
        professorNameTextField.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        professorNameTextField.setSelectedTextColor(new java.awt.Color(87, 87, 87));
        professorNameTextField.setSelectionColor(new java.awt.Color(255, 255, 255));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Professor username");

        professorUsernameTextField.setBackground(new java.awt.Color(87, 87, 87));
        professorUsernameTextField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        professorUsernameTextField.setForeground(new java.awt.Color(255, 255, 255));
        professorUsernameTextField.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        professorUsernameTextField.setSelectedTextColor(new java.awt.Color(87, 87, 87));
        professorUsernameTextField.setSelectionColor(new java.awt.Color(255, 255, 255));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Professor password");

        professorPassTextField.setBackground(new java.awt.Color(87, 87, 87));
        professorPassTextField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        professorPassTextField.setForeground(new java.awt.Color(255, 255, 255));
        professorPassTextField.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        professorPassTextField.setSelectedTextColor(new java.awt.Color(87, 87, 87));
        professorPassTextField.setSelectionColor(new java.awt.Color(255, 255, 255));

        adjustProfessorBtn.setText("Adjust Professor");
        adjustProfessorBtn.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        adjustProfessorBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adjustProfessorBtnActionPerformed(evt);
            }
        });

        errTextID.setForeground(java.awt.Color.red);
        errTextID.setText("jLabel6");

        errTextName.setForeground(java.awt.Color.red);
        errTextName.setText("jLabel7");

        errTextUsername.setForeground(java.awt.Color.red);
        errTextUsername.setText("jLabel8");

        errTextPass.setForeground(java.awt.Color.red);
        errTextPass.setText("jLabel9");

        javax.swing.GroupLayout newJPanel1Layout = new javax.swing.GroupLayout(newJPanel1);
        newJPanel1.setLayout(newJPanel1Layout);
        newJPanel1Layout.setHorizontalGroup(
            newJPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(newJPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(newJPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(newJPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(newJPanel1Layout.createSequentialGroup()
                        .addComponent(professorUsernameTextField)
                        .addContainerGap())))
            .addGroup(newJPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(adjustProfessorBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(newJPanel1Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(newJPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(newJPanel1Layout.createSequentialGroup()
                        .addGroup(newJPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(exit, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, newJPanel1Layout.createSequentialGroup()
                        .addGroup(newJPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(errTextID, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(professorIDTextField)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 384, Short.MAX_VALUE))
                        .addGap(8, 8, 8))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, newJPanel1Layout.createSequentialGroup()
                        .addGroup(newJPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(errTextName, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(professorNameTextField))
                        .addContainerGap())))
            .addGroup(newJPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(newJPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(professorPassTextField)
                    .addGroup(newJPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(errTextUsername, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(errTextPass, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        newJPanel1Layout.setVerticalGroup(
            newJPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, newJPanel1Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(exit, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addGap(40, 40, 40)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(professorIDTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(errTextID)
                .addGap(17, 17, 17)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(professorNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(errTextName)
                .addGap(17, 17, 17)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(professorUsernameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(errTextUsername)
                .addGap(17, 17, 17)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(professorPassTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(errTextPass)
                .addGap(17, 17, 17)
                .addComponent(adjustProfessorBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void exitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitMouseClicked
        dispose();
    }//GEN-LAST:event_exitMouseClicked

    private void adjustProfessorBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adjustProfessorBtnActionPerformed
        String newId = professorIDTextField.getText();
        String newName = professorNameTextField.getText();
        String newUsername = professorUsernameTextField.getText();
        String newPass = professorPassTextField.getText();

        boolean found = false;

        if (newId.isEmpty()) {
            found = true;
            errTextID.setText("ID not entered!");
        }
        if (newUsername.isEmpty()) {
            found = true;
            errTextUsername.setText("Username not entered!");
        }

        if (newName.isEmpty()) {
            found = true;
            errTextName.setText("Name not entered!");
        }
        if (!newName.contains(" ")) {
            found = true;
            errTextName.setText("Name not entered correctly!");
        }
        if (newPass.isEmpty() || newPass.equals(" ")) {
            found = true;
            errTextPass.setText("Password not entered!");
        }

        for (int i = 0; i < counterProfessorAdmin; i++) {
            if (professorAdmin[i].getID().equals(newId) && !professorAdmin[i].getID().equals(id)) {
                found = true;
                errTextID.setText("ID alredy exists!");
            }
            if (professorAdmin[i].getUsername().equals(newUsername) && !professorAdmin[i].getID().equals(id)) {
                found = true;
                errTextUsername.setText("Username already exists!");
            }
        }
        if (found == false) {
            if (!newId.equals(id)) {
                for (int i = 0; i < counterProfessorAdmin; i++) {
                    if (professorAdmin[i].getID().equals(id)) {
                        professorAdmin[i].setID(newId);
                    }
                }

                for (int i = 0; i < counterSubjects; i++) {
                    if (arraySubjects[i].getProfessorID().equals(id)) {
                        arraySubjects[i].setProfessorID(newId);
                    }
                }
            }

            if (!newName.equals(name)) {
                for (int i = 0; i < counterProfessorAdmin; i++) {
                    if (professorAdmin[i].getName().equals(name)) {

                        professorAdmin[i].setName(newName);
                    }
                }

                for (int i = 0; i < counterSubjects; i++) {
                    if (arraySubjects[i].getProfessor().equals(name)) {
                        arraySubjects[i].setProfessor(newName);
                    }
                }
            }

            if (!newUsername.equals(username)) {
                for (int i = 0; i < counterProfessorAdmin; i++) {
                    if (professorAdmin[i].getUsername().equals(username)) {

                        professorAdmin[i].setUsername(newUsername);
                    }
                }
            }

            if (!newPass.equals(pass)) {
                for (int i = 0; i < counterProfessorAdmin; i++) {
                    if (professorAdmin[i].getPassword().equals(pass)) {

                        professorAdmin[i].setPassword(newPass);
                    }
                }
            }

            WriteProfessor();
            dispose();
        }

    }//GEN-LAST:event_adjustProfessorBtnActionPerformed

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
            java.util.logging.Logger.getLogger(AdjustProfessor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdjustProfessor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdjustProfessor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdjustProfessor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdjustProfessor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private AddOns.MyButton adjustProfessorBtn;
    private javax.swing.JLabel errTextID;
    private javax.swing.JLabel errTextName;
    private javax.swing.JLabel errTextPass;
    private javax.swing.JLabel errTextUsername;
    private AddOns.ProfilePicture exit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private AddOns.TransparentPanel newJPanel1;
    private static javax.swing.JTextField professorIDTextField;
    private static javax.swing.JTextField professorNameTextField;
    private static javax.swing.JTextField professorPassTextField;
    private static javax.swing.JTextField professorUsernameTextField;
    // End of variables declaration//GEN-END:variables
}
