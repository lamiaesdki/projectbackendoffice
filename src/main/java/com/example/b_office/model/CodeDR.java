package com.example.b_office.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class CodeDR {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "codeDR")
    private String codeDR;

    @Column(name = "libDR")
    private String libDR;

    @ManyToOne
    @JoinColumn(name = "typeUO_id")
    private TypeUO typeUO;

    @ManyToOne
    @JoinColumn(name = "region_id")
    private Region region;


    // Default constructor
    public CodeDR() {}

    // Constructor for initializing with codeDR, libDR, and typeUO
    public CodeDR(String codeDR, String libDR, TypeUO typeUO) {
        this.codeDR = codeDR;
        this.libDR = libDR;
        this.typeUO = typeUO;
    }

    // Constructor for initializing with all fields
    public CodeDR(String codeDR, String libDR, TypeUO typeUO, Region region) {
        this.codeDR = codeDR;
        this.libDR = libDR;
        this.typeUO = typeUO;
        this.region = region;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodeDR() {
        return codeDR;
    }

    public void setCodeDR(String codeDR) {
        this.codeDR = codeDR;
    }

    public String getLibDR() {
        return libDR;
    }

    public void setLibDR(String libDR) {
        this.libDR = libDR;
    }

    public TypeUO getTypeUO() {
        return typeUO;
    }

    public void setTypeUO(TypeUO typeUO) {
        this.typeUO = typeUO;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }



 }
