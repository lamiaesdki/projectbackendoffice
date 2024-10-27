package com.example.b_office.model;

import jakarta.persistence.*;

@Entity
@Table(name = "secteur")
public class Secteur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;
    @Column(name = "code_secteur")
    private String code_secteur;

    // Default constructor
    public Secteur() {
    }

    // Constructor with name
    public Secteur(String name ,String code_secteur) {
        this.name = name;
        this.code_secteur = code_secteur;


    }

    // Getters and setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode_secteur() {
        return code_secteur;
    }

    public void setCode_secteur(String code_secteur) {
        this.code_secteur = code_secteur;
    }
}

