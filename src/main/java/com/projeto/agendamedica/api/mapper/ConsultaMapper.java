package com.projeto.agendamedica.api.mapper;

import com.projeto.agendamedica.api.modeldto.ConsultaInfo;
import com.projeto.agendamedica.api.modeldto.input.ConsultaInput;
import com.projeto.agendamedica.domain.model.Consulta;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Component
public class ConsultaMapper {

    private ModelMapper modelMapper;

    public ConsultaInfo toModel(Consulta consulta) {
        return modelMapper.map(consulta, ConsultaInfo.class);
    }

    public List<ConsultaInfo> toCollectionModel(List<Consulta> consultas) {
        return consultas.stream()
                .map(this::toModel)
                .collect(Collectors.toList());
    }

    public Consulta toEntity(ConsultaInput consultaInput) {
        return modelMapper.map(consultaInput, Consulta.class);
    }

}
