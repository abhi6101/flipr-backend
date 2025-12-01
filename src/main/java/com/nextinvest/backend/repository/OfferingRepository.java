package com.nextinvest.backend.repository;

import com.nextinvest.backend.model.Offering;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OfferingRepository extends JpaRepository<Offering, Long> {
}