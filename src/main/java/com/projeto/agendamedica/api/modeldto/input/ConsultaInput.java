package com.projeto.agendamedica.api.modeldto.input;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@Setter
public class ConsultaInput {

    @NotEmpty
    private String nomePaciente;

    @NotEmpty
    private String especialidade;

    @NotNull
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime dataConsulta;

    private Integer consultorio;

    @Valid
    @NotNull
    private MedicoInputId medico;
}
