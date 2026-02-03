package med.vol.api.Domain.Medicos.DTOS;

import jakarta.validation.constraints.NotNull;
import med.vol.api.Domain.Medicos.EnderecoMedico.EnderecoDTO;

public record DadosDeAtualizacaoMedico(
        @NotNull
        Long id,
        String nome,
        String telefone,
        EnderecoDTO endereco


) {
}
