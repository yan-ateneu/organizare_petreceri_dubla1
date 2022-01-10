package com.petrecere.repository;

import com.petrecere.domain.Eveniment;
import com.petrecere.exception.NoDataFoundException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class EvenimentRepository {
    private List<Eveniment> evenimente = new ArrayList<>();
    public EvenimentRepository() {
        setupInitialData();
    }
    public List<Eveniment> getAll() {
        return evenimente;
    }

    public Eveniment save(Eveniment eveniment) {
        evenimente.add(eveniment);
        return eveniment;
    }

    public void delete(Eveniment eveniment) {
        evenimente.remove(eveniment);
    }

    public Eveniment updatePartialEveniment(Eveniment eveniment, Long id_locatie) {
        Eveniment existingEveniment = this.evenimente.stream().filter(even -> even.getId_locatie().equals(id_locatie)).findFirst()
                .orElseThrow(() -> new NoDataFoundException("Person not found!"));
        evenimente.remove(existingEveniment);
        existingEveniment.setDenumire(eveniment.getDenumire() != null ? eveniment.getDenumire() : existingEveniment.getDenumire());
        existingEveniment.setId_locatie(eveniment.getId_locatie() != null ? eveniment.getId_locatie() : existingEveniment.getId_locatie());
        existingEveniment.setBuget(eveniment.getBuget() != null ? eveniment.getBuget() : existingEveniment.getBuget());
        evenimente.add(existingEveniment);
        return existingEveniment;
    }
    public List<Eveniment> getFilteredEvenimente(Long id_locatie) {
        return getAll()
                .stream()
                .filter(eveniment -> eveniment.getId_locatie().equals(id_locatie))
                .collect(Collectors.toList());
    }
    private void setupInitialData() {
        Eveniment eveniment = Eveniment.builder()
                .id(1L)
                .denumire("Saga la Moieciu")
                .id_locatie(1L)
                .buget(1234)
                .build();
        evenimente.add(eveniment);
    }
}
