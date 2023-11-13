package com.employeeAPI.entities;

import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Employee")
public class Employee {
	//generating ID's automatically using IDENTITY strategy in MySQL
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    @Column(name = "name", nullable = false)
    private String name;
    
    @Column(name = "email", unique = true, nullable = false)
    private String email;
    
    @Column(name = "phone", unique = true, nullable = false)
    private long phone;
    
    @Column(name = "created_by", nullable = false)
    private String created_by;
    
    //generating the Date when the record is created automatically
    @Column(name = "created_on", nullable = false)
    @CreationTimestamp
    private LocalDate created_on;

    public Employee() {
        super();
    }

    public Employee(String name, String email, long phone, String created_by) {
        super();
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.created_by = created_by;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public String getCreated_by() {
        return created_by;
    }

    public void setCreated_by(String created_by) {
        this.created_by = created_by;
    }

    public LocalDate getCreated_on() {
        return created_on;
    }

    public void setCreated_on(LocalDate created_on) {
        this.created_on = created_on;
    }
}
