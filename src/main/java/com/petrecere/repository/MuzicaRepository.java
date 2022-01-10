package com.petrecere.repository;

import com.petrecere.domain.Locatie;
import com.petrecere.domain.Muzica;
import com.petrecere.domain.Participant;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MuzicaRepository {
    private List<Muzica> sir_muzica = new ArrayList<>();
    public MuzicaRepository() {
        setupInitialData();
    }

    public List<Muzica> getAll() { return sir_muzica;
    }

    public Muzica save(Muzica muzica) {
        sir_muzica.add(muzica);
        return muzica;
    }
    private void setupInitialData() {
        Muzica muzica1 = Muzica.builder()
                .stil("techno")
                .forma("Dj")
                .nr(1)
                .build();
        sir_muzica.add(muzica1);
        Muzica muzica2 = Muzica.builder()
                .stil("rock")
                .forma("formatie")
                .nr(3)
                .build();
        sir_muzica.add(muzica2);
    }
}
