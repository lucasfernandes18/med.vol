package med.vol.api.Model.MedicosModel;

import jakarta.validation.constraints.NotNull;
import med.vol.api.Model.MedicosModel.EnderecoMedicoModel.EnderecoDTO;

public record DadosDeAtualizacaoMedico(
        @NotNull
        Long id,
        String nome,
        String telefone,
        EnderecoDTO endereco


) {
}
