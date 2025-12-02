package com.nextinvest.backend.service;

import com.nextinvest.backend.model.Offering;
import com.nextinvest.backend.repository.OfferingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OfferingService {

    @Autowired
    private OfferingRepository repository;

    // Get all investment cards
    public List<Offering> findAll() {
        return repository.findAll();
    }

    // Get a specific card by ID
    public Optional<Offering> findById(Long id) {
        return repository.findById(id);
    }

    // Save or Update a card
    public Offering save(Offering offering) {
        return repository.save(offering);
    }

    // Delete a card
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}