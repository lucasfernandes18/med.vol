package med.vol.api.Model;

public record MedicosModel(String nome, String email, Long telefone, Long crm, Especialidades especialidades, DadosEndereco endereco) {
}
