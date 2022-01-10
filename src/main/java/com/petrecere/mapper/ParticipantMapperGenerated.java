package com.petrecere.mapper;

import com.petrecere.domain.Participant;
import com.petrecere.dto.ParticipantDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ParticipantMapperGenerated {
    @Mapping(target = "nume", source = "participant.nume")
    @Mapping(target = "prenume", source = "participant.prenume")
    @Mapping(target = "varsta", source = "participant.varsta")
    ParticipantDto mapToDto(Participant participant);

    @Mapping(target = "nume", source = "participantDto.nume")
    @Mapping(target = "prenume", source = "participantDto.prenume")
    @Mapping(target = "varsta", source = "participantDto.varsta")
    Participant mapToEntity(ParticipantDto participantDto);
}
