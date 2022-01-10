package com.petrecere.dto;

import com.sun.istack.NotNull;
import lombok.*;

import javax.validation.constraints.Size;
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LocatieDto {
    @NotNull
    private String denumire;

    private String oras;

    @Size(min = 100, max = 50000)
    private Integer tarif;
}
