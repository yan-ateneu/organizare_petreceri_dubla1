package com.petrecere.mapper;

import com.petrecere.domain.Eveniment;
import com.petrecere.domain.Locatie;
import com.petrecere.dto.EvenimentDto;
import com.petrecere.dto.LocatieDto;
import org.springframework.stereotype.Component;

@Component
public class LocatieMapper {
    public LocatieDto mapToDto(Locatie locatie) {
        return LocatieDto.builder()
                .id(locatie.getId())
                .denumire(locatie.getDenumire())
                .oras(locatie.getOras())
                .tarif(locatie.getTarif())
                .build();
    }
    public Locatie mapToEntity(LocatieDto locatieDto) {
        return Locatie.builder()
                .id(locatieDto.getId())
                .denumire(locatieDto.getDenumire())
                .oras(locatieDto.getOras())
                .tarif(locatieDto.getTarif())
                .build();
    }
}
