package med.vol.api.Model.MedicosModel;

public record MedicoListagem(String nome, String email, String crm, Especialidades especialidades) {

    public MedicoListagem(MedicoEntity medico){
        this(medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getEspecialidade());
    }

}
