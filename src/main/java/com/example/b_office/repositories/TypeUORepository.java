package com.example.b_office.repositories;

import com.example.b_office.model.TypeUO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TypeUORepository extends JpaRepository<TypeUO, Long> {
    Optional<TypeUO> findByName(String name);
     TypeUO getById(long id);

}
