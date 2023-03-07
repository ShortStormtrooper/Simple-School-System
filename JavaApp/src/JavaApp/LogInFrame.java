/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaApp;

import Admin.Professor;
import Admin.AdminFrame;
import java.awt.Color;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Samardzija Njegos
 */
public class LogInFrame extends javax.swing.JFrame {

    /**
     * Creates new form LogInFrame
     */
    public static ResultSet rst;
    public static Statement stm;
    public static Connection conn;

    public static String sql = "";

    public static String type;
    public boolean found = false;
    public static String CURRENT_USER_ID = "";

    public static byte[] imageData;
    public static String subject_ID_professor = "";
    public static String subject_name = "";

    public static int counterObligations = 0;
    public static int counterSubjects = 0;
    public static int counterObligationType = 0;
    public static int counterStudent = 0;
    public static int finalGradeCounter = 0;
    public static int counterType = 0;
    public static int counterProfessorAdmin = 0;
    public static int counterSubjectObligations = 0;

    public static Subjects arraySubjects[] = new Subjects[1000];
    public static Obligations arrayObligations[] = new Obligations[1000];
    public static String arrayObligationType[] = new String[1000];
    public static Student Student[] = new Student[1000];
    public static String finalGrade[] = new String[1000];
    public static String professorSubjectType[] = new String[1000];
    public static String subjectObligations[] = new String[1000];
    public static Professor professorAdmin[] = new Professor[100];

    public LogInFrame() {
        initComponents();
        setBackground(new Color(0, 0, 0, 0));
        counterType = 0;
        LogInForm.setBackground(new Color(0, 0, 0, 180));
        LogInName.setBackground(new Color(0, 0, 0, 0));
        LogInName.setSelectedTextColor(new Color(214, 0, 255, 180));
        LogInPass.setBackground(new Color(0, 0, 0, 0));
        LogInPass.setSelectedTextColor(new Color(214, 0, 255, 180));

        LogInErr.setText(" ");

    }

    public void Search(String type, Statement stm) throws SQLException, IOException {

        String log_in_pass = new String(LogInPass.getPassword());
        String log_in_username = LogInName.getText().toLowerCase();

        if (!type.equals("admin")) {

            sql = "SELECT * FROM " + type;
            rst = stm.executeQuery(sql);
            while (rst.next()) {

                String username = rst.getString("USERNAME");
                String pass = rst.getString("PASSWORD");
                String name = rst.getString("FULL_NAME");
                String[] full_name = name.split(" ");

                if (log_in_username.equals(username) && log_in_pass.equals(pass)) {

                    if (type.equals("student")) {

                        CURRENT_USER_ID = rst.getString("ID");

                        GetData(arraySubjects, arrayObligations);

                        MainFrame MainFramePanel = new MainFrame();
                        MainFramePanel.setVisible(true);

                        String new_name = "<html> <p style=' display: flex; justify-content: center; flex_direction: column; text-align: center;'>" + full_name[0].substring(0, 1).toUpperCase() + full_name[0].substring(1) + " " + full_name[1].substring(0, 1).toUpperCase() + full_name[1].substring(1) + "</p> </html>";
                        MainFrame.ProjectLabel.setText(new_name);
                        found = true;
                        dispose();

                    } else if (type.equals("professor")) {

                        CURRENT_USER_ID = rst.getString("ID");

                        GetDataOfStudent(arrayObligationType, arrayObligations);

                        MainFrame MainFramePanel = new MainFrame();
                        MainFramePanel.setVisible(true);

                        String new_name = "<html> <p style=' display: flex; justify-content: center; flex_direction: column; text-align: center;'>" + full_name[0].substring(0, 1).toUpperCase() + full_name[0].substring(1) + " " + full_name[1].substring(0, 1).toUpperCase() + full_name[1].substring(1) + "</p> </html>";
                        MainFrame.ProjectLabel.setText(new_name);
                        found = true;
                        dispose();
                    }
                } else {
                    LogInErr.setText("Invalid inputs! Please try again");
                }
            }

        } else {

            if (log_in_username.equals("admin") && log_in_pass.equals("admin")) {
                CURRENT_USER_ID = "ADMIN";

                getDataAdmin();

                found = true;

                AdminFrame AdminFramePanel = new AdminFrame();
                AdminFramePanel.setVisible(true);
                dispose();
            }

        }

    }

