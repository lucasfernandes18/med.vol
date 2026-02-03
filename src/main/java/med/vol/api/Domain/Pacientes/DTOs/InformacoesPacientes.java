package med.vol.api.Domain.Pacientes.DTOs;

import med.vol.api.Domain.Pacientes.PacientesEntity;

public record InformacoesPacientes(Long id, String nome, String email, Long telefone, Boolean ativo) {

    public InformacoesPacientes(PacientesEntity pacientes){
        this(pacientes.getId(), pacientes.getNome(),pacientes.getEmail(), pacientes.getTelefone(), pacientes.getAtivo());
    }
}
