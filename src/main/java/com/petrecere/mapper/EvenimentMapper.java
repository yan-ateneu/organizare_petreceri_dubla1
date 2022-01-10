package com.petrecere.mapper;

import com.petrecere.domain.Eveniment;
import com.petrecere.dto.EvenimentDto;
import org.springframework.stereotype.Component;

@Component
public class EvenimentMapper {
    public EvenimentDto mapToDto(Eveniment eveniment) {
        return EvenimentDto.builder()
                .id(eveniment.getId())
                .denumire(eveniment.getDenumire())
                .id_locatie(eveniment.getId_locatie())
                .buget(eveniment.getBuget())
                .build();
    }
    public Eveniment mapToEntity(EvenimentDto evenimentDto) {
        return Eveniment.builder()
                .id(evenimentDto.getId())
                .denumire(evenimentDto.getDenumire())
                .id_locatie(evenimentDto.getId_locatie())
                .buget(evenimentDto.getBuget())
                .build();
    }
}
