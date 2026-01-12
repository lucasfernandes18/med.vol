package med.vol.api.Model.MedicosModel.PacientesModel;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record PacientesDTO(

        @NotBlank
        String nome,

        @Email
        @NotBlank
        String email,

        @NotNull
        Long telefone,

        @NotBlank
        @Valid
        EnderecoPacientesDTO endereco

) {
}
