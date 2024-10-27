package com.example.b_office.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "mode_formation") // Optional: specify the table name
public class ModeFormation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "modeFormation")
    @JsonIgnore
    private List<Filiere> filieres;

    public ModeFormation() {
        // Default constructor
    }

    public ModeFormation(String name) {
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
