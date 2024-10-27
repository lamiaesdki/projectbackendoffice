package com.example.b_office.controllers;

import com.example.b_office.model.UniteOrganisation;
import com.example.b_office.repositories.UniteOrganisationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/unite-organisations")
public class UniteOrgController {

    @Autowired
    private UniteOrganisationRepository uniteOrganisationRepository;

    // Fetch all DR (Direction Régionale)
    @GetMapping("/dr")
    public List<UniteOrganisation> getAllDrs() {
        List<UniteOrganisation> drs = uniteOrganisationRepository.findByTypeUO_Id(2L);

        // Debugging: Print out the number of DRs fetched and their details
        System.out.println("Repository returned DRs: " + drs.size());
        for (UniteOrganisation dr : drs) {
            System.out.println("DR ID: " + dr.getId() + ", Name: " + dr.getLibelleuo());
        }

        return drs;
    }

    // Fetch CMPs by DR id
    @GetMapping("/cmp/by-dr/{drId}")
    public List<UniteOrganisation> getCmpsByDr(@PathVariable Long drId) {
        return uniteOrganisationRepository.findByTypeUO_IdAndParentUo_Id(3L, drId);
    }

    // Fetch EFPs by CMP id
    @GetMapping("/efp/by-cmp/{cmpId}")
    public List<UniteOrganisation> getEfpsByCmp(@PathVariable Long cmpId) {
        return uniteOrganisationRepository.findByTypeUO_IdAndParentUo_Id(4L, cmpId);
    }
}
