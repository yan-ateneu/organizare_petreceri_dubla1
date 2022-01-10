package com.petrecere.service;

import com.petrecere.domain.Locatie;
import com.petrecere.domain.Participant;
import com.petrecere.dto.LocatieDto;
import com.petrecere.dto.ParticipantDto;
import com.petrecere.exception.NoDataFoundException;
import com.petrecere.mapper.ParticipantMapper;
import com.petrecere.mapper.ParticipantMapperGenerated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.petrecere.repository.ParticipantRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ParticipantService {
    @Autowired
    private ParticipantRepository repository;

    @Autowired
    private ParticipantMapper mapper;

    @Autowired
    private ParticipantMapperGenerated mapperGenerated;

    public List<ParticipantDto> getAllParticipanti() {
        List<ParticipantDto> participantiDto =repository.getAll()
                .stream()
                .map(participant -> mapperGenerated.mapToDto(participant))
                .collect(Collectors.toList());

        if (participantiDto.isEmpty()) {
            throw new NoDataFoundException("No data found");
        }
        return participantiDto;
    }
    public ParticipantDto save(ParticipantDto participantDto) {
        Participant participant = mapperGenerated.mapToEntity(participantDto);
        Participant participantSalvat = repository.save(participant);
        return mapperGenerated.mapToDto(participantSalvat);
    }
    public List<ParticipantDto> filter(Integer varsta) {
        List<Participant> participanti = repository.getFilteredParticipanti(varsta);
        return participanti.stream().map(p -> mapper.mapToDto(p)).collect(Collectors.toList());
    }
}
