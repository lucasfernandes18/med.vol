package med.vol.api.Model.MedicosModel.PacientesModel;

import med.vol.api.Model.MedicosModel.DadosEndereco;
import med.vol.api.Model.MedicosModel.Especialidades;

public record PacientesModel(String nome, String email, Long telefone, DadosEnderecoPaciente endereco) {
}