    public void getDataAdmin() throws SQLException {
        conn = DriverManager.getConnection("jdbc:mysql://localhost/javaproject", "root", "");
        stm = conn.createStatement();

        sql = "SELECT * FROM student";
        rst = stm.executeQuery(sql);

        while (rst.next()) {
            Student[counterStudent] = new Student();
            Student[counterStudent].setName(rst.getString("FULL_NAME"));
            Student[counterStudent].setId(rst.getString("ID"));
            Student[counterStudent].setStudy_year(rst.getString("STUDY_YEAR"));
            Student[counterStudent].setPassword(rst.getString("PASSWORD"));
            Student[counterStudent].setPicture(rst.getBytes("PICTURE"));
            Student[counterStudent].setUsername(rst.getString("USERNAME"));
            counterStudent++;

        }

        sql = "SELECT * FROM student_final_grade";
        rst = stm.executeQuery(sql);

        while (rst.next()) {
            finalGrade[finalGradeCounter] = rst.getString("SUBJECT_ID");
            finalGradeCounter++;

            finalGrade[finalGradeCounter] = rst.getString("STUDENT_ID");
            finalGradeCounter++;

            finalGrade[finalGradeCounter] = rst.getString("FINAL_GRADE");
            finalGradeCounter++;

        }

        sql = "SELECT * FROM obligation_student INNER JOIN student ON obligation_student.STUDENT_ID = student.ID";
        rst = stm.executeQuery(sql);

        while (rst.next()) {
            arrayObligations[counterObligations] = new Obligations();
            arrayObligations[counterObligations].setSubjectName(rst.getString("SUBJECT_ID"));
            arrayObligations[counterObligations].setObligationType(rst.getString("OBLIGATION_TYPE"));
            arrayObligations[counterObligations].setObligationName(rst.getString("OBLIGATION_NAME"));
            arrayObligations[counterObligations].setStudentName(rst.getString("FULL_NAME"));
            arrayObligations[counterObligations].setMaximumPoints(rst.getInt("MAXIMUM_POINTS"));
            arrayObligations[counterObligations].setScoredPoints(rst.getInt("SCORED_POINTS"));
            arrayObligations[counterObligations].setStudentID(rst.getString("STUDENT_ID"));
            arrayObligations[counterObligations].setGrade(rst.getInt("GRADE"));
            arrayObligations[counterObligations].setPrecentage(rst.getInt("GRADE_PRECENTAGE"));

            counterObligations++;
        }

        sql = "SELECT subject.PROFESSOR_ID, subject.ID, subject.SUBJECT_NAME, professor.FULL_NAME, subject.YEAR, subject.SEMESTER, subject.ECTS_POINTS FROM subject INNER JOIN professor ON subject.PROFESSOR_ID = professor.ID";
        rst = stm.executeQuery(sql);

        while (rst.next()) {
            arraySubjects[counterSubjects] = new Subjects();
            arraySubjects[counterSubjects].setId(rst.getString("ID"));
            arraySubjects[counterSubjects].setName(rst.getString("SUBJECT_NAME"));
            arraySubjects[counterSubjects].setProfessor(rst.getString("FULL_NAME"));
            arraySubjects[counterSubjects].setProfessorID(rst.getString("PROFESSOR_ID"));
            arraySubjects[counterSubjects].setYear(rst.getInt("YEAR"));
            arraySubjects[counterSubjects].setSemester(rst.getString("SEMESTER"));
            arraySubjects[counterSubjects].setEctsPoints(rst.getInt("ECTS_POINTS"));

            counterSubjects++;
        }

        sql = "SELECT * FROM obligation_subject INNER JOIN subject ON obligation_subject.SUBJECT_ID = subject.ID";
        rst = stm.executeQuery(sql);

        while (rst.next()) {
            String subject_name_for_student = rst.getString("SUBJECT_NAME");

            for (int i = 0; i < counterSubjects; i++) {

                if (subject_name_for_student.equals(arraySubjects[i].getName())) {

                    String type_of_obligation = rst.getString("OBLIGATION_TYPE");
                    int points_of_obligation = rst.getInt("POINTS_FOR_SUBJECT");

                    int numOfObligations = arraySubjects[i].getNumberOfObligations();

                    numOfObligations++;

                    arraySubjects[i].setNumberOfObligations(numOfObligations);
                    arraySubjects[i].setObligations(type_of_obligation, points_of_obligation, numOfObligations);
                }
            }
        }

        sql = "SELECT * FROM obligation_subject";
        rst = stm.executeQuery(sql);

        while (rst.next()) {

            subjectObligations[counterSubjectObligations] = rst.getString("OBLIGATION_TYPE");
            counterSubjectObligations++;
            subjectObligations[counterSubjectObligations] = rst.getString("POINTS_FOR_SUBJECT");
            counterSubjectObligations++;
            subjectObligations[counterSubjectObligations] = rst.getString("SUBJECT_ID");
            counterSubjectObligations++;

        }

        sql = "SELECT * FROM professor";
        rst = stm.executeQuery(sql);

        while (rst.next()) {

            professorAdmin[counterProfessorAdmin] = new Professor();
            professorAdmin[counterProfessorAdmin].setID(rst.getString("ID"));
            professorAdmin[counterProfessorAdmin].setName(rst.getString("FULL_NAME"));
            professorAdmin[counterProfessorAdmin].setPassword(rst.getString("PASSWORD"));
            professorAdmin[counterProfessorAdmin].setPicture(rst.getBytes("PICTURE"));
            professorAdmin[counterProfessorAdmin].setUsername(rst.getString("USERNAME"));
            counterProfessorAdmin++;

        }

    }

