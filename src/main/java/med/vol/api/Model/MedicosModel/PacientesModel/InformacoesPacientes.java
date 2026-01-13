package med.vol.api.Model.MedicosModel.PacientesModel;

import med.vol.api.Model.MedicosModel.MedicoEntity;

public record InformacoesPacientes(String nome, Long telefone) {

    public InformacoesPacientes(PacientesEntity pacientes){
        this(pacientes.getNome(), pacientes.getTelefone());
    }
}
