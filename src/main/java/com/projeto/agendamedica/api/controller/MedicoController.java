package com.projeto.agendamedica.api.controller;

import com.projeto.agendamedica.api.mapper.MedicoMapper;
import com.projeto.agendamedica.api.modeldto.MedicoInfo;
import com.projeto.agendamedica.api.modeldto.input.MedicoInput;
import com.projeto.agendamedica.domain.model.Medico;
import com.projeto.agendamedica.domain.repository.MedicoRepository;
import com.projeto.agendamedica.domain.service.MedicoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/medico")
public class MedicoController {

    private MedicoRepository medicoRepository;
    private MedicoService medicoService;
    private MedicoMapper medicoMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MedicoInfo cadastrar(@Valid @RequestBody MedicoInput medicoInput) {
        Medico medico = medicoMapper.toEntity(medicoInput);
        Medico medicoCadastrado = medicoService.cadastrarMedico(medico);

        return medicoMapper.toModel(medicoCadastrado);
    }

    @GetMapping
    public List<MedicoInfo> listarMedicos() {
        return medicoMapper.toCollectionModel(medicoRepository.findAll());
    }

    @GetMapping("/{medicoId}")
    public ResponseEntity<MedicoInfo> listarMedicoPorId(@PathVariable Long medicoId) {
        return medicoRepository.findById(medicoId)
                .map(medico -> ResponseEntity.ok(medicoMapper.toModel(medico)))
                .orElse(ResponseEntity.notFound().build());
    }
}
