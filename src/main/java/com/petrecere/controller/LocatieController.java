package com.petrecere.controller;

import com.petrecere.dto.EvenimentDto;
import com.petrecere.dto.LocatieDto;
import com.petrecere.service.EvenimentService;
import com.petrecere.service.LocatieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/locatii")
public class LocatieController {
    @Autowired
    private LocatieService service;


    @GetMapping("")
    public List<LocatieDto> getAll() {
        return service.getAllLocatii();
    }

    @PostMapping()
    public LocatieDto create(@Valid @RequestBody LocatieDto locatieDto) {
        return service.save(locatieDto);
    }
    @GetMapping("/filter")
    public List<LocatieDto> filterLocatii_peorase(@RequestParam String oras) {
        return service.filter(oras);
    }
}
