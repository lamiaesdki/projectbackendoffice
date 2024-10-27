package com.example.b_office.repositories;

import com.example.b_office.model.ModeFormation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ModeFormationRepository extends JpaRepository<ModeFormation, Long> {
    Optional<ModeFormation> findByName(String name);

    ModeFormation getById(int id);
}
