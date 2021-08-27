package com.projeto.agendamedica.domain.repository;

import com.projeto.agendamedica.domain.model.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface ConsultaRepository extends JpaRepository<Consulta, Long> {

    List<Consulta> findByDataConsulta(LocalDateTime dataConsulta);
}
