package com.petrecere.controller;

import com.petrecere.dto.LocatieDto;
import com.petrecere.dto.ParticipantDto;
import org.springframework.beans.factory.annotation.Autowired;
import com.petrecere.service.ParticipantService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
@RestController
@RequestMapping("/participanti")
public class ParticipantController {
    @Autowired
    private ParticipantService service;
    @GetMapping("")
    public List<ParticipantDto> getAll() {
        return service.getAllParticipanti();
    }
    @PostMapping()
    public ParticipantDto create(@Valid @RequestBody ParticipantDto participantDto) {
        return service.save(participantDto);
    }
    @GetMapping("/varsta")
    public List<ParticipantDto> filterPersons(@RequestParam Integer varsta) {
        return service.filter(varsta);
    }
}
