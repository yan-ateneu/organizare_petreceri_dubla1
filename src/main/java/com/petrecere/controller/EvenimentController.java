package com.petrecere.controller;

import com.petrecere.dto.EvenimentDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.petrecere.service.EvenimentService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/evenimente")
public class EvenimentController {
    @Autowired
    private EvenimentService service;


    @GetMapping("")
    public List<EvenimentDto> getAll() {
        return service.getAllEvenimente();
    }

    @PostMapping()
    public EvenimentDto create(@Valid @RequestBody EvenimentDto evenimentDto) {
        return service.save(evenimentDto);
    }
    @PatchMapping("/{id_locatie}")
    public ResponseEntity<EvenimentDto> updatePartial(@RequestBody EvenimentDto evenimentDto, @PathVariable Long id_locatie) {
        return ResponseEntity.ok(service.updatePartialDto(evenimentDto, id_locatie));
    }
    @GetMapping("/filter")
    public List<EvenimentDto> filterPersons(@RequestParam Long id_locatie) {
        return service.filter(id_locatie);
    }
}
