package com.example.b_office.repositories;


import com.example.b_office.model.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CardRepository extends JpaRepository<Card, Integer> {
    @Query("SELECT c FROM Card c JOIN c.filiere f WHERE " +
            "(:typeFormationId IS NULL OR f.typeFormation.id = :typeFormationId) " +
            "AND (:niveauFormationId IS NULL OR f.niveauFormation.id = :niveauFormationId) " +
            "AND (:anneeFormationId IS NULL OR f.anneeFormation.id = :anneeFormationId) " +
            "AND (:modeFormationId IS NULL OR f.modeFormation.id = :modeFormationId)")
    List<Card> findCardsByFiliereCriteria(@Param("typeFormationId") Long typeFormationId,
                                          @Param("niveauFormationId") Long niveauFormationId,
                                          @Param("anneeFormationId") Long anneeFormationId,
                                          @Param("modeFormationId") Long modeFormationId);
}

