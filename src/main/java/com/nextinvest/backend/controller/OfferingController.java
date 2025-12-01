package com.nextinvest.backend.controller;

import com.nextinvest.backend.model.Offering;
import com.nextinvest.backend.repository.OfferingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:5173")
public class OfferingController {

    @Autowired
    private OfferingRepository repository;

    // 1. Get all offerings
    @GetMapping("/offerings")
    public List<Offering> getAllOfferings() {
        return repository.findAll();
    }

    // 2. NEW: Get Single Offering by ID (For Details Page)
    @GetMapping("/offerings/{id}")
    public Offering getOfferingById(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Offering not found with id: " + id));
    }

    // 3. Add a new offering
    @PostMapping("/admin/offerings")
    public Offering createOffering(@RequestBody Offering offering) {
        return repository.save(offering);
    }

    // 4. Update an offering
    @PutMapping("/admin/offerings/{id}")
    public Offering updateOffering(@PathVariable Long id, @RequestBody Offering newDetail) {
        return repository.findById(id)
                .map(offering -> {
                    offering.setTitle(newDetail.getTitle());
                    offering.setLocation(newDetail.getLocation());
                    offering.setImage(newDetail.getImage());
                    offering.setDescription(newDetail.getDescription());
                    offering.setRaised(newDetail.getRaised());
                    offering.setTarget(newDetail.getTarget());
                    offering.setSecurityType(newDetail.getSecurityType());
                    offering.setMultiple(newDetail.getMultiple());
                    offering.setMaturity(newDetail.getMaturity());
                    offering.setMinInvestment(newDetail.getMinInvestment());
                    return repository.save(offering);
                })
                .orElseGet(() -> {
                    newDetail.setId(id);
                    return repository.save(newDetail);
                });
    }

    // 5. Delete an offering
    @DeleteMapping("/admin/offerings/{id}")
    public void deleteOffering(@PathVariable Long id) {
        repository.deleteById(id);
    }
}