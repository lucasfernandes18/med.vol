package med.vol.api.Domain.Pacientes.DTOs;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import med.vol.api.Domain.Pacientes.EnderecoPacientes.EnderecoPacientesDTO;

public record PacientesDTO(

        @NotBlank
        String nome,

        @Email
        @NotBlank
        String email,

        @NotNull
        Long telefone,

        @NotNull
        @Valid
        EnderecoPacientesDTO endereco,

        @NotNull
        Boolean ativo

) {
}
