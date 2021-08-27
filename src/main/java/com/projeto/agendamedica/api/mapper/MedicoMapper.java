package com.projeto.agendamedica.api.mapper;

import com.projeto.agendamedica.api.modeldto.MedicoInfo;
import com.projeto.agendamedica.api.modeldto.input.MedicoInput;
import com.projeto.agendamedica.api.modeldto.input.MedicoInputId;
import com.projeto.agendamedica.domain.model.Medico;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Component
public class MedicoMapper {

    private ModelMapper modelMapper;

    public MedicoInfo toModel(Medico medico) {
        return modelMapper.map(medico, MedicoInfo.class);
    }

    public List<MedicoInfo> toCollectionModel(List<Medico> medicos) {
        return medicos.stream()
                .map(this::toModel)
                .collect(Collectors.toList());
    }

    public Medico toEntity(MedicoInput medicoInput) {
        return modelMapper.map(medicoInput, Medico.class);
    }

    public Medico toEntity(MedicoInputId medicoInputId) {
        return modelMapper.map(medicoInputId, Medico.class);
    }
}
