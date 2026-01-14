package med.vol.api.Model.MedicosModel;

public record MedicoListagem(Long id, String nome, String email, String crm, Especialidades especialidades) {

    public MedicoListagem(MedicoEntity medico){
        this(medico.getId(), medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getEspecialidade());
    }

}
