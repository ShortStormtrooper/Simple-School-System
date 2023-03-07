/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Admin;

import AddOns.ScrollBarCustom;
import JavaApp.LogInFrame;
import JavaApp.Obligations;
import static JavaApp.LogInFrame.Student;
import static JavaApp.LogInFrame.arrayObligations;
import static JavaApp.LogInFrame.arraySubjects;
import static JavaApp.LogInFrame.conn;
import static JavaApp.LogInFrame.counterObligations;
import static JavaApp.LogInFrame.counterProfessorAdmin;
import static JavaApp.LogInFrame.counterStudent;
import static JavaApp.LogInFrame.counterSubjectObligations;
import static JavaApp.LogInFrame.counterSubjects;
import static JavaApp.LogInFrame.finalGrade;
import static JavaApp.LogInFrame.finalGradeCounter;
import static JavaApp.LogInFrame.professorAdmin;
import static JavaApp.LogInFrame.sql;
import static JavaApp.LogInFrame.stm;
import static JavaApp.LogInFrame.subjectObligations;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.sql.Blob;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.rowset.serial.SerialBlob;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

/**
 *
 * @author Samardzija Njegos
 */
public class AdminFrame extends javax.swing.JFrame {

    /**
     * Creates new form AdminFrame
     */
    static DefaultTableModel tableModel3;
    static DefaultTableModel tableModel4;
    static DefaultTableModel tableModel5;

    public AdminFrame() {
        initComponents();
        jPanel6.setVisible(false);
        jPanel7.setVisible(false);
        jPanel3.setVisible(false);

        fixTable(jScrollPane1);
        fixTable(jScrollPane2);
        fixTable(jScrollPane3);

        setBackground(new Color(0, 0, 0, 0));
        newJPanel1.setBackground(new Color(67, 67, 67));

        WriteStudent();
        WriteProfessor();
        WriteSubjects();

    }

    public void RemoveAll() {
        counterObligations = 0;
        counterSubjects = 0;
        counterStudent = 0;
        counterSubjects = 0;
        counterProfessorAdmin = 0;
        finalGradeCounter = 0;
    }

    public static void returnCounterSubject(int counter) {
        counterSubjects = counter;
    }

    public static void returnCounterObligations(int counter) {
        counterObligations = counter;
    }

    public static void returnFinalCounter(int counter) {
        finalGradeCounter = counter;
    }

    public static void WriteSubjects() {

        int counterTableSubject = 0;

        String[] columnsSubject = {"Subject ID", "Subject Name", "Semester", "ECTS Points", "Year", "Professor"};

        String[][] readTableDataSubject = new String[1000][6];

        for (int i = 0; i < counterSubjects; i++) {
            readTableDataSubject[counterTableSubject][0] = arraySubjects[i].getId();
            readTableDataSubject[counterTableSubject][1] = arraySubjects[i].getName();
            readTableDataSubject[counterTableSubject][2] = arraySubjects[i].getSemester();
            readTableDataSubject[counterTableSubject][3] = String.valueOf(arraySubjects[i].getEctsPoints());
            readTableDataSubject[counterTableSubject][4] = String.valueOf(arraySubjects[i].getYear());
            readTableDataSubject[counterTableSubject][5] = arraySubjects[i].getProfessor();
            counterTableSubject++;

        }

        String[][] tableDataSubject = new String[counterTableSubject][6];

        for (int i = 0; i < counterTableSubject; i++) {
            for (int j = 0; j < 6; j++) {
                tableDataSubject[i][j] = readTableDataSubject[i][j];
            }
        }

        tableModel4 = new DefaultTableModel(tableDataSubject, columnsSubject);
        jTable2.setModel(tableModel4);
    }

    public static void WriteStudent() {

        int counterTableStudent = 0;

        String[] columnsStudent = {"Student ID", "Student Name", "Username", "Study Year", "Password"};

        String[][] readTableDataStudent = new String[1000][5];

        for (int i = 0; i < counterStudent; i++) {
            readTableDataStudent[counterTableStudent][0] = Student[i].getId();
            readTableDataStudent[counterTableStudent][1] = Student[i].getName();
            readTableDataStudent[counterTableStudent][2] = Student[i].getUsername();
            readTableDataStudent[counterTableStudent][3] = Student[i].getStudy_year();
            readTableDataStudent[counterTableStudent][4] = Student[i].getPassword();
            counterTableStudent++;
        }

        String[][] tableDataStudent = new String[counterTableStudent][5];

        for (int i = 0; i < counterTableStudent; i++) {
            for (int j = 0; j < 5; j++) {
                tableDataStudent[i][j] = readTableDataStudent[i][j];
            }
        }

        tableModel5 = new DefaultTableModel(tableDataStudent, columnsStudent);
        jTable3.setModel(tableModel5);
    }

