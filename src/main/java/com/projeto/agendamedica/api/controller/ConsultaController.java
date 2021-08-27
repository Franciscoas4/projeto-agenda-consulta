package com.projeto.agendamedica.api.controller;

import com.projeto.agendamedica.api.mapper.ConsultaMapper;
import com.projeto.agendamedica.api.modeldto.ConsultaInfo;
import com.projeto.agendamedica.api.modeldto.input.ConsultaInput;
import com.projeto.agendamedica.domain.model.Consulta;
import com.projeto.agendamedica.domain.repository.ConsultaRepository;
import com.projeto.agendamedica.domain.service.ConsultaService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/consulta")
public class ConsultaController {

    private ConsultaRepository consultaRepository;
    private ConsultaService consultaService;
    private ConsultaMapper consultaMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ConsultaInfo cadastrarConsulta(@Valid @RequestBody ConsultaInput consultaInput) {
        Consulta consulta = consultaMapper.toEntity(consultaInput);
        Consulta consultaCadastrada = consultaService.cadastrarConsulta(consulta);

        return consultaMapper.toModel(consultaCadastrada);
    }

    @GetMapping
    public List<ConsultaInfo> listarConsultas() {
        return consultaMapper.toCollectionModel(consultaRepository.findAll());
    }

    @GetMapping("/{consultaId}")
    public ResponseEntity<ConsultaInfo> consultaPorId(@PathVariable Long consultaId) {
        return consultaRepository.findById(consultaId)
                .map(consulta -> ResponseEntity.ok(consultaMapper.toModel(consulta)))
                .orElse(ResponseEntity.notFound().build());
    }
}
