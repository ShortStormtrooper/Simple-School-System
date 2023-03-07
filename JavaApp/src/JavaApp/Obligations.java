/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaApp;

/**
 *
 * @author Samardzija Njegos
 */
public class Obligations {

    public Obligations() {
        SubjectName = "";
        ObligationType = "";
        ObligationName = "";
        StudentName = "";
        MaximumPoints = 0;
        ScoredPoints = 0;
        grade = 0;
        precentage = 0;
        StudentID = "";
    }

    public String getSubjectName() {
        return SubjectName;
    }

    public String getStudentName() {
        return StudentName;
    }

    public String getObligationName() {
        return ObligationName;
    }

    public String getObligationType() {
        return ObligationType;
    }

    public double getMaximumPoints() {
        return MaximumPoints;
    }

    public double getScoredPoints() {
        return ScoredPoints;
    }

    public void setSubjectName(String z) {
        SubjectName = z;
    }

    public void setStudentName(String z) {
        StudentName = z;
    }

    public void setObligationName(String t) {
        ObligationName = t;
    }

    public void setObligationType(String t) {
        ObligationType = t;
    }

    public void setMaximumPoints(double l) {
        MaximumPoints = l;
    }

    public void setScoredPoints(double l) {
        ScoredPoints = l;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int newGrade) {
        grade = newGrade;
    }

    public double getPrecentage() {
        return precentage;
    }

    public void setPrecentage(double newPrecentage) {
        precentage = newPrecentage;
    }

    public String getStudentID() {
        return StudentID;
    }

    public void setStudentID(String StudentID) {
        this.StudentID = StudentID;
    }

    private int grade;
    private double precentage;
    private String SubjectName;
    private String StudentID;
    private String ObligationName;
    private String ObligationType;
    private String StudentName;
    private double MaximumPoints;
    private double ScoredPoints;
}
