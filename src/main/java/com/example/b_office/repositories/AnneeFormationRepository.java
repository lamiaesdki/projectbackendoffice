package com.example.b_office.repositories;

import com.example.b_office.model.AnneeFormation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnneeFormationRepository extends JpaRepository<AnneeFormation, Long> {

    AnneeFormation getById(long id);
}
