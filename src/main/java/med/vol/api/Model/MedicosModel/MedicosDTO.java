package med.vol.api.Model.MedicosModel;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.vol.api.Model.MedicosModel.EnderecoMedicoModel.EnderecoDTO;

public record MedicosDTO(
        @NotBlank // verifica se o campo é nulo ou vazio
        String nome,

        @NotBlank
        @Email
        String email,

        @NotBlank
        String telefone,

        @NotBlank
        @Pattern(regexp = "\\d{4,6}") //verifica se o usuário digitou de 4 a 6 dígitos
        String crm,

        @NotNull //Não é usado @NotBlank porque não é um campo string.
        Especialidades especialidade,

        @NotNull
        @Valid //valida também o outro dto
        EnderecoDTO endereco
) {
}
