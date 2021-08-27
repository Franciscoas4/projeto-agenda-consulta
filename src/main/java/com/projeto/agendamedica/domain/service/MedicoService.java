package com.projeto.agendamedica.domain.service;

import com.projeto.agendamedica.api.modeldto.MedicoInfo;
import com.projeto.agendamedica.domain.exception.NegocioException;
import com.projeto.agendamedica.domain.model.Medico;
import com.projeto.agendamedica.domain.repository.MedicoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class MedicoService {

    private MedicoRepository medicoRepository;

    public List<Medico> listarMedicos() {
        return medicoRepository.findAll();
    }

    public Medico cadastrarMedico(Medico medico) {
        boolean crmEmUso = medicoRepository.findByCrm(medico.getCrm())
                .stream()
                .anyMatch(medicoExistente -> !medicoExistente.equals(medico));

        if (crmEmUso) {
            throw new NegocioException("Já existe um médico cadastrado com esse CRM.");
        }

        return medicoRepository.save(medico);
    }

    public Medico buscarPorId(Long medicoId) {
        return medicoRepository.findById(medicoId).orElseThrow(() -> new NegocioException("Médico não encontrado."));
    }

    public List<Medico> buscarMedicoNome(String nome) {
        return medicoRepository.findByNome(nome);
    }

    public List<Medico> buscarMedicoCrm(String crm) {
        return medicoRepository.findByCrm(crm);
    }
}
