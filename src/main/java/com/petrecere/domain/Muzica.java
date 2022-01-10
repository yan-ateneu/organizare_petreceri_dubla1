package com.petrecere.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;

@Getter
@Setter
@Builder
public class Muzica {
    @Column(name = "stil muzical")
    private String stil;
    @Column(name = "forma interpretare")
    private String forma;
    @Column(name = "nr_artisti_necesari")
    private Integer nr;
}
