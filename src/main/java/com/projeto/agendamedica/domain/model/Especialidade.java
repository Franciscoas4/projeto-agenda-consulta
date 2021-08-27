package com.projeto.agendamedica.domain.model;

public enum Especialidade {
    CIRURGIAO("Cirurgião"),
    OUTRAS("Outras");

    private String info;

    Especialidade(String info) {
        this.info = info;
    }

    public static Especialidade getEspeci(String info) {
        if (info != null) {
            return (CIRURGIAO.getInfo().equalsIgnoreCase(info) ? CIRURGIAO : OUTRAS);
        }

        return null;
    }

    public String getInfo() {
        return this.info;
    }
}
