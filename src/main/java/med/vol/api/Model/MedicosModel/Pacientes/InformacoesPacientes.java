package med.vol.api.Model.MedicosModel.Pacientes;

public record InformacoesPacientes(Long id, String nome,String email, Long telefone) {

    public InformacoesPacientes(PacientesEntity pacientes){
        this(pacientes.getId(), pacientes.getNome(),pacientes.getEmail(), pacientes.getTelefone());
    }
}
