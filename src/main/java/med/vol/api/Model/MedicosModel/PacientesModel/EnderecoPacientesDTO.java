package med.vol.api.Model.MedicosModel.PacientesModel;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record EnderecoPacientesDTO(

        @NotBlank
        String logradouro,

        @NotBlank
        String bairro,

        @NotNull
        @Pattern(regexp = "\\d{8}") //valida se o usuário digitou 8 números.
        String cep,

        @NotBlank
        String cidade,

        @NotBlank
        String uf,

        @NotBlank
        String complemento,

        @NotNull
        Number numero

) {
}
