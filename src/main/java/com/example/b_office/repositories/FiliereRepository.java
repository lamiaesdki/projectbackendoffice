package com.example.b_office.repositories;


import com.example.b_office.model.Filiere;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
//FAM
@Repository
public interface FiliereRepository extends JpaRepository<Filiere, Long> {
    @Override
    Filiere getById(Long aLong);
    @Query("SELECT f FROM Filiere f WHERE " +
            "(:modeFormationId IS NULL OR f.modeFormation.id = :modeFormationId) AND " +
            "(:typeFormationId IS NULL OR f.typeFormation.id = :typeFormationId) AND " +
            "(:niveauFormationId IS NULL OR f.niveauFormation.id = :niveauFormationId) AND " +
            "(:anneeFormationId IS NULL OR f.anneeFormation.id = :anneeFormationId)")
    List<Filiere> findFilieresByCriteria(@Param("modeFormationId") Long modeFormationId,
                                         @Param("typeFormationId") Long typeFormationId,
                                         @Param("niveauFormationId") Long niveauFormationId,
                                         @Param("anneeFormationId") Long anneeFormationId);
    @Query("SELECT f FROM Filiere f LEFT JOIN Card c ON f.id = c.filiere.id " +
            "WHERE c.id IS NULL " +
            "AND (:modeFormationId IS NULL OR f.modeFormation.id = :modeFormationId) " +
            "AND (:typeFormationId IS NULL OR f.typeFormation.id = :typeFormationId) " +
            "AND (:niveauFormationId IS NULL OR f.niveauFormation.id = :niveauFormationId) " +
            "AND (:anneeFormationId IS NULL OR f.anneeFormation.id = :anneeFormationId)")
    List<Filiere> findFilieresWithoutCardAndByCriteria(
            @Param("modeFormationId") Long modeFormationId,
            @Param("typeFormationId") Long typeFormationId,
            @Param("niveauFormationId") Long niveauFormationId,
            @Param("anneeFormationId") Long anneeFormationId);

    List<Filiere> findByCodeFilNotIn(List<String> codes);



}
