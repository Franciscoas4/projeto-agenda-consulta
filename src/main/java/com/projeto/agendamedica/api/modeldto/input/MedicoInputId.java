package com.projeto.agendamedica.api.modeldto.input;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class MedicoInputId {

    @NotNull
    private Long medicoId;
}
