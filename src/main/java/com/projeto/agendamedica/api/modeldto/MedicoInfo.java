package com.projeto.agendamedica.api.modeldto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MedicoInfo {

    private Long medicoId;
    private String nome;
    private String crm;
    private Integer idade;
}
