package com.example.b_office.controllers;

import com.example.b_office.model.TypeUO;
import com.example.b_office.repositories.TypeUORepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TypeUOController {

    @Autowired
    private TypeUORepository typeUORepository;

    @GetMapping("/type-uos")
    public List<TypeUO> getAllTypeUOs() {
        return typeUORepository.findAll();  // Ensure this returns all types
    }
}