    public static void returnCounterStudent(int counter) {
        counterStudent = counter;
    }

    public static void returnCounterProfessor(int counter) {
        counterProfessorAdmin = counter;
    }

    public void GetData(Subjects[] subjectsArray, Obligations[] obligationsArray) throws SQLException, IOException {
        conn = DriverManager.getConnection("jdbc:mysql://localhost/javaproject", "root", "");
        stm = conn.createStatement();

        int studyYear = 0;

        sql = "SELECT * FROM student WHERE ID = '" + CURRENT_USER_ID + "'";
        rst = stm.executeQuery(sql);
        if (rst.next()) {
            studyYear = rst.getInt("STUDY_YEAR");
            imageData = rst.getBytes("PICTURE");

        }

        sql = "SELECT * FROM subject INNER JOIN professor ON subject.PROFESSOR_ID = professor.ID WHERE YEAR = " + studyYear;
        rst = stm.executeQuery(sql);

        while (rst.next()) {
            subjectsArray[counterSubjects] = new Subjects();
            subjectsArray[counterSubjects].setId(rst.getString("ID"));
            subjectsArray[counterSubjects].setName(rst.getString("SUBJECT_NAME"));
            subjectsArray[counterSubjects].setProfessor(rst.getString("FULL_NAME"));
            subjectsArray[counterSubjects].setYear(rst.getInt("YEAR"));
            subjectsArray[counterSubjects].setSemester(rst.getString("SEMESTER"));
            subjectsArray[counterSubjects].setEctsPoints(rst.getInt("ECTS_POINTS"));

            counterSubjects++;
        }

        sql = "SELECT * FROM student_final_grade INNER JOIN subject ON student_final_grade.SUBJECT_ID = subject.ID WHERE STUDENT_ID = '" + CURRENT_USER_ID + "'";
        rst = stm.executeQuery(sql);

        while (rst.next()) {
            String subject = rst.getString("SUBJECT_NAME");

            int grade;

            for (int i = 0; i < counterSubjects; i++) {
                if (subject.equals(subjectsArray[i].getName())) {
                    grade = rst.getInt("FINAL_GRADE");
                    subjectsArray[i].setGrade(grade);
                }
            }
        }

        sql = "SELECT * FROM obligation_subject INNER JOIN subject ON obligation_subject.SUBJECT_ID = subject.ID";
        rst = stm.executeQuery(sql);

        while (rst.next()) {
            String subject_name_for_student = rst.getString("SUBJECT_NAME");

            for (int i = 0; i < counterSubjects; i++) {

                if (subject_name_for_student.equals(subjectsArray[i].getName())) {

                    String type_of_obligation = rst.getString("OBLIGATION_TYPE");
                    int points_of_obligation = rst.getInt("POINTS_FOR_SUBJECT");

                    int numOfObligations = subjectsArray[i].getNumberOfObligations();

                    numOfObligations++;

                    subjectsArray[i].setNumberOfObligations(numOfObligations);
                    subjectsArray[i].setObligations(type_of_obligation, points_of_obligation, numOfObligations);
                }
            }
        }

        sql = "SELECT * FROM obligation_student INNER JOIN subject ON obligation_student.SUBJECT_ID = subject.ID WHERE STUDENT_ID = '" + CURRENT_USER_ID + "'";
        rst = stm.executeQuery(sql);
        while (rst.next()) {
            obligationsArray[counterObligations] = new Obligations();
            obligationsArray[counterObligations].setSubjectName(rst.getString("SUBJECT_NAME"));
            obligationsArray[counterObligations].setObligationType(rst.getString("OBLIGATION_TYPE"));
            obligationsArray[counterObligations].setObligationName(rst.getString("OBLIGATION_NAME"));
            obligationsArray[counterObligations].setMaximumPoints(rst.getInt("MAXIMUM_POINTS"));
            obligationsArray[counterObligations].setScoredPoints(rst.getInt("SCORED_POINTS"));
            obligationsArray[counterObligations].setPrecentage(rst.getInt("GRADE_PRECENTAGE"));
            obligationsArray[counterObligations].setGrade(rst.getInt("GRADE"));

            counterObligations++;
        }

    }

