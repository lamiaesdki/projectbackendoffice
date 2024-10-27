package com.example.b_office.repositories;

import com.example.b_office.model.NiveauFormation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface NiveauFormationRepository extends JpaRepository<NiveauFormation, Long> {
    Optional<NiveauFormation> findByName(String name);
    NiveauFormation getById(long id);
}
