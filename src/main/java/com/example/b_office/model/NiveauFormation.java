package com.example.b_office.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "niveau_formation") // Optional: specify the table name
public class NiveauFormation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "niveauFormation")
    @JsonIgnore
    private List<Filiere> filieres;

    public NiveauFormation() {
        // Default constructor
    }

    public NiveauFormation(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Filiere> getFilieres() {
        return filieres;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFilieres(List<Filiere> filieres) {
        this.filieres = filieres;
    }
}
