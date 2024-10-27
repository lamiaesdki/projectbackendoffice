package com.example.b_office.repositories;

import com.example.b_office.model.TypeFormation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TypeFormationRepository extends JpaRepository<TypeFormation, Long> {
    Optional<TypeFormation> findByName(String name);
    TypeFormation getById(long id);
}
