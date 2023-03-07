/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaApp;

import AddOns.ScrollBarCustom;
import static JavaApp.LogInFrame.CURRENT_USER_ID;
import static JavaApp.LogInFrame.Student;
import static JavaApp.LogInFrame.arrayObligationType;
import static JavaApp.LogInFrame.arrayObligations;
import static JavaApp.LogInFrame.arraySubjects;
import static JavaApp.LogInFrame.conn;
import static JavaApp.LogInFrame.counterObligationType;
import static JavaApp.LogInFrame.counterObligations;
import static JavaApp.LogInFrame.counterStudent;
import static JavaApp.LogInFrame.counterSubjects;
import static JavaApp.LogInFrame.counterType;
import static JavaApp.LogInFrame.finalGrade;
import static JavaApp.LogInFrame.finalGradeCounter;
import static JavaApp.LogInFrame.imageData;
import static JavaApp.LogInFrame.professorSubjectType;
import static JavaApp.LogInFrame.sql;
import static JavaApp.LogInFrame.stm;
import static JavaApp.LogInFrame.subject_ID_professor;
import static JavaApp.LogInFrame.subject_name;
import static JavaApp.LogInFrame.type;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.sql.Blob;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.sql.rowset.serial.SerialBlob;
import javax.swing.DefaultListModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

/**
 *
 * @author Samardzija Njegos
 */
public class MainFrame extends javax.swing.JFrame {

    /**
     * Creates new form MainFrame
     */
    static DefaultTableModel tableModel = new DefaultTableModel();
    static DefaultTableModel tableModel2 = new DefaultTableModel();
    static DefaultListModel listModel = new DefaultListModel();

    public MainFrame() throws IOException {
        initComponents();
        setBackground(new Color(0, 0, 0, 0));
        jPanel3.setBackground(new Color(0, 0, 0, 0));
        jPanel3.setVisible(false);
        jPanel5.setBackground(new Color(0, 0, 0, 0));
        //jPanel5.setVisible(false);
        jTable1.setShowGrid(false);
        fixTable(jScrollPane1);
        fixTable(jScrollPane3);

        jTable1.getTableHeader().setDefaultRenderer(new TableHeader());
        jTable1.getTableHeader().setPreferredSize(new Dimension(0, 35));
        jTable1.getTableHeader().setOpaque(false);
        jTable1.setOpaque(false);
        jTable1.setBackground(new Color(67, 67, 67));
        jTable1.setForeground(Color.WHITE);

        profilePicture2.setBackground(new Color(0, 0, 0, 0));
        MainPanel.setBackground(new Color(0, 0, 0, 160));

        studentList2.setBackground(new Color(67, 67, 67));
        studentList2.setFixedCellHeight(40);

        BufferedImage image = ImageIO.read(new ByteArrayInputStream(imageData));
        ImageIcon icon = new ImageIcon(image);
        profilePicture1.setIcon(icon);

        if (type.equals("student")) {
            jPanel5.setVisible(false);
            for (int i = 0; i < counterSubjects; i++) {
                listModel.addElement(arraySubjects[i].getName());
            }
            studentList2.setModel(listModel);
        } else {
            writeList();

            jTable2.setShowGrid(false);
            jTable2.getTableHeader().setDefaultRenderer(new TableHeader());
            jTable2.getTableHeader().setPreferredSize(new Dimension(0, 35));
            jTable2.getTableHeader().setOpaque(false);
            jTable2.setOpaque(false);
            jTable2.setBackground(new Color(67, 67, 67));
            jTable2.setForeground(Color.WHITE);
            myButton3.setEnabled(false);

        }

    }

    public static void writeList() {

        for (int i = 0; i < counterObligationType; i++) {
            listModel.addElement(arrayObligationType[i]);
        }
        studentList2.setModel(listModel);
    }

    public void fixTable(JScrollPane scroll) {
        scroll.setVerticalScrollBar(new ScrollBarCustom());
        scroll.getViewport().setBackground(new Color(255, 255, 255));
        scroll.setOpaque(false);
        scroll.getViewport().setOpaque(false);
    }

    private class TableHeader extends DefaultTableCellRenderer {

