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
public class Subjects {

    public Subjects() {
        id = "";
        name = "";
        professor = "";
        professorID = "";
        year = 0;
        semester = "";
        ectsPoints = 0;
        numberOfObligations = 0;
        obligations = new String[20];
        grade = 0;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getProfessor() {
        return professor;
    }

    public int getYear() {
        return year;
    }

    public String getSemester() {
        return semester;
    }

    public int getEctsPoints() {
        return ectsPoints;
    }

    public int getNumberOfObligations() {
        return numberOfObligations;
    }

    public String[] getObligations() {
        return obligations;
    }

    public double getGrade() {
        return grade;
    }

    public void setId(String z) {
        id = z;
    }

    public void setName(String t) {
        name = t;
    }

    public void setProfessor(String l) {
        professor = l;
    }

    public void setYear(int l) {
        year = l;
    }

    public void setSemester(String l) {
        semester = l;
    }

    public void setEctsPoints(int l) {
        ectsPoints = l;
    }

    public void setNumberOfObligations(int l) {
        numberOfObligations = l;
    }

    public void setObligations(String type, int points, int numofObligations) {
        int counterEnd = numofObligations * 2;
        int counterStart = counterEnd - 2;
        for (int i = counterStart; i < counterEnd; i++) {
            obligations[i] = type;
            i++;
            obligations[i] = String.valueOf(points);
        }
    }

    public void setObligations(String[] newObligations) {
        obligations = newObligations;
    }

    public void setGrade(double l) {
        grade = l;
    }

    public String getProfessorID() {
        return professorID;
    }

    public void setProfessorID(String professorID) {
        this.professorID = professorID;
    }

    private String id;
    private String name;
    private String professor;
    private String professorID;
    private int year;
    private String semester;
    private int ectsPoints;
    private int numberOfObligations;
    private String[] obligations;
    private double grade;

}
