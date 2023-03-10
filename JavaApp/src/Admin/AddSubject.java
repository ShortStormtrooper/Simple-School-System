/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Admin;

import JavaApp.Subjects;
import static Admin.AdminFrame.WriteSubjects;
import static Admin.AdminFrame.returnCounterSubject;
import static Admin.AdminFrame.returnFinalCounter;
import static JavaApp.LogInFrame.Student;
import static JavaApp.LogInFrame.arraySubjects;
import static JavaApp.LogInFrame.counterProfessorAdmin;
import static JavaApp.LogInFrame.counterStudent;
import static JavaApp.LogInFrame.counterSubjects;
import static JavaApp.LogInFrame.finalGrade;
import static JavaApp.LogInFrame.finalGradeCounter;
import static JavaApp.LogInFrame.professorAdmin;
import java.awt.Color;

/**
 *
 * @author Samardzija Njegos
 */
public class AddSubject extends javax.swing.JFrame {

    /**
     * Creates new form AddSubjects
     */
    int year;
    boolean box1;
    boolean box2;
    boolean found = false;

    public AddSubject() {
        initComponents();
        setBackground(new Color(0, 0, 0, 0));

        for (int i = 0; i < counterProfessorAdmin; i++) {
            for (int j = 0; j < counterSubjects; j++) {
                if (arraySubjects[j].getProfessorID().equals(professorAdmin[i].getID())) {
                    found = true;
                }
            }
            if (found == false) {
                SubjectProfessorText.addItem(professorAdmin[i].getID() + " - " + professorAdmin[i].getName());
            }
            found = false;
        }

    }

