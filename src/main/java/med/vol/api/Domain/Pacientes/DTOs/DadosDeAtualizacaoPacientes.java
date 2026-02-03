package med.vol.api.Domain.Pacientes.DTOs;

import jakarta.validation.constraints.NotNull;
import med.vol.api.Domain.Pacientes.EnderecoPacientes.EnderecoPacientesDTO;

public record DadosDeAtualizacaoPacientes(
        @NotNull
        Long id,
        String nome,
        String email,
        Long telefone,
        Boolean ativo,
        EnderecoPacientesDTO endereco

) {

}
