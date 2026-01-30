package med.vol.api.Model.MedicosModel.EnderecoMedico;

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

        @NotBlank
        String cidade,

        @NotBlank
        String uf,

        @NotBlank
        String complemento,

        @NotNull
        Integer numero



) {
        public EnderecoDTO(EnderecoEntity dados){
                this( dados.getLogradouro(),
                 dados.getBairro(),
                dados.getCep(),
                dados.getCidade(),
                dados.getUf(),
                dados.getComplemento(),
                dados.getNumero());

        }


}