    public static void WriteProfessor() {

        int countertableProfessor = 0;

        String[] columnsProfessor = {"Professor ID", "Professor Name", "Username", "Password"};

        String[][] readTableDataProfessor = new String[1000][4];

        for (int i = 0; i < counterProfessorAdmin; i++) {
            readTableDataProfessor[countertableProfessor][0] = professorAdmin[i].getID();
            readTableDataProfessor[countertableProfessor][1] = professorAdmin[i].getName();
            readTableDataProfessor[countertableProfessor][2] = professorAdmin[i].getUsername();
            readTableDataProfessor[countertableProfessor][3] = professorAdmin[i].getPassword();

            countertableProfessor++;
        }

        String[][] tableDataProfessor = new String[countertableProfessor][4];

        for (int i = 0; i < countertableProfessor; i++) {
            for (int j = 0; j < 4; j++) {
                tableDataProfessor[i][j] = readTableDataProfessor[i][j];
            }
        }

        tableModel3 = new DefaultTableModel(tableDataProfessor, columnsProfessor);
        jTable1.setModel(tableModel3);
    }

    public void fixTable(JScrollPane scroll) {
        scroll.setVerticalScrollBar(new ScrollBarCustom());
        scroll.getViewport().setBackground(new Color(67, 67, 67));
    }

    private class TableHeader extends DefaultTableCellRenderer {

        @Override
        public Component getTableCellRendererComponent(JTable jtable, Object o, boolean bln, boolean bln1, int i, int i1) {
            JTableHeader header = jtable.getTableHeader();
            header.setBackground(new Color(0, 0, 0, 0));
            Component com = super.getTableCellRendererComponent(jtable, o, bln, bln1, i, i1);
            com.setBackground(new Color(47, 47, 47));
            com.setForeground(new Color(255, 255, 255));
            com.setFont(new Font("Tahoma", Font.PLAIN, 20));
            JLabel label = new JLabel(o.toString());
            label.setOpaque(false);
            label.setForeground(Color.WHITE);
            return com;
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

        newJPanel1 = new AddOns.TransparentPanel();
        jSplitPane1 = new javax.swing.JSplitPane();
        jPanel1 = new javax.swing.JPanel();
        myButton4 = new AddOns.MyButton();
        myButton6 = new AddOns.MyButton();
        myButton5 = new AddOns.MyButton();
        profilePicture3 = new AddOns.ProfilePicture();
        profilePicture2 = new AddOns.ProfilePicture();
        myButton15 = new AddOns.MyButton();
        jPanel5 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        myButton12 = new AddOns.MyButton();
        myButton13 = new AddOns.MyButton();
        myButton14 = new AddOns.MyButton();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        myButton8 = new AddOns.MyButton();
        myButton9 = new AddOns.MyButton();
        myButton10 = new AddOns.MyButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        myButton1 = new AddOns.MyButton();
        myButton2 = new AddOns.MyButton();
        myButton3 = new AddOns.MyButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new java.awt.CardLayout());

        newJPanel1.setMaximumSize(new java.awt.Dimension(1163, 714));
        newJPanel1.setMinimumSize(new java.awt.Dimension(1163, 714));
        newJPanel1.setPreferredSize(new java.awt.Dimension(1163, 714));

        jSplitPane1.setDividerLocation(220);
        jSplitPane1.setDividerSize(0);
        jSplitPane1.setMaximumSize(new java.awt.Dimension(600, 700));
        jSplitPane1.setMinimumSize(new java.awt.Dimension(600, 700));
        jSplitPane1.setPreferredSize(new java.awt.Dimension(600, 700));

        jPanel1.setBackground(new java.awt.Color(67, 67, 67));
        jPanel1.setMaximumSize(new java.awt.Dimension(219, 705));
        jPanel1.setMinimumSize(new java.awt.Dimension(219, 705));
        jPanel1.setPreferredSize(new java.awt.Dimension(219, 705));

