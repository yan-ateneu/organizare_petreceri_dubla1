package com.petrecere.dto;

import com.sun.istack.NotNull;
import lombok.*;

import javax.validation.constraints.Size;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EvenimentDto {
    @NotNull
    private String denumire;

    private Long id_locatie;

    @Size(min = 100, max = 10000000)
    private Integer buget;
}
