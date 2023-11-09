package com.inputvalidation.springphonebook.model;

import jakarta.persistence.*;

@Entity
public class PhoneBook {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,name = "NAME")
    private String name;

    @Column(nullable = false,name = "PHONE_NUMBER")
    private String phoneNumber;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getPhoneNumber(){
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "[id: " + id +", name: " + name + ", phoneNumber: " + phoneNumber + " ]";
    }
}
