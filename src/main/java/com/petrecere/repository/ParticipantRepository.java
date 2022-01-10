package com.petrecere.repository;

import com.petrecere.domain.Participant;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
@Repository
public class ParticipantRepository {
    private List<Participant> participanti = new ArrayList<>();
    public ParticipantRepository() {
        setupInitialData();
    }


    public List<Participant> getAll() {
        return participanti;
    }
    public Participant save(Participant participant) {
        participanti.add(participant);
        return participant;
    }

    public void delete(Participant participant) {
        participanti.remove(participant);
    }
    public List<Participant> getFilteredParticipanti(Integer varsta) {
        return getAll()
                .stream()
                .filter(person -> person.getVarsta().equals(varsta))
                .collect(Collectors.toList());
    }
    private void setupInitialData() {
        Participant participant = Participant.builder()
                .id(1L)
                .nume("Zidaru")
                .prenume("Catalin")
                .varsta(52)
                .build();
        participanti.add(participant);

        Participant altparticipant = Participant.builder()
                .id(2L)
                .nume("Ronaldo")
                .prenume("Cristiano")
                .varsta(36)
                .build();
        participanti.add(altparticipant);
    }
}
