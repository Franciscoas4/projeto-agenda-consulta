package com.projeto.agendamedica.domain.repository;

import com.projeto.agendamedica.domain.model.Medico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MedicoRepository extends JpaRepository<Medico, Long> {

    List<Medico> findByNome(String nome);
    List<Medico> findByCrm(String crm);
}
