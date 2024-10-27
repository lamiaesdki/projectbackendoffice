package com.example.b_office.controllers;

import com.example.b_office.model.AnneeFormation;
import com.example.b_office.model.ModeFormation;
import com.example.b_office.model.NiveauFormation;
import com.example.b_office.model.TypeFormation;
import com.example.b_office.repositories.AnneeFormationRepository;
import com.example.b_office.repositories.ModeFormationRepository;
import com.example.b_office.repositories.NiveauFormationRepository;
import com.example.b_office.repositories.TypeFormationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/reference-data")
public class ReferenceDataController {

    @Autowired
    private TypeFormationRepository typeFormationRepository;

    @Autowired
    private NiveauFormationRepository niveauFormationRepository;

    @Autowired
    private AnneeFormationRepository anneeFormationRepository;

    @Autowired
    private ModeFormationRepository modeFormationRepository;

    @GetMapping("/type-formations")
    public List<TypeFormation> getAllTypeFormations() {
        System.out.println("data fetched"+typeFormationRepository.findAll());
        return typeFormationRepository.findAll();
    }

    @GetMapping("/niveau-formations")
    public List<NiveauFormation> getAllNiveauFormations() {
        return niveauFormationRepository.findAll();
    }

    @GetMapping("/annee-formations")
    public List<AnneeFormation> getAllAnneeFormations() {
        return anneeFormationRepository.findAll();
    }

    @GetMapping("/mode-formations")
    public List<ModeFormation> getAllModeFormations() {
        return modeFormationRepository.findAll();
    }
}