        @Override
        public Component getTableCellRendererComponent(JTable jtable, Object o, boolean bln, boolean bln1, int i, int i1) {
            JTableHeader header = jtable.getTableHeader();
            header.setBackground(new Color(0, 0, 0, 0));
            Component com = super.getTableCellRendererComponent(jtable, o, bln, bln1, i, i1);
            com.setBackground(new Color(67, 67, 67));
            com.setForeground(new Color(255, 255, 255));
            com.setFont(new Font("Tahoma", Font.PLAIN, 16));
            JLabel label = new JLabel(o.toString());
            label.setOpaque(false);
            label.setForeground(Color.WHITE);
            return com;
        }

    }

    public static void calculateGrade() {

        double precentageOfScoredPoints;

        for (int i = 0; i < counterObligations; i++) {

            precentageOfScoredPoints = arrayObligations[i].getScoredPoints() / arrayObligations[i].getMaximumPoints() * 100;
            arrayObligations[i].setPrecentage(precentageOfScoredPoints);

            if (precentageOfScoredPoints <= 50) {
                arrayObligations[i].setGrade(0);
            } else if (precentageOfScoredPoints > 50 && precentageOfScoredPoints <= 60) {
                arrayObligations[i].setGrade(6);
            } else if (precentageOfScoredPoints > 60 && precentageOfScoredPoints <= 70) {
                arrayObligations[i].setGrade(7);
            } else if (precentageOfScoredPoints > 70 && precentageOfScoredPoints <= 80) {
                arrayObligations[i].setGrade(8);
            } else if (precentageOfScoredPoints > 80 && precentageOfScoredPoints <= 90) {
                arrayObligations[i].setGrade(9);
            } else if (precentageOfScoredPoints > 90 && precentageOfScoredPoints <= 100) {
                arrayObligations[i].setGrade(10);
            }
        }

        for (int i = 0; i < counterStudent; i++) {

            int points = 0;
            int part = 0;
            int typeFinalGrade = 0;

            double[] arrayPrecentage = new double[100];

            for (int j = 0; j < counterType; j += 2) {

                int gradeTypeCounter = 0;

                for (int k = 0; k < counterObligations; k++) {
                    if (arrayObligations[k].getObligationType().equals(professorSubjectType[j]) && arrayObligations[k].getStudentName().equals(Student[i].getName())) {
                        arrayPrecentage[gradeTypeCounter] = arrayObligations[k].getPrecentage();
                        gradeTypeCounter++;
                    }
                }

                points = Integer.parseInt(professorSubjectType[j + 1]);

                if (gradeTypeCounter != 0) {
                    part = points / gradeTypeCounter;
                }

                for (int k = 0; k < gradeTypeCounter; k++) {
                    typeFinalGrade += part * arrayPrecentage[k] / 100;
                    System.out.println("type: " + typeFinalGrade + ", part: " + part + ", precentage: " + arrayPrecentage[k] / 100);
                }
            }

            for (int j = 1; j < finalGradeCounter; j += 3) {

                if (finalGrade[j].equals(Student[i].getName())) {
                    System.out.println(finalGrade[j] + " +++ " + Student[i].getName());
                    if (typeFinalGrade <= 50) {
                        System.out.println("Garde: dwefrgthfjhk");
                        finalGrade[j + 1] = "0";
                    } else if (typeFinalGrade > 50 && typeFinalGrade <= 60) {
                        finalGrade[j + 1] = "6";
                    } else if (typeFinalGrade > 60 && typeFinalGrade <= 70) {
                        finalGrade[j + 1] = "7";
                    } else if (typeFinalGrade > 70 && typeFinalGrade <= 80) {
                        finalGrade[j + 1] = "8";
                    } else if (typeFinalGrade > 80 && typeFinalGrade <= 90) {
                        finalGrade[j + 1] = "9";
                    } else if (typeFinalGrade > 90 && typeFinalGrade <= 100) {
                        finalGrade[j + 1] = "10";
                    }
                }
            }

        }

    }

