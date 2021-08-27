package com.projeto.agendamedica.api.modeldto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.projeto.agendamedica.domain.model.Especialidade;
import com.projeto.agendamedica.domain.model.Medico;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class ConsultaInfo {

    private Long consultaId;

    @NotEmpty
    private String nomePaciente;

    @NotEmpty
    private String especialidade;

    @NotEmpty
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime dataConsulta;

    private Integer consultorio;

    @NotEmpty
    private Medico medico;
}
