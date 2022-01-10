package com.petrecere.service;

import com.petrecere.domain.Eveniment;
import com.petrecere.domain.Locatie;
import com.petrecere.dto.EvenimentDto;
import com.petrecere.dto.LocatieDto;
import com.petrecere.exception.NoDataFoundException;
import com.petrecere.mapper.LocatieMapper;
import com.petrecere.mapper.LocatieMapperGenerated;
import com.petrecere.repository.LocatieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LocatieService {
    @Autowired
    private LocatieRepository repository;

    @Autowired
    private LocatieMapper mapper;

    @Autowired
    private LocatieMapperGenerated mapperGenerated;

    public List<LocatieDto> getAllLocatii() {
        List<LocatieDto> locatiiDtos = repository.getAll()
                .stream()
                .map(locatie -> mapperGenerated.mapToDto(locatie))
                .collect(Collectors.toList());

        if (locatiiDtos.isEmpty()) {
            throw new NoDataFoundException("No data found");
        }
        return locatiiDtos;
    }
    public LocatieDto save(LocatieDto locatieDto) {
        Locatie locatie = mapperGenerated.mapToEntity(locatieDto);
        Locatie locatieSalvat = repository.save(locatie);
        return mapperGenerated.mapToDto(locatieSalvat);
    }
    public List<LocatieDto> filter(String oras) {
        List<Locatie> locatii = repository.getFilteredLocatii_orase(oras);
        return locatii.stream().map(p -> mapper.mapToDto(p)).collect(Collectors.toList());
    }
}