    public void GetDataOfStudent(String[] arrayObligationType, Obligations[] obligationsArray) throws SQLException {

        conn = DriverManager.getConnection("jdbc:mysql://localhost/javaproject", "root", "");
        stm = conn.createStatement();

        String obligationName;
        String obligationType;
        String finalObligation;

        counterObligations = 0;
        counterObligationType = 0;

        sql = "SELECT * FROM professor WHERE ID = '" + CURRENT_USER_ID + "'";
        rst = stm.executeQuery(sql);
        if (rst.next()) {
            imageData = rst.getBytes("PICTURE");

        }

        String sql = "SELECT ID FROM subject WHERE PROFESSOR_ID = '" + CURRENT_USER_ID + "'";
        rst = stm.executeQuery(sql);

        if (rst.next()) {
            subject_ID_professor = rst.getString("ID");
        }

        sql = "SELECT DISTINCT student.FULL_NAME, STUDENT_ID FROM student_final_grade INNER JOIN student ON student_final_grade.STUDENT_ID = student.ID WHERE SUBJECT_ID = '" + subject_ID_professor + "'";
        rst = stm.executeQuery(sql);

        while (rst.next()) {
            Student[counterStudent] = new Student();
            Student[counterStudent].setName(rst.getString("FULL_NAME"));
            Student[counterStudent].setId(rst.getString("STUDENT_ID"));
            counterStudent++;

        }

        sql = "SELECT * FROM student_final_grade INNER JOIN student ON student_final_grade.STUDENT_ID = student.ID WHERE SUBJECT_ID = '" + subject_ID_professor + "'";
        rst = stm.executeQuery(sql);

        while (rst.next()) {
            finalGrade[finalGradeCounter] = rst.getString("STUDENT_ID");
            finalGradeCounter++;

            finalGrade[finalGradeCounter] = rst.getString("FULL_NAME");
            finalGradeCounter++;

            finalGrade[finalGradeCounter] = rst.getString("FINAL_GRADE");
            finalGradeCounter++;

        }

        sql = "SELECT OBLIGATION_TYPE, POINTS_FOR_SUBJECT FROM obligation_subject WHERE SUBJECT_ID = '" + subject_ID_professor + "'";
        rst = stm.executeQuery(sql);

        while (rst.next()) {
            professorSubjectType[counterType] = rst.getString("OBLIGATION_TYPE");
            counterType++;

            professorSubjectType[counterType] = rst.getString("POINTS_FOR_SUBJECT");
            counterType++;

        }

        sql = "SELECT SUBJECT_NAME FROM subject WHERE ID = '" + subject_ID_professor + "'";
        rst = stm.executeQuery(sql);

        if (rst.next()) {
            subject_name = rst.getString("SUBJECT_NAME");
        }

        sql = "SELECT DISTINCT OBLIGATION_NAME, OBLIGATION_TYPE FROM obligation_student WHERE SUBJECT_ID = '" + subject_ID_professor + "'";
        rst = stm.executeQuery(sql);

        while (rst.next()) {
            obligationName = rst.getString("OBLIGATION_NAME");
            obligationType = rst.getString("OBLIGATION_TYPE");
            finalObligation = obligationType + "  -  " + obligationName;
            arrayObligationType[counterObligationType] = finalObligation;

            counterObligationType++;
        }

        sql = "SELECT * FROM obligation_student INNER JOIN student ON obligation_student.STUDENT_ID = student.ID WHERE SUBJECT_ID = '" + subject_ID_professor + "'";
        rst = stm.executeQuery(sql);

        while (rst.next()) {
            obligationsArray[counterObligations] = new Obligations();
            obligationsArray[counterObligations].setSubjectName(subject_name);
            obligationsArray[counterObligations].setObligationType(rst.getString("OBLIGATION_TYPE"));
            obligationsArray[counterObligations].setObligationName(rst.getString("OBLIGATION_NAME"));
            obligationsArray[counterObligations].setStudentName(rst.getString("FULL_NAME"));
            obligationsArray[counterObligations].setMaximumPoints(rst.getInt("MAXIMUM_POINTS"));
            obligationsArray[counterObligations].setScoredPoints(rst.getInt("SCORED_POINTS"));
            obligationsArray[counterObligations].setStudentID(rst.getString("STUDENT_ID"));
            obligationsArray[counterObligations].setGrade(rst.getInt("GRADE"));
            obligationsArray[counterObligations].setPrecentage(rst.getInt("GRADE_PRECENTAGE"));

            counterObligations++;
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

        LogInForm = new AddOns.TransparentPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        LogInName = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        LogInPass = new javax.swing.JPasswordField();
        LogInBtn = new AddOns.MyButton();
        LogInErr = new javax.swing.JLabel();
        showPassword = new AddOns.CheckBox();
        profilePicture3 = new AddOns.ProfilePicture();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(400, 446));
        setMinimumSize(new java.awt.Dimension(400, 446));
        setUndecorated(true);

        LogInForm.setMaximumSize(new java.awt.Dimension(400, 550));
        LogInForm.setMinimumSize(new java.awt.Dimension(400, 550));
        LogInForm.setPreferredSize(new java.awt.Dimension(400, 550));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Log In");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Enter username:");

