package com.example.b_office.controllers;

import com.example.b_office.model.Filiere;
import com.example.b_office.repositories.FiliereRepository;
import com.example.b_office.services.CardService;
import com.example.b_office.services.FiliereService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/filieres")
public class FiliereController {

    @Autowired
    private FiliereRepository filiereRepository;

    @Autowired
    private CardService cardService;
    @Autowired
    private FiliereService filiereService;

    @GetMapping
    public List<Filiere> getAllFilieres(@RequestParam(required = false) Long modeFormationId,
                                        @RequestParam(required = false) Long typeFormationId,
                                        @RequestParam(required = false) Long niveauFormationId,
                                        @RequestParam(required = false) Long anneeFormationId) {
        return filiereRepository.findFilieresByCriteria(modeFormationId, typeFormationId, niveauFormationId, anneeFormationId);
    }
    @GetMapping("/by-criteria")
    public ResponseEntity<List<Filiere>> getFilieresByCriteria(
            @RequestParam(required = false) Long modeFormationId,
            @RequestParam(required = false) Long typeFormationId,
            @RequestParam(required = false) Long niveauFormationId,
            @RequestParam(required = false) Long anneeFormationId) {
        List<Filiere> filieres = filiereRepository.findFilieresByCriteria(
                modeFormationId, typeFormationId, niveauFormationId, anneeFormationId);
        return ResponseEntity.ok(filieres);
    }

    @GetMapping("/without-card")
    public ResponseEntity<List<Filiere>> getFilieresWithoutCard(
            @RequestParam(required = false) Long modeFormationId,
            @RequestParam(required = false) Long typeFormationId,
            @RequestParam(required = false) Long niveauFormationId,
            @RequestParam(required = false) Long anneeFormationId) {

        List<Filiere> filieres = filiereService.getFilieresWithoutCardAndByCriteria(
                modeFormationId, typeFormationId, niveauFormationId, anneeFormationId);

        return ResponseEntity.ok(filieres);
    }

}
