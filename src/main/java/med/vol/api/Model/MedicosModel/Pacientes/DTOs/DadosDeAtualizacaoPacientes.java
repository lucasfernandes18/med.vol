package med.vol.api.Model.MedicosModel.Pacientes.DTOs;

import jakarta.validation.constraints.NotNull;
import med.vol.api.Model.MedicosModel.Pacientes.EnderecoPacientes.EnderecoPacientesDTO;

public record DadosDeAtualizacaoPacientes(
        @NotNull
        Long id,
        String nome,
        String email,
        Long telefone,
        Boolean atividade,
        EnderecoPacientesDTO endereco

) {

}
