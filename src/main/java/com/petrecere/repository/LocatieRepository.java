package com.petrecere.repository;

import com.petrecere.domain.Eveniment;
import com.petrecere.domain.Locatie;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class LocatieRepository {
    private List<Locatie> locatii = new ArrayList<>();
    public LocatieRepository() {
        setupInitialData();
    }

    public List<Locatie> getAll() {
        return locatii;
    }

    public Locatie save(Locatie locatie) {
        locatii.add(locatie);
        return locatie;
    }

    public List<Locatie> getFilteredLocatii_orase(String oras) {
        return getAll()
                .stream()
                .filter(locatie -> locatie.getOras().equals(oras))
                .collect(Collectors.toList());
    }
    public void delete(Locatie locatie) {
        locatii.remove(locatie);
    }
    private void setupInitialData() {
        Locatie locatie = Locatie.builder()
                .id(1L)
                .denumire("Pensiunea Pui de Urs")
                .oras("Moieciu de sus")
                .tarif(2300)
                .build();
        locatii.add(locatie);
    }

}
