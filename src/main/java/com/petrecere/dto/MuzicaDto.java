package com.petrecere.dto;

import com.sun.istack.NotNull;
import lombok.*;

import javax.validation.constraints.Size;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MuzicaDto {
    @NotNull
    private String tip;

    private String forma;

    @Size(min = 1, max = 50)
    private Integer nr;
}
