package com.projeto.agendamedica.api.modeldto.input;

import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class MedicoInput {

    @NotBlank
    private String nome;

    @NotBlank
    private String crm;

    private Integer idade;

}
