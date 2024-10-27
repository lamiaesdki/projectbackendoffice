package com.example.b_office.repositories;

import com.example.b_office.model.UniteOrganisation;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface UniteOrganisationRepository extends JpaRepository<UniteOrganisation, Long> {
    List<UniteOrganisation> findByTypeUO_Id(Long typeuo_id);
    List<UniteOrganisation> findByTypeUO_IdAndParentUo_Id(Long typeUOId, Long parentUoId);



}
