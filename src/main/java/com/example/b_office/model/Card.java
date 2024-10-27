package com.example.b_office.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "card")
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "effectif")
    private Integer effectif;

    @Column(name = "date_prevue_demarrage")
    @Temporal(TemporalType.DATE)
    private Date datePrevueDemarrage;

    @Column(name = "commentaire", length = 500)
    private String commentaire;


    @OneToOne
    @JoinColumn(name = "filiere_id", unique = true) // Ensures one-to-one relationship
    private Filiere filiere;

    @Column(name = "statut",nullable = false)
    private Integer statut = 1;


    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
    public Card() {
    }

    public Card(Integer effectif, Date datePrevueDemarrage, String commentaire, Filiere filiere, User user) {
        this.effectif = effectif;
        this.datePrevueDemarrage = datePrevueDemarrage;
        this.commentaire = commentaire;
        this.filiere = filiere;
        this.user = user;
    }

    public Card(Integer effectif, Date datePrevueDemarrage, String commentaire, Filiere filiere) {
    }

    // Getters and setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getEffectif() {
        return effectif;
    }

    public void setEffectif(Integer effectif) {
        this.effectif = effectif;
    }

    public Date getDatePrevueDemarrage() {
        return datePrevueDemarrage;
    }

    public void setDatePrevueDemarrage(Date datePrevueDemarrage) {
        this.datePrevueDemarrage = datePrevueDemarrage;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public Filiere getFiliere() {
        return filiere;
    }

    public void setFiliere(Filiere filiere) {
        this.filiere = filiere;
    }

    public Integer getStatut() {
        return statut;
    }

    public void setStatut(Integer statut) {
        this.statut = statut;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