    public void changePic(byte[] data) throws SQLException {
        PreparedStatement stmt;
        Blob blob = new SerialBlob(data);
        if (type.equals("student")) {
            sql = "UPDATE student SET PICTURE = ? WHERE ID = '" + CURRENT_USER_ID + "'";
            stmt = conn.prepareStatement(sql);
            stmt.setBlob(1, blob);
            stmt.execute();
        } else if (type.equals("professor")) {
            sql = "UPDATE professor SET PICTURE = ? WHERE ID = '" + CURRENT_USER_ID + "'";
            stmt = conn.prepareStatement(sql);
            stmt.setBlob(1, blob);
            stmt.execute();
        }
    }

    public void RemoveAll() {
        counterObligations = 0;
        counterSubjects = 0;
        counterObligationType = 0;
        counterStudent = 0;
        counterType = 0;
        finalGradeCounter = 0;
        listModel.removeAllElements();
    }

    public static void deleteItem(int index) {

        deleteTable();

        String name = studentList2.getSelectedValue();
        String[] finalName = name.split("  -  ");
        // index radi System.out.println(index);
        Obligations[] temp = new Obligations[1000];
        String[] temp2 = new String[1000];

        int newCounter2 = 0;
        int newCounter = 0;

        for (int i = 0; i < counterObligations; i++) {
            if (!arrayObligations[i].getObligationName().equals(finalName[1]) || !arrayObligations[i].getObligationType().equals(finalName[0])) {
                temp[newCounter] = new Obligations();
                temp[newCounter].setSubjectName(arrayObligations[i].getSubjectName());
                temp[newCounter].setStudentName(arrayObligations[i].getStudentName());
                temp[newCounter].setObligationName(arrayObligations[i].getObligationName());
                temp[newCounter].setObligationType(arrayObligations[i].getObligationType());
                temp[newCounter].setMaximumPoints(arrayObligations[i].getMaximumPoints());
                temp[newCounter].setScoredPoints(arrayObligations[i].getScoredPoints());
                newCounter++;
            }
        }

        for (int i = 0; i < newCounter; i++) {

            arrayObligations[i].setSubjectName(temp[i].getSubjectName());
            arrayObligations[i].setObligationType(temp[i].getObligationType());
            arrayObligations[i].setObligationName(temp[i].getObligationName());
            arrayObligations[i].setStudentName(temp[i].getStudentName());
            arrayObligations[i].setMaximumPoints(temp[i].getMaximumPoints());
            arrayObligations[i].setScoredPoints(temp[i].getScoredPoints());
        }

        for (int i = 0; i < counterObligationType; i++) {
            if (!name.equals(arrayObligationType[i])) {
                temp2[newCounter2] = arrayObligationType[i];
                newCounter2++;
            }
        }

        for (int i = 0; i <= newCounter2; i++) {
            if (i == newCounter2) {
                arrayObligationType[i] = null;
            } else {
                arrayObligationType[i] = temp2[i];
            }

        }

        counterObligations = newCounter;
        counterObligationType = newCounter2;

        listModel.removeAllElements();
        for (int i = 0; i < counterObligationType; i++) {
            listModel.addElement(arrayObligationType[i]);
        }

        studentList2.setModel(listModel);
        writeTableProfessor(arrayObligationType[0]);
    }

    public static void changeObligationCounter(int counter) {
        counterObligations = counter;
    }

    public static void deleteTable() {
        int counter = jTable2.getRowCount();
        for (int i = counter - 1; i >= 0; i--) {
            ((DefaultTableModel) tableModel2).removeRow(i);
        }
        jTable2.setModel(tableModel2);
    }

    public static void writeTableProfessor(String selected) {

        calculateGrade();

        jTable2.setVisible(true);
        String[] finalSelect = new String[2];
        if (selected != null) {
            finalSelect = selected.split("  -  ");
        } else {
            finalSelect[0] = "";
            finalSelect[1] = "";
        }
        int counter = 0;

        String[] columns = {"Student Name", "Maximum Points", "Scored Points", "Grade %", "Grade"};
        String[][] readTableData = new String[1000][5];

        for (int i = 0; i < counterObligations; i++) {
            System.out.println(arrayObligations[i].getObligationName() + " --- " + arrayObligations[i].getObligationType());
            if (arrayObligations[i].getObligationName().equals(finalSelect[1]) && arrayObligations[i].getObligationType().equals(finalSelect[0])) {
                readTableData[counter][0] = arrayObligations[i].getStudentName();
                readTableData[counter][1] = String.valueOf(arrayObligations[i].getMaximumPoints());
                readTableData[counter][2] = String.valueOf(arrayObligations[i].getScoredPoints());
                readTableData[counter][3] = String.valueOf(arrayObligations[i].getPrecentage());
                readTableData[counter][4] = String.valueOf(arrayObligations[i].getGrade());

                counter++;
            }
        }

        String[][] tableData = new String[counter][5];

        if (counter == 0) {
            tableData = new String[1][5];
            tableData[0][0] = "";
            tableData[0][1] = "";
            tableData[0][2] = "";
            tableData[0][3] = "";
            tableData[0][4] = "";
        } else {
            for (int i = 0; i < counter; i++) {
                for (int j = 0; j < 5; j++) {
                    tableData[i][j] = readTableData[i][j];
                }
            }
        }

        tableModel2 = new DefaultTableModel(tableData, columns);
        jTable2.setModel(tableModel2);
    }

