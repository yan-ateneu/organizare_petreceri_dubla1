package com.petrecere.dto;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.validation.constraints.Size;
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ParticipantDto {
    @NotNull
    private String nume;

    private String prenume;

    @Size(min = 16, max = 100)
    private Integer varsta;
}
