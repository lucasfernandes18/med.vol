package med.vol.api.Model.MedicosModel.PacientesModel;

import jakarta.validation.constraints.NotNull;
import med.vol.api.Model.MedicosModel.DadosDeAtualizacaoMedico;
import med.vol.api.Model.MedicosModel.EnderecoMedicoModel.EnderecoDTO;
import med.vol.api.Model.MedicosModel.EnderecoMedicoModel.EnderecoEntity;
import med.vol.api.Model.MedicosModel.EnderecoPacientes.EnderecoPacientesDTO;

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
