package com.petrecere.mapper;

import com.petrecere.domain.Participant;
import com.petrecere.dto.ParticipantDto;
import org.springframework.stereotype.Component;

@Component
public class ParticipantMapper {
    public ParticipantDto mapToDto(Participant participant) {
        return ParticipantDto.builder()
                .id(participant.getId())
                .nume(participant.getNume())
                .prenume(participant.getPrenume())
                .varsta(participant.getVarsta())
                .build();
    }
    public Participant mapToEntity(ParticipantDto participantDto) {
        return Participant.builder()
                .id(participantDto.getId())
                .nume(participantDto.getNume())
                .prenume(participantDto.getPrenume())
                .varsta(participantDto.getVarsta())
                .build();
    }
}
