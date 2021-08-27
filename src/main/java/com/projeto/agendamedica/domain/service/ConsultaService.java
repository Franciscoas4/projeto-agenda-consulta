package com.projeto.agendamedica.domain.service;

import com.projeto.agendamedica.domain.exception.NegocioException;
import com.projeto.agendamedica.domain.model.Consulta;
import com.projeto.agendamedica.domain.model.Medico;
import com.projeto.agendamedica.domain.repository.ConsultaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.LocalTime;


@AllArgsConstructor
@Service
public class ConsultaService {

    private ConsultaRepository consultaRepository;
    private MedicoService medicoService;

    @Transactional
    public Consulta cadastrarConsulta(Consulta consulta) {
        Medico medico = medicoService.buscarPorId(consulta.getMedico().getMedicoId());
        consulta.setMedico(medico);

        boolean dataExistente = consultaRepository.findByDataConsulta(consulta.getDataConsulta())
                .stream().anyMatch(dataSalva -> !dataSalva.equals(consulta));
        if (dataExistente) {
            throw new NegocioException("Já existe consulta marcada para o horário " + consulta.getDataConsulta() + ". Favor marcar para 15 minutos após esse horário.");
        }

        return consultaRepository.save(consulta);
    }

    public Consulta consultaPorId(Long consultaId) {
        return consultaRepository.findById(consultaId)
                .orElseThrow(() -> new NegocioException("Consulta não encontrado."));
    }


}
