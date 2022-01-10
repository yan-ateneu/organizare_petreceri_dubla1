package com.petrecere.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Builder
public class Eveniment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "denumire")
    private String denumire;
    @JoinColumn(name = "id_locatie")
    private Long id_locatie;
    @Column(name = "buget")
    private Integer buget;
}
