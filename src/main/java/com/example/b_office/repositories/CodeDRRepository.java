package com.example.b_office.repositories;

import com.example.b_office.model.CodeDR;
import com.example.b_office.model.Secteur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CodeDRRepository extends JpaRepository<CodeDR, Long> {

    CodeDR getById(int id);



}
