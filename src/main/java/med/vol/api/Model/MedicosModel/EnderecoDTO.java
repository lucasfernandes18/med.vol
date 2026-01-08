package med.vol.api.Model.MedicosModel;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record EnderecoDTO(
        @NotBlank
        String logradouro,

        @NotBlank
        String bairro,

        @NotBlank
        @Pattern(regexp = "\\d{8}") //faz a verificação se foi digitado 8 digitos;
        String cep,

        @NotNull
        String cidade,

        @NotNull
        String uf,

        String complemento,
        Integer numero
) {
}
