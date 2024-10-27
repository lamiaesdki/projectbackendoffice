package com.example.b_office.repositories;

import com.example.b_office.model.Secteur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SecteurRepository extends JpaRepository<Secteur, Integer> {
    @Override
    Optional<Secteur> findById(Integer integer);
}