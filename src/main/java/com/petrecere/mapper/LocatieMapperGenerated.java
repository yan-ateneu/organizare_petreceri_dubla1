package com.petrecere.mapper;

import com.petrecere.domain.Eveniment;
import com.petrecere.domain.Locatie;
import com.petrecere.dto.EvenimentDto;
import com.petrecere.dto.LocatieDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface LocatieMapperGenerated {
    @Mapping(target = "id", source = "locatie.id")
    @Mapping(target = "denumire", source = "locatie.denumire")
    @Mapping(target = "oras", source = "locatie.oras")
    @Mapping(target = "tarif", source = "locatie.tarif")
    LocatieDto mapToDto(Locatie locatie);

    @Mapping(target = "id", source = "locatieDto.id")
    @Mapping(target = "denumire", source = "locatieDto.denumire")
    @Mapping(target = "oras", source = "locatieDto.oras")
    @Mapping(target = "tarif", source = "locatieDto.tarif")
    Locatie mapToEntity(LocatieDto locatieDto);
}