    public static void writeTableStudent() {

        calculateGrade();

        String selected = studentList2.getSelectedValue();
        System.out.println(selected);
        jPanel3.setVisible(true);

        for (int i = 0; i < counterSubjects; i++) {
            if (selected.equals(arraySubjects[i].getName())) {

                //jLabel8.setText(arraySubjects[i].getName());
                String stringSubjectName = "<html> <p style=' display: flex; justify-content: center; flex_direction: column; text-align: center;'>" + arraySubjects[i].getName().toUpperCase() + "</p> </html>";
                jLabel8.setText(stringSubjectName);
                jLabel2.setText(arraySubjects[i].getSemester());
                jLabel3.setText(arraySubjects[i].getProfessor());
                jLabel4.setText(arraySubjects[i].getId());
                jLabel5.setText(String.valueOf(arraySubjects[i].getEctsPoints()));
                jLabel6.setText(String.valueOf(arraySubjects[i].getGrade()));

                int numOfObligations = arraySubjects[i].getNumberOfObligations() * 2;

                String[] arrayOfObligations = arraySubjects[i].getObligations();
                String stringObligations = "<html>";

                for (int j = 0; j < numOfObligations; j += 2) {
                    stringObligations = stringObligations + arrayOfObligations[j] + " - " + arrayOfObligations[j + 1] + "%<br>";
                }

                jLabel7.setText(stringObligations);
            }
        }

        int counter = 0;

        String[] columns = {"Type", "Name", "Maximum", "Scored", "Grade %", "Grade"};
        String[][] readTableData = new String[1000][6];

        for (int i = 0; i < counterObligations; i++) {
            readTableData[counter][0] = arrayObligations[i].getObligationType();
            readTableData[counter][1] = arrayObligations[i].getObligationName();
            readTableData[counter][2] = String.valueOf(arrayObligations[i].getMaximumPoints());
            readTableData[counter][3] = String.valueOf(arrayObligations[i].getScoredPoints());
            readTableData[counter][4] = String.valueOf(arrayObligations[i].getPrecentage());
            readTableData[counter][5] = String.valueOf(arrayObligations[i].getGrade());

            counter++;
        }

        String[][] tableData = new String[counter][6];
        for (int i = 0; i < counter; i++) {
            for (int j = 0; j < 6; j++) {
                tableData[i][j] = readTableData[i][j];
            }
        }

        tableModel = new DefaultTableModel(tableData, columns);
        jTable1.setModel(tableModel);
    }

    public static void adjustObligationFunction() {
        String selected = studentList2.getSelectedValue();
        String[] finalSelected = selected.split("  -  ");

        AdjustObligation AdjustObligationFrame = new AdjustObligation();
        AdjustObligationFrame.setVisible(true);
        AdjustObligationFrame.pass(subject_name, finalSelected[0], finalSelected[1], professorSubjectType, counterType);
    }

