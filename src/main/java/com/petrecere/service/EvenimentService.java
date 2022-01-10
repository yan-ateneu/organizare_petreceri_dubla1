package com.petrecere.service;

import com.petrecere.domain.Eveniment;
import com.petrecere.dto.EvenimentDto;
import com.petrecere.exception.NoDataFoundException;
import com.petrecere.mapper.EvenimentMapper;
import com.petrecere.mapper.EvenimentMapperGenerated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.petrecere.repository.EvenimentRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EvenimentService {
    @Autowired
    private EvenimentRepository repository;

    @Autowired
    private EvenimentMapper mapper;

    @Autowired
    private EvenimentMapperGenerated mapperGenerated;

    public List<EvenimentDto> getAllEvenimente() {
        List<EvenimentDto> evenimenteDtos = repository.getAll()
                .stream()
                .map(eveniment -> mapperGenerated.mapToDto(eveniment))
                .collect(Collectors.toList());

        if (evenimenteDtos.isEmpty()) {
            throw new NoDataFoundException("No data found");
        }
        return evenimenteDtos;
    }
    public EvenimentDto save(EvenimentDto evenimentDto) {
        Eveniment eveniment = mapperGenerated.mapToEntity(evenimentDto);
        Eveniment evenimentSalvat = repository.save(eveniment);
        return mapperGenerated.mapToDto(evenimentSalvat);
    }
    public EvenimentDto updatePartialDto(EvenimentDto evenimentDto, Long id_locatie) {
        Eveniment eveniment = repository.updatePartialEveniment(mapper.mapToEntity(evenimentDto), id_locatie);
        return mapper.mapToDto(eveniment);
    }
    public List<EvenimentDto> filter(Long id_locatie) {
        List<Eveniment> evenimente = repository.getFilteredEvenimente(id_locatie);
        return evenimente.stream().map(p -> mapper.mapToDto(p)).collect(Collectors.toList());
    }
}
