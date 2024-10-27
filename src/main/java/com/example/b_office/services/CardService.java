package com.example.b_office.services;

import com.example.b_office.dto.CardDTO;
import com.example.b_office.exception.ResourceNotFoundException;
import com.example.b_office.model.Card;
import com.example.b_office.model.Filiere;
import com.example.b_office.model.User;
import com.example.b_office.repositories.CardRepository;
import com.example.b_office.repositories.FiliereRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CardService {

    @Autowired
    private CardRepository cardRepository;

    @Autowired
    private FiliereRepository filiereRepository;

    public List<CardDTO> getAllCardsWithFiliereDetails() {
        List<Card> cards = cardRepository.findAll();
        List<CardDTO> cardDTOs = new ArrayList<>();

        for (Card card : cards) {
            CardDTO dto = new CardDTO();
            dto.setId(card.getId());
            dto.setEffectif(card.getEffectif());
            dto.setDatePrevueDemarrage(card.getDatePrevueDemarrage());
            card.getStatut();

            if (card.getFiliere() != null) {
                dto.setCodeFil(card.getFiliere().getCodeFil());
                dto.setIntituler(card.getFiliere().getIntituler());
            }

            cardDTOs.add(dto);
        }

        return cardDTOs;
    }

    public List<Card> findCardsByFiliereCriteria(Long typeFormationId, Long niveauFormationId,
                                                 Long anneeFormationId, Long modeFormationId) {
        return cardRepository.findCardsByFiliereCriteria(typeFormationId, niveauFormationId, anneeFormationId, modeFormationId);
    }

    public List<Filiere> getFilieresWithoutCard() {
        List<Card> cards = cardRepository.findAll();
        List<String> codesFiliereInCards = cards.stream()
                .map(card -> card.getFiliere().getCodeFil())
                .distinct()
                .collect(Collectors.toList());

        return filiereRepository.findByCodeFilNotIn(codesFiliereInCards);
    }

    public Card createCard(Card card, User user) {
        if (card.getId() == null) {
            card.setStatut(1); // New card, first save
        } else {
            // Logic to change status based on user's role
            if (user.getRole().equals("dir_cmp")) {
                card.setStatut(3); // Approved by dir_cmp
            } else if (!user.getRole().equals("admin") && !user.getRole().equals("dir_efp")) {
                card.setStatut(2); // Submitted for approval
            }
        }
        return cardRepository.save(card);
    }

    public Card rejectCard(Integer id, User user) {
        Card card = cardRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Card not found"));

        if (user.getRole().equals("dir_cmp")) {
            card.setStatut(1); // Rejected, revert to status 1
        }
        return cardRepository.save(card);
    }
    public Card updateCard(Integer id, Integer effectif, Date datePrevueDemarrage, String commentaire) {
        Optional<Card> optionalCard = cardRepository.findById(id);
        Card cardd = optionalCard.get();
        System.out.println("effectif"+cardd.getEffectif());
        if (optionalCard.isPresent()) {
            Card card = optionalCard.get();
            card.setEffectif(effectif);
            card.setDatePrevueDemarrage(datePrevueDemarrage);
            card.setCommentaire(commentaire);
            return cardRepository.save(card);
        } else {
            throw new ResourceNotFoundException("Card not found with ID: " + id);
        }
    }

    public void deleteCard(Integer id) {
        if (cardRepository.existsById(id)) {
            cardRepository.deleteById(id);
        } else {
            throw new ResourceNotFoundException("Card not found with ID: " + id);
        }
    }
    public Card getCardById(Integer id) throws ResourceNotFoundException {
        Optional<Card> card = cardRepository.findById(id);
        System.out.println(card.get());
        if (card.isPresent()) {
            return card.get();
        } else {
            throw new ResourceNotFoundException("Card not found with id: " + id);
        }
    }
}

