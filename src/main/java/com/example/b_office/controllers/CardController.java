package com.example.b_office.controllers;

import com.example.b_office.dto.CardDTO;
import com.example.b_office.exception.ResourceNotFoundException;
import com.example.b_office.model.Card;
import com.example.b_office.model.Filiere;
import com.example.b_office.model.User;
import com.example.b_office.repositories.CardRepository;
import com.example.b_office.repositories.FiliereRepository;
import com.example.b_office.repositories.UserRepository;
import com.example.b_office.services.CardService;
import com.example.b_office.services.FiliereService;
import com.example.b_office.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/cards")
public class CardController {

    @Autowired
    private CardService cardService;
    @Autowired
    private UserService userService;
    @Autowired
    private FiliereRepository filiereRepository;
    @Autowired
    private UserRepository userRepository;// Assuming you have a FiliereService
    @Autowired
    private CardRepository cardRepository;

    @PostMapping("/create")
    public ResponseEntity<?> createCard(@RequestParam Long userId, @RequestBody CardDTO cardDTO) {
        if (cardDTO.getFiliereId() == null) {
            return ResponseEntity.badRequest().build(); // Return a 400 Bad Request if Filiere ID is missing
        }

        // Fetch the Filiere by its ID
        Filiere filiere = filiereRepository.findById(Long.valueOf(cardDTO.getFiliereId()))
                .orElseThrow(() -> new ResourceNotFoundException("Filiere not found with ID: " + cardDTO.getFiliereId()));

        // Fetch the User by its ID
        Optional<User> userOptional = userRepository.findById(userId);
        if (!userOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid userId");
        }

        User user = userOptional.get();

        // Create a new Card entity and set the Filiere and User
        Card card = new Card();
        card.setEffectif(cardDTO.getEffectif());
        card.setDatePrevueDemarrage(cardDTO.getDatePrevueDemarrage());
        card.setCommentaire(cardDTO.getCommentaire());
        card.setFiliere(filiere);
        card.setUser(user);

        // Set the statut based on the user's role
        int statut = (user.getRole().equals("admin") || user.getRole().equals("dir_efp")) ? 1 : 2;
        card.setStatut(statut);

        // Save the Card entity using the service
        Card savedCard = cardService.createCard(card, user);

        // Convert saved card to DTO to include the statut
        CardDTO savedCardDTO = new CardDTO();
        savedCardDTO.setId(savedCard.getId());
        savedCardDTO.setFiliereId(savedCard.getFiliere().getId());
        savedCardDTO.setEffectif(savedCard.getEffectif());
        savedCardDTO.setDatePrevueDemarrage(savedCard.getDatePrevueDemarrage());
        savedCardDTO.setCommentaire(savedCard.getCommentaire());
        savedCardDTO.setStatut(savedCard.getStatut());

        return ResponseEntity.ok(savedCardDTO);
    }



    @GetMapping
    public ResponseEntity<List<CardDTO>> getAllCardsWithFiliereDetails() {
        List<CardDTO> cardDTOs = cardService.getAllCardsWithFiliereDetails();
        return ResponseEntity.ok(cardDTOs);
    }

    @GetMapping("/search")
    public ResponseEntity<List<CardDTO>> searchCards(
            @RequestParam(required = false) Long typeFormationId,
            @RequestParam(required = false) Long niveauFormationId,
            @RequestParam(required = false) Long anneeFormationId,
            @RequestParam(required = false) Long modeFormationId) {

        List<Card> cards = cardService.findCardsByFiliereCriteria(typeFormationId, niveauFormationId, anneeFormationId, modeFormationId);

        // Convert to DTO
        List<CardDTO> cardDTOs = cards.stream().map(card -> {
            CardDTO dto = new CardDTO();
            dto.setId(card.getId());
            dto.setCodeFil(card.getFiliere() != null ? card.getFiliere().getCodeFil() : "N/A");
            dto.setIntituler(card.getFiliere() != null ? card.getFiliere().getIntituler() : "N/A");
            dto.setEffectif(card.getEffectif());
            dto.setDatePrevueDemarrage(card.getDatePrevueDemarrage());
            dto.setCommentaire(card.getCommentaire());
            dto.setStatut(card.getStatut()); // Ensure statut is included
            System.err.println("DTO statut: " + dto.getStatut()); // Debug print
            return dto;
        }).toList();

        return ResponseEntity.ok(cardDTOs);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Card> getCardById(@PathVariable Integer id) {
        try {
            Card card = cardService.getCardById(id);
            return ResponseEntity.ok(card);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateCard(
            @PathVariable Integer id,
            @RequestBody CardDTO cardData) {

        System.out.println("test");
        try {
            // Extract values from cardData
            Integer effectif = cardData.getEffectif();
            Date datePrevueDemarrage = cardData.getDatePrevueDemarrage();
            String commentaire = cardData.getCommentaire();

            Card updatedCard = cardService.updateCard(id, effectif, datePrevueDemarrage, commentaire);
            return ResponseEntity.ok(updatedCard);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteCard(@PathVariable Integer id) {
        try {
            cardService.deleteCard(id);
            return ResponseEntity.ok("Card deleted successfully");
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
    @PutMapping("/reject/{id}")
    public ResponseEntity<?> rejectCard(@PathVariable Integer id, @RequestParam Integer userId) {
        User user = userService.findById(Long.valueOf(userId));
        Card rejectedCard = cardService.rejectCard(id, user);
        return ResponseEntity.ok(rejectedCard);
    }
    @PutMapping("/{id}/update-stat")
    public ResponseEntity<String> updateCardStatut(@PathVariable Long id, @RequestBody CardDTO cardDTO) {
        Optional<Card> cardOptional = cardRepository.findById(Math.toIntExact(id));

        if (!cardOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Card not found");
        }

        Card card = cardOptional.get();
        int newStatut = cardDTO.getStatut();

        // Handle validation, submission, and rejection
        if (newStatut == 3) {
            // Set statut to 3 (Validated)
            card.setStatut(3);
        } else if (newStatut == 1) {
            // Set statut to 1 (Rejected)
            card.setStatut(1);
        } else if (newStatut == 2) {
            // Set statut to 2 (Submitted for Approval)
            card.setStatut(2);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid status");
        }

        cardRepository.save(card);
        return ResponseEntity.ok("Card statut updated successfully");
    }



}
