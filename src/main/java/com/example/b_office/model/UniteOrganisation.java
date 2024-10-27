package com.example.b_office.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "unite_organisation")
public class UniteOrganisation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "codeuo", nullable = false)
    private String codeuo;

    @Column(name = "libelleuo", nullable = false)
    private String libelleuo;

    @ManyToOne
    @JoinColumn(name = "TypeUO_id")
    @JsonBackReference
    private TypeUO typeUO;

    @Column(name = "libelle_reduituo")
    private String libelleReduitUo;

    @ManyToOne
    @JoinColumn(name = "id_codeuoparent")
    @JsonIgnore
    private UniteOrganisation parentUo;



    @OneToOne(mappedBy = "uniteOrganisation")
    @JsonIgnore
    private User user;

    // Default constructor
    public UniteOrganisation() {
    }

    // Parameterized constructor
    public UniteOrganisation(Long id, String codeuo, String libelleuo, TypeUO typeUO, String libelleReduitUo, UniteOrganisation parentUo) {
        this.id = id;
        this.codeuo = codeuo;
        this.libelleuo = libelleuo;
        this.typeUO = typeUO;
        this.libelleReduitUo = libelleReduitUo;
        this.parentUo = parentUo;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodeuo() {
        return codeuo;
    }

    public void setCodeuo(String codeuo) {
        this.codeuo = codeuo;
    }

    public String getLibelleuo() {
        return libelleuo;
    }

    public void setLibelleuo(String libelleuo) {
        this.libelleuo = libelleuo;
    }

    public String getLibelleReduitUo() {
        return libelleReduitUo;
    }

    public void setLibelleReduitUo(String libelleReduitUo) {
        this.libelleReduitUo = libelleReduitUo;
    }

    public UniteOrganisation getParentUo() {
        return parentUo;
    }

    public void setParentUo(UniteOrganisation parentUo) {
        this.parentUo = parentUo;
    }


    public TypeUO getTypeUO() {
        return typeUO;
    }

    public void setTypeUO(TypeUO typeUO) {
        this.typeUO = typeUO;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
