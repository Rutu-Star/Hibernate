package com.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int student_id;

    @Column(name = "Name")
    String Name;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    Address address;

    @OneToMany(mappedBy = "student",fetch=FetchType.EAGER, cascade = CascadeType.ALL)
    List<Courses> courses = new ArrayList<>();
    

    public int getId() {
        return student_id;
    }

    public void setId(int student_id) {
        this.student_id = student_id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Courses> getCourses() {
        return courses;
    }

    public void setCourses(List<Courses> courses) {
        this.courses = courses;
    }

    
    
    @Override
    public String toString() {
        return "Student [student_id=" + student_id + ", Name=" + Name + ", address=" + address + "]";
    }
}
