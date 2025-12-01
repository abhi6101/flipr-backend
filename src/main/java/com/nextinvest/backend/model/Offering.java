package com.nextinvest.backend.model;

import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;

@Entity
@Data
@Table(name = "offerings")
public class Offering {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tag;         // e.g. "House"
    private String image;       // e.g. "/10.svg"
    private String title;       // e.g. "Oxalis"
    private String location;    // e.g. "Brooklyn, NY"
    
    @Column(length = 1000)
    private String description;

    private BigDecimal raised;  // e.g. 574920
    private BigDecimal target;  // e.g. 1000000
    
    private String securityType; // e.g. "Revenue Sharing Note"
    private Double multiple;     // e.g. 1.4
    private Integer maturity;    // e.g. 48
    private BigDecimal minInvestment; // e.g. 100
}