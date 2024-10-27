package com.example.b_office.controllers;

import com.example.b_office.model.LoginResponse;
import com.example.b_office.model.Role;
import com.example.b_office.model.UniteOrganisation;
import com.example.b_office.model.User;
import com.example.b_office.repositories.RoleRepository;
import com.example.b_office.repositories.UniteOrganisationRepository;
import com.example.b_office.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:9000")
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private UniteOrganisationRepository uniteOrganisationRepository;


    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody User user) {
        Optional<User> existingUser = userRepository.findByEmail(user.getEmail());
        if (existingUser.isPresent()) {
            return ResponseEntity.badRequest().body("Email is already in use.");
        }

        // Find the role by name
        Optional<Role> roleOptional = roleRepository.findByName(user.getRole().getName());
        if (!roleOptional.isPresent()) {
            return ResponseEntity.badRequest().body("Role not found.");
        }
        user.setRole(roleOptional.get());

        // Find the UniteOrganisation by ID
        if (user.getUniteOrganisation() != null && user.getUniteOrganisation().getId() != null) {
            Optional<UniteOrganisation> uoOptional = uniteOrganisationRepository.findById(user.getUniteOrganisation().getId());
            if (!uoOptional.isPresent()) {
                return ResponseEntity.badRequest().body("Unite Organisation not found.");
            }
            user.setUniteOrganisation(uoOptional.get());
        }

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return ResponseEntity.ok("User registered successfully.");
    }



    @PostMapping("/login")
    public ResponseEntity<LoginResponse> loginUser(@RequestBody User user) {
        Optional<User> existingUser = userRepository.findByEmail(user.getEmail());
        if (existingUser.isPresent()) {
            User authenticatedUser = existingUser.get();
            if (passwordEncoder.matches(user.getPassword(), authenticatedUser.getPassword())) {
                String role = authenticatedUser.getRole().getName();
                return ResponseEntity.ok(new LoginResponse("Login successful", role, authenticatedUser.getId())); // Returning userId
            } else {
                return ResponseEntity.badRequest().body(new LoginResponse("Invalid password", null, null));
            }
        } else {
            return ResponseEntity.badRequest().body(new LoginResponse("User not found", null, null));
        }
    }

    @GetMapping("/user/{userId}/uo-libelle")
    public ResponseEntity<Map<String, Object>> getUserUoLibelle(@PathVariable Long userId) {
        Optional<User> user = userRepository.findById(userId);
        if (user.isPresent() && user.get().getUniteOrganisation() != null) {
            String libelleuo = user.get().getUniteOrganisation().getLibelleuo();
            Long uoId = user.get().getUniteOrganisation().getId(); // Get the UO ID

            Map<String, Object> response = new HashMap<>();
            response.put("libelle", libelleuo);
            response.put("uoId", uoId); // Add the UO ID to the response

            return ResponseEntity.ok(response);
        }
        Map<String, Object> errorResponse = new HashMap<>();
        errorResponse.put("error", "User or UO not found.");
        return ResponseEntity.badRequest().body(errorResponse);
    }



}