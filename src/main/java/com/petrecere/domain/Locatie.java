package com.petrecere.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Getter
@Setter
@Builder
public class Locatie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    @Column(name = "denumire")
    private String denumire;
    @Column(name = "oras")
    private String oras;
    @Column(name = "tarif")
    private Integer tarif;
}
