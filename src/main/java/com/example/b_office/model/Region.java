package com.example.b_office.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Region {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;


    @ManyToOne
    @JoinColumn(name = "code_dr")
    private CodeDR codeDR;





    public Region(String name, CodeDR codeDR) {
        this.name = name;
        this.codeDR = codeDR;
    }

    public Region() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public CodeDR getCodeDR() {
        return codeDR;
    }

    public void setCodeDR(CodeDR codeDR) {
        this.codeDR = codeDR;
    }

}
