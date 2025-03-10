package com.mkr.springboot.SpringWebApp.entity;

import javax.persistence.*;

import java.util.Arrays;
import java.util.Date;

@Entity
@Table(name="learner")
public class Student {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="full_names")
    private String fullNames;

    @Column(name="email")

    // more fields, getters and setters




    private String email;
    private String gender;
    private String faculty;
    private Date dob;
    private String phoneNumber;

    @Lob
    byte[] image;

    @Lob
    byte[] pdf;

    @Transient
    private String date;
    @Transient
    private String base64Image;

    @Transient
    private String base64File;

    // define constructors

    public Student() {
    }

    public Student(String fullNames, String email) {
        this.fullNames = fullNames;
        this.email = email;
    }

    public Student(String fullNames, String email, String gender, String faculty, Date dob, String phoneNumber, byte[] image, byte[] pdf) {
        this.fullNames = fullNames;
        this.email = email;
        this.gender = gender;
        this.faculty = faculty;
        this.dob = dob;
        this.phoneNumber = phoneNumber;
        this.image = image;
        this.pdf = pdf;
    }

    public Student(String fullNames, String email, String phoneNumber, byte[] pdf, byte[] image) {
        this.fullNames = fullNames;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.pdf = pdf;
        this.image = image;
    }

    public Student(int id, String fullNames, String email) {
        this.id = id;
        this.fullNames = fullNames;
        this.email = email;
            }

    public Student(String fullNames, String email, String faculty, String phoneNumber) {
        this.fullNames = fullNames;
        this.email = email;
        this.faculty = faculty;
        this.phoneNumber = phoneNumber;
    }

    public String getFullNames() {
        return fullNames;
    }

    public void setFullNames(String fullNames) {
        this.fullNames = fullNames;
    }

    public int getId() {
        return id;
    }

    public String getBase64File() {
        return base64File;
    }

    public void setBase64File(String base64File) {
        this.base64File = base64File;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public byte[] getPdf() {
        return pdf;
    }

    public void setPdf(byte[] pdf) {
        this.pdf = pdf;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getBase64Image() {
        return base64Image;
    }

    public void setBase64Image(String base64Image) {
        this.base64Image = base64Image;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", fullNames='" + fullNames + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
