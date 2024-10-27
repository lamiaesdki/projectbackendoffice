package com.example.b_office.repositories;

import com.example.b_office.model.Region;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegionRepository extends JpaRepository<Region, Long> {
    Region findByName(String name);
    Region getById(long id);
}