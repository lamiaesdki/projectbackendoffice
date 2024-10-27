package com.example.b_office.model;

import jakarta.persistence.*;

@Entity
@Table(name = "filiere")
public class Filiere {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "code_fil")
    private String codeFil;

    @Column(name = "intituler")
    private String intituler;

    @ManyToOne
    @JoinColumn(name = "modefr_id")
    private ModeFormation modeFormation;

    @ManyToOne
    @JoinColumn(name = "typefr_id")
    private TypeFormation typeFormation;

    @ManyToOne
    @JoinColumn(name = "nivfr_id")
    private NiveauFormation niveauFormation;

    @ManyToOne
    @JoinColumn(name = "anfr_id")
    private AnneeFormation anneeFormation;

    @ManyToOne
    @JoinColumn(name = "code_secteur")
    private Secteur secteur;
    @OneToOne(mappedBy = "filiere")
    private Card card;

    public Filiere() {
    }

    public Filiere(String codeFil, String intituler, ModeFormation modeFormation, TypeFormation typeFormation,
                   NiveauFormation niveauFormation, AnneeFormation anneeFormation, Secteur secteur) {
        this.codeFil = codeFil;
        this.intituler = intituler;
        this.modeFormation = modeFormation;
        this.typeFormation = typeFormation;
        this.niveauFormation = niveauFormation;
        this.anneeFormation = anneeFormation;
        this.secteur = secteur;
    }

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

    public String getIntituler() {
        return intituler;
    }

    public void setIntituler(String intituler) {
        this.intituler = intituler;
    }

    public ModeFormation getModeFormation() {
        return modeFormation;
    }

    public void setModeFormation(ModeFormation modeFormation) {
        this.modeFormation = modeFormation;
    }

    public TypeFormation getTypeFormation() {
        return typeFormation;
    }

    public void setTypeFormation(TypeFormation typeFormation) {
        this.typeFormation = typeFormation;
    }

    public NiveauFormation getNiveauFormation() {
        return niveauFormation;
    }

    public void setNiveauFormation(NiveauFormation niveauFormation) {
        this.niveauFormation = niveauFormation;
    }

    public AnneeFormation getAnneeFormation() {
        return anneeFormation;
    }

    public void setAnneeFormation(AnneeFormation anneeFormation) {
        this.anneeFormation = anneeFormation;
    }

    public Secteur getSecteur() {
        return secteur;
    }

    public void setSecteur(Secteur secteur) {
        this.secteur = secteur;
    }
}
