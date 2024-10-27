package com.example.b_office.services;

import com.example.b_office.exception.ResourceNotFoundException;
import com.example.b_office.model.UniteOrganisation;
import com.example.b_office.model.User;
import com.example.b_office.repositories.UniteOrganisationRepository;
import com.example.b_office.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UniteOrganisationService {

    @Autowired
    private UniteOrganisationRepository uniteOrganisationRepository;

    @Autowired
    private UserRepository userRepository;

    public void assignUserToUniteOrganisation(Long uoId, Long userId) {
        UniteOrganisation uo = uniteOrganisationRepository.findById(uoId)
                .orElseThrow(() -> new ResourceNotFoundException("UniteOrganisation not found"));

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        uo.setUser(user);
        uniteOrganisationRepository.save(uo);
    }
}
