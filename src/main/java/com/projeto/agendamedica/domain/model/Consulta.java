package com.projeto.agendamedica.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Consulta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long consultaId;

    @Column(nullable = false)
    private String nomePaciente;

    @Column(nullable = false)
    private String especialidade;

    @Column(nullable = false)
    private LocalDateTime dataConsulta;

    private Integer consultorio;

   @ManyToOne
   private Medico medico;

}
