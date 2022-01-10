package com.petrecere.mapper;

import com.petrecere.domain.Eveniment;
import com.petrecere.dto.EvenimentDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface EvenimentMapperGenerated {
    @Mapping(target = "id", source = "eveniment.id")
    @Mapping(target = "denumire", source = "eveniment.denumire")
    @Mapping(target = "id_locatie", source = "eveniment.id_locatie")
    @Mapping(target = "buget", source = "eveniment.buget")
    EvenimentDto mapToDto(Eveniment eveniment);

    @Mapping(target = "id", source = "evenimentDto.id")
    @Mapping(target = "denumire", source = "evenimentDto.denumire")
    @Mapping(target = "id_locatie", source = "evenimentDto.id_locatie")
    @Mapping(target = "buget", source = "evenimentDto.buget")
    Eveniment mapToEntity(EvenimentDto evenimentDto);
}
