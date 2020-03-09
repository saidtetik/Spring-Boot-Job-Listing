package com.project.joblist.model;

import javax.persistence.*;


@Entity
public class Applicant {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String email;
    private String phone;
    @Lob
    private String address;
    @Lob
    private String tought;
    @Lob
    private String resume;
    private String resumeName;

    public String getResumeName() {
        return resumeName;
    }

    public void setResumeName(String resumeName) {
        this.resumeName = resumeName;
    }

    public Applicant(){

    }
    public Applicant(String name, String email, String phone, String address, String tought, String resume){
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.tought = tought;
        this.resume = resume;
    }
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTought() {
        return tought;
    }

    public void setTought(String tought) {
        this.tought = tought;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }


}
