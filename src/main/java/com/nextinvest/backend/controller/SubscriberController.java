package com.nextinvest.backend.controller;

import com.nextinvest.backend.model.Subscriber;
import com.nextinvest.backend.repository.SubscriberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/newsletter")
// CHANGE: Allow all origins so the live site can send emails
@CrossOrigin(origins = "*")
public class SubscriberController {

    @Autowired
    private SubscriberRepository repository;

    // 1. Save Email (Public)
    @PostMapping
    public Subscriber subscribe(@RequestBody Subscriber subscriber) {
        return repository.save(subscriber);
    }

    // 2. Get All Emails (Admin)
    @GetMapping
    public List<Subscriber> getAllSubscribers() {
        return repository.findAll();
    }

    // 3. Delete Subscriber (Admin)
    @DeleteMapping("/{id}")
    public void deleteSubscriber(@PathVariable Long id) {
        repository.deleteById(id);
    }
}