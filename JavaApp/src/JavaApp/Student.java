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
public class Student {

    private String name;
    private String id;
    private String username;
    private String password;
    private String study_year;
    private byte[] picture;

    public Student() {
        name = "";
        id = "";
        username = "";
        password = "";
        study_year = "";
        picture = null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStudy_year() {
        return study_year;
    }

    public void setStudy_year(String study_year) {
        this.study_year = study_year;
    }

    public byte[] getPicture() {
        return picture;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }

}