        myButton4.setText("Students");
        myButton4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        myButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myButton4ActionPerformed(evt);
            }
        });

        myButton6.setText("Professors");
        myButton6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        myButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myButton6ActionPerformed(evt);
            }
        });

        myButton5.setText("Subjects");
        myButton5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        myButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myButton5ActionPerformed(evt);
            }
        });

        profilePicture3.setBackground(new java.awt.Color(67, 67, 67));
        profilePicture3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/turn-off.png"))); // NOI18N
        profilePicture3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                profilePicture3MouseClicked(evt);
            }
        });

        profilePicture2.setBackground(new java.awt.Color(67, 67, 67));
        profilePicture2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/log-out.png"))); // NOI18N
        profilePicture2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                profilePicture2MouseClicked(evt);
            }
        });

        myButton15.setText("Save Changes");
        myButton15.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        myButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myButton15ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(myButton15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(profilePicture3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(myButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(profilePicture2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(myButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(myButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 38, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(profilePicture2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(profilePicture3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(120, 120, 120)
                .addComponent(myButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(90, 90, 90)
                .addComponent(myButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(90, 90, 90)
                .addComponent(myButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 196, Short.MAX_VALUE)
                .addComponent(myButton15, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jSplitPane1.setLeftComponent(jPanel1);

        jPanel5.setBackground(new java.awt.Color(67, 67, 67));
        jPanel5.setMaximumSize(new java.awt.Dimension(920, 712));
        jPanel5.setMinimumSize(new java.awt.Dimension(920, 712));
        jPanel5.setPreferredSize(new java.awt.Dimension(920, 712));

        jPanel7.setBackground(new java.awt.Color(67, 67, 67));

        jScrollPane1.setBackground(new java.awt.Color(67, 67, 67));
        jScrollPane1.setBorder(null);

        jTable1.setBackground(new java.awt.Color(87, 87, 87));
        jTable1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTable1.setForeground(new java.awt.Color(255, 255, 255));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jTable1.setFocusable(false);
        jTable1.setGridColor(new java.awt.Color(67, 67, 67));
        jTable1.setRowHeight(30);
        jTable1.setSelectionBackground(new java.awt.Color(214, 0, 255));
        jTable1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable1.setShowHorizontalLines(false);
        jTable1.setShowVerticalLines(false);
        jScrollPane1.setViewportView(jTable1);

        myButton12.setText("Add New Professor ");
        myButton12.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        myButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myButton12ActionPerformed(evt);
            }
        });

        myButton13.setText("Delete Professor");
        myButton13.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        myButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myButton13ActionPerformed(evt);
            }
        });

        myButton14.setText("Adjust Professor");
        myButton14.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        myButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myButton14ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 930, Short.MAX_VALUE)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(myButton12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(myButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(myButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 664, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(myButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(myButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(myButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel6.setBackground(new java.awt.Color(67, 67, 67));

        jScrollPane2.setBorder(null);

        jTable2.setBackground(new java.awt.Color(87, 87, 87));
        jTable2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
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
        jTable2.setRequestFocusEnabled(false);
        jTable2.setRowHeight(30);
        jTable2.setSelectionBackground(new java.awt.Color(214, 0, 255));
        jTable2.setShowHorizontalLines(false);
        jTable2.setShowVerticalLines(false);
        jScrollPane2.setViewportView(jTable2);

        myButton8.setText("Add New Subject");
        myButton8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        myButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myButton8ActionPerformed(evt);
            }
        });

        myButton9.setText("Delete Subject");
        myButton9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        myButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myButton9ActionPerformed(evt);
            }
        });

        myButton10.setText("Adjust Subject");
        myButton10.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        myButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myButton10ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 930, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(myButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(myButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(myButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 664, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(myButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(myButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(myButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(67, 67, 67));
        jPanel3.setPreferredSize(new java.awt.Dimension(918, 712));

        jScrollPane3.setBorder(null);

        jTable3.setBackground(new java.awt.Color(87, 87, 87));
        jTable3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTable3.setModel(new javax.swing.table.DefaultTableModel(
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
        jTable3.setRequestFocusEnabled(false);
        jTable3.setRowHeight(30);
        jTable3.setSelectionBackground(new java.awt.Color(214, 0, 255));
        jTable3.setShowHorizontalLines(false);
        jTable3.setShowVerticalLines(false);
        jScrollPane3.setViewportView(jTable3);

        myButton1.setText("Add New Student");
        myButton1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        myButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myButton1ActionPerformed(evt);
            }
        });

        myButton2.setText("Adjust Student");
        myButton2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        myButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myButton2ActionPerformed(evt);
            }
        });

        myButton3.setText("Delete Student");
        myButton3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        myButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 930, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(myButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(myButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(myButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 658, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(myButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(myButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(myButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel5Layout.createSequentialGroup()
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 930, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel5Layout.createSequentialGroup()
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 724, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jSplitPane1.setRightComponent(jPanel5);

        javax.swing.GroupLayout newJPanel1Layout = new javax.swing.GroupLayout(newJPanel1);
        newJPanel1.setLayout(newJPanel1Layout);
        newJPanel1Layout.setHorizontalGroup(
            newJPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(newJPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSplitPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1139, Short.MAX_VALUE)
                .addContainerGap())
        );
        newJPanel1Layout.setVerticalGroup(
            newJPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, newJPanel1Layout.createSequentialGroup()
                .addComponent(jSplitPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 714, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(newJPanel1, "card2");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void profilePicture3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_profilePicture3MouseClicked
        System.exit(0);
    }//GEN-LAST:event_profilePicture3MouseClicked

    private void profilePicture2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_profilePicture2MouseClicked
        LogInFrame logInFramePanel = new LogInFrame();
        logInFramePanel.setVisible(true);
        RemoveAll();
        dispose();
    }//GEN-LAST:event_profilePicture2MouseClicked

    private void myButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myButton4ActionPerformed
        jPanel3.setVisible(true);
        jPanel6.setVisible(false);
        jPanel7.setVisible(false);

        jTable3.setShowGrid(false);
        jTable3.getTableHeader().setDefaultRenderer(new AdminFrame.TableHeader());
        jTable3.getTableHeader().setPreferredSize(new Dimension(0, 35));
        jTable3.setBackground(new Color(67, 67, 67));
        jTable3.setForeground(Color.WHITE);
    }//GEN-LAST:event_myButton4ActionPerformed

    private void myButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myButton6ActionPerformed
        jPanel7.setVisible(true);
        jPanel6.setVisible(false);
        jPanel3.setVisible(false);

        jTable1.setShowGrid(false);
        jTable1.getTableHeader().setDefaultRenderer(new AdminFrame.TableHeader());
        jTable1.getTableHeader().setPreferredSize(new Dimension(0, 35));
        jTable1.setBackground(new Color(67, 67, 67));
        jTable1.setForeground(Color.WHITE);
    }//GEN-LAST:event_myButton6ActionPerformed

    private void myButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myButton5ActionPerformed
        jPanel7.setVisible(false);
        jPanel6.setVisible(true);
        jPanel3.setVisible(false);

        jTable2.setShowGrid(false);
        jTable2.getTableHeader().setDefaultRenderer(new AdminFrame.TableHeader());
        jTable2.getTableHeader().setPreferredSize(new Dimension(0, 35));
        jTable2.setBackground(new Color(67, 67, 67));
        jTable2.setForeground(Color.WHITE);
    }//GEN-LAST:event_myButton5ActionPerformed

    private void myButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myButton3ActionPerformed
        int row = jTable3.getSelectedRow();
        String id = jTable3.getModel().getValueAt(row, 0).toString();
        String name = jTable3.getModel().getValueAt(row, 1).toString();
        String username = jTable3.getModel().getValueAt(row, 2).toString();
        String year = jTable3.getModel().getValueAt(row, 3).toString();
        String password = jTable3.getModel().getValueAt(row, 4).toString();

        int index = 0;
        int counter = 0;
        String[] temp = new String[1000];
        Obligations[] tempObligations = new Obligations[1000];

        for (int i = 0; i < counterObligations; i++) {
            if (!arrayObligations[i].getStudentID().equals(id)) {
                tempObligations[counter] = new Obligations();
                tempObligations[counter].setGrade(arrayObligations[i].getGrade());
                tempObligations[counter].setMaximumPoints(arrayObligations[i].getMaximumPoints());
                tempObligations[counter].setObligationName(arrayObligations[i].getObligationName());
                tempObligations[counter].setObligationType(arrayObligations[i].getObligationType());
                tempObligations[counter].setPrecentage(arrayObligations[i].getPrecentage());
                tempObligations[counter].setScoredPoints(arrayObligations[i].getScoredPoints());
                tempObligations[counter].setStudentID(arrayObligations[i].getStudentID());
                tempObligations[counter].setStudentName(arrayObligations[i].getStudentName());
                tempObligations[counter].setSubjectName(arrayObligations[i].getSubjectName());
                tempObligations[counter].setGrade(arrayObligations[i].getGrade());
                counter++;
            }
        }

        counterObligations = counter;

        for (int i = 0; i < counterObligations; i++) {
            arrayObligations[i].setGrade(tempObligations[i].getGrade());
            arrayObligations[i].setMaximumPoints(tempObligations[i].getMaximumPoints());
            arrayObligations[i].setObligationName(tempObligations[i].getObligationName());
            arrayObligations[i].setObligationType(tempObligations[i].getObligationType());
            arrayObligations[i].setPrecentage(tempObligations[i].getPrecentage());
            arrayObligations[i].setScoredPoints(tempObligations[i].getScoredPoints());
            arrayObligations[i].setStudentID(tempObligations[i].getStudentID());
            arrayObligations[i].setStudentName(tempObligations[i].getStudentName());
            arrayObligations[i].setSubjectName(tempObligations[i].getSubjectName());
            arrayObligations[i].setGrade(tempObligations[i].getGrade());
        }

        counter = 0;

        for (int i = 0; i < finalGradeCounter; i += 3) {
            if (!finalGrade[i + 1].equals(id)) {
                temp[counter] = finalGrade[i];
                counter++;
                temp[counter] = finalGrade[i + 1];
                counter++;
                temp[counter] = finalGrade[i + 2];
                counter++;
            }
        }

        finalGradeCounter = counter;

        for (int i = 0; i < finalGradeCounter; i += 3) {
            finalGrade[i] = temp[i];
            finalGrade[i + 1] = temp[i + 1];
            finalGrade[i + 2] = temp[i + 2];
        }

        for (int i = 0; i < counterStudent; i++) {
            if (Student[i].getId().equals(id) && Student[i].getName().equals(name) && Student[i].getPassword().equals(password) && Student[i].getStudy_year().equals(year) && Student[i].getUsername().equals(username)) {
                index = i;
            }
        }

        for (int i = index; i < counterStudent - 1; i++) {
            Student[i].setId(Student[i + 1].getId());
            Student[i].setName(Student[i + 1].getName());
            Student[i].setPassword(Student[i + 1].getPassword());
            Student[i].setPicture(Student[i + 1].getPicture());
            Student[i].setStudy_year(Student[i + 1].getStudy_year());
            Student[i].setUsername(Student[i + 1].getUsername());
        }

        counterStudent--;

        WriteStudent();
    }//GEN-LAST:event_myButton3ActionPerformed

    private void myButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myButton2ActionPerformed
        int row = jTable3.getSelectedRow();
        String id = jTable3.getModel().getValueAt(row, 0).toString();
        String name = jTable3.getModel().getValueAt(row, 1).toString();
        String username = jTable3.getModel().getValueAt(row, 2).toString();
        String year = jTable3.getModel().getValueAt(row, 3).toString();
        String pass = jTable3.getModel().getValueAt(row, 4).toString();

        AdjustStudent AdjustStudentPanel = new AdjustStudent();
        AdjustStudentPanel.pass(id, name, username, pass, year);
        AdjustStudentPanel.setVisible(true);
    }//GEN-LAST:event_myButton2ActionPerformed

    private void myButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myButton1ActionPerformed

        AddStudent AddStudentPanel = new AddStudent();
        AddStudentPanel.setVisible(true);

    }//GEN-LAST:event_myButton1ActionPerformed

    private void myButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myButton8ActionPerformed

        AddSubject AddSubjectPanel = new AddSubject();
        AddSubjectPanel.setVisible(true);

    }//GEN-LAST:event_myButton8ActionPerformed

    private void myButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myButton9ActionPerformed
        int row = jTable2.getSelectedRow();
        String id = jTable2.getModel().getValueAt(row, 0).toString();
        String name = jTable2.getModel().getValueAt(row, 1).toString();
        String semester = jTable2.getModel().getValueAt(row, 2).toString();
        String ects = jTable2.getModel().getValueAt(row, 3).toString();
        String year = jTable2.getModel().getValueAt(row, 4).toString();
        String professor = jTable2.getModel().getValueAt(row, 5).toString();

        int index = 0;
        int counter = 0;
        String[] temp = new String[1000];
        Obligations[] tempObligations = new Obligations[1000];

        for (int i = 0; i < counterSubjects; i++) {
            if (arraySubjects[i].getId().equals(id)) {
                index = i;
            }
        }

        for (int i = index; i < counterSubjects - 1; i++) {
            arraySubjects[i].setId(arraySubjects[i + 1].getId());
            arraySubjects[i].setName(arraySubjects[i + 1].getName());
            arraySubjects[i].setNumberOfObligations(arraySubjects[i + 1].getNumberOfObligations());
            arraySubjects[i].setObligations(arraySubjects[i + 1].getObligations());
            arraySubjects[i].setProfessor(arraySubjects[i + 1].getProfessor());
            arraySubjects[i].setSemester(arraySubjects[i + 1].getSemester());
            arraySubjects[i].setYear(arraySubjects[i + 1].getYear());
            arraySubjects[i].setEctsPoints(arraySubjects[i + 1].getEctsPoints());
            arraySubjects[i].setGrade(arraySubjects[i + 1].getGrade());
        }

        counterSubjects--;

        for (int i = 0; i < counterObligations; i++) {
            if (!arrayObligations[i].getSubjectName().equals(id)) {
                tempObligations[counter] = new Obligations();
                tempObligations[counter].setGrade(arrayObligations[i].getGrade());
                tempObligations[counter].setMaximumPoints(arrayObligations[i].getMaximumPoints());
                tempObligations[counter].setObligationName(arrayObligations[i].getObligationName());
                tempObligations[counter].setObligationType(arrayObligations[i].getObligationType());
                tempObligations[counter].setPrecentage(arrayObligations[i].getPrecentage());
                tempObligations[counter].setScoredPoints(arrayObligations[i].getScoredPoints());
                tempObligations[counter].setStudentID(arrayObligations[i].getStudentID());
                tempObligations[counter].setStudentName(arrayObligations[i].getStudentName());
                tempObligations[counter].setSubjectName(arrayObligations[i].getSubjectName());
                tempObligations[counter].setGrade(arrayObligations[i].getGrade());
                counter++;
            }
        }

        counterObligations = counter;

        for (int i = 0; i < counterObligations; i++) {
            arrayObligations[i].setGrade(tempObligations[i].getGrade());
            arrayObligations[i].setMaximumPoints(tempObligations[i].getMaximumPoints());
            arrayObligations[i].setObligationName(tempObligations[i].getObligationName());
            arrayObligations[i].setObligationType(tempObligations[i].getObligationType());
            arrayObligations[i].setPrecentage(tempObligations[i].getPrecentage());
            arrayObligations[i].setScoredPoints(tempObligations[i].getScoredPoints());
            arrayObligations[i].setStudentID(tempObligations[i].getStudentID());
            arrayObligations[i].setStudentName(tempObligations[i].getStudentName());
            arrayObligations[i].setSubjectName(tempObligations[i].getSubjectName());
            arrayObligations[i].setGrade(tempObligations[i].getGrade());
        }

        counter = 0;

        for (int i = 0; i < finalGradeCounter; i += 3) {
            if (!finalGrade[i].equals(id)) {
                temp[counter] = finalGrade[i];
                counter++;
                temp[counter] = finalGrade[i + 1];
                counter++;
                temp[counter] = finalGrade[i + 2];
                counter++;
            }
        }

        finalGradeCounter = counter;

        for (int i = 0; i < finalGradeCounter; i += 3) {
            finalGrade[i] = temp[i];
            finalGrade[i + 1] = temp[i + 1];
            finalGrade[i + 2] = temp[i + 2];
        }

        counter = 0;

        for (int i = 0; i < counterSubjectObligations; i += 3) {
            if (!subjectObligations[i + 2].equals(id)) {
                temp[counter] = subjectObligations[i];
                counter++;
                temp[counter] = subjectObligations[i + 1];
                counter++;
                temp[counter] = subjectObligations[i + 2];
                counter++;
            }
        }

        counterSubjectObligations = counter;

        for (int i = 0; i < counterSubjectObligations; i++) {
            subjectObligations[i] = temp[i];
        }

        WriteSubjects();
    }//GEN-LAST:event_myButton9ActionPerformed

    private void myButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myButton10ActionPerformed

        int row = jTable2.getSelectedRow();
        String id = jTable2.getModel().getValueAt(row, 0).toString();
        String name = jTable2.getModel().getValueAt(row, 1).toString();
        String semester = jTable2.getModel().getValueAt(row, 2).toString();
        String ects = jTable2.getModel().getValueAt(row, 3).toString();
        String year = jTable2.getModel().getValueAt(row, 4).toString();
        String professor = jTable2.getModel().getValueAt(row, 5).toString();

        AdjustSubject AdjustSubjectPanel = new AdjustSubject();
        AdjustSubjectPanel.pass(id, name, semester, ects, year, professor);
        AdjustSubjectPanel.setVisible(true);

    }//GEN-LAST:event_myButton10ActionPerformed

    private void myButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myButton12ActionPerformed
        AddProfessor AddProfessorPanel = new AddProfessor();
        AddProfessorPanel.setVisible(true);
    }//GEN-LAST:event_myButton12ActionPerformed

    private void myButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myButton13ActionPerformed
        int row = jTable1.getSelectedRow();
        String id = jTable1.getModel().getValueAt(row, 0).toString();
        String name = jTable1.getModel().getValueAt(row, 1).toString();
        String username = jTable1.getModel().getValueAt(row, 2).toString();
        String password = jTable1.getModel().getValueAt(row, 3).toString();

        int index = 0;
        int counter = 0;
        String[] temp = new String[1000];
        Obligations[] tempObligations = new Obligations[1000];

        for (int i = 0; i < counterProfessorAdmin; i++) {
            if (professorAdmin[i].getID().equals(id)) {
                index = i;
            }
        }

        for (int i = index; i < counterProfessorAdmin - 1; i++) {
            professorAdmin[i].setID(professorAdmin[i + 1].getID());
            professorAdmin[i].setName(professorAdmin[i + 1].getName());
            professorAdmin[i].setPassword(professorAdmin[i + 1].getPassword());
            professorAdmin[i].setUsername(professorAdmin[i + 1].getUsername());
        }

        counterProfessorAdmin--;

        for (int i = 0; i < counterSubjects; i++) {
            if (arraySubjects[i].getProfessor().equals(name)) {
                arraySubjects[i].setProfessor("");
                arraySubjects[i].setProfessorID("");
            }
        }

        WriteProfessor();
    }//GEN-LAST:event_myButton13ActionPerformed

    private void myButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myButton14ActionPerformed
        int row = jTable1.getSelectedRow();
        String id = jTable1.getModel().getValueAt(row, 0).toString();
        String name = jTable1.getModel().getValueAt(row, 1).toString();
        String username = jTable1.getModel().getValueAt(row, 2).toString();
        String pass = jTable1.getModel().getValueAt(row, 3).toString();

        AdjustProfessor AdjustProfessorPanel = new AdjustProfessor();
        AdjustProfessorPanel.pass(id, name, username, pass);
        AdjustProfessorPanel.setVisible(true);
    }//GEN-LAST:event_myButton14ActionPerformed

    private void myButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myButton15ActionPerformed

        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost/javaproject", "root", "");
            stm = conn.createStatement();
            PreparedStatement stmt;

            sql = "DELETE FROM obligation_student";
            stm.executeUpdate(sql);

            sql = "DELETE FROM obligation_subject";
            stm.executeUpdate(sql);

            sql = "DELETE FROM student_final_grade";
            stm.executeUpdate(sql);

            sql = "DELETE FROM student";
            stm.executeUpdate(sql);

            sql = "DELETE FROM subject";
            stm.executeUpdate(sql);

            sql = "DELETE FROM professor";
            stm.executeUpdate(sql);

            for (int i = 0; i < counterProfessorAdmin; i++) {
                Blob blob = new SerialBlob(professorAdmin[i].getPicture());
                sql = "INSERT INTO `professor`(`ID`, `FULL_NAME`, `USERNAME`, `PASSWORD`, `PICTURE`) VALUES ('" + professorAdmin[i].getID() + "','" + professorAdmin[i].getName() + "','" + professorAdmin[i].getUsername() + "','" + professorAdmin[i].getPassword() + "', ?)";
                stmt = conn.prepareStatement(sql);
                stmt.setBlob(1, blob);
                stmt.execute();
            }

            for (int i = 0; i < counterStudent; i++) {
                Blob blob = new SerialBlob(Student[i].getPicture());
                sql = "INSERT INTO `student`(`ID`, `FULL_NAME`, `USERNAME`, `PASSWORD`, `STUDY_YEAR`, `PICTURE`) VALUES ('" + Student[i].getId() + "','" + Student[i].getName() + "','" + Student[i].getUsername() + "','" + Student[i].getPassword() + "'," + Student[i].getStudy_year() + ",?)";
                stmt = conn.prepareStatement(sql);
                stmt.setBlob(1, blob);
                stmt.execute();
            }

            for (int i = 0; i < finalGradeCounter; i += 3) {
                sql = "INSERT INTO `student_final_grade`(`SUBJECT_ID`, `STUDENT_ID`, `FINAL_GRADE`) VALUES ('" + finalGrade[i] + "','" + finalGrade[i + 1] + "','" + finalGrade[i + 2] + "')";
                stm.executeUpdate(sql);
            }

            for (int i = 0; i < counterObligations; i++) {
                sql = "INSERT INTO `obligation_student`(`OBLIGATION_NAME`, `OBLIGATION_TYPE`, `SUBJECT_ID`, `STUDENT_ID`, `MAXIMUM_POINTS`, `SCORED_POINTS`, `GRADE`, `GRADE_PRECENTAGE`) VALUES ('" + arrayObligations[i].getObligationName() + "','" + arrayObligations[i].getObligationType() + "','" + arrayObligations[i].getSubjectName() + "','" + arrayObligations[i].getStudentID() + "'," + arrayObligations[i].getMaximumPoints() + "," + arrayObligations[i].getScoredPoints() + "," + arrayObligations[i].getGrade() + "," + arrayObligations[i].getPrecentage() + ")";
                stm.executeUpdate(sql);
            }

            for (int i = 0; i < counterSubjects; i++) {
                if (arraySubjects[i].getProfessorID().equals("")) {
                    sql = "INSERT INTO `subject`(`ID`, `SUBJECT_NAME`, `YEAR`, `SEMESTER`, `ECTS_POINTS`) VALUES ('" + arraySubjects[i].getId() + "','" + arraySubjects[i].getName() + "','" + arraySubjects[i].getYear() + "','" + arraySubjects[i].getSemester() + "'," + arraySubjects[i].getEctsPoints() + ")";
                    stm.executeUpdate(sql);
                } else {
                    sql = "INSERT INTO `subject`(`ID`, `SUBJECT_NAME`, `PROFESSOR_ID`, `YEAR`, `SEMESTER`, `ECTS_POINTS`) VALUES ('" + arraySubjects[i].getId() + "','" + arraySubjects[i].getName() + "','" + arraySubjects[i].getProfessorID() + "','" + arraySubjects[i].getYear() + "','" + arraySubjects[i].getSemester() + "'," + arraySubjects[i].getEctsPoints() + ")";
                    stm.executeUpdate(sql);
                }

                String[] temp = arraySubjects[i].getObligations();

                for (int j = 0; j < arraySubjects[i].getNumberOfObligations() * 2; j += 2) {
                    sql = "INSERT INTO `obligation_subject`(`OBLIGATION_TYPE`, `POINTS_FOR_SUBJECT`, `SUBJECT_ID`) VALUES ('" + temp[j] + "','" + temp[j + 1] + "','" + arraySubjects[i].getId() + "')";

                    stm.executeUpdate(sql);
                }

            }

            stm.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(AdminFrame.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_myButton15ActionPerformed

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
            java.util.logging.Logger.getLogger(AdminFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSplitPane jSplitPane1;
    private static javax.swing.JTable jTable1;
    private static javax.swing.JTable jTable2;
    private static javax.swing.JTable jTable3;
    private AddOns.MyButton myButton1;
    private AddOns.MyButton myButton10;
    private AddOns.MyButton myButton12;
    private AddOns.MyButton myButton13;
    private AddOns.MyButton myButton14;
    private AddOns.MyButton myButton15;
    private AddOns.MyButton myButton2;
    private AddOns.MyButton myButton3;
    private AddOns.MyButton myButton4;
    private AddOns.MyButton myButton5;
    private AddOns.MyButton myButton6;
    private AddOns.MyButton myButton8;
    private AddOns.MyButton myButton9;
    private AddOns.TransparentPanel newJPanel1;
    private AddOns.ProfilePicture profilePicture2;
    private AddOns.ProfilePicture profilePicture3;
    // End of variables declaration//GEN-END:variables
}
