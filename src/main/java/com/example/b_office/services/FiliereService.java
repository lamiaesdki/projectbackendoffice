package com.example.b_office.services;

import com.example.b_office.model.Card;
import com.example.b_office.model.Filiere;
import com.example.b_office.repositories.FiliereRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FiliereService {
    @Autowired
    private FiliereRepository filiereRepository;

    public Filiere findById(Integer id) {
        return filiereRepository.findById(id.longValue()).orElseThrow(() -> new RuntimeException("Filiere not found"));
    }
    public List<Filiere> getFilieresWithoutCardAndByCriteria(Long modeFormationId, Long typeFormationId, Long niveauFormationId, Long anneeFormationId) {
        return filiereRepository.findFilieresWithoutCardAndByCriteria(modeFormationId, typeFormationId, niveauFormationId, anneeFormationId);
    }    public List<Filiere> findFilieresByCriteria(Long typeFormationId, Long niveauFormationId,
                                                Long anneeFormationId, Long modeFormationId) {
        return filiereRepository.findFilieresByCriteria(typeFormationId, niveauFormationId, anneeFormationId, modeFormationId);
    }
}
