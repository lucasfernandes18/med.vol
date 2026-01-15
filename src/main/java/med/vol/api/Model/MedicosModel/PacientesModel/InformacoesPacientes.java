package med.vol.api.Model.MedicosModel.PacientesModel;

import med.vol.api.Model.MedicosModel.MedicoEntity;

public record InformacoesPacientes(Long id, String nome,String email, Long telefone) {

    public InformacoesPacientes(PacientesEntity pacientes){
        this(pacientes.getId(), pacientes.getNome(),pacientes.getEmail(), pacientes.getTelefone());
    }
}