        LogInName.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        LogInName.setForeground(new java.awt.Color(255, 255, 255));
        LogInName.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(214, 0, 255)));
        LogInName.setOpaque(false);
        LogInName.setSelectionColor(new java.awt.Color(255, 255, 255));
        LogInName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogInNameActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Enter password:");

        LogInPass.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        LogInPass.setForeground(new java.awt.Color(255, 255, 255));
        LogInPass.setToolTipText("");
        LogInPass.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(214, 0, 255)));
        LogInPass.setOpaque(false);
        LogInPass.setSelectionColor(new java.awt.Color(255, 255, 255));

        LogInBtn.setBackground(new java.awt.Color(255, 255, 255));
        LogInBtn.setForeground(new java.awt.Color(48, 0, 48));
        LogInBtn.setText("Log In");
        LogInBtn.setBorderPainted(false);
        LogInBtn.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        LogInBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogInBtnActionPerformed(evt);
            }
        });

        LogInErr.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        LogInErr.setForeground(java.awt.Color.red);
        LogInErr.setText("Invalid inputs! Please try again");

        showPassword.setForeground(new java.awt.Color(255, 255, 255));
        showPassword.setText("Show password");
        showPassword.setContentAreaFilled(false);
        showPassword.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        showPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showPasswordActionPerformed(evt);
            }
        });

        profilePicture3.setBackground(new java.awt.Color(67, 67, 67));
        profilePicture3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/turn-off.png"))); // NOI18N
        profilePicture3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                profilePicture3MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout LogInFormLayout = new javax.swing.GroupLayout(LogInForm);
        LogInForm.setLayout(LogInFormLayout);
        LogInFormLayout.setHorizontalGroup(
            LogInFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LogInFormLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(LogInFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(LogInFormLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(showPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(LogInFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(LogInFormLayout.createSequentialGroup()
                            .addGroup(LogInFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING))
                            .addContainerGap(232, Short.MAX_VALUE))
                        .addGroup(LogInFormLayout.createSequentialGroup()
                            .addGroup(LogInFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(LogInPass)
                                .addComponent(LogInName, javax.swing.GroupLayout.Alignment.LEADING))
                            .addGap(30, 30, 30)))))
            .addGroup(LogInFormLayout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(profilePicture3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(LogInFormLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(LogInFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LogInBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LogInErr)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        LogInFormLayout.setVerticalGroup(
            LogInFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LogInFormLayout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(profilePicture3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel1)
                .addGap(30, 30, 30)
                .addComponent(jLabel2)
                .addGap(0, 0, 0)
                .addComponent(LogInName, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(jLabel4)
                .addGap(0, 0, 0)
                .addComponent(LogInPass, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(showPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(LogInErr)
                .addGap(18, 18, 18)
                .addComponent(LogInBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(LogInForm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(LogInForm, javax.swing.GroupLayout.PREFERRED_SIZE, 446, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void LogInNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogInNameActionPerformed

    }//GEN-LAST:event_LogInNameActionPerformed

    private void LogInBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogInBtnActionPerformed

        boolean end = false;

        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost/javaproject", "root", "");
            stm = conn.createStatement();

            type = "student";

            while (found == false && end == false) {
                Search(type, stm);

                if (type.equals("student") && found == false) {
                    type = "professor";
                    Search(type, stm);
                } else if (type.equals("professor") && found == false) {
                    type = "admin";
                    Search(type, stm);
                    end = true;
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(LogInFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(LogInFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_LogInBtnActionPerformed

    private void showPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void showPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showPasswordActionPerformed
        boolean isPassSelected = showPassword.isSelected();

        if (isPassSelected == true) {

            LogInPass.setEchoChar((char) 0);

        } else {

            LogInPass.setEchoChar('*');
        }
    }//GEN-LAST:event_showPasswordActionPerformed

    private void profilePicture3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_profilePicture3MouseClicked
        System.exit(0);
    }//GEN-LAST:event_profilePicture3MouseClicked

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
            java.util.logging.Logger.getLogger(LogInFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LogInFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LogInFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LogInFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LogInFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private AddOns.MyButton LogInBtn;
    private javax.swing.JLabel LogInErr;
    private AddOns.TransparentPanel LogInForm;
    private javax.swing.JTextField LogInName;
    private javax.swing.JPasswordField LogInPass;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private AddOns.ProfilePicture profilePicture3;
    private AddOns.CheckBox showPassword;
    // End of variables declaration//GEN-END:variables
}
