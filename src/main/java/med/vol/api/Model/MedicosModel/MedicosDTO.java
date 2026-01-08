package med.vol.api.Model.MedicosModel;

public record MedicosDTO(String nome, String email, Long telefone, Long crm, Especialidades especialidade, EnderecoDTO endereco) {
}