    public void saveProfessor() throws SQLException {

        calculateGrade();

        conn = DriverManager.getConnection("jdbc:mysql://localhost/javaproject", "root", "");
        stm = conn.createStatement();

        int studyYear = 0;

        String obligationName;
        String obligationType;
        String finalObligation;

        sql = "DELETE FROM obligation_student WHERE SUBJECT_ID = '" + subject_ID_professor + "'";
        stm.executeUpdate(sql);

        for (int i = 0; i < counterObligations; i++) {
            sql = "INSERT INTO `obligation_student`(`OBLIGATION_NAME`, `OBLIGATION_TYPE`, `SUBJECT_ID`, `STUDENT_ID`, `MAXIMUM_POINTS`, `SCORED_POINTS`, `GRADE`, `GRADE_PRECENTAGE`) VALUES ('" + arrayObligations[i].getObligationName() + "','" + arrayObligations[i].getObligationType() + "','" + subject_ID_professor + "','" + arrayObligations[i].getStudentID() + "'," + arrayObligations[i].getMaximumPoints() + "," + arrayObligations[i].getScoredPoints() + "," + arrayObligations[i].getGrade() + "," + arrayObligations[i].getPrecentage() + ")";
            stm.executeUpdate(sql);
        }

        sql = "DELETE FROM student_final_grade WHERE SUBJECT_ID = '" + subject_ID_professor + "'";
        System.out.println(sql);
        stm.executeUpdate(sql);

        if (finalGradeCounter == 0) {
            finalGradeCounter = 1;
        }

        for (int i = 0; i < finalGradeCounter; i += 3) {
            sql = "INSERT INTO `student_final_grade`(`SUBJECT_ID`, `STUDENT_ID`, `FINAL_GRADE`) VALUES ('" + subject_ID_professor + "','" + finalGrade[i] + "','" + finalGrade[i + 2] + "')";
            System.out.println(sql);
            stm.executeUpdate(sql);
        }

        stm.close();
        conn.close();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        MainPanel = new AddOns.TransparentPanel();
        newJPanel11 = new AddOns.RoundedPanel();
        ProjectLabel = new javax.swing.JLabel();
        profilePicture1 = new AddOns.ProfilePicture();
        profilePicture2 = new AddOns.ProfilePicture();
        profilePicture3 = new AddOns.ProfilePicture();
        jScrollPane2 = new javax.swing.JScrollPane();
        studentList2 = new javax.swing.JList<>();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        myButton2 = new AddOns.MyButton();
        myButton3 = new AddOns.MyButton();
        myButton1 = new AddOns.MyButton();
        myButton4 = new AddOns.MyButton();
        myButton5 = new AddOns.MyButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        MainPanel.setPreferredSize(new java.awt.Dimension(1260, 680));
        MainPanel.setLayout(new javax.swing.BoxLayout(MainPanel, javax.swing.BoxLayout.LINE_AXIS));

        newJPanel11.setMaximumSize(new java.awt.Dimension(300, 714));
        newJPanel11.setMinimumSize(new java.awt.Dimension(300, 714));
        newJPanel11.setPreferredSize(new java.awt.Dimension(300, 714));

        ProjectLabel.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        ProjectLabel.setForeground(new java.awt.Color(255, 255, 255));
        ProjectLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ProjectLabel.setText("---");

        profilePicture1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                profilePicture1MouseClicked(evt);
            }
        });

        profilePicture2.setBackground(new java.awt.Color(67, 67, 67));
        profilePicture2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/log-out.png"))); // NOI18N
        profilePicture2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                profilePicture2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                profilePicture2MouseEntered(evt);
            }
        });

        profilePicture3.setBackground(new java.awt.Color(67, 67, 67));
        profilePicture3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/turn-off.png"))); // NOI18N
        profilePicture3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                profilePicture3MouseClicked(evt);
            }
        });

        jScrollPane2.setBorder(null);

        studentList2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        studentList2.setForeground(new java.awt.Color(255, 255, 255));
        studentList2.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        studentList2.setFocusable(false);
        studentList2.setRequestFocusEnabled(false);
        studentList2.setSelectionBackground(new java.awt.Color(214, 0, 255));
        studentList2.setVerifyInputWhenFocusTarget(false);
        studentList2.setVisibleRowCount(16);
        studentList2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                studentList2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(studentList2);

        javax.swing.GroupLayout newJPanel11Layout = new javax.swing.GroupLayout(newJPanel11);
        newJPanel11.setLayout(newJPanel11Layout);
        newJPanel11Layout.setHorizontalGroup(
            newJPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(newJPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, newJPanel11Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(profilePicture1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(newJPanel11Layout.createSequentialGroup()
                .addGroup(newJPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(newJPanel11Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(profilePicture3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(profilePicture2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(newJPanel11Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(ProjectLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        newJPanel11Layout.setVerticalGroup(
            newJPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(newJPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(newJPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(profilePicture2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(profilePicture3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addComponent(profilePicture1, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ProjectLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 459, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        MainPanel.add(newJPanel11);

        jPanel5.setMaximumSize(new java.awt.Dimension(982, 714));
        jPanel5.setMinimumSize(new java.awt.Dimension(982, 714));
        jPanel5.setPreferredSize(new java.awt.Dimension(982, 714));

        jScrollPane3.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        jScrollPane3.setViewportBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        jScrollPane3.setFocusable(false);
        jScrollPane3.setMinimumSize(new java.awt.Dimension(25, 29));
        jScrollPane3.setPreferredSize(new java.awt.Dimension(450, 400));

        jTable2.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Student Name", "Maximum Points", "Scored Points", "Grade %", "Grade"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable2.setRequestFocusEnabled(false);
        jTable2.setRowHeight(30);
        jTable2.setSelectionBackground(new java.awt.Color(214, 0, 255));
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTable2);

        myButton2.setBorder(null);
        myButton2.setText("Add Obligation");
        myButton2.setBorderPainted(false);
        myButton2.setFocusPainted(false);
        myButton2.setFocusable(false);
        myButton2.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        myButton2.setRequestFocusEnabled(false);
        myButton2.setRolloverEnabled(false);
        myButton2.setVerifyInputWhenFocusTarget(false);
        myButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myButton2ActionPerformed(evt);
            }
        });

        myButton3.setText("Change Score");
        myButton3.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        myButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myButton3ActionPerformed(evt);
            }
        });

        myButton1.setText("Save Changes");
        myButton1.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        myButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myButton1ActionPerformed(evt);
            }
        });

        myButton4.setText("Delete");
        myButton4.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        myButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myButton4ActionPerformed(evt);
            }
        });

        myButton5.setText("Adjust");
        myButton5.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        myButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 923, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(myButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(myButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(myButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(myButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(myButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(39, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 622, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(myButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(myButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(myButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(myButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(myButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );

        MainPanel.add(jPanel5);

        jPanel3.setMaximumSize(new java.awt.Dimension(982, 714));
        jPanel3.setMinimumSize(new java.awt.Dimension(982, 714));
        jPanel3.setPreferredSize(new java.awt.Dimension(982, 714));

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Obligations:");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Semester: ");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("---");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("---");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("---");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("---");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("---");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("---");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("---");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Professor: ");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("ID: ");

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("ECTS: ");

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Grade: ");

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Obligations - Weight");

        jScrollPane1.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        jScrollPane1.setViewportBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        jScrollPane1.setOpaque(false);

        jTable1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6"
            }
        ));
        jTable1.setOpaque(false);
        jTable1.setRequestFocusEnabled(false);
        jTable1.setRowHeight(30);
        jTable1.setRowSelectionAllowed(false);
        jTable1.setSelectionBackground(new java.awt.Color(214, 0, 255));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel10))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addGap(0, 150, Short.MAX_VALUE))
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 558, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)))
                .addGap(0, 0, 0))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addGap(50, 50, 50)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel4)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(45, 45, 45)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(jLabel3))
                        .addGap(45, 45, 45)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(jLabel5))
                        .addGap(45, 45, 45)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(jLabel6))
                        .addGap(45, 45, 45)
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel7)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 540, Short.MAX_VALUE)
                        .addContainerGap())))
        );

        MainPanel.add(jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MainPanel, 1261, 1261, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 714, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void studentList2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_studentList2MouseClicked

        myButton3.setEnabled(false);
        String selected = studentList2.getSelectedValue();
        if (type.equals("student")) {
            jPanel3.setVisible(true);
            writeTableStudent();
        } else {
            writeTableProfessor(selected);
        }

        /*
        jTable1.setColumnWidth(0, 150);
        jTable1.setColumnWidth(1, 150);
        jTable1.setColumnWidth(5, 50);
         */
    }//GEN-LAST:event_studentList2MouseClicked

    private void profilePicture2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_profilePicture2MouseClicked
        LogInFrame logInFramePanel = new LogInFrame();
        logInFramePanel.setVisible(true);
        RemoveAll();
        dispose();
    }//GEN-LAST:event_profilePicture2MouseClicked

    private void profilePicture3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_profilePicture3MouseClicked
        System.exit(0);
    }//GEN-LAST:event_profilePicture3MouseClicked

    private void myButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myButton2ActionPerformed
        AddObligation AddObligationFrame = new AddObligation();
        AddObligationFrame.setVisible(true);
        AddObligationFrame.pass(professorSubjectType, counterType, subject_name, counterObligations, Student, counterStudent);
    }//GEN-LAST:event_myButton2ActionPerformed

    private void myButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myButton3ActionPerformed
        ChangeGrade ChangeGradeFrame = new ChangeGrade();
        ChangeGradeFrame.setVisible(true);

        int row = jTable2.getSelectedRow();
        String studentName = jTable2.getModel().getValueAt(row, 0).toString();
        String maxPoints = jTable2.getModel().getValueAt(row, 1).toString();
        String scoredPoints = jTable2.getModel().getValueAt(row, 2).toString();
        String obligation = studentList2.getSelectedValue();

        ChangeGradeFrame.pass(studentName, obligation, maxPoints, scoredPoints);
    }//GEN-LAST:event_myButton3ActionPerformed

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        myButton3.setEnabled(true);
    }//GEN-LAST:event_jTable2MouseClicked

    private void myButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myButton1ActionPerformed
        try {
            saveProfessor();
        } catch (SQLException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_myButton1ActionPerformed

    private void profilePicture2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_profilePicture2MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_profilePicture2MouseEntered

    private void myButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myButton4ActionPerformed
        int selected = studentList2.getSelectedIndex();
        deleteItem(selected);
    }//GEN-LAST:event_myButton4ActionPerformed

    private void myButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myButton5ActionPerformed
        adjustObligationFunction();
    }//GEN-LAST:event_myButton5ActionPerformed

    private void profilePicture1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_profilePicture1MouseClicked
        JFileChooser input = new JFileChooser();
        int result = input.showSaveDialog(this);
        input.setCurrentDirectory(new File(System.getProperty("user.home")));
        FileNameExtensionFilter filter = new FileNameExtensionFilter("*.Images", "jpg", "png", "jpeg");
        input.addChoosableFileFilter(filter);
        input.setAcceptAllFileFilterUsed(false);

        if (result == JFileChooser.APPROVE_OPTION) {
            try {
                byte[] data = null;
                File selectedFile = input.getSelectedFile();
                String path = selectedFile.getAbsolutePath();
                BufferedImage image = ImageIO.read(new File(path));
                ImageIcon icon = new ImageIcon(image);
                profilePicture1.setIcon(icon);
                ByteArrayOutputStream bos = new ByteArrayOutputStream();
                ImageIO.write(image, "jpg", bos);
                data = bos.toByteArray();
                repaint();
                changePic(data);
            } catch (IOException ex) {
                Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (result == JFileChooser.CANCEL_OPTION) {
            input.setVisible(false);
        }
    }//GEN-LAST:event_profilePicture1MouseClicked

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
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new MainFrame().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private AddOns.TransparentPanel MainPanel;
    public static javax.swing.JLabel ProjectLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private static javax.swing.JLabel jLabel2;
    private static javax.swing.JLabel jLabel3;
    private static javax.swing.JLabel jLabel4;
    private static javax.swing.JLabel jLabel5;
    private static javax.swing.JLabel jLabel6;
    private static javax.swing.JLabel jLabel7;
    private static javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private static javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private static javax.swing.JTable jTable1;
    private static javax.swing.JTable jTable2;
    private AddOns.MyButton myButton1;
    private AddOns.MyButton myButton2;
    public static AddOns.MyButton myButton3;
    public static AddOns.MyButton myButton4;
    public static AddOns.MyButton myButton5;
    private AddOns.RoundedPanel newJPanel11;
    public static AddOns.ProfilePicture profilePicture1;
    private AddOns.ProfilePicture profilePicture2;
    private AddOns.ProfilePicture profilePicture3;
    public static javax.swing.JList<String> studentList2;
    // End of variables declaration//GEN-END:variables
}
