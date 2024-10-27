package com.example.b_office.dto;

import java.util.Date;

public class CardDTO {
    private Integer id;
    private Integer filiereId;
    private String codeFil;
    private String intituler;
    private Integer effectif;
    private Date datePrevueDemarrage;
    private String commentaire;
    private Integer statut=1;

    // Getters and setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public String getCodeFil() {
        return codeFil;
    }

    public void setCodeFil(String codeFil) {
        this.codeFil = codeFil;
    }

    public Integer getFiliereId() {
        return filiereId;
    }

    public void setFiliereId(Integer filiereId) {
        this.filiereId = filiereId;
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

    public String getIntituler() {
        return intituler;
    }

    public void setIntituler(String intituler) {
        this.intituler = intituler;
    }

    public Integer getStatut() {
        return statut;
    }

    public void setStatut(Integer statut) {
        this.statut = statut;
    }
}
