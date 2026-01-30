package med.vol.api.Model.MedicosModel.Medicos;

import jakarta.validation.constraints.NotNull;
import med.vol.api.Model.MedicosModel.EnderecoMedico.EnderecoDTO;

public record DadosDeAtualizacaoMedico(
        @NotNull
        Long id,
        String nome,
        String telefone,
        EnderecoDTO endereco


) {
}