    public void pass(int pass, boolean addBox1, boolean addBox2) {
        year = pass;
        box1 = addBox1;
        box2 = addBox2;

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jProgressBar1 = new javax.swing.JProgressBar();
        newJPanel1 = new AddOns.TransparentPanel();
        exit = new AddOns.ProfilePicture();
        jLabel16 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        SubjectIDText = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        SubjectNameText = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        SubjectProfessorText = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        SubjectSemesterText = new javax.swing.JTextField();
        AddSubjectBtn = new AddOns.MyButton();
        jLabel5 = new javax.swing.JLabel();
        SubjectYearText = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        SubjectEctsPointsText = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        SubjectObligationsText = new javax.swing.JTextArea();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("AddSubject");
        setBackground(new java.awt.Color(0, 204, 204));
        setUndecorated(true);

        newJPanel1.setBackground(new java.awt.Color(87, 87, 87));

        exit.setBackground(new java.awt.Color(67, 67, 67));
        exit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/turn-off.png"))); // NOI18N
        exit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exitMouseClicked(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("Add Subject");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Add Subject ID:");

        SubjectIDText.setBackground(new java.awt.Color(87, 87, 87));
        SubjectIDText.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        SubjectIDText.setForeground(new java.awt.Color(255, 255, 255));
        SubjectIDText.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        SubjectIDText.setSelectedTextColor(new java.awt.Color(87, 87, 87));
        SubjectIDText.setSelectionColor(new java.awt.Color(255, 255, 255));
        SubjectIDText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SubjectIDTextActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Add Subject Name:");

        SubjectNameText.setBackground(new java.awt.Color(87, 87, 87));
        SubjectNameText.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        SubjectNameText.setForeground(new java.awt.Color(255, 255, 255));
        SubjectNameText.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        SubjectNameText.setSelectedTextColor(new java.awt.Color(87, 87, 87));
        SubjectNameText.setSelectionColor(new java.awt.Color(255, 255, 255));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Add Subject Professor:");

        SubjectProfessorText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SubjectProfessorTextActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Add Subject Semester:");

        SubjectSemesterText.setBackground(new java.awt.Color(87, 87, 87));
        SubjectSemesterText.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        SubjectSemesterText.setForeground(new java.awt.Color(255, 255, 255));
        SubjectSemesterText.setToolTipText("");
        SubjectSemesterText.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        SubjectSemesterText.setSelectedTextColor(new java.awt.Color(87, 87, 87));
        SubjectSemesterText.setSelectionColor(new java.awt.Color(255, 255, 255));

        AddSubjectBtn.setText("Add Subject");
        AddSubjectBtn.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        AddSubjectBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddSubjectBtnActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Add Year:");

        SubjectYearText.setBackground(new java.awt.Color(87, 87, 87));
        SubjectYearText.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        SubjectYearText.setForeground(new java.awt.Color(255, 255, 255));
        SubjectYearText.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        SubjectYearText.setSelectedTextColor(new java.awt.Color(87, 87, 87));
        SubjectYearText.setSelectionColor(new java.awt.Color(255, 255, 255));
        SubjectYearText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                SubjectYearTextKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                SubjectYearTextKeyTyped(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Add Subject ECTS points:");

        SubjectEctsPointsText.setBackground(new java.awt.Color(87, 87, 87));
        SubjectEctsPointsText.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        SubjectEctsPointsText.setForeground(new java.awt.Color(255, 255, 255));
        SubjectEctsPointsText.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        SubjectEctsPointsText.setSelectedTextColor(new java.awt.Color(87, 87, 87));
        SubjectEctsPointsText.setSelectionColor(new java.awt.Color(255, 255, 255));
        SubjectEctsPointsText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SubjectEctsPointsTextActionPerformed(evt);
            }
        });
        SubjectEctsPointsText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                SubjectEctsPointsTextKeyTyped(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Add Subject Obligations:");

        jScrollPane1.setBorder(null);
        jScrollPane1.setFocusable(false);
        jScrollPane1.setRequestFocusEnabled(false);
        jScrollPane1.setVerifyInputWhenFocusTarget(false);

        SubjectObligationsText.setBackground(new java.awt.Color(87, 87, 87));
        SubjectObligationsText.setColumns(20);
        SubjectObligationsText.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        SubjectObligationsText.setForeground(new java.awt.Color(255, 255, 255));
        SubjectObligationsText.setRows(5);
        SubjectObligationsText.setAutoscrolls(false);
        SubjectObligationsText.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        SubjectObligationsText.setSelectedTextColor(new java.awt.Color(87, 87, 87));
        SubjectObligationsText.setSelectionColor(new java.awt.Color(255, 255, 255));
        jScrollPane1.setViewportView(SubjectObligationsText);

        jLabel9.setForeground(java.awt.Color.red);
        jLabel9.setText(" ");

        jLabel10.setForeground(java.awt.Color.red);
        jLabel10.setText(" ");

        jLabel11.setForeground(java.awt.Color.red);
        jLabel11.setText(" ");
        jLabel11.setToolTipText("");

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setForeground(java.awt.Color.red);
        jLabel12.setText(" ");

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setForeground(java.awt.Color.red);
        jLabel13.setText(" ");

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel14.setForeground(java.awt.Color.red);
        jLabel14.setText(" ");

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel15.setForeground(java.awt.Color.red);
        jLabel15.setText(" ");

        javax.swing.GroupLayout newJPanel1Layout = new javax.swing.GroupLayout(newJPanel1);
        newJPanel1.setLayout(newJPanel1Layout);
        newJPanel1Layout.setHorizontalGroup(
            newJPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(newJPanel1Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(exit, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(newJPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(AddSubjectBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(newJPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(newJPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(newJPanel1Layout.createSequentialGroup()
                        .addGroup(newJPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(SubjectProfessorText, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(SubjectNameText)
                            .addComponent(SubjectIDText)
                            .addComponent(SubjectSemesterText, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(newJPanel1Layout.createSequentialGroup()
                                .addGroup(newJPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel6))
                                .addGap(0, 231, Short.MAX_VALUE))
                            .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(newJPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(SubjectEctsPointsText, javax.swing.GroupLayout.DEFAULT_SIZE, 411, Short.MAX_VALUE)
                            .addComponent(jScrollPane1)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(SubjectYearText)
                            .addGroup(newJPanel1Layout.createSequentialGroup()
                                .addGroup(newJPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel8))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        newJPanel1Layout.setVerticalGroup(
            newJPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(newJPanel1Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(exit, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel16)
                .addGap(40, 40, 40)
                .addGroup(newJPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(newJPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SubjectIDText, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SubjectYearText, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(newJPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel12))
                .addGap(17, 17, 17)
                .addGroup(newJPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(newJPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SubjectNameText, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SubjectEctsPointsText, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(newJPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jLabel15))
                .addGap(16, 16, 16)
                .addGroup(newJPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(newJPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(newJPanel1Layout.createSequentialGroup()
                        .addComponent(SubjectProfessorText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel14)
                        .addGap(16, 16, 16)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(SubjectSemesterText, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(newJPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(newJPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(17, 17, 17)
                        .addComponent(AddSubjectBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel11))
                .addGap(40, 40, 40))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(newJPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(newJPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void SubjectEctsPointsTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SubjectEctsPointsTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SubjectEctsPointsTextActionPerformed

    private void SubjectIDTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SubjectIDTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SubjectIDTextActionPerformed

    private void exitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitMouseClicked
        dispose();
    }//GEN-LAST:event_exitMouseClicked

    private void AddSubjectBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddSubjectBtnActionPerformed
        jLabel9.setText(" ");
        jLabel10.setText(" ");
        jLabel11.setText(" ");
        jLabel12.setText(" ");
        jLabel13.setText(" ");
        jLabel14.setText(" ");
        jLabel15.setText(" ");

        boolean isValid = true, obligationsGood = false, semesterGood = false, yearGood = false, idGood = false, nameGood = false, professorGood = false, ectsGood = false;
        double allPoints = 0;
        String poljeAttribute[] = SubjectObligationsText.getText().split("\n");
        String[] temp = new String[10];
        int count = 0;

        if ("".equals(SubjectObligationsText.getText())) {
            isValid = false;
        } else {
            for (int j = 0; j < poljeAttribute.length; j++) {
                int str = poljeAttribute[j].lastIndexOf(" ");
                String strnew = poljeAttribute[j].substring(0, str);
                double strnew2 = Double.parseDouble(poljeAttribute[j].substring(str + 1));
                allPoints += strnew2;

            }

            if (allPoints != 100) {
                isValid = false;
            }
        }
        if ("1".equals(SubjectYearText.getText()) || "2".equals(SubjectYearText.getText()) || "3".equals(SubjectYearText.getText())) {
            jLabel9.setText(" ");
            yearGood = true;
        } else {
            jLabel9.setText("Year must be 1, 2 or 3!");
            yearGood = false;
        }
        if ("summer".equals(SubjectSemesterText.getText().trim().toLowerCase()) || "winter".equals(SubjectSemesterText.getText().trim().toLowerCase())) {
            jLabel10.setText(" ");
            semesterGood = true;
        } else {
            jLabel10.setText("Semester must be Winter or Summer!");
            semesterGood = false;
        }
        if (isValid == false) {
            jLabel11.setText("Obligations not entered correctly!");
            obligationsGood = false;
        } else {
            jLabel11.setText(" ");
            obligationsGood = true;
        }
        if ("".equals(SubjectIDText.getText()) || SubjectIDText.getText() == null) {
            jLabel12.setText("Subject ID not entered!");
            idGood = false;
        } else {
            if (counterSubjects > 0) {
                for (int i = 0; i < counterSubjects; i++) {
                    if (arraySubjects[i].getId().equals(SubjectIDText.getText())) {
                        jLabel12.setText("ID alredy exists!");
                        idGood = false;
                    } else {
                        jLabel12.setText(" ");
                        idGood = true;
                    }
                }

            } else {
                idGood = true;
            }

        }
        if ("".equals(SubjectNameText.getText()) || SubjectNameText.getText() == null) {
            jLabel13.setText("Subject name not entered!");
            nameGood = false;
        } else {
            if (counterSubjects > 0) {
                for (int i = 0; i < counterSubjects; i++) {
                    if (arraySubjects[i].getName().equals(SubjectNameText.getText())) {
                        jLabel13.setText("Name already exists!");
                        nameGood = false;
                    } else {
                        jLabel13.setText(" ");
                        nameGood = true;
                    }
                }

            } else {
                nameGood = true;
            }
        }
        if ("".equals(SubjectProfessorText.getSelectedItem().toString()) || SubjectProfessorText.getSelectedItem().toString() == null) {
            jLabel14.setText("Professor not entered!");
            professorGood = false;
        } else {
            jLabel14.setText(" ");
            professorGood = true;
        }
        if ("".equals(SubjectEctsPointsText.getText()) || SubjectYearText.getText() == null) {
            jLabel15.setText("ECTS points not entered!");
            ectsGood = false;
        } else {
            jLabel15.setText(" ");
            ectsGood = true;
        }
        if (obligationsGood == true && semesterGood == true && yearGood == true && idGood == true && nameGood == true && professorGood == true && ectsGood == true) {

            String[] professor = SubjectProfessorText.getSelectedItem().toString().split(" - ");

            arraySubjects[counterSubjects] = new Subjects();
            arraySubjects[counterSubjects].setId(SubjectIDText.getText());
            arraySubjects[counterSubjects].setName(SubjectNameText.getText());
            arraySubjects[counterSubjects].setProfessor(professor[1]);
            arraySubjects[counterSubjects].setProfessorID(professor[0]);
            arraySubjects[counterSubjects].setSemester(SubjectSemesterText.getText());
            arraySubjects[counterSubjects].setYear(Integer.parseInt(SubjectYearText.getText()));
            arraySubjects[counterSubjects].setEctsPoints(Integer.parseInt(SubjectEctsPointsText.getText()));
            arraySubjects[counterSubjects].setGrade(0);
            arraySubjects[counterSubjects].setNumberOfObligations(poljeAttribute.length);

            for (int j = 0; j < poljeAttribute.length; j++) {
                int str = poljeAttribute[j].lastIndexOf(" ");
                String strnew = poljeAttribute[j].substring(0, str);
                int strnew2 = Integer.parseInt(poljeAttribute[j].substring(str + 1));
                arraySubjects[counterSubjects].setObligations(strnew, strnew2, j + 1);
            }

            for (int i = 0; i < counterStudent; i++) {
                if (Student[i].getStudy_year().equals(SubjectYearText.getText())) {
                    finalGrade[finalGradeCounter] = SubjectIDText.getText();
                    finalGradeCounter++;
                    finalGrade[finalGradeCounter] = Student[i].getId();
                    finalGradeCounter++;
                    finalGrade[finalGradeCounter] = "0";
                    finalGradeCounter++;

                }
            }

            counterSubjects++;
            returnFinalCounter(finalGradeCounter);
            returnCounterSubject(counterSubjects);
            WriteSubjects();
            dispose();
        }
    }//GEN-LAST:event_AddSubjectBtnActionPerformed

    private void SubjectProfessorTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SubjectProfessorTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SubjectProfessorTextActionPerformed

    private void SubjectEctsPointsTextKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SubjectEctsPointsTextKeyTyped
        char enteredChar = evt.getKeyChar();

        if (!Character.isDigit(enteredChar)) {
            evt.consume();
        }
    }//GEN-LAST:event_SubjectEctsPointsTextKeyTyped

    private void SubjectYearTextKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SubjectYearTextKeyTyped
        char enteredChar = evt.getKeyChar();

        if (!Character.isDigit(enteredChar)) {
            evt.consume();
        }
    }//GEN-LAST:event_SubjectYearTextKeyTyped

    private void SubjectYearTextKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SubjectYearTextKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_SubjectYearTextKeyPressed

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
            java.util.logging.Logger.getLogger(AddSubject.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddSubject.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddSubject.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddSubject.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddSubject().setVisible(true);
            }
        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private AddOns.MyButton AddSubjectBtn;
    private javax.swing.JTextField SubjectEctsPointsText;
    private javax.swing.JTextField SubjectIDText;
    private javax.swing.JTextField SubjectNameText;
    private javax.swing.JTextArea SubjectObligationsText;
    private javax.swing.JComboBox<String> SubjectProfessorText;
    private javax.swing.JTextField SubjectSemesterText;
    private javax.swing.JTextField SubjectYearText;
    private AddOns.ProfilePicture exit;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private AddOns.TransparentPanel newJPanel1;
    // End of variables declaration//GEN-END:variables
}
